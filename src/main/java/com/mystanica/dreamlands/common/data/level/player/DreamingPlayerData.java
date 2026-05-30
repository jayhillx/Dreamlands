package com.mystanica.dreamlands.common.data.level.player;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.player.Player;

/**
 * saved data of the dreaming player.
 *      > dreaming player data
 *      > bed position
 */
public class DreamingPlayerData {
    private CompoundTag dreamPlayerData;
    private BlockPos dreamBedPos;

    public DreamingPlayerData(CompoundTag tag) {
        if (tag.contains("DreamPlayerData")) {
            this.dreamPlayerData = tag.getCompound("DreamPlayerData");
        }

        if (tag.contains("DreamBedPos")) {
            this.dreamBedPos = NbtUtils.readBlockPos(tag.getCompound("DreamBedPos"));
        }
    }

    public static DreamingPlayerData create(Player player) {
        DreamingPlayerData dreamingData = new DreamingPlayerData(new CompoundTag());
        dreamingData.setDreamPlayerData(player.saveWithoutId(new CompoundTag()));
        return dreamingData;
    }

    public CompoundTag getDreamPlayerData() {
        return this.dreamPlayerData;
    }

    public void setDreamPlayerData(CompoundTag tag) {
        this.dreamPlayerData = tag;
    }

    public ListTag getInventory() {
        return this.dreamPlayerData.getList("Inventory", Tag.TAG_COMPOUND);
    }

    public BlockPos getDreamBedPos() {
        return this.dreamBedPos;
    }

    public void setDreamBedPos(BlockPos pos) {
        this.dreamBedPos = pos;
    }

    public CompoundTag write(CompoundTag tag) {
        if (this.dreamPlayerData != null) {
            tag.put("DreamPlayerData", this.dreamPlayerData);
        }

        if (this.dreamBedPos != null) {
            tag.put("DreamBedPos", NbtUtils.writeBlockPos(this.dreamBedPos));
        }

        return tag;
    }

}