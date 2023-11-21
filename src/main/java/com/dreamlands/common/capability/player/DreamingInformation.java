package com.dreamlands.common.capability.player;

import net.minecraft.nbt.CompoundTag;

public class DreamingInformation {
    private boolean inducedDream = false;

    /** @return is determined if the player has consumed mushroom soup before sleeping. */
    public boolean willHaveDream() {
        return this.inducedDream;
    }

    public void setWillHaveDream(boolean value) {
        this.inducedDream = value;
    }

    public void clone(DreamingInformation info) {
        this.inducedDream = info.willHaveDream();
    }

    public CompoundTag write(CompoundTag nbt) {
        nbt.putBoolean("WillDream", this.inducedDream);
        return nbt;
    }

    public void read(CompoundTag nbt) {
        this.inducedDream = nbt.getBoolean("WillDream");
    }

}