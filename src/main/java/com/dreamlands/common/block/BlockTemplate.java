package com.dreamlands.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public interface BlockTemplate {

    static DreamLogBlock log(Block strippedBlock, MapColor yColor, MapColor xzColor) {
        return new DreamLogBlock(strippedBlock, BlockBehaviour.Properties.of().mapColor((state) -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? yColor : xzColor).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava());
    }

    static RotatedPillarBlock strippedLog(MapColor color) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(color).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava());
    }

    static Block planks(MapColor color) {
        return new Block(BlockBehaviour.Properties.of().mapColor(color).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava());
    }

    static StairBlock stairs(Block block) {
        return new StairBlock(block::defaultBlockState, BlockBehaviour.Properties.copy(block));
    }

    static SlabBlock slab(Block block) {
        return new SlabBlock(BlockBehaviour.Properties.copy(block));
    }

    static FenceBlock fence(Block block) {
        return new FenceBlock(BlockBehaviour.Properties.copy(block).forceSolidOn());
    }

    static FenceGateBlock fenceGate(Block block, WoodType woodType) {
        return new FenceGateBlock(BlockBehaviour.Properties.copy(block).forceSolidOn(), woodType);
    }

    static ButtonBlock button(BlockSetType setType) {
        return new ButtonBlock(BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), setType, 30, true);
    }

    static PressurePlateBlock pressurePlate(Block block, BlockSetType setType) {
        return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(block).forceSolidOn().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), setType);
    }

    static TrapDoorBlock trapdoor(Block block, BlockSetType setType) {
        return new TrapDoorBlock(BlockBehaviour.Properties.copy(block).strength(3.0F).noOcclusion().isValidSpawn(BlockTemplate::never).ignitedByLava(), setType);
    }

    static DoorBlock door(Block block, BlockSetType setType) {
        return new DoorBlock(BlockBehaviour.Properties.copy(block).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY), setType);
    }

    static DreamStandingSignBlock sign(Block block, WoodType woodType) {
        return new DreamStandingSignBlock(BlockBehaviour.Properties.copy(block).forceSolidOn().noCollission().strength(1.0F).ignitedByLava(), woodType);
    }

    static DreamWallSignBlock wallSign(Block block, WoodType woodType) {
        return new DreamWallSignBlock(BlockBehaviour.Properties.copy(block), woodType);
    }

    static DreamCeilingHangingSignBlock hangingSign(Block block, WoodType woodType) {
        return new DreamCeilingHangingSignBlock(BlockBehaviour.Properties.copy(block), woodType);
    }

    static DreamWallHangingSignBlock wallHangingSign(Block block, WoodType woodType) {
        return new DreamWallHangingSignBlock(BlockBehaviour.Properties.copy(block), woodType);
    }

    private static Boolean never(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> entityType) {
        return false;
    }
    
}