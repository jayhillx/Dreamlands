package io.github.jay.dreamlands.common.capability;

import net.minecraft.nbt.CompoundTag;

public class DreamData {
    private boolean willDream = false;

    /** @return is determined if the player has consumed mushroom soup before sleeping. */
    public boolean willHaveDream() {
        return this.willDream;
    }

    public void setWillHaveDream(boolean value) {
        this.willDream = value;
    }

    public CompoundTag write(CompoundTag nbt) {
        nbt.putBoolean("WillHaveDream", this.willDream);
        return nbt;
    }

    public void read(CompoundTag nbt) {
        this.willDream = nbt.getBoolean("WillHaveDream");
    }

}