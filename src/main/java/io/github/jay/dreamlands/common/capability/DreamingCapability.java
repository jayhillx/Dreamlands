package io.github.jay.dreamlands.common.capability;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DreamingCapability implements ICapabilityProvider, ICapabilitySerializable<CompoundTag> {
    public static Capability<DreamData> DREAMING_DATA = CapabilityManager.get(new CapabilityToken<>() {});

    private final DreamData info = new DreamData();
    private final LazyOptional<DreamData> infoOptional = LazyOptional.of(() -> info);

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