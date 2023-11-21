package com.dreamlands.common.capability.player;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DreamingCapability implements ICapabilityProvider, ICapabilitySerializable<CompoundTag> {
    public static Capability<DreamingInformation> DREAMING_DATA = CapabilityManager.get(new CapabilityToken<>() {});

    private final DreamingInformation info = new DreamingInformation();
    private final LazyOptional<DreamingInformation> infoOptional = LazyOptional.of(() -> info);

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return DREAMING_DATA.orEmpty(cap, this.infoOptional);
    }

    @Override
    public CompoundTag serializeNBT() {
        return this.info.write(new CompoundTag());
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        this.info.read(tag);
    }

}