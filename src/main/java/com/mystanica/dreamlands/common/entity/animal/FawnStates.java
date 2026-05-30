package com.mystanica.dreamlands.common.entity.animal;

import com.mystanica.dreamlands.common.entity.EntityStates;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;

import javax.annotation.Nonnull;
import java.util.function.IntFunction;

public enum FawnStates implements EntityStates<FawnStates> {
    NONE(0, "none", 0, false),
    EATING_START(1, "eating_start", 20, false) {
        @Override
        public FawnStates nextState() {
            return EATING;
        }
    },
    EATING(2, "eating", 60, true),
    EATING_STOP(3, "eating_stop", 20, false) {
        @Override
        public FawnStates nextState() {
            return NONE;
        }
    };

    public static final IntFunction<FawnStates> BY_ID = ByIdMap.continuous(FawnStates::id, values(), ByIdMap.OutOfBoundsStrategy.ZERO);
    private final int id;
    private final String name;
    private final int animationDuration;
    private final boolean shouldLoop;

    FawnStates(final int id, final String name, final int animationDuration, final boolean shouldLoop) {
        this.id = id;
        this.name = name;
        this.animationDuration = animationDuration;
        this.shouldLoop = shouldLoop;
    }

    @Override
    public int id() {
        return this.id;
    }

    @Nonnull
    @Override
    public String getSerializedName() {
        return this.name;
    }

    public static FawnStates fromName(String name) {
        return StringRepresentable.fromEnum(FawnStates::values).byName(name, NONE);
    }

    @Override
    public int animationDuration() {
        return this.animationDuration;
    }

    @Override
    public boolean shouldLoop() {
        return this.shouldLoop;
    }

}