package com.mystanica.dreamlands.common.worldgen.feature.tree;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import com.mystanica.dreamlands.common.block.DreamLeavesBlock;
import com.mystanica.dreamlands.common.worldgen.feature.config.DreamTreeConfiguration;
import com.mystanica.dreamlands.init.DreamBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.BitSetDiscreteVoxelShape;
import net.minecraft.world.phys.shapes.DiscreteVoxelShape;

import java.util.Iterator;
import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.BiConsumer;

public abstract class DreamTreeFeature extends Feature<DreamTreeConfiguration> {

    public DreamTreeFeature(Codec<DreamTreeConfiguration> codec) {
        super(codec);
    }

    public abstract boolean placeTree(WorldGenLevel level, RandomSource random, BlockPos initialPos, BiConsumer<BlockPos, BlockState> trunkSetter, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config);

    @Override
    public boolean place(FeaturePlaceContext<DreamTreeConfiguration> context) {
        final WorldGenLevel level = context.level();
        RandomSource random = context.random();
        BlockPos initialPos = context.origin();
        DreamTreeConfiguration config = context.config();

        Set<BlockPos> trunkPositions = Sets.newHashSet();
        Set<BlockPos> branchPositions = Sets.newHashSet();
        final Set<BlockPos> foliagePositions = Sets.newHashSet();
        Set<BlockPos> decoratorPositions = Sets.newHashSet();

        BiConsumer<BlockPos, BlockState> trunkSetter = setter(level, trunkPositions);
        BiConsumer<BlockPos, BlockState> branchSetter = setter(level, branchPositions);
        BiConsumer<BlockPos, BlockState> foliageSetter = setter(level, foliagePositions);
        BiConsumer<BlockPos, BlockState> decoratorSetter = setter(level, decoratorPositions);

        boolean flag = this.doPlace(level, random, initialPos, trunkSetter, branchSetter, foliageSetter, config);
        if (flag && (!branchPositions.isEmpty() || !foliagePositions.isEmpty())) {
            if (!config.decorators.isEmpty()) {
                config.decorators.forEach((decorator) -> decorator.place(new TreeDecorator.Context(level, decoratorSetter, random, branchPositions, foliagePositions, trunkPositions)));
            }
            return BoundingBox.encapsulatingPositions(Iterables.concat(trunkPositions, branchPositions, foliagePositions, decoratorPositions)).map((box) -> {
                StructureTemplate.updateShapeAtEdge(level, 3, updateLeaves(level, box, branchPositions, decoratorPositions, trunkPositions), box.minX(), box.minY(), box.minZ());
                return true;
            }).orElse(false);
        } else {
            return false;
        }
    }

    private static BiConsumer<BlockPos, BlockState> setter(LevelAccessor level, Set<BlockPos> set) {
        return (pos, state) -> {
            set.add(pos.immutable());
            level.setBlock(pos, state, 19);
        };
    }

    private boolean doPlace(WorldGenLevel level, RandomSource random, BlockPos initialPos, BiConsumer<BlockPos, BlockState> trunkSetter, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config) {
        int trunkHeight = config.trunkShape.getTrunkHeight(random);
        int y = initialPos.getY();
        if (y >= level.getMinBuildHeight() + 1 && y + trunkHeight + 1 <= level.getMaxBuildHeight()) {
            if (this.getMaxFreeTreeHeight(level, initialPos, trunkHeight, config) >= trunkHeight) {
                return this.placeTree(level, random, initialPos, trunkSetter, branchSetter, foliageSetter, config);
            }
            return false;
        }
        return false;
    }

