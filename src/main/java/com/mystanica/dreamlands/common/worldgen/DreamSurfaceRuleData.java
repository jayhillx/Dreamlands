package com.mystanica.dreamlands.common.worldgen;

import com.mystanica.dreamlands.init.DreamBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class DreamSurfaceRuleData {

    private static final SurfaceRules.RuleSource DREAMY_GRASS_BLOCK = makeStateRule(DreamBlocks.DREAMY_GRASS_BLOCK.get());
    private static final SurfaceRules.RuleSource DREAMY_DIRT = makeStateRule(DreamBlocks.DREAMY_DIRT.get());

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }

    public static SurfaceRules.RuleSource overworldLike() {
        SurfaceRules.ConditionSource aboveWater = SurfaceRules.waterBlockCheck(0, 0);
        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(aboveWater, DREAMY_GRASS_BLOCK), DREAMY_DIRT);

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, DREAMY_DIRT)
        );
    }

}