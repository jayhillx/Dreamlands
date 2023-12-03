package com.dreamlands.init;

import com.dreamlands.Dreamlands;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

public class DreamBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Dreamlands.modId);

    public static final RegistryObject<BlockEntityType<SignBlockEntity>> SIGN = BLOCK_ENTITIES.register("sign", () -> BlockEntityType.Builder.of(SignBlockEntity::new, DreamBlocks.EVERGREEN_SIGN.get(), DreamBlocks.EVERGREEN_WALL_SIGN.get(), DreamBlocks.ETHEREAL_SIGN.get(), DreamBlocks.ETHEREAL_WALL_SIGN.get(), DreamBlocks.CANDY_SIGN.get(), DreamBlocks.CANDY_WALL_SIGN.get()).build(Objects.requireNonNull(Util.fetchChoiceType(References.BLOCK_ENTITY, "sign"))));
    public static final RegistryObject<BlockEntityType<HangingSignBlockEntity>> HANGING_SIGN = BLOCK_ENTITIES.register("hanging_sign", () -> BlockEntityType.Builder.of(HangingSignBlockEntity::new, DreamBlocks.EVERGREEN_HANGING_SIGN.get(), DreamBlocks.EVERGREEN_WALL_HANGING_SIGN.get(), DreamBlocks.ETHEREAL_HANGING_SIGN.get(), DreamBlocks.ETHEREAL_WALL_HANGING_SIGN.get(), DreamBlocks.CANDY_HANGING_SIGN.get(), DreamBlocks.CANDY_WALL_HANGING_SIGN.get()).build(Objects.requireNonNull(Util.fetchChoiceType(References.BLOCK_ENTITY, "hanging_sign"))));

}