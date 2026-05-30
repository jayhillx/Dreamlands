package com.mystanica.dreamlands.network.packet;

import com.mystanica.dreamlands.common.entity.misc.SleepingPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class WakeUpPacket {
    private final BlockPos sleepingPos;
    private final int sleepingPlayerId;

    public WakeUpPacket(BlockPos sleepingPos, int sleepingPlayerId) {
        this.sleepingPos = sleepingPos;
        this.sleepingPlayerId = sleepingPlayerId;
    }

    public static void encode(WakeUpPacket msg, FriendlyByteBuf buf) {
        buf.writeBlockPos(msg.sleepingPos);
        buf.writeInt(msg.sleepingPlayerId);
    }

    public static WakeUpPacket decode(FriendlyByteBuf buf) {
        return new WakeUpPacket(buf.readBlockPos(), buf.readInt());
    }

    public static void handle(WakeUpPacket msg, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            Player player = context.get().getSender();

            if (context.get().getDirection().getReceptionSide() == LogicalSide.CLIENT) {
                player = Minecraft.getInstance().player;
            }

            if (player != null) {
                Entity entity = player.level().getEntity(msg.sleepingPlayerId);
                if (entity instanceof SleepingPlayer sleepingPlayer) {
                    sleepingPlayer.stopSleeping();
                    sleepingPlayer.discard();
                }

                player.startSleeping(msg.sleepingPos);
                player.stopSleeping();
            }
        });

        context.get().setPacketHandled(true);
    }

}