    private int getMaxFreeTreeHeight(LevelSimulatedReader level, BlockPos initialPos, int trunkHeight, DreamTreeConfiguration config) {
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        for (int y = 0; y <= trunkHeight + 1; y++) {
            int radius = config.minimumSize.getSizeAtHeight(trunkHeight, y);

            for (int dx = -radius; dx <= radius; dx++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    mutablePos.setWithOffset(initialPos, dx, y, dz);
                    if (!(TreeFeature.validTreePos(level, mutablePos) || level.isStateAtPosition(mutablePos, state -> state.is(BlockTags.LOGS)))) {
                        return y - 2;
                    }
                }
            }
        }
        return trunkHeight;
    }

    private static DiscreteVoxelShape updateLeaves(LevelAccessor level, BoundingBox box, Set<BlockPos> logs, Set<BlockPos> leaves, Set<BlockPos> persistentLeaves) {
        DiscreteVoxelShape shape = new BitSetDiscreteVoxelShape(box.getXSpan(), box.getYSpan(), box.getZSpan());
        List<Set<BlockPos>> list = Lists.newArrayList();

        for (int i = 0; i < 12; i++) {
            list.add(Sets.newHashSet());
        }

        for (BlockPos pos : Lists.newArrayList(Sets.union(leaves, persistentLeaves))) {
            if (box.isInside(pos)) {
                shape.fill(pos.getX() - box.minX(), pos.getY() - box.minY(), pos.getZ() - box.minZ());
            }
        }

        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();
        int currentDistance = 0;
        list.get(0).addAll(logs);

        while (true) {
            while (currentDistance >= 12 || !list.get(currentDistance).isEmpty()) {
                if (currentDistance >= 12) return shape;

                Iterator<BlockPos> iterator = list.get(currentDistance).iterator();
                BlockPos currentPos = iterator.next();
                iterator.remove();

                if (box.isInside(currentPos)) {
                    if (currentDistance != 0) {
                        BlockState state = level.getBlockState(currentPos);
                        if (state.hasProperty(DreamLeavesBlock.DISTANCE)) {
                            level.setBlock(currentPos, state.setValue(DreamLeavesBlock.DISTANCE, currentDistance), 19);
                        }
                    }

                    shape.fill(currentPos.getX() - box.minX(), currentPos.getY() - box.minY(), currentPos.getZ() - box.minZ());

                    for (Direction direction : Direction.values()) {
                        mutablePos.setWithOffset(currentPos, direction);
                        if (box.isInside(mutablePos)) {
                            int dx = mutablePos.getX() - box.minX();
                            int dy = mutablePos.getY() - box.minY();
                            int dz = mutablePos.getZ() - box.minZ();

                            if (!shape.isFull(dx, dy, dz)) {
                                OptionalInt distance = DreamLeavesBlock.getOptionalDistanceAt(level.getBlockState(mutablePos));

                                if (distance.isPresent()) {
                                    int nextDistance = Math.min(distance.getAsInt(), currentDistance + 1);
                                    if (nextDistance < 12) {
                                        list.get(nextDistance).add(mutablePos.immutable());
                                        currentDistance = Math.min(currentDistance, nextDistance);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            ++currentDistance;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    protected static void setDirtAt(LevelSimulatedReader level, RandomSource random, BlockPos pos, BiConsumer<BlockPos, BlockState> trunkSetter, DreamTreeConfiguration config) {
        if (!level.isStateAtPosition(pos, state -> state.is(BlockTags.DIRT) && !state.is(DreamBlocks.DREAMY_GRASS_BLOCK.get()))) {
            trunkSetter.accept(pos, config.dirtProvider.getState(random, pos));
        }
    }

    protected void placeTrunk(LevelAccessor level, RandomSource random, BlockPos initialPos, BiConsumer<BlockPos, BlockState> trunkSetter, DreamTreeConfiguration config, int currentY, boolean doubleTrunk) {
        setDirtAt(level, random, initialPos.below(), trunkSetter, config);
        this.placeLog(level, random, initialPos.above(currentY), Direction.Axis.Y, trunkSetter, config);

        if (doubleTrunk) {
            BlockPos[] positions = {initialPos.east(), initialPos.east().south(), initialPos.south()};

            for (BlockPos pos : positions) {
                setDirtAt(level, random, pos.below(), trunkSetter, config);
                this.placeLog(level, random, pos.above(currentY), Direction.Axis.Y, trunkSetter, config);
            }
        }
    }

    protected void placeLog(LevelAccessor level, RandomSource random, BlockPos pos, Direction.Axis axis, BiConsumer<BlockPos, BlockState> blockSetter, DreamTreeConfiguration config) {
        if (level.isStateAtPosition(pos, state -> state.isAir() || state.is(BlockTags.LEAVES) || state.is(BlockTags.REPLACEABLE_BY_TREES))) {
            blockSetter.accept(pos, config.trunkProvider.getState(random, pos).setValue(RotatedPillarBlock.AXIS, axis));
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * @param doubleTrunk determines if the branchPos should be offset on a double sized trunk.
     * branches on large trunks will be randomly placed on the left/right side of each side of the trunk.
     */
    protected BlockPos getBranchPos(BlockPos currentPos, Direction branchDirection, boolean randomizePos, boolean doubleTrunk) {
        BlockPos branchPos = currentPos.relative(branchDirection);
        return !doubleTrunk ? branchPos : switch (branchDirection) {
            case NORTH -> randomizePos ? branchPos.east() : branchPos;
            case EAST ->  randomizePos ? branchPos.east().south() : branchPos.east();
            case SOUTH -> randomizePos ? branchPos.south().east() : branchPos.south();
            case WEST ->  randomizePos ? branchPos.south() : branchPos;
            default -> branchPos;
        };
    }

    protected boolean canPlaceBranch(LevelAccessor level, BlockPos branchPos, Direction direction, int checkHeight) {
        for (int y = -checkHeight; y <= checkHeight; y++) {
            if (level.isEmptyBlock(branchPos.relative(direction).above(y))) {
                return true;
            }
        }
        return false;
    }

    protected boolean canGenerateBranch(LevelAccessor level, BlockPos branchPos, Direction direction, int branchLength) {
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        for (int i = 0; i <= branchLength; i++) {
            mutablePos.set(branchPos).move(direction, 1);
            if (!level.isEmptyBlock(branchPos)) return false;// || level.getBlockState(branchPos).is(BlockTags.LEAVES)) return false;
        }
        return true;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    protected void placeBushyFoliage(LevelAccessor level, RandomSource random, BlockPos pos, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config, int foliageRadius, int foliageHeight, boolean doubleTrunk) {
        this.placeBushyFoliage(level, random, pos, foliageSetter, config, foliageRadius, foliageHeight, doubleTrunk, 0.5D);
    }

    protected void placeBushyFoliage(LevelAccessor level, RandomSource random, BlockPos pos, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config, int foliageRadius, int foliageHeight, boolean doubleTrunk, double randomProbability) {
        BlockPos.MutableBlockPos mutablePos = pos.mutable();

        for (int y = 0; y < foliageHeight; y++) {
            this.placeLeavesRow(level, random, mutablePos, foliageSetter, config, foliageRadius, doubleTrunk, true, randomProbability);
            mutablePos.move(Direction.UP);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    protected void placeLeafShape(LevelAccessor level, RandomSource random, BlockPos pos, Direction direction, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config) {
        for (Direction directions : Direction.Plane.HORIZONTAL) {
            this.placeLeaves(level, random, pos.above(), foliageSetter, config);
            BlockPos relativePos = pos.relative(directions);
            this.placeLeaves(level, random, relativePos, foliageSetter, config);
            this.placeLeaves(level, random, relativePos.above(), foliageSetter, config);
        }

        BlockPos clockWisePos = pos.relative(random.nextBoolean() ? direction.getClockWise() : direction.getCounterClockWise());
        this.placeLeaves(level, random, clockWisePos.above(), foliageSetter, config);
        this.placeLeaves(level, random, clockWisePos.relative(direction), foliageSetter, config);
    }

    protected void placeLogWithSurroundingLeaves(LevelAccessor level, RandomSource random, BlockPos branchPos, Direction branchDirection, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config, boolean hasOffsetLeaves, boolean hasBottomLeaves) {
        this.placeLogWithSurroundingLeaves(level, random, branchPos, branchDirection, branchDirection, branchSetter, foliageSetter, config, hasOffsetLeaves, hasBottomLeaves);
    }

    /**
     * @param branchDirection -
     * @param hasOffsetLeaves -
     * @param hasBottomLeaves -
     */
    protected void placeLogWithSurroundingLeaves(
            LevelAccessor level,
            RandomSource random,
            BlockPos branchPos,
            Direction branchDirection,
            Direction offsetDirection,
            BiConsumer<BlockPos, BlockState> branchSetter,
            BiConsumer<BlockPos, BlockState> foliageSetter,
            DreamTreeConfiguration config,
            boolean hasOffsetLeaves,
            boolean hasBottomLeaves
    ) {
        this.placeLog(level, random, branchPos, branchDirection.getAxis(), branchSetter, config);

        for (Direction directions : Direction.values()) {
            if (directions == Direction.DOWN && !hasBottomLeaves) {
                continue;
            }

            this.placeLeaves(level, random, branchPos.relative(directions), foliageSetter, config);

            if (hasOffsetLeaves) {
                this.placeLeaves(level, random, branchPos.offset(offsetDirection.getNormal().relative(offsetDirection.getClockWise())), foliageSetter, config);
            }
        }
    }

    protected void placeLeavesRow(LevelAccessor level, RandomSource random, BlockPos pos, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config, int foliageRadius, boolean doubleTrunk, boolean randomFoliage) {
        this.placeLeavesRow(level, random, pos, foliageSetter, config, foliageRadius, doubleTrunk, randomFoliage, 0.5D);
    }

    protected void placeLeavesRow(LevelAccessor level, RandomSource random, BlockPos pos, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config, int foliageRadius, boolean doubleTrunk, boolean randomFoliage, double randomProbability) {
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        int extraRange = doubleTrunk ? 1 : 0;
        for (int x = -foliageRadius; x <= foliageRadius + extraRange; x++) {
            for (int z = -foliageRadius; z <= foliageRadius + extraRange; z++) {
                if (!this.shouldSkipLocationSigned(random, x, 0, z, foliageRadius, doubleTrunk)) {
                    mutablePos.setWithOffset(pos, x, 0, z);

                    this.placeLeaves(level, random, mutablePos, foliageSetter, config);
                    if (randomFoliage) {
                        this.placeRandomLeaves(level, random, mutablePos, foliageSetter, config, randomProbability);
                    }
                }
            }
        }
    }

    /**
     * place row of leaves without the chance of placing random leaves.
     */
    protected void placeLeavesRow(LevelAccessor level, RandomSource random, BlockPos pos, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config, int foliageHeight, int foliageRadius, boolean doubleTrunk) {
        this.placeLeavesRow(level, random, pos, foliageSetter, config, foliageHeight, foliageRadius, 0.0D, doubleTrunk);
    }

    protected void placeLeavesRow(LevelAccessor level,
                                  RandomSource random,
                                  BlockPos pos,
                                  BiConsumer<BlockPos, BlockState> foliageSetter,
                                  DreamTreeConfiguration config,
                                  int foliageHeight,
                                  int foliageRadius,
                                  double randomFoliageChance,
                                  boolean doubleTrunk
    ) {
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        int extraRange = doubleTrunk ? 1 : 0;
        for (int x = -foliageRadius; x <= foliageRadius + extraRange; x++) {
            for (int z = -foliageRadius; z <= foliageRadius + extraRange; z++) {
                if (!this.shouldSkipLocationSigned(random, x, foliageHeight, z, foliageRadius, doubleTrunk)) {
                    mutablePos.setWithOffset(pos, x, foliageHeight, z);

                    this.placeLeaves(level, random, mutablePos, foliageSetter, config);
                    if (randomFoliageChance > 0.0D) {
                        this.placeRandomLeaves(level, random, mutablePos, foliageSetter, config, randomFoliageChance);
                    }
                }
            }
        }
    }

    protected void placeRandomLeaves(LevelAccessor level, RandomSource random, BlockPos pos, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config) {
        this.placeRandomLeaves(level, random, pos, foliageSetter, config, 0.5D);
    }

    protected void placeRandomLeaves(LevelAccessor level, RandomSource random, BlockPos pos, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config, double probability) {
        for (Direction direction : Direction.values()) {
            if (random.nextDouble() < probability) {
                if (level.getBlockState(pos.relative(direction)).isAir()) {
                    this.placeLeaves(level, random, pos.relative(direction), foliageSetter, config);
                }
            }
        }
    }

    protected void placeLeaves(LevelAccessor level, RandomSource random, BlockPos pos, BiConsumer<BlockPos, BlockState> foliageSetter, DreamTreeConfiguration config) {
        if (TreeFeature.validTreePos(level, pos)) {
            BlockState state = config.foliageProvider.getState(random, pos).setValue(DreamLeavesBlock.PERSISTENT, false);
            if (state.hasProperty(BlockStateProperties.WATERLOGGED)) {
                state = state.setValue(BlockStateProperties.WATERLOGGED, level.isFluidAtPosition(pos, fluidState -> fluidState.isSourceOfType(Fluids.WATER)));
            }

            foliageSetter.accept(pos, state);
        }
    }

    protected boolean shouldSkipLocationSigned(RandomSource random, int x, int y, int z, int radius, boolean doubleTrunk) {
        int absX, absZ;
        if (doubleTrunk) {
            absX = Math.min(Math.abs(x), Math.abs(x - 1));
            absZ = Math.min(Math.abs(z), Math.abs(z - 1));
        } else {
            absX = Math.abs(x);
            absZ = Math.abs(z);
        }
        return this.shouldSkipLocation(random, absX, y, absZ, radius, doubleTrunk);
    }

    protected abstract boolean shouldSkipLocation(RandomSource random, int x, int y, int z, int radius, boolean doubleTrunk);

}