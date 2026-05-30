package com.mystanica.dreamlands.common.worldgen.feature.tree.config;

import net.minecraft.core.Direction;

public class BasicBranchShapeConfig {
    public final int branchLength;
    public final int bendInterval;
    public final int bendCurveAmount;
    public final int forwardInterval;
    public BendDirection verticalBendDirection;
    public final int verticalBendInterval;
    public BendDirection horizontalBendDirection;
    public final int horizontalBendInterval;
    public final boolean hasSubBranches;

    private BasicBranchShapeConfig(Builder builder) {
        this.branchLength = builder.branchLength;
        this.bendInterval = builder.bendInterval;
        this.bendCurveAmount = builder.bendCurveAmount;
        this.forwardInterval = builder.forwardInterval;
        this.verticalBendDirection = builder.verticalBendDirection;
        this.verticalBendInterval = builder.verticalBendInterval;
        this.horizontalBendDirection = builder.horizontalBendDirection;
        this.horizontalBendInterval = builder.horizontalBendInterval;
        this.hasSubBranches = builder.hasSubBranches;
    }

    public static class Builder {
        private final int branchLength;
        private int bendInterval = 0;
        private int bendCurveAmount = 0;
        private int forwardInterval = 0;
        private BendDirection verticalBendDirection = BendDirection.NONE;
        private int verticalBendInterval = 0;
        private BendDirection horizontalBendDirection = BendDirection.NONE;
        private int horizontalBendInterval = 0;
        private boolean hasSubBranches = false;

        public Builder(int branchLength) {
            this.branchLength = branchLength;
        }

        public Builder bend(int bendInterval, int bendCurveAmount) {
            this.bendInterval = bendInterval;
            this.bendCurveAmount = bendCurveAmount;
            return this;
        }
        
        public Builder bendVertically(BendDirection direction, int forwardInterval, int verticalInterval) {
            this.verticalBendDirection = direction;
            this.verticalBendInterval = verticalInterval;
            this.forwardInterval = forwardInterval;
            return this;
        }

        public Builder bendHorizontally(BendDirection direction, int horizontalInterval) {
            this.horizontalBendDirection = direction;
            this.horizontalBendInterval = horizontalInterval;
            return this;
        }

        public Builder allowSubBranches() {
            this.hasSubBranches = true;
            return this;
        }

        public BasicBranchShapeConfig build() {
            return new BasicBranchShapeConfig(this);
        }
    }

    public enum BendDirection {
        NONE,
        UP,
        DOWN,
        LEFT,
        RIGHT;

        public Direction bendDirection(Direction branchDirection) {
            return switch (this) {
                case NONE -> branchDirection;
                case UP -> Direction.UP;
                case DOWN -> Direction.DOWN;
                case LEFT -> branchDirection.getCounterClockWise();
                case RIGHT -> branchDirection.getClockWise();
            };
        }
    }

}