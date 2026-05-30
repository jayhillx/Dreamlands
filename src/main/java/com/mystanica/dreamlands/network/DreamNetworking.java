package com.mystanica.dreamlands.network;

import com.mystanica.dreamlands.Dreamlands;
import com.mystanica.dreamlands.network.packet.WakeUpPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.server.ServerLifecycleHooks;

public class DreamNetworking {
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            Dreamlands.modLoc("main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );
    private static int packetId = 0;

    public static void register() {
        INSTANCE.registerMessage(
                packetId++,
                WakeUpPacket.class,
                WakeUpPacket::encode,
                WakeUpPacket::decode,
                WakeUpPacket::handle
        );
    }

    public static <MSG> void sendToAll(MSG msg) {
        for (ServerPlayer player : ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayers()) {
            sendToClient(msg, player);
        }
    }

    public static <MSG> void sendToClient(MSG msg, ServerPlayer player) {
        INSTANCE.sendTo(msg, player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
    }

    public static <MSG> void sendToServer(MSG msg) {
        INSTANCE.sendToServer(msg);
    }

}