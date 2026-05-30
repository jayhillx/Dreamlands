package com.mystanica.dreamlands.common.worldgen.feature.tree.config;

public class FoliageShapeConfig {
    public final int foliageRadius;
    public final int foliageHeight;

    private FoliageShapeConfig(Builder builder) {
        this.foliageRadius = builder.foliageRadius;
        this.foliageHeight = builder.foliageHeight;
    }

    public static class Builder {
        private final int foliageRadius;
        private final int foliageHeight;

        public Builder(int foliageRadius, int foliageHeight) {
            this.foliageRadius = foliageRadius;
            this.foliageHeight = foliageHeight;
        }

        public FoliageShapeConfig build() {
            return new FoliageShapeConfig(this);
        }
    }
    
}