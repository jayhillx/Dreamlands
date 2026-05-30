package com.mystanica.dreamlands.common.entity.vehicle;

import com.mystanica.dreamlands.init.DreamEntities;
import com.mystanica.dreamlands.init.DreamItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;

public class DreamChestBoat extends ChestBoat {

    public DreamChestBoat(EntityType<? extends ChestBoat> entityType, Level level) {
        super(entityType, level);
        this.blocksBuilding = true;
    }

    public DreamChestBoat(Level level, double x, double y, double z) {
        this(DreamEntities.CHEST_BOAT.get(), level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putString("Type", this.getModel().getName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("Type", Tag.TAG_STRING)) {
            this.setModel(DreamBoat.Type.byName(tag.getString("Type")));
        }
    }

    @Override
    protected void checkFallDamage(double fallDistance, boolean onGround, BlockState state, BlockPos pos) {
        this.lastYd = this.getDeltaMovement().y;

        if (!this.isPassenger()) {
            if (onGround) {
                if (this.fallDistance > 3.0F) {
                    if (this.status != Status.ON_LAND) {
                        this.resetFallDistance();
                        return;
                    }

                    this.causeFallDamage(this.fallDistance, 1.0F, this.damageSources().fall());

                    if (!this.level().isClientSide && !this.isRemoved()) {
                        this.kill();
                        if (this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                            for (int i = 0; i < 3; ++i) {
                                this.spawnAtLocation(this.getModel().getPlanks());
                            }

                            for (int j = 0; j < 2; ++j) {
                                this.spawnAtLocation(Items.STICK);
                            }
                        }
                    }
                }

                this.resetFallDistance();
            } else if (!this.level().getFluidState(this.blockPosition().below()).is(FluidTags.WATER) && fallDistance < 0.0D) {
                this.fallDistance -= (float)fallDistance;
            }
        }
    }

    @Override
    public double getPassengersRidingOffset() {
        return this.getModel().isRaft() ? 0.25D : -0.1D;
    }

    @Nonnull
    @Override
    public Item getDropItem() {
        return switch (DreamBoat.Type.byId(this.entityData.get(DATA_ID_TYPE))) {
            case DREAMY -> DreamItems.DREAMY_BOAT.get();
            ///case ASPEN -> DreamItems.ASPEN_BOAT.get();
            case EVERGREEN -> DreamItems.EVERGREEN_BOAT.get();
            case ETHEREAL -> DreamItems.ETHEREAL_BOAT.get();
            case CANDY -> DreamItems.CANDY_BOAT.get();
            case WISTERIA -> DreamItems.WISTERIA_BOAT.get();
            case MYSTICAL -> DreamItems.MYSTICAL_BOAT.get();
            case MUSHROOM -> DreamItems.MUSHROOM_BOAT.get();
            ///case GLOOMY -> DreamItems.GLOOMY_BOAT.get();
            ///case GRIMWOOD -> DreamItems.GRIMWOOD_BOAT.get();
            ///case PINE -> DreamItems.PINE_BOAT.get();
            ///case POISED -> DreamItems.POISED_BOAT.get();
            ///case DEAD -> DreamItems.DEAD_BOAT.get();
            ///case BLOODWOOD -> DreamItems.BLOODWOOD_BOAT.get();
            ///case SOUR -> DreamItems.SOUR_BOAT.get();
            ///case FUNGUS -> DreamItems.FUNGUS_BOAT.get();
        };
    }

    public DreamBoat.Type getModel() {
        return DreamBoat.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    public void setModel(DreamBoat.Type type) {
        this.entityData.set(DATA_ID_TYPE, type.ordinal());
    }

}