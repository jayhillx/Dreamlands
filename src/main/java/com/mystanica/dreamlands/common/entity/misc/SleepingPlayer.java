package com.mystanica.dreamlands.common.entity.misc;

import com.mojang.authlib.GameProfile;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.ForgeHooks;

import java.util.Collections;

public class SleepingPlayer extends LivingEntity {
    private static final EntityDataAccessor<CompoundTag> DATA_PROFILE = SynchedEntityData.defineId(SleepingPlayer.class, EntityDataSerializers.COMPOUND_TAG);
    private GameProfile playerProfile;

    public SleepingPlayer(EntityType<? extends LivingEntity> type, Level level) {
        super(type, level);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_PROFILE, new CompoundTag());
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.0D);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        if (this.playerProfile != null) {
            tag.put("Profile", NbtUtils.writeGameProfile(new CompoundTag(), this.playerProfile));
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("Profile")) {
            CompoundTag profileTag = tag.getCompound("Profile");
            this.playerProfile = NbtUtils.readGameProfile(profileTag);

            if (this.playerProfile != null) {
                this.entityData.set(DATA_PROFILE, profileTag);
            }
        }
    }

    public GameProfile getGameProfile() {
        if (this.playerProfile == null) {
            CompoundTag tag = this.entityData.get(DATA_PROFILE);
            if (!tag.isEmpty()) {
                this.playerProfile = NbtUtils.readGameProfile(tag);
            }
        }

        return this.playerProfile;
    }

    public void setGameProfile(GameProfile profile) {
        this.playerProfile = profile;
        CompoundTag profileTag = NbtUtils.writeGameProfile(new CompoundTag(), profile);
        this.entityData.set(DATA_PROFILE, profileTag);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.isSleeping() && this.getSleepingPos().isPresent()) {
            this.startSleeping(this.getSleepingPos().get());
        }
    }

    /**
     * save the chunk the sleeping player is in when spawned in.
     * this is ESSENTIAL to ensure the entity is loaded for the player to return to coming back from a dream dimension.
     */
    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();

        if (!this.level().isClientSide() && this.level() instanceof ServerLevel serverLevel) {
            ChunkPos pos = this.chunkPosition();

            if (!serverLevel.getForcedChunks().contains(pos.toLong())) {
                serverLevel.setChunkForced(pos.x, pos.z, true);
            }
        }
    }

    /**
     * just to be safe and potentially optimize it, remove the forced chunk when the entity is removed.
     */
    @Override
    public void onRemovedFromWorld() {
        if (!level().isClientSide() && level() instanceof ServerLevel serverLevel) {
            ChunkPos pos = this.chunkPosition();

            /// check if there are other sleeping player entities that share the same chunk.
            /// problems could occur if the chunk is unforced when another player will need it to still be forced to return.
            boolean otherSleepingPlayers = !serverLevel.getEntitiesOfClass(
                    SleepingPlayer.class, new AABB(pos.getMinBlockX(), serverLevel.getMinBuildHeight(), pos.getMinBlockZ(), pos.getMaxBlockX() + 1, serverLevel.getMaxBuildHeight(), pos.getMaxBlockZ() + 1))
                    .stream()
                    .filter(entity -> entity != this)
                    .toList()
                    .isEmpty();

            if (!otherSleepingPlayers) {
                serverLevel.setChunkForced(pos.x, pos.z, false);
            }
        }

        super.onRemovedFromWorld();
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (!ForgeHooks.onLivingAttack(this, source, amount)) return false;
        if (this.isInvulnerableTo(source)) {
            return false;
        } else if (this.level().isClientSide) {
            return false;
        } else if (this.isDeadOrDying()) {
            return false;
        } else if (source.is(DamageTypeTags.IS_FIRE) && this.hasEffect(MobEffects.FIRE_RESISTANCE)) {
            return false;
        } else {
            this.noActionTime = 0;
            boolean flag1 = true;
            if ((float)this.invulnerableTime > 10.0F && !source.is(DamageTypeTags.BYPASSES_COOLDOWN)) {
                if (amount <= this.lastHurt) {
                    return false;
                }

                this.actuallyHurt(source, amount - this.lastHurt);
                this.lastHurt = amount;
                flag1 = false;
            } else {
                this.lastHurt = amount;
                this.invulnerableTime = 20;
                this.actuallyHurt(source, amount);
                this.hurtDuration = 10;
                this.hurtTime = this.hurtDuration;
            }

            if (source.is(DamageTypeTags.DAMAGES_HELMET) && !this.getItemBySlot(EquipmentSlot.HEAD).isEmpty()) {
                this.hurtHelmet(source, amount);
                amount *= 0.75F;
            }

            if (source.getEntity() != null) {
                if (source.getEntity() instanceof LivingEntity entity) {
                    if (!source.is(DamageTypeTags.NO_ANGER)) {
                        this.setLastHurtByMob(entity);
                    }
                }

                if (source.getEntity() instanceof Player player) {
                    this.lastHurtByPlayerTime = 100;
                    this.lastHurtByPlayer = player;
                } else if (source.getEntity() instanceof TamableAnimal animal) {
                    if (animal.isTame()) {
                        this.lastHurtByPlayerTime = 100;
                        if (animal.getOwner() instanceof Player playerOwner) {
                            this.lastHurtByPlayer = playerOwner;
                        } else {
                            this.lastHurtByPlayer = null;
                        }
                    }
                }
            }

            if (flag1) {
                this.level().broadcastDamageEvent(this, source);
                if (!source.is(DamageTypeTags.NO_IMPACT) && (amount > 0.0F)) {
                    this.markHurt();
                }
            }

            if (this.isDeadOrDying()) {
                if (flag1 && this.getDeathSound() != null) {
                    this.playSound(this.getDeathSound(), this.getSoundVolume(), this.getVoicePitch());
                }

                this.die(source);
            } else if (flag1) {
                this.playHurtSound(source);
            }
            return amount > 0.0F;
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return source.type().effects().sound();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.PLAYER_DEATH;
    }

    @Override
    public boolean isInvulnerable() {
        return false;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public HumanoidArm getMainArm() {
        return HumanoidArm.RIGHT;
    }

    @Override
    public Iterable<ItemStack> getArmorSlots() {
        return Collections.emptyList();
    }

    @Override
    public ItemStack getItemBySlot(EquipmentSlot slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public void setItemSlot(EquipmentSlot slot, ItemStack stack) {

    }

}