package com.mystanica.dreamlands.handler.util;

import com.mystanica.dreamlands.common.data.level.DreamlandsPlayerEntry;
import com.mystanica.dreamlands.common.data.level.DreamlandsSavedData;
import com.mystanica.dreamlands.common.data.level.player.SleepingPlayerData;
import com.mystanica.dreamlands.common.entity.misc.SleepingPlayer;
import com.mystanica.dreamlands.common.worldgen.BedTeleporter;
import com.mystanica.dreamlands.init.DreamEntities;
import com.mystanica.dreamlands.network.DreamNetworking;
import com.mystanica.dreamlands.network.packet.WakeUpPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;

import javax.annotation.Nullable;
import java.util.UUID;
import java.util.function.Consumer;

public class SleepingPlayerEntityUtils {

    /**
     * create a sleeping player based from the actual player when they enter a dream.
     *
     * @param player - create the sleeping player from this player.
     */
    public static void createPlayersSleepingPlayer(ServerLevel level, Player player) {
        DreamlandsSavedData savedData = DreamlandsSavedData.getData(level);
        DreamlandsPlayerEntry playerEntry = savedData.getPlayerById(player.getUUID());

        if (playerEntry.getSleepingPlayerData() == null) {
            playerEntry.saveSleepingPlayerData(SleepingPlayerData.create(player));

            spawnSleepingPlayer(level, player, playerEntry.getSleepingPlayerData());

            savedData.getPlayers().put(player.getUUID(), playerEntry);
            savedData.setChanged();
        }
    }

    public static void removePlayersSleepingPlayer(ServerLevel level, Player player) {
        DreamlandsSavedData savedData = DreamlandsSavedData.getData(level);
        DreamlandsPlayerEntry playerEntry = savedData.getPlayerById(player.getUUID());

        if (playerEntry != null) {
            SleepingPlayerData playerData = playerEntry.getSleepingPlayerData();

            if (playerData != null) {
                getSleepingPlayer(level, playerData.getSleepingPlayersId(), sleepingPlayer -> {
                    sleepingPlayer.stopSleeping();
                    sleepingPlayer.discard();

                    player.startSleeping(playerData.getSleepingPos());
                    player.stopSleeping();

                    DreamNetworking.sendToClient(new WakeUpPacket(playerData.getSleepingPos(), sleepingPlayer.getId()), (ServerPlayer)player);
                });

                playerEntry.clearSleepingPlayerData();
                savedData.setChanged();
            }
        }
    }

    public static void unloadSleepingPlayer(ServerLevel level, Player player) {
        DreamlandsSavedData savedData = DreamlandsSavedData.getData(level);
        DreamlandsPlayerEntry playerEntry = savedData.getPlayerById(player.getUUID());

        if (playerEntry != null) {
            SleepingPlayerData playerData = playerEntry.getSleepingPlayerData();

            if (playerData != null) {
                getSleepingPlayer(level, playerData.getSleepingPlayersId(), sleepingPlayer -> {
                    sleepingPlayer.remove(Entity.RemovalReason.UNLOADED_WITH_PLAYER);
                });
            }
        }
    }

    public static void reloadSleepingPlayer(ServerLevel level, Player player) {
        DreamlandsSavedData savedData = DreamlandsSavedData.getData(level);
        DreamlandsPlayerEntry playerEntry = savedData.getPlayerById(player.getUUID());

        if (playerEntry != null) {
            SleepingPlayerData playerData = playerEntry.getSleepingPlayerData();

            if (playerData != null) {
                if (getSleepingPlayer(level, playerData.getSleepingPlayersId()) == null) {
                    spawnSleepingPlayer(level, player, playerData);
                }
            }
        }
    }

    private static void spawnSleepingPlayer(ServerLevel level, Player player, SleepingPlayerData playerData) {
        SleepingPlayer sleepingPlayer = DreamEntities.SLEEPING_PLAYER.get().create(level);

        if (sleepingPlayer != null && level.isLoaded(playerData.getSleepingPos())) {
            sleepingPlayer.load(playerData.getPlayerData());
            sleepingPlayer.setGameProfile(playerData.getPlayerProfile());
            sleepingPlayer.setUUID(playerData.getSleepingPlayersId());
            sleepingPlayer.setCustomName(player.getName());
            sleepingPlayer.setSleepingPos(playerData.getSleepingPos());
            sleepingPlayer.setPose(Pose.SLEEPING);
            sleepingPlayer.refreshDimensions();
            sleepingPlayer.copyPosition(player);

            level.addFreshEntity(sleepingPlayer);
        }
    }

    public static void wakePlayer(ServerLevel level, ServerPlayer player) {
        if (player.getServer() != null) {
            player.getServer().execute(() -> {
                removePlayersSleepingPlayer(level, player);

                player.getServer().execute(() -> {
                    sendToDimension(player, player.getServer().overworld());
                });
            });
        }
    }

    public static void getSleepingPlayer(ServerLevel level, UUID uuid, Consumer<SleepingPlayer> consumer) {
        Entity entity = level.getEntity(uuid);

        if (entity instanceof SleepingPlayer sleepingPlayer) {
            consumer.accept(sleepingPlayer);
        }
    }

    /**
     * @param level - this needs to be the overworld, as the data is always saved in it.
     * @param uuid -- the uuid of the sleeping player; grabbed from the players' overworld saved data.
     *
     * @return either the sleeping player, or null.
     */
    @Nullable
    public static SleepingPlayer getSleepingPlayer(ServerLevel level, UUID uuid) {
        Entity entity = level.getEntity(uuid);

        if (entity instanceof SleepingPlayer sleepingPlayer) {
            return sleepingPlayer;
        }

        return null;
    }

    @Nullable
    public static Player getPlayerFromSleepingPlayer(SleepingPlayer sleepingPlayer) {
        if (sleepingPlayer.getServer() != null && sleepingPlayer.getGameProfile() != null) {
            UUID uuid = sleepingPlayer.getGameProfile().getId();
            return sleepingPlayer.getServer().getPlayerList().getPlayer(uuid);
        }

        return null;
    }

    public static <T extends LivingEntity> void sendToDimension(T entity, ServerLevel destination) {
        if (entity instanceof Player player) {
            player.changeDimension(destination, new BedTeleporter());
        }
    }

}