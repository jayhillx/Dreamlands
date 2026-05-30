package com.mystanica.dreamlands.common.block.state;

import com.mystanica.dreamlands.Dreamlands;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class DreamBlockSetTypes {

    public static final BlockSetType DREAMSTONE = register("dreamstone");
    ///public static final BlockSetType GRIMSTONE = register("grimstone");

    public static final BlockSetType DREAMY = register("dreamy");
    public static final BlockSetType ASPEN = register("aspen");
    public static final BlockSetType EVERGREEN = register("evergreen");
    public static final BlockSetType ETHEREAL = register("ethereal");
    public static final BlockSetType CANDY = register("candy");
    public static final BlockSetType WISTERIA = register("wisteria");
    public static final BlockSetType MYSTICAL = register("mystical");
    public static final BlockSetType MUSHROOM = register("mushroom");
    ///public static final BlockSetType GLOOMY = register("gloomy");
    ///public static final BlockSetType GRIMWOOD = register("grimwood");
    ///public static final BlockSetType PINE = register("pine");
    ///public static final BlockSetType POISED = register("poised");
    ///public static final BlockSetType DEAD = register("dead");
    ///public static final BlockSetType BLOODWOOD = register("bloodwood");
    ///public static final BlockSetType SOUR = register("sour");
    ///public static final BlockSetType FUNGUS = register("fungus");

    private static BlockSetType register(String name) {
        return BlockSetType.register(new BlockSetType(Dreamlands.modId + ":" + name));
    }

    // DREAMY
    // ASPEN
    // EVERGREEN
    // ETHEREAL
    // CANDY
    // WISTERIA
    // MYSTICAL
    // MUSHROOM
    // GLOOMY
    // GRIMWOOD
    // PINE
    // POISED
    // DEAD
    // BLOODWOOD
    // SOUR
    // FUNGUS

    // dreamy
    // aspen
    // evergreen
    // ethereal
    // candy
    // wisteria
    // mystical
    // mushroom
    // gloomy
    // grimwood
    // pine
    // poised
    // dead
    // bloodwood
    // sour
    // fungus

}