package com.mystanica.dreamlands.common.worldgen;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class BedTeleporter implements ITeleporter {
    private static final int SEARCH_RADIUS = 128;
    private static final int MAX_ATTEMPTS = 64;

    @Override
    public Entity placeEntity(Entity entity, ServerLevel current, ServerLevel destination, float yaw, Function<Boolean, Entity> repositionEntity) {
        //BlockPos spawnPos = this.findPortalStyleSpawn(destination, entity.blockPosition());
        //
        //Entity placedEntity = repositionEntity.apply(true);
        //if (placedEntity instanceof ServerPlayer player && player.getServer() != null) {
        //    BlockPos headPos = spawnPos.relative(Direction.NORTH);
        //
        //    if (this.canPlaceBedAt(destination, headPos, spawnPos)) {
        //        BlockState bedState = Blocks.WHITE_BED.defaultBlockState().setValue(BedBlock.FACING, Direction.NORTH);
        //        destination.setBlock(spawnPos, bedState.setValue(BedBlock.PART, BedPart.FOOT), 3);
        //        destination.setBlock(headPos, bedState.setValue(BedBlock.PART, BedPart.HEAD), 3);
        //    }
        //
        //    player.randomTeleport(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(), false);
        //    player.startSleepInBed(spawnPos);
        //    player.stopSleeping();
        //}
        //
        //return placedEntity;
        return repositionEntity.apply(true);
    }

    private BlockPos findPortalStyleSpawn(ServerLevel level, BlockPos origin) {
        BlockPos startPos = origin.offset(
                level.random.nextInt(SEARCH_RADIUS * 2) - SEARCH_RADIUS,
                0,
                level.random.nextInt(SEARCH_RADIUS * 2) - SEARCH_RADIUS
        );
        BlockPos placePos = null;

        double value = Double.MAX_VALUE;
        for (int i = 0; i < 64; i++) {
            BlockPos candidate = this.spiralOffset(startPos, i);

            level.getChunkAt(candidate); /// force chunk load (VERY important for portal-style behavior)

            BlockPos surfacePos = this.findSurface(level, candidate);
            if (surfacePos != null) {
                double distSqr = surfacePos.distSqr(origin);

                if (distSqr < value) {
                    value = distSqr;
                    placePos = surfacePos;
                }
            }
        }

        if (placePos != null) {
            return placePos;
        }

        return level.getSharedSpawnPos();
    }

    private BlockPos spiralOffset(BlockPos pos, int index) {
        int x = 0;
        int z = 0;
        int dx = 0;
        int dz = -1;
        for (int i = 0; i <= index; i++) {
            if (x == z || (x < 0 && x == -z) || (x > 0 && x == 1 - z)) {
                int temp = dx;
                dx = -dz;
                dz = temp;
            }

            x += dx;
            z += dz;
        }

        return pos.offset(x, 0, z);
    }

    private BlockPos findSurface(ServerLevel level, BlockPos pos) {
        int minY = level.getMinBuildHeight();
        int maxY = level.getMaxBuildHeight();

        for (int y = maxY; y > minY; y--) {
            BlockPos groundPos = new BlockPos(pos.getX(), y, pos.getZ());
            BlockState state = level.getBlockState(groundPos);
            BlockState below = level.getBlockState(groundPos.below());
            BlockState above = level.getBlockState(groundPos.above());
            FluidState fluid = level.getFluidState(groundPos);

            if (below.isFaceSturdy(level, groundPos.below(), Direction.UP) && state.isAir() && above.isAir() && fluid.isEmpty()) {
                return groundPos;
            }
        }

        return null;
    }

    private boolean placeBedAt(ServerLevel level, BlockPos pos) {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockPos footPos = pos;
            BlockPos headPos = pos.relative(direction);

            if (this.canPlaceBedAt(level, headPos, footPos)) {
                BlockState bedState = Blocks.WHITE_BED.defaultBlockState().setValue(BedBlock.FACING, direction);
                level.setBlock(footPos, bedState.setValue(BedBlock.PART, BedPart.FOOT), 3);
                level.setBlock(headPos, bedState.setValue(BedBlock.PART, BedPart.HEAD), 3);
            }

            return true;
        }

        return false;
    }

    private boolean canPlaceBedAt(ServerLevel level, BlockPos head, BlockPos foot) {
        BlockState headState = level.getBlockState(head);
        BlockState footState = level.getBlockState(foot);
        BlockState headAbove = level.getBlockState(head.above());
        BlockState footAbove = level.getBlockState(foot.above());
        BlockState headBelow = level.getBlockState(head.below());
        BlockState footBelow = level.getBlockState(foot.below());
        FluidState headFluid = level.getFluidState(head);
        FluidState footFluid = level.getFluidState(foot);

        boolean spaceClear =
                (headState.isAir() || headState.canBeReplaced())
                && headAbove.isAir()
                && (footState.isAir() || footState.canBeReplaced())
                && footAbove.isAir();

        boolean solidSupport =
                headBelow.isFaceSturdy(level, head.below(), Direction.UP)
                && footBelow.isFaceSturdy(level, foot.below(), Direction.UP);

        boolean noFluid =
                headFluid.isEmpty()
                && footFluid.isEmpty();

        return true;
    }

    @Override
    public PortalInfo getPortalInfo(Entity entity, ServerLevel destination, Function<ServerLevel, PortalInfo> info) {
        return new PortalInfo(entity.position(), Vec3.ZERO, 0, 0);
    }

    @Override
    public boolean playTeleportSound(ServerPlayer player, ServerLevel sourceWorld, ServerLevel destWorld) {
        return false;
    }

    @Override
    public boolean isVanilla() {
        return false;
    }

}