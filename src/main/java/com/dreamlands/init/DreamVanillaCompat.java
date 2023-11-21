package com.dreamlands.init;

import com.dreamlands.common.util.BlockDataUtils;

public class DreamVanillaCompat {

    public static class Common {

        public static void registerFlammables() {
            BlockDataUtils.flammable(DreamBlocks.EVERGREEN_PLANKS.get(), 5, 20);
            BlockDataUtils.flammable(DreamBlocks.ETHEREAL_PLANKS.get(), 5, 20);
            BlockDataUtils.flammable(DreamBlocks.CANDY_PLANKS.get(), 5, 20);
        }

        /** Leaves, Saplings & Food - 0.3 | Flower Leaves - 0.6 | Flowers - 0.65 */
        public static void registerCompostables() {
            BlockDataUtils.compostable(DreamItems.MARSHMALLOW.get(), 0.3F);
            BlockDataUtils.compostable(DreamItems.TOASTED_MARSHMALLOW.get(), 0.3F);
            BlockDataUtils.compostable(DreamItems.BURNT_MARSHMALLOW.get(), 0.3F);
            BlockDataUtils.compostable(DreamItems.DREAMY_MUSHROOM.get(), 0.45F);
        }
    }

}