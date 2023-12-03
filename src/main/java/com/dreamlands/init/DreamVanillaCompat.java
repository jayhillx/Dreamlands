package com.dreamlands.init;

import com.dreamlands.common.util.BlockDataUtils;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;

public class DreamVanillaCompat {

    public static class Common {

        public static void registerFlammables() {
            BlockDataUtils.flammable(DreamBlocks.EVERGREEN_LOG.get(), 5, 5);
            BlockDataUtils.flammable(DreamBlocks.STRIPPED_EVERGREEN_LOG.get(), 5, 5);
            BlockDataUtils.flammable(DreamBlocks.EVERGREEN_WOOD.get(), 5, 5);
            BlockDataUtils.flammable(DreamBlocks.STRIPPED_EVERGREEN_WOOD.get(), 5, 5);
            BlockDataUtils.flammable(DreamBlocks.EVERGREEN_PLANKS.get(), 5, 20);
            BlockDataUtils.flammable(DreamBlocks.EVERGREEN_STAIRS.get(), 5, 20);
            BlockDataUtils.flammable(DreamBlocks.EVERGREEN_SLAB.get(), 5, 20);
            BlockDataUtils.flammable(DreamBlocks.EVERGREEN_FENCE.get(), 5, 20);
            BlockDataUtils.flammable(DreamBlocks.EVERGREEN_FENCE_GATE.get(), 5, 20);
            BlockDataUtils.flammable(DreamBlocks.EVERGREEN_BUTTON.get(), 5, 20);
            BlockDataUtils.flammable(DreamBlocks.EVERGREEN_PRESSURE_PLATE.get(), 5, 20);
            BlockDataUtils.flammable(DreamBlocks.EVERGREEN_TRAPDOOR.get(), 5, 20);
            BlockDataUtils.flammable(DreamBlocks.EVERGREEN_DOOR.get(), 5, 20);

            BlockDataUtils.flammable(DreamBlocks.ETHEREAL_LOG.get(), 5, 5);
            BlockDataUtils.flammable(DreamBlocks.STRIPPED_ETHEREAL_LOG.get(), 5, 5);
            BlockDataUtils.flammable(DreamBlocks.ETHEREAL_WOOD.get(), 5, 5);
            BlockDataUtils.flammable(DreamBlocks.STRIPPED_ETHEREAL_WOOD.get(), 5, 5);
            BlockDataUtils.flammable(DreamBlocks.ETHEREAL_PLANKS.get(), 5, 20);
            BlockDataUtils.flammable(DreamBlocks.ETHEREAL_STAIRS.get(), 5, 20);
            BlockDataUtils.flammable(DreamBlocks.ETHEREAL_SLAB.get(), 5, 20);
            BlockDataUtils.flammable(DreamBlocks.ETHEREAL_FENCE.get(), 5, 20);
            BlockDataUtils.flammable(DreamBlocks.ETHEREAL_FENCE_GATE.get(), 5, 20);
            BlockDataUtils.flammable(DreamBlocks.ETHEREAL_BUTTON.get(), 5, 20);
            BlockDataUtils.flammable(DreamBlocks.ETHEREAL_PRESSURE_PLATE.get(), 5, 20);
            BlockDataUtils.flammable(DreamBlocks.ETHEREAL_TRAPDOOR.get(), 5, 20);
            BlockDataUtils.flammable(DreamBlocks.ETHEREAL_DOOR.get(), 5, 20);
            
            BlockDataUtils.flammable(DreamBlocks.CANDY_LOG.get(), 5, 5);
            BlockDataUtils.flammable(DreamBlocks.STRIPPED_CANDY_LOG.get(), 5, 5);
            BlockDataUtils.flammable(DreamBlocks.CANDY_WOOD.get(), 5, 5);
            BlockDataUtils.flammable(DreamBlocks.STRIPPED_CANDY_WOOD.get(), 5, 5);
            BlockDataUtils.flammable(DreamBlocks.CANDY_PLANKS.get(), 5, 20);
            BlockDataUtils.flammable(DreamBlocks.CANDY_STAIRS.get(), 5, 20);
            BlockDataUtils.flammable(DreamBlocks.CANDY_SLAB.get(), 5, 20);
            BlockDataUtils.flammable(DreamBlocks.CANDY_FENCE.get(), 5, 20);
            BlockDataUtils.flammable(DreamBlocks.CANDY_FENCE_GATE.get(), 5, 20);
            BlockDataUtils.flammable(DreamBlocks.CANDY_BUTTON.get(), 5, 20);
            BlockDataUtils.flammable(DreamBlocks.CANDY_PRESSURE_PLATE.get(), 5, 20);
            BlockDataUtils.flammable(DreamBlocks.CANDY_TRAPDOOR.get(), 5, 20);
            BlockDataUtils.flammable(DreamBlocks.CANDY_DOOR.get(), 5, 20);
        }

        /** Leaves, Saplings & Food - 0.3 | Flower Leaves - 0.6 | Flowers - 0.65 */
        public static void registerCompostables() {
            BlockDataUtils.compostable(DreamItems.MARSHMALLOW.get(), 0.3F);
            BlockDataUtils.compostable(DreamItems.TOASTED_MARSHMALLOW.get(), 0.3F);
            BlockDataUtils.compostable(DreamItems.BURNT_MARSHMALLOW.get(), 0.3F);
            BlockDataUtils.compostable(DreamItems.DREAMY_MUSHROOM.get(), 0.45F);
        }
    }

    public static class Client {

        public static void registerRenderLayers() {
            BlockEntityRenderers.register(DreamBlockEntities.SIGN.get(), SignRenderer::new);
            BlockEntityRenderers.register(DreamBlockEntities.HANGING_SIGN.get(), HangingSignRenderer::new);
        }
    }

}