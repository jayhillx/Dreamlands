package com.mystanica.dreamlands.common.data.level;

import com.mystanica.dreamlands.common.data.level.player.DreamingPlayerData;
import com.mystanica.dreamlands.common.data.level.player.SleepingPlayerData;
import net.minecraft.nbt.CompoundTag;

import java.util.UUID;

/**
 * most likely will be safer to save data on the overworld since without it the game would break anyway.
 */
public class DreamlandsPlayerEntry {
    private UUID playerId;
    private SleepingPlayerData sleepingData;
    private DreamingPlayerData dreamingData;

    public DreamlandsPlayerEntry(CompoundTag tag) {
        if (tag.contains("PlayerId")) {
            this.playerId = tag.getUUID("PlayerId");
        }

        if (tag.contains("SleepingPlayerData")) {
            this.sleepingData = new SleepingPlayerData(tag.getCompound("SleepingPlayerData"));
        }

        if (tag.contains("DreamingPlayerData")) {
            this.dreamingData = new DreamingPlayerData(tag.getCompound("DreamingPlayerData"));
        }
    }

    public UUID getPlayerId() {
        return this.playerId;
    }

    public void setPlayerId(UUID id) {
        this.playerId = id;
    }

    public SleepingPlayerData getSleepingPlayerData() {
        return this.sleepingData;
    }

    public void saveSleepingPlayerData(SleepingPlayerData data) {
        this.sleepingData = data;
    }

    public void clearSleepingPlayerData() {
        this.sleepingData = null;
    }

    public DreamingPlayerData getDreamingPlayerData() {
        return this.dreamingData;
    }

    public void saveDreamingPlayerData(DreamingPlayerData data) {
        this.dreamingData = data;
    }

    public CompoundTag write(CompoundTag tag) {
        if (this.playerId != null) {
            tag.putUUID("PlayerId", this.playerId);
        }

        if (this.sleepingData != null) {
            tag.put("SleepingPlayerData", this.sleepingData.write(new CompoundTag()));
        }

        if (this.dreamingData != null) {
            tag.put("DreamingPlayerData", this.dreamingData.write(new CompoundTag()));
        }

        return tag;
    }

}