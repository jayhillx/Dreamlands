package com.mystanica.dreamlands.client.handler;

import com.mystanica.dreamlands.Dreamlands;
import com.mystanica.dreamlands.client.renderer.DreamBiomeColors;
import com.mystanica.dreamlands.init.DreamBlocks;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Dreamlands.modId, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BlockColorHandler {

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        event.register((state, level, pos, tintIndex) -> {
            if (tintIndex == 0) return getGrassColor(level, pos);
            if (tintIndex == 1) return DreamBiomeColors.getDefaultDirtColor();
            return -1;
            }, DreamBlocks.DREAMY_GRASS_BLOCK.get()
        );

        event.register((state, level, pos, tintIndex) -> tintIndex == 1 ? DreamBiomeColors.getDefaultDirtColor() : -1,
                DreamBlocks.DREAMY_DIRT.get(),
                DreamBlocks.DREAMY_DIRT_PATH.get()
        );

        event.register((state, level, pos, tintIndex) -> tintIndex == 0 ? getFoliageColor(level, pos) : -1,
                DreamBlocks.DREAMY_LEAVES.get()
        );

        event.register((state, level, pos, tintIndex) -> tintIndex == 0 ? getGrassColor(level, pos) : -1,
                DreamBlocks.DREAMY_GRASS.get(),
                DreamBlocks.TALL_DREAMY_GRASS.get()
        );
    }

    private static int getFoliageColor(BlockAndTintGetter level, BlockPos pos) {
        return level != null && pos != null
                ? BiomeColors.getAverageFoliageColor(level, pos)
                : DreamBiomeColors.getDefaultFoliageColor();
    }

    private static int getGrassColor(BlockAndTintGetter level, BlockPos pos) {
        return level != null && pos != null
                ? BiomeColors.getAverageGrassColor(level, pos)
                : DreamBiomeColors.getDefaultGrassColor();
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.register((stack, tintIndex) -> {
            if (tintIndex == 0) return DreamBiomeColors.getDefaultGrassColor();
            if (tintIndex == 1) return DreamBiomeColors.getDefaultDirtColor();
            return -1;
            }, DreamBlocks.DREAMY_GRASS_BLOCK.get());

        event.register((stack, tintIndex) -> DreamBiomeColors.getDefaultDirtColor(),
                DreamBlocks.DREAMY_DIRT.get(),
                DreamBlocks.DREAMY_DIRT_PATH.get()
        );

        event.register((stack, tintIndex) -> DreamBiomeColors.getDefaultFoliageColor(),
                DreamBlocks.DREAMY_LEAVES.get()
        );
    }

}