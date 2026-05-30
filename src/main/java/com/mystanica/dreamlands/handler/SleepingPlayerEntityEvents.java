package com.mystanica.dreamlands.handler;

import com.mystanica.dreamlands.Dreamlands;
import com.mystanica.dreamlands.common.entity.misc.SleepingPlayer;
import com.mystanica.dreamlands.init.DreamCriteriaTriggers;
import com.mystanica.dreamlands.init.DreamDimensions;
import com.mystanica.dreamlands.init.DreamEffects;
import com.mystanica.dreamlands.init.DreamTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import static com.mystanica.dreamlands.handler.util.SleepingPlayerEntityUtils.*;

/**
 * events for handling the sleeping player entity.
 */
public class SleepingPlayerEntityEvents {

    @SubscribeEvent
    public void playerSleepInBed(TickEvent.PlayerTickEvent event) {
        Player player = event.player;

        if (!player.isSleepingLongEnough()) return;// todo: && !player.hasEffect(DreamEffects.SLEEPY.get())) return;

        if (!player.level().isClientSide()) {
            if (player.getServer() != null) {
                if (player.level().dimension() == Level.OVERWORLD) {
                    ServerLevel dreamland = player.getServer().getLevel(DreamDimensions.DREAMLAND);

                    if (dreamland != null) {
                        DreamCriteriaTriggers.ENTER_DREAM.trigger((ServerPlayer)player);
                        sendToDimension(player, dreamland);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void playerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        Player player = event.getEntity();
        if (player.isCreative() || player.isSpectator()) return; /// ignore this feature if player is in creative or a spectator.

        if (player.getServer() != null) {
            ServerLevel overworld = player.getServer().overworld();

            boolean toDreamland = event.getFrom() == Level.OVERWORLD && event.getTo() == DreamDimensions.DREAMLAND;
            boolean toOverworld = event.getFrom() == DreamDimensions.DREAMLAND && event.getTo() == Level.OVERWORLD;

            if (toDreamland) {
                createPlayersSleepingPlayer(overworld, player);
                player.forceAddEffect(new MobEffectInstance(DreamEffects.DREAMING.get(), -1, 0, false, false, false), player);
            }

            if (toOverworld) {
                wakePlayer(overworld, (ServerPlayer)player);
                player.removeEffect(DreamEffects.DREAMING.get());
            }
        }
    }

    @SubscribeEvent
    public void sleepingPlayerHurt(LivingDamageEvent event) {
        if (event.getEntity() instanceof SleepingPlayer sleepingPlayer) {
            Player player = getPlayerFromSleepingPlayer(sleepingPlayer);

            if (player != null && player.getServer() != null) {
                player.hurt(event.getSource(), event.getAmount());

                if (player.level().dimension() == Level.OVERWORLD) {
                    return;
                }

                /// eventually add some feature so they will be stuck in the dream while they die.
                if (player.level().getRandom().nextFloat() < 0.5F || event.getSource().is(DamageTypes.EXPLOSION)) {
                    DreamCriteriaTriggers.WOKEN_UP_FROM_SLEEP.trigger((ServerPlayer)player);
                    sendToDimension(player, player.getServer().overworld()); /// 50% chance of waking the player up from the dream.
                }
            }
        }
    }

    @SubscribeEvent
    public void sleepingPlayerDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (event.getSource() instanceof DreamTags.DamageSourceTag tag) {
                tag.setWasInDream(true);
            }
        }

        if (event.getEntity() instanceof SleepingPlayer sleepingPlayer) {
            Player player = getPlayerFromSleepingPlayer(sleepingPlayer);

            if (player != null) {
                if (event.getSource() instanceof DreamTags.DamageSourceTag tag) {
                    tag.setFromSleepingPlayer(true);
                }

                player.die(event.getSource());
                player.setHealth(0.0F);
            }
        }
    }

    @SubscribeEvent
    public void playerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
        Player player = event.getEntity();

        if (player.getServer() != null) {
            unloadSleepingPlayer(player.getServer().overworld(), player);
        }
    }

    @SubscribeEvent
    public void playerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();

        if (player.getServer() != null) {
            reloadSleepingPlayer(player.getServer().overworld(), player);
        }
    }

}