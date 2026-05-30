package com.mystanica.dreamlands.init;

import com.mystanica.dreamlands.Dreamlands;
import com.mystanica.dreamlands.common.block.entity.DreamHangingSignBlockEntity;
import com.mystanica.dreamlands.common.block.entity.DreamSignBlockEntity;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

public class DreamBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Dreamlands.modId);

    public static final RegistryObject<BlockEntityType<DreamSignBlockEntity>> SIGN = BLOCK_ENTITIES.register("sign", () -> {
        return BlockEntityType.Builder.of(DreamSignBlockEntity::new,
                DreamBlocks.DREAMY_SIGN.get(), DreamBlocks.DREAMY_WALL_SIGN.get(),
                ///DreamBlocks.ASPEN_SIGN.get(), DreamBlocks.ASPEN_WALL_SIGN.get(),
                DreamBlocks.EVERGREEN_SIGN.get(), DreamBlocks.EVERGREEN_WALL_SIGN.get(),
                DreamBlocks.ETHEREAL_SIGN.get(), DreamBlocks.ETHEREAL_WALL_SIGN.get(),
                DreamBlocks.CANDY_SIGN.get(), DreamBlocks.CANDY_WALL_SIGN.get(),
                DreamBlocks.WISTERIA_SIGN.get(), DreamBlocks.WISTERIA_WALL_SIGN.get(),
                DreamBlocks.MYSTICAL_SIGN.get(), DreamBlocks.MYSTICAL_WALL_SIGN.get(),
                DreamBlocks.MUSHROOM_SIGN.get(), DreamBlocks.MUSHROOM_WALL_SIGN.get()
                ///DreamBlocks.GLOOMY_SIGN.get(), DreamBlocks.GLOOMY_WALL_SIGN.get(),
                ///DreamBlocks.GRIMWOOD_SIGN.get(), DreamBlocks.GRIMWOOD_WALL_SIGN.get(),
                ///DreamBlocks.DEAD_SIGN.get(), DreamBlocks.DEAD_WALL_SIGN.get(),
                ///DreamBlocks.PINE_SIGN.get(), DreamBlocks.PINE_WALL_SIGN.get(),
                ///DreamBlocks.POISED_SIGN.get(), DreamBlocks.POISED_WALL_SIGN.get(),
                ///DreamBlocks.BLOODWOOD_SIGN.get(), DreamBlocks.BLOODWOOD_WALL_SIGN.get(),
                ///DreamBlocks.SOUR_SIGN.get(), DreamBlocks.SOUR_WALL_SIGN.get(),
                ///DreamBlocks.FUNGUS_SIGN.get(), DreamBlocks.FUNGUS_WALL_SIGN.get()
        ).build(Objects.requireNonNull(Util.fetchChoiceType(References.BLOCK_ENTITY, "sign")));
    });
    public static final RegistryObject<BlockEntityType<DreamHangingSignBlockEntity>> HANGING_SIGN = BLOCK_ENTITIES.register("hanging_sign", () -> {
        return BlockEntityType.Builder.of(DreamHangingSignBlockEntity::new,
                DreamBlocks.DREAMY_HANGING_SIGN.get(), DreamBlocks.DREAMY_WALL_HANGING_SIGN.get(),
                ///DreamBlocks.ASPEN_HANGING_SIGN.get(), DreamBlocks.ASPEN_WALL_HANGING_SIGN.get(),
                DreamBlocks.EVERGREEN_HANGING_SIGN.get(), DreamBlocks.EVERGREEN_WALL_HANGING_SIGN.get(),
                DreamBlocks.ETHEREAL_HANGING_SIGN.get(), DreamBlocks.ETHEREAL_WALL_HANGING_SIGN.get(),
                DreamBlocks.CANDY_HANGING_SIGN.get(), DreamBlocks.CANDY_WALL_HANGING_SIGN.get(),
                DreamBlocks.WISTERIA_HANGING_SIGN.get(), DreamBlocks.WISTERIA_WALL_HANGING_SIGN.get(),
                DreamBlocks.MYSTICAL_HANGING_SIGN.get(), DreamBlocks.MYSTICAL_WALL_HANGING_SIGN.get(),
                DreamBlocks.MUSHROOM_HANGING_SIGN.get(), DreamBlocks.MUSHROOM_WALL_HANGING_SIGN.get()
                ///DreamBlocks.GLOOMY_HANGING_SIGN.get(), DreamBlocks.GLOOMY_WALL_HANGING_SIGN.get(),
                ///DreamBlocks.GRIMWOOD_HANGING_SIGN.get(), DreamBlocks.GRIMWOOD_WALL_HANGING_SIGN.get(),
                ///DreamBlocks.DEAD_HANGING_SIGN.get(), DreamBlocks.DEAD_WALL_HANGING_SIGN.get(),
                ///DreamBlocks.PINE_HANGING_SIGN.get(), DreamBlocks.PINE_WALL_HANGING_SIGN.get(),
                ///DreamBlocks.POISED_HANGING_SIGN.get(), DreamBlocks.POISED_WALL_HANGING_SIGN.get(),
                ///DreamBlocks.BLOODWOOD_HANGING_SIGN.get(), DreamBlocks.BLOODWOOD_WALL_HANGING_SIGN.get(),
                ///DreamBlocks.SOUR_HANGING_SIGN.get(), DreamBlocks.SOUR_WALL_HANGING_SIGN.get(),
                ///DreamBlocks.FUNGUS_HANGING_SIGN.get(), DreamBlocks.FUNGUS_WALL_HANGING_SIGN.get()
        ).build(Objects.requireNonNull(Util.fetchChoiceType(References.BLOCK_ENTITY, "hanging_sign")));
    });

}