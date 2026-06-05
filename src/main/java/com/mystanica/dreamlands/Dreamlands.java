package com.mystanica.dreamlands;

import com.google.common.collect.Sets;
import com.mystanica.dreamlands.common.block.state.DreamWoodTypes;
import com.mystanica.dreamlands.datagen.provider.*;
import com.mystanica.dreamlands.datagen.provider.tag.DreamBlockTags;
import com.mystanica.dreamlands.datagen.provider.tag.DreamItemTags;
import com.mystanica.dreamlands.handler.DreamingPlayerEvents;
import com.mystanica.dreamlands.handler.SleepingPlayerEntityEvents;
import com.mystanica.dreamlands.init.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod(Dreamlands.modId)
public class Dreamlands {
    public static final String modId = "dreamlands";

    public static ResourceLocation modLoc(String path) {
        return ResourceLocation.fromNamespaceAndPath(modId, path);
    }

    /**
     * beta 1 - saturday, may 23rd 2026
     * beta 2 - saturday, october 3rd 2026
     *
     * escape the reality of life, no pain, no death. just blissful ignorance.
     * stop trying to escape, embrace the end.
     *
     * unless a player does not have a bed set, they will be randomly spawned in to a random place every single time they dream.
     *      - the idea of entering a dream and being placed into a spider nest.
     * you will wake up everytime in your set bed.
     * if you don't want to and wanna save your progress of where you are in the dream, using a sleeping bag/bedroll will be the only way to save that.
     *
     * make it so if the player is starting to sleep/waking up there is a custom screen that overrides the vanilla sleep one.
     *
     * create the players dream data. stores:
     *      - players deceased pets
     *      - players dream inventory
     */
    public Dreamlands(FMLJavaModLoadingContext context) {
        IEventBus bus = context.getModEventBus();
        bus.addListener(this::gatherData);
        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(new SleepingPlayerEntityEvents());
        MinecraftForge.EVENT_BUS.register(new DreamingPlayerEvents());

        DreamBlocks.BLOCKS.register(bus);
        DreamBlockEntities.BLOCK_ENTITIES.register(bus);
        DreamEntities.ENTITIES.register(bus);
        DreamEntitySerializers.ENTITY_SERIALIZERS.register(bus);
        DreamEffects.EFFECTS.register(bus);
        DreamItems.ITEMS.register(bus);
        DreamParticles.PARTICLES.register(bus);
        DreamFeatures.FEATURES.register(bus);
        DreamFeatures.TREE_DECORATORS.register(bus);
        DreamTabs.CREATIVE_TABS.register(bus);
    }

    private void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();

        RegistrySetBuilder builder = new RegistrySetBuilder();
        builder.add(Registries.BIOME, DreamBiomes::bootstrap);
        builder.add(Registries.DIMENSION_TYPE, DreamDimensionTypes::bootstrap);
        builder.add(Registries.LEVEL_STEM, DreamDimensions::bootstrap);
        builder.add(Registries.NOISE_SETTINGS, DreamNoiseSettings::bootstrap);
        builder.add(Registries.CONFIGURED_FEATURE, DreamFeatures.Configured::bootstrap);
        builder.add(Registries.PLACED_FEATURE, DreamFeatures.Placed::bootstrap);
        generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(output, provider, builder, Set.of(Dreamlands.modId)));
        generator.addProvider(event.includeServer(), new ForgeAdvancementProvider(output, provider, helper, List.of(new DreamAdvancements())));
        generator.addProvider(event.includeServer(), new LootTableProvider(output, Collections.unmodifiableSet(Sets.newHashSet()), List.of(new LootTableProvider.SubProviderEntry(DreamBlockLoot::new, LootContextParamSets.BLOCK))));
        DreamBlockTags blockTags = new DreamBlockTags(output, provider, helper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new DreamItemTags(output, provider, blockTags.contentsGetter()));
        generator.addProvider(event.includeServer(), new DreamRecipes(output));

        ///ExistingFileHelper debugHelper = new ExistingFileHelper(Set.of(), Set.of(), false, null, null);
        ///generator.addProvider(event.includeClient(), new DreamBlockModels(output, debugHelper));
        ///generator.addProvider(event.includeClient(), new DreamItemModels(output, debugHelper));
        ///generator.addProvider(event.includeClient(), new DreamLanguage(output));
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            DreamCompat.registerFlammables();
            DreamCompat.registerCompostables();
            DreamCompat.registerStrippables();
            DreamCriteriaTriggers.registerCriteriaTriggers();
        });
    }

    private void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            DreamCompat.registerRenderLayers();
            DreamWoodTypes.registerWoodTypes();
        });
    }

}