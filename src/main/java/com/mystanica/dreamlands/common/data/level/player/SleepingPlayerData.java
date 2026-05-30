package com.mystanica.dreamlands.common.data.level.player;

import com.mojang.authlib.GameProfile;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.player.Player;

import java.util.UUID;

/**
 * saved data of the "real" player.
 * saves the data of the player right before they change to a dream dimension.
 * be able to easily to decode the compoundTags and get given values.
 */
public class SleepingPlayerData {
    private GameProfile playerProfile;
    private CompoundTag playerData;
    private UUID sleepingPlayersId;
    private BlockPos sleepingPos;

    public SleepingPlayerData(CompoundTag tag) {
        this.playerProfile = NbtUtils.readGameProfile(tag.getCompound("PlayerProfile"));

        if (tag.contains("PlayerData")) {
            this.playerData = tag.getCompound("PlayerData");
        }

        if (tag.contains("SleepingPlayerId")) {
            this.sleepingPlayersId = tag.getUUID("SleepingPlayerId");
        }

        if (tag.contains("SleepingPos")) {
            this.sleepingPos = NbtUtils.readBlockPos(tag.getCompound("SleepingPos"));
        }
    }

    public static SleepingPlayerData create(Player player) {
        SleepingPlayerData playerData = new SleepingPlayerData(new CompoundTag());
        playerData.setProfileFromPlayer(player.getGameProfile());
        playerData.setSavedDataFromPlayer(player.saveWithoutId(new CompoundTag()));
        playerData.setSleepingPlayersId(UUID.randomUUID());
        playerData.setSleepingPos(player.getSleepingPos().orElseGet(player::getOnPos));
        return playerData;
    }

    public GameProfile getPlayerProfile() {
        return this.playerProfile;
    }

    public void setProfileFromPlayer(GameProfile profile) {
        this.playerProfile = profile;
    }

    public CompoundTag getPlayerData() {
        return this.playerData;
    }

    public void setSavedDataFromPlayer(CompoundTag tag) {
        this.playerData = tag;
    }

    public ListTag getInventory() {
        return this.playerData.getList("Inventory", Tag.TAG_COMPOUND);
    }

    public UUID getSleepingPlayersId() {
        return this.sleepingPlayersId;
    }

    public void setSleepingPlayersId(UUID id) {
        this.sleepingPlayersId = id;
    }

    public BlockPos getSleepingPos() {
        return this.sleepingPos;
    }

    public void setSleepingPos(BlockPos sleepingPos) {
        this.sleepingPos = sleepingPos;
    }

    public CompoundTag write(CompoundTag tag) {
        tag.put("PlayerProfile", NbtUtils.writeGameProfile(new CompoundTag(), this.playerProfile));

        if (this.playerData != null) {
            tag.put("PlayerData", this.playerData);
        }

        if (this.sleepingPlayersId != null) {
            tag.putUUID("SleepingPlayerId", this.sleepingPlayersId);
        }

        if (this.sleepingPos != null) {
            tag.put("SleepingPos", NbtUtils.writeBlockPos(this.sleepingPos));
        }

        return tag;
    }

}