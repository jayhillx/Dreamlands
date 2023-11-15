package com.dreamlands.common.event;

import com.dreamlands.init.DreamItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * Handles toasting marshmallows mechanic, and eating burnt marshmallows.
 */
public class CampfireEvents {
    private int ticksNearCampfire;

    @SubscribeEvent
    public void standNearCampfire(TickEvent.PlayerTickEvent event) {
        Player player = event.player;

        if (event.phase == TickEvent.Phase.START && player.getItemInHand(player.getUsedItemHand()).is(DreamItems.MARSHMALLOW_ON_A_STICK.get())) {
            Optional<BlockPos> campfirePos = this.findNearestCampfire(player, (state) -> state.is(Blocks.CAMPFIRE));

            if (campfirePos.isPresent()) {
                /// double distance = player.distanceToSqr(campfirePos.get().getX(), campfirePos.get().getY(), campfirePos.get().getZ());
                /// int speed = (int) Math.sqrt(distance) * 2; // speed of how fast it will burn.

                ++this.ticksNearCampfire;
                if (this.ticksNearCampfire == 300) {
                    player.getItemInHand(player.getUsedItemHand()).getOrCreateTag().putInt("Condition", 1);
                } else if (this.ticksNearCampfire == 600) {
                    player.getItemInHand(player.getUsedItemHand()).getOrCreateTag().putInt("Condition", 2);
                } else if (this.ticksNearCampfire >= 700) {
                    player.setItemInHand(player.getUsedItemHand(), new ItemStack(Items.STICK));
                    this.ticksNearCampfire = 0;
                }
            }
        }
    }

    private Optional<BlockPos> findNearestCampfire(Player player, Predicate<BlockState> predicate) {
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        for (int i = 0; (double)i <= 2; i = i > 0 ? -i : 1 - i) {
            for (int j = 0; (double)j < 2; ++j) {
                for (int k = 0; k <= j; k = k > 0 ? -k : 1 - k) {
                    for (int l = k < j && k > -j ? j : 0; l <= j; l = l > 0 ? -l : 1 - l) {
                        mutablePos.setWithOffset(player.getOnPos(), k, i - 1, l);
                        if (player.getOnPos().closerThan(mutablePos, 2) && predicate.test(player.level().getBlockState(mutablePos))) {
                            return Optional.of(mutablePos);
                        }
                    }
                }
            }
        }
        return Optional.empty();
    }

}