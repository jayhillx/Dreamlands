package com.dreamlands.common.util;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.util.ITeleporter;

public class TeleporterUtils implements ITeleporter {

    @Override
    public boolean playTeleportSound(ServerPlayer player, ServerLevel fromLevel, ServerLevel toLevel) {
        return false;
    }

}