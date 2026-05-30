package com.mystanica.dreamlands.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.level.SaplingGrowTreeEvent;
import net.minecraftforge.eventbus.api.Event;

import java.util.Optional;

public class MushroomBlock extends BushBlock implements BonemealableBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty AMOUNT = IntegerProperty.create("amount", 1, 3);
    public static final BooleanProperty SHELF = BooleanProperty.create("shelf");
    private final ResourceKey<ConfiguredFeature<?, ?>> feature;

    public MushroomBlock(ResourceKey<ConfiguredFeature<?, ?>> feature, Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(AMOUNT, 1).setValue(SHELF, false));
        this.feature = feature;
    }
    
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if (state.getValue(SHELF)) {
            return switch (state.getValue(FACING)) {
                case EAST -> Block.box(0.0D, 0.0D, 0.0D, 5.0D, 16.0D, 16.0D);
                case SOUTH -> Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 5.0D);
                case WEST -> Block.box(11.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
                default -> Block.box(0.0D, 0.0D, 11.0D, 16.0D, 16.0D, 16.0D);
            };
        } else {
            return Block.box(2.0D, 0.0D, 2.0D, 14.0D, 8.0D, 14.0D);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        LevelReader level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Direction face = context.getClickedFace();

        BlockState state = level.getBlockState(pos);
        if (state.is(this)) {
            return state.setValue(AMOUNT, Math.min(3, state.getValue(AMOUNT) + 1));
        }

        if (face.getAxis().isHorizontal()) {
            return this.defaultBlockState().setValue(FACING, face).setValue(AMOUNT, 1).setValue(SHELF, true);
        }

        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()).setValue(AMOUNT, 1).setValue(SHELF, false);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return !context.isSecondaryUseActive() && context.getItemInHand().is(this.asItem()) && state.getValue(AMOUNT) < 3;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos belowPos = pos.below();
        BlockState belowState = level.getBlockState(belowPos);
        if (belowState.is(BlockTags.MUSHROOM_GROW_BLOCK)) {
            return true;
        } else {
            return level.getRawBrightness(pos, 0) < 13 && belowState.canSustainPlant(level, belowPos, Direction.UP, this);
        }
    }
    
    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.isSolidRender(level, pos);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, AMOUNT, SHELF);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean valid) {
        return state.getValue(AMOUNT) == 1 && !state.getValue(SHELF);
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return (double)random.nextFloat() < 0.4F;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        this.growMushroom(level, pos, state, random);
    }

    public boolean growMushroom(ServerLevel level, BlockPos pos, BlockState state, RandomSource random) {
        Optional<? extends Holder<ConfiguredFeature<?, ?>>> optional = level.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).getHolder(this.feature);
        if (optional.isEmpty()) {
            return false;
        } else {
            SaplingGrowTreeEvent event = ForgeEventFactory.blockGrowFeature(level, random, pos, optional.get());
            if (event.getResult().equals(Event.Result.DENY)) {
                return false;
            } else {
                level.removeBlock(pos, false);
                if (event.getFeature().value().place(level, level.getChunkSource().getGenerator(), random, pos)) {
                    return true;
                } else {
                    level.setBlock(pos, state, 3);
                    return false;
                }
            }
        }
    }
    
}