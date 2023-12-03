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

public class CampfireEvents {
    private int ticksNearCampfire = 0;

    @SubscribeEvent
    public void onStandingNearCampfire(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        ItemStack stack = player.getItemInHand(player.getUsedItemHand());

        if (event.phase == TickEvent.Phase.START && stack.is(DreamItems.MARSHMALLOW_ON_A_STICK.get())) {
            Optional<BlockPos> campfirePos = this.findNearestCampfire(player, (state) -> state.is(Blocks.CAMPFIRE));

            if (campfirePos.isPresent()) {
                ++this.ticksNearCampfire;
                if (this.ticksNearCampfire == 300) {
                    player.setItemInHand(player.getUsedItemHand(), new ItemStack(DreamItems.TOASTED_MARSHMALLOW_ON_A_STICK.get()));
                } else if (this.ticksNearCampfire == 450) {
                    player.setItemInHand(player.getUsedItemHand(), new ItemStack(DreamItems.BURNT_MARSHMALLOW_ON_A_STICK.get()));
                } else if (this.ticksNearCampfire >= 550) {
                    player.setItemInHand(player.getUsedItemHand(), Items.STICK.getDefaultInstance());
                }
            } else {
                this.ticksNearCampfire = 0;
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