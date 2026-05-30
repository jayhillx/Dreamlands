package com.mystanica.dreamlands.common.data.level;

import net.minecraft.util.StringRepresentable;

import javax.annotation.Nonnull;

public enum SleepPhase implements StringRepresentable {
    AWAKE("dreaming", 0),
    FALLING_ASLEEP("falling_asleep", 100),
    ASLEEP("asleep", 0),
    WAKING_UP("waking_up", 100);

    private static final EnumCodec<SleepPhase> CODEC = StringRepresentable.fromEnum(SleepPhase::values);
    private final String name;
    private final int duration;

    SleepPhase(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    @Nonnull
    @Override
    public String getSerializedName() {
        return this.name;
    }

    public static SleepPhase fromName(String name) {
        return CODEC.byName(name, AWAKE);
    }

    public int getDuration() {
        return this.duration;
    }

    public float getProgress(long ticksInPhase) {
        if (this.duration <= 0) {
            return 1.0F;
        }

        return Math.min((float)ticksInPhase / (float)this.duration, 1.0F);
    }

    /**
     * This will be used in filtering the phases to the ones that will have a transition screen/overlay
     * when the player is sleeping.
     *
     * @return if the phase will have a transition or not.
     */
    public boolean hasTransition() {
        return this == FALLING_ASLEEP || this == WAKING_UP;
    }

}