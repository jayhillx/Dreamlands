package com.dreamlands.datagen;

import com.dreamlands.Dreamlands;
import com.dreamlands.datagen.generator.DreamBlockLoot;
import com.dreamlands.datagen.generator.DreamBlockStates;
import com.dreamlands.datagen.generator.DreamRecipes;
import com.dreamlands.datagen.generator.tag.DreamBlockTags;
import com.dreamlands.datagen.generator.tag.DreamItemTags;
import com.dreamlands.datagen.registry.DreamBiomes;
import com.dreamlands.datagen.registry.DreamDimensionTypes;
import com.dreamlands.datagen.registry.DreamDimensions;
import com.dreamlands.datagen.registry.DreamNoiseSettings;
import com.dreamlands.datagen.generator.DreamItemModels;
import com.google.common.collect.Sets;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Dreamlands.modId, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SetupDataGenerator {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.DIMENSION_TYPE, DreamDimensionTypes::bootstrap).add(Registries.LEVEL_STEM, DreamDimensions::bootstrap).add(Registries.NOISE_SETTINGS, DreamNoiseSettings::bootstrap).add(Registries.BIOME, DreamBiomes::bootstrap);

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
        PackOutput output = generator.getPackOutput();

        generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(output, provider, BUILDER, Set.of(Dreamlands.modId)));
        generator.addProvider(event.includeServer(), new DreamRecipes(output));
        generator.addProvider(event.includeServer(), new LootTableProvider(output, Collections.unmodifiableSet(Sets.newHashSet()), List.of(new LootTableProvider.SubProviderEntry(DreamBlockLoot::new, LootContextParamSets.BLOCK))));
        DreamBlockTags blockTags = new DreamBlockTags(output, provider, helper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new DreamItemTags(output, provider, blockTags.contentsGetter(), helper));

        generator.addProvider(event.includeClient(), new DreamBlockStates(output, helper));
        generator.addProvider(event.includeClient(), new DreamItemModels(output, helper));
    }

}