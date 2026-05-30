package com.mystanica.dreamlands.common.block.state;

import com.mystanica.dreamlands.Dreamlands;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DreamWoodTypes {

    public static final WoodType DREAMY = register("dreamy", DreamBlockSetTypes.DREAMY);
    public static final WoodType ASPEN = register("aspen", DreamBlockSetTypes.ASPEN);
    public static final WoodType EVERGREEN = register("evergreen", DreamBlockSetTypes.EVERGREEN);
    public static final WoodType ETHEREAL = register("ethereal", DreamBlockSetTypes.ETHEREAL);
    public static final WoodType CANDY = register("candy", DreamBlockSetTypes.CANDY);
    public static final WoodType WISTERIA = register("wisteria", DreamBlockSetTypes.WISTERIA);
    public static final WoodType MYSTICAL = register("mystical", DreamBlockSetTypes.MYSTICAL);
    public static final WoodType MUSHROOM = register("mushroom", DreamBlockSetTypes.MUSHROOM);
    ///public static final WoodType GLOOMY = register("gloomy", DreamBlockSetTypes.GLOOMY);
    ///public static final WoodType GRIMWOOD = register("grimwood", DreamBlockSetTypes.GRIMWOOD);
    ///public static final WoodType PINE = register("pine", DreamBlockSetTypes.PINE);
    ///public static final WoodType POISED = register("poised", DreamBlockSetTypes.POISED);
    ///public static final WoodType DEAD = register("dead", DreamBlockSetTypes.DEAD);
    ///public static final WoodType BLOODWOOD = register("bloodwood", DreamBlockSetTypes.BLOODWOOD);
    ///public static final WoodType SOUR = register("sour", DreamBlockSetTypes.SOUR);
    ///public static final WoodType FUNGUS = register("fungus", DreamBlockSetTypes.FUNGUS);

    private static WoodType register(String name, BlockSetType type) {
        return WoodType.register(new WoodType(Dreamlands.modId + ":" + name, type));
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerWoodTypes() {
        Sheets.addWoodType(DREAMY);
        Sheets.addWoodType(ASPEN);
        Sheets.addWoodType(EVERGREEN);
        Sheets.addWoodType(ETHEREAL);
        Sheets.addWoodType(CANDY);
        Sheets.addWoodType(WISTERIA);
        Sheets.addWoodType(MYSTICAL);
        Sheets.addWoodType(MUSHROOM);
        ///Sheets.addWoodType(GLOOMY);
        ///Sheets.addWoodType(GRIMWOOD);
        ///Sheets.addWoodType(PINE);
        ///Sheets.addWoodType(POISED);
        ///Sheets.addWoodType(DEAD);
        ///Sheets.addWoodType(BLOODWOOD);
        ///Sheets.addWoodType(SOUR);
        ///Sheets.addWoodType(FUNGUS);
    }

}