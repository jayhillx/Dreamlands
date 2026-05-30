package com.mystanica.dreamlands.network.packet;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SyncInventoryPacket {
    public int player;
    public int slotId;
    public ItemStack stack;

    public SyncInventoryPacket(int player, int slotId, ItemStack stack) {
        this.player = player;
        this.slotId = slotId;
        this.stack = stack;
    }

    public static SyncInventoryPacket read(FriendlyByteBuf buf) {
        return new SyncInventoryPacket(buf.readInt(), buf.readInt(), buf.readItem());
    }

    public static void write(SyncInventoryPacket message, FriendlyByteBuf buf) {
        buf.writeInt(message.player);
        buf.writeInt(message.slotId);
        buf.writeItem(message.stack);
    }

    public static void handle(SyncInventoryPacket message, Supplier<NetworkEvent.Context> context) {
        context.get().setPacketHandled(true);
        context.get().enqueueWork(() -> {
            Player sender = context.get().getSender();

            if (context.get().getDirection().getReceptionSide() == LogicalSide.CLIENT) {
                sender = Minecraft.getInstance().player;
            }

            if (sender != null) {
                Entity entity = sender.level().getEntity(message.player);

                if (entity instanceof Player player) {
                    if (message.slotId > 0) {
                        player.getInventory().setItem(message.slotId, message.stack);
                    }
                }
            }
        });
    }
    
}