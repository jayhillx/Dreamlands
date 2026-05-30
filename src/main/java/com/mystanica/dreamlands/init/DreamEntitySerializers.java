package com.mystanica.dreamlands.init;

import com.mystanica.dreamlands.Dreamlands;
import com.mystanica.dreamlands.common.entity.EntityStates;
import com.mystanica.dreamlands.common.entity.animal.FawnStates;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.IntFunction;
import java.util.function.Supplier;

public class DreamEntitySerializers {
    public static final DeferredRegister<EntityDataSerializer<?>> ENTITY_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.ENTITY_DATA_SERIALIZERS, Dreamlands.modId);

    public static final Supplier<EntityDataSerializer<FawnStates>> FAWN_STATES = ENTITY_SERIALIZERS.register("fawn_states", () -> enumState(FawnStates.BY_ID));

    public static <T extends EntityStates<?>> EntityDataSerializer<T> enumState(IntFunction<T> id) {
        return new EntityDataSerializer<>() {
            @Override
            public void write(FriendlyByteBuf buf, T state) {
                buf.writeVarInt(state.id());
            }

            @Override
            public T read(FriendlyByteBuf buf) {
                return id.apply(buf.readVarInt());
            }

            @Override
            public T copy(T state) {
                return state;
            }
        };
    }

}