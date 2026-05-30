package com.mystanica.dreamlands.common.data.level;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DreamlandsSavedData extends SavedData {
    private final Map<UUID, DreamlandsPlayerEntry> playerData = new HashMap<>();

    public Map<UUID, DreamlandsPlayerEntry> getPlayers() {
        return this.playerData;
    }

    /**
     * @return existing data, or new if the uuid given is not in the map.
     */
    public DreamlandsPlayerEntry getPlayerById(UUID id) {
        return this.playerData.computeIfAbsent(id, (newId) -> {
            DreamlandsPlayerEntry playerEntry = new DreamlandsPlayerEntry(new CompoundTag());
            playerEntry.setPlayerId(id);
            return playerEntry;
        });
    }
    
    @Override
    public CompoundTag save(CompoundTag tag) {
        ListTag list = new ListTag();
        for (DreamlandsPlayerEntry data : this.playerData.values()) {
            list.add(data.write(new CompoundTag()));
        }
        tag.put("Players", list);

        return tag;
    }

    public static DreamlandsSavedData load(CompoundTag tag) {
        DreamlandsSavedData savedData = new DreamlandsSavedData();

        ListTag list = tag.getList("Players", 10);
        for (int index = 0; index < list.size(); index++) {
            DreamlandsPlayerEntry data = new DreamlandsPlayerEntry(list.getCompound(index));
            savedData.playerData.put(data.getPlayerId(), data);
        }

        return savedData;
    }

    /**
     * call this after every set value.
     */
    public void setChanged() {
        this.setDirty();
    }

    /**
     * use this to calculate the data and get the values stored in it.
     */
    public static DreamlandsSavedData getData(ServerLevel level) {
        ServerLevel overworld = level.getServer().overworld();
        return overworld.getDataStorage().computeIfAbsent(
                DreamlandsSavedData::load,
                DreamlandsSavedData::new,
                "dreamlands"
        );
    }

}