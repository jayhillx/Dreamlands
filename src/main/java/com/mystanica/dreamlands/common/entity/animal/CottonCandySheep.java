package com.mystanica.dreamlands.common.entity.animal;

import com.mystanica.dreamlands.init.DreamBlocks;
import com.mystanica.dreamlands.init.DreamEntities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class CottonCandySheep extends Animal implements Shearable {
    private static final EntityDataAccessor<String> DATA_TYPE_ID = SynchedEntityData.defineId(CottonCandySheep.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<Boolean> DATA_SHEARED_ID = SynchedEntityData.defineId(CottonCandySheep.class, EntityDataSerializers.BOOLEAN);
    private EatBlockGoal eatBlockGoal;
    private int eatAnimationTick;
    public final AnimationState idleAnimation = new AnimationState();

    public CottonCandySheep(EntityType<? extends CottonCandySheep> type, Level level) {
        super(type, level);
        this.moveControl = new MoveControl(this);
        this.lookControl = new LookControl(this);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.125D).add(Attributes.MAX_HEALTH, 10.0D);
    }

    @Override
    protected void registerGoals() {
        this.eatBlockGoal = new EatBlockGoal(this);
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, Ingredient.of(Items.SUGAR), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(5, this.eatBlockGoal);
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_TYPE_ID, Type.PINK.type);
        this.entityData.define(DATA_SHEARED_ID, false);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putString("Color", this.getVariant().getSerializedName());
        tag.putBoolean("Sheared", this.isSheared());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setVariant(Type.byType(tag.getString("Color")));
        this.setSheared(tag.getBoolean("Sheared"));
    }

    public Type getVariant() {
        return Type.byType(this.getEntityData().get(DATA_TYPE_ID));
    }

    public void setVariant(Type type) {
        this.entityData.set(DATA_TYPE_ID, type.getSerializedName());
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            this.idleAnimation.animateWhen(!this.walkAnimation.isMoving(), this.tickCount);
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.level().isClientSide()) {
            this.eatAnimationTick = Math.max(0, this.eatAnimationTick - 1);
        }
    }

    @Override
    protected void customServerAiStep() {
        this.eatAnimationTick = this.eatBlockGoal.getEatAnimationTick();
        super.customServerAiStep();
    }

    @Override
    public CottonCandySheep getBreedOffspring(ServerLevel level, AgeableMob mob) {
        CottonCandySheep sheep = DreamEntities.COTTON_CANDY_SHEEP.get().create(level);
        if (sheep != null) {
            sheep.setVariant(this.random.nextBoolean() ? this.getVariant() : ((CottonCandySheep)mob).getVariant());
        }
        return sheep;
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData,  @Nullable CompoundTag tag) {
        this.setVariant(this.random.nextBoolean() ? Type.PINK : Type.BLUE);
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData, tag);
    }

    public boolean isSheared() {
        return this.entityData.get(DATA_SHEARED_ID);
    }

    public void setSheared(boolean sheared) {
        this.entityData.set(DATA_SHEARED_ID, sheared);
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (stack.getItem() == Items.SHEARS) {
            if (!this.level().isClientSide && this.readyForShearing()) {
                this.shear(SoundSource.PLAYERS);
                this.gameEvent(GameEvent.SHEAR, player);
                stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));
                return InteractionResult.SUCCESS;
            } else {
                return InteractionResult.CONSUME;
            }
        } else {
            return super.mobInteract(player, hand);
        }
    }

    @Override
    public boolean readyForShearing() {
        return this.isAlive() && !this.isSheared() && !this.isBaby();
    }

    @Override
    public void shear(SoundSource sound) {
        this.level().playSound(null, this, SoundEvents.SHEEP_SHEAR, sound, 1.0F, 1.0F);
        this.setSheared(true);
        int i = 1 + this.random.nextInt(3);

        for (int j = 0; j < i; ++j) {
            ItemEntity itemEntity = this.spawnAtLocation(this.getVariant().getBlockState().getBlock(), 1);
            if (itemEntity != null) {
                itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().add((this.random.nextFloat() - this.random.nextFloat()) * 0.1F, this.random.nextFloat() * 0.05F, (this.random.nextFloat() - this.random.nextFloat()) * 0.1F));
            }
        }
    }

    @Override
    public void ate() {
        super.ate();
        this.setSheared(false);
        if (this.isBaby()) {
            this.ageUp(60);
        }
    }

    @Override
    public void handleEntityEvent(byte tick) {
        if (tick == 10) {
            this.eatAnimationTick = 40;
        } else {
            super.handleEntityEvent(tick);
        }
    }

    public float getHeadEatPositionScale(float tick) {
        if (this.eatAnimationTick <= 0) {
            return 0.0F;
        } else if (this.eatAnimationTick >= 4 && this.eatAnimationTick <= 36) {
            return 1.0F;
        } else {
            return this.eatAnimationTick < 4 ? ((float)this.eatAnimationTick - tick) / 4.0F : -((float)(this.eatAnimationTick - 40) - tick) / 4.0F;
        }
    }

    public float getHeadEatAngleScale(float tick) {
        if (this.eatAnimationTick > 4 && this.eatAnimationTick <= 36) {
            float f = ((float)(this.eatAnimationTick - 4) - tick) / 32.0F;
            return ((float)Math.PI / 5F) + 0.21991149F * Mth.sin(f * 28.7F);
        } else {
            return this.eatAnimationTick > 0 ? ((float)Math.PI / 5F) : this.getXRot() * ((float)Math.PI / 180F);
        }
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(Items.SUGAR);
    }

    public enum Type implements StringRepresentable {
        PINK("pink", DreamBlocks.PINK_COTTON_CANDY_BLOCK.get().defaultBlockState()),
        BLUE("blue", DreamBlocks.BLUE_COTTON_CANDY_BLOCK.get().defaultBlockState());

        private final String type;
        private final BlockState state;

        Type(String type, BlockState state) {
            this.type = type;
            this.state = state;
        }

        @Nonnull
        @Override
        public String getSerializedName() {
            return this.type;
        }

        public BlockState getBlockState() {
            return this.state;
        }

        public static Type byType(String name) {
            return StringRepresentable.fromEnum(Type::values).byName(name, PINK);
        }
    }

}