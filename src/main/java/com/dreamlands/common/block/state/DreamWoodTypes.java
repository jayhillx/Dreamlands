package com.dreamlands.common.block.state;

import com.dreamlands.Dreamlands;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static net.minecraft.world.level.block.state.properties.WoodType.register;

public class DreamWoodTypes {

    public static final WoodType EVERGREEN = register(new WoodType(Dreamlands.modId + ":evergreen", DreamBlockSetTypes.EVERGREEN));
    public static final WoodType ETHEREAL = register(new WoodType(Dreamlands.modId + ":ethereal", DreamBlockSetTypes.ETHEREAL));
    public static final WoodType CANDY = register(new WoodType(Dreamlands.modId + ":candy", DreamBlockSetTypes.CANDY));

    /**
     * Register new wood types. (Enqueued in {@link Dreamlands::clientSetup})
     */
    @OnlyIn(Dist.CLIENT)
    public static void registerWoodTypes() {
        Sheets.addWoodType(EVERGREEN);
        Sheets.addWoodType(ETHEREAL);
        Sheets.addWoodType(CANDY);
    }

}