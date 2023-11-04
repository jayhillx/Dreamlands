package io.github.jay.dreamlands.common.datagen;

import io.github.jay.dreamlands.Dreamlands;
import io.github.jay.dreamlands.core.init.DreamBiomes;
import io.github.jay.dreamlands.core.init.DreamDimensions;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Set;

@Mod.EventBusSubscriber(modid = Dreamlands.modId, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SetupDataGenerator {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.DIMENSION_TYPE, DreamDimensions::bootstrap).add(Registries.BIOME, DreamBiomes::bootstrap);

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(generator.getPackOutput(), event.getLookupProvider(), BUILDER, Set.of(Dreamlands.modId)));
    }

}