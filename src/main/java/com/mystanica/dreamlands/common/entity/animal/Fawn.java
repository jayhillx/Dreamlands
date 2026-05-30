package com.mystanica.dreamlands.common.entity.animal;

import com.mystanica.dreamlands.common.entity.EntityFlagManager;
import com.mystanica.dreamlands.common.entity.EntityStateManager;
import com.mystanica.dreamlands.init.DreamBlocks;
import com.mystanica.dreamlands.init.DreamEntitySerializers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;

import javax.annotation.Nonnull;
import java.util.EnumSet;

public class Fawn extends Animal {
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(Fawn.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<FawnStates> DATA_STATE_ID = SynchedEntityData.defineId(Fawn.class, DreamEntitySerializers.FAWN_STATES.get());

    public final EntityFlagManager flagManager = new EntityFlagManager(this, Fawn.DATA_FLAGS_ID);
    public final EntityStateManager<FawnStates> stateManager = new EntityStateManager<>(this, Fawn.DATA_STATE_ID, FawnStates.class);

    public final AnimationState idleAnimationState = new AnimationState();

    public Fawn(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new MoveControl(this);
        this.lookControl = new LookControl(this);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.125F).add(Attributes.MAX_HEALTH, 20.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new EatGrassGoal(this));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_STATE_ID, FawnStates.NONE);
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
    }

    @Override
    public void onSyncedDataUpdated(@Nonnull EntityDataAccessor<?> accessor) {
        super.onSyncedDataUpdated(accessor);
        if (this.stateManager != null) {
            this.stateManager.onSyncedDataUpdated(accessor);
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putString("State", this.stateManager.getState().getSerializedName());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.stateManager.switchToState(FawnStates.fromName(tag.getString("State")));
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
        return null;
    }

    @Override
    public void tick() {
        super.tick();
        this.stateManager.tick();

        if (this.level().isClientSide()) {
            if (this.stateManager.getState() == FawnStates.NONE) {
                if (!this.isEating()) {
                    this.idleAnimationState.animateWhen(!this.walkAnimation.isMoving(), this.tickCount);
                }
            }
        }
    }

    public boolean isEating() {
        return this.flagManager.getFlag(1 << 1);
    }

    public void setEating(boolean value) {
        this.flagManager.setFlag(1 << 1, value);
    }

    @Override
    public boolean isFood(@Nonnull ItemStack stack) {
        return false;
    }

    public static class EatGrassGoal extends Goal {
        private final Fawn fawn;
        private int durationTicks;

        public EatGrassGoal(Fawn mob) {
            this.fawn = mob;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            if (this.fawn.getRandom().nextInt(1000) != 0) {
                return false;
            } else {
                BlockPos pos = this.fawn.blockPosition();
                return this.isStateGrass(this.fawn.level().getBlockState(pos)) || this.isStateGrassBlock(this.fawn.level().getBlockState(pos.below()));
            }
        }

        @Override
        public boolean canContinueToUse() {
            return this.durationTicks > 0;
        }

        @Override
        public void start() {
            this.durationTicks = this.adjustedTickDelay(160);
            this.fawn.setEating(true);
            this.fawn.getNavigation().stop();
            this.fawn.stateManager.trySwitchToState(FawnStates.EATING_START);
        }

        @Override
        public void stop() {
            this.durationTicks = 0;
            this.fawn.setEating(false);
            if (this.fawn.stateManager.getState() == FawnStates.EATING) {
                this.fawn.stateManager.switchToState(FawnStates.EATING_STOP);
            }
        }

        @Override
        public void tick() {
            this.durationTicks = Math.max(0, this.durationTicks - 1);
            if (this.durationTicks == this.adjustedTickDelay(4)) {
                BlockPos pos = this.fawn.blockPosition();
                BlockPos belowPos = pos.below();
                BlockState belowState = this.fawn.level().getBlockState(belowPos);

                if (this.isStateGrass(this.fawn.level().getBlockState(pos))) {
                    this.fawn.level().destroyBlock(pos, false);
                    this.fawn.ate();
                } else if (this.isStateGrass(belowState)) {
                    this.fawn.level().levelEvent(2001, belowPos, Block.getId(belowState));
                    this.fawn.level().setBlock(belowPos, (belowState.is(DreamBlocks.DREAMY_GRASS_BLOCK.get()) ? DreamBlocks.DREAMY_DIRT.get() : Blocks.DIRT).defaultBlockState(), 2);
                    this.fawn.ate();
                }
            }
        }

        private boolean isStateGrass(BlockState state) {
            return BlockStatePredicate.forBlock(Blocks.GRASS).test(state) || BlockStatePredicate.forBlock(DreamBlocks.DREAMY_GRASS.get()).test(state);
        }

        private boolean isStateGrassBlock(BlockState state) {
            return state.is(Blocks.GRASS_BLOCK) || state.is(DreamBlocks.DREAMY_GRASS_BLOCK.get());
        }
    }

}