package com.mystanica.dreamlands.common.worldgen.feature.tree.config;

import net.minecraft.core.Direction;

import javax.annotation.Nullable;

public class BranchShapeConfig {
    public final int branchLength;
    public final int bendStrength;
    @Nullable
    public Direction bendDirection;
    public final int droopInterval;
    public final int droopCurveAmount;
    public final boolean offsetLeaves;
    public final boolean bottomLeaves;

    private BranchShapeConfig(Builder builder) {
        this.branchLength = builder.branchLength;
        this.bendStrength = builder.bendStrength;
        this.bendDirection = builder.bendDirection;
        this.droopInterval = builder.droopInterval;
        this.droopCurveAmount = builder.droopCurveAmount;
        this.offsetLeaves = builder.offsetLeaves;
        this.bottomLeaves = builder.bottomLeaves;
    }

    public static class Builder {
        private int branchLength = 4;
        private int bendStrength = 0;
        @Nullable
        private Direction bendDirection = null;
        private int droopInterval = 0;
        private int droopCurveAmount = 0;
        private boolean offsetLeaves = false;
        private boolean bottomLeaves = true;

        public Builder length(int length) {
            this.branchLength = length;
            return this;
        }

        public Builder horizontalBend(Direction direction, int strength) {
            this.bendDirection = direction;
            this.bendStrength = strength;
            this.offsetLeaves = true;
            return this;
        }

        /**
         * @param interval - i.e. an interval of 2 means the branch will move down one, and forward two.
         * @return --------- determines the rate at which a branch will move downward.
         */
        public Builder droop(int interval) {
            this.droopInterval = interval;
            return this;
        }

        /**
         * @return temp way to make the branches droop at a specific angle.
         *         0 is none, 1 is dynamic, and 2 is static/the old way of doing it.
         */
        public Builder staticDroop() {
            this.droopCurveAmount = 2;
            return this;
        }

        public Builder hasOffsetLeaves() {
            this.offsetLeaves = true;
            return this;
        }

        public Builder noBottomLeaves() {
            this.bottomLeaves = false;
            return this;
        }

        public BranchShapeConfig build() {
            return new BranchShapeConfig(this);
        }
    }

}