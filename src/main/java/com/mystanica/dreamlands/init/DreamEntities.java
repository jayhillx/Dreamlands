package com.mystanica.dreamlands.init;

import com.mystanica.dreamlands.Dreamlands;
import com.mystanica.dreamlands.client.entity.model.CottonCandySheepModel;
import com.mystanica.dreamlands.client.entity.model.FawnModel;
import com.mystanica.dreamlands.client.entity.model.ForestFoxModel;
import com.mystanica.dreamlands.client.entity.model.GnomeModel;
import com.mystanica.dreamlands.client.entity.model.layer.DreamModelLayers;
import com.mystanica.dreamlands.client.entity.renderer.*;
import com.mystanica.dreamlands.common.entity.animal.CottonCandySheep;
import com.mystanica.dreamlands.common.entity.animal.Fawn;
import com.mystanica.dreamlands.common.entity.animal.ForestFox;
import com.mystanica.dreamlands.common.entity.animal.Gnome;
import com.mystanica.dreamlands.common.entity.misc.SleepingPlayer;
import com.mystanica.dreamlands.common.entity.vehicle.DreamBoat;
import com.mystanica.dreamlands.common.entity.vehicle.DreamChestBoat;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Dreamlands.modId, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DreamEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, Dreamlands.modId);

    /// animals
    public static final RegistryObject<EntityType<Fawn>> FAWN = ENTITIES.register("fawn", () -> EntityType.Builder.of(Fawn::new, MobCategory.CREATURE).sized(0.7F, 2.0F).clientTrackingRange(10).build(Dreamlands.modId + ":fawn"));
    public static final RegistryObject<EntityType<ForestFox>> FOREST_FOX = ENTITIES.register("forest_fox", () -> EntityType.Builder.of(ForestFox::new, MobCategory.CREATURE).sized(0.6F, 0.7F).clientTrackingRange(8).build(Dreamlands.modId + ":forest_fox"));
    public static final RegistryObject<EntityType<Gnome>> GNOME = ENTITIES.register("gnome", () -> EntityType.Builder.of(Gnome::new, MobCategory.CREATURE).sized(0.5F, 0.8F).clientTrackingRange(8).build(Dreamlands.modId + ":forest_fox"));
    public static final RegistryObject<EntityType<CottonCandySheep>> COTTON_CANDY_SHEEP = ENTITIES.register("cotton_candy_sheep", () -> EntityType.Builder.of(CottonCandySheep::new, MobCategory.CREATURE).sized(0.6F, 1.5F).clientTrackingRange(10).build(Dreamlands.modId + ":cotton_candy_sheep"));

    /// misc.
    public static final RegistryObject<EntityType<SleepingPlayer>> SLEEPING_PLAYER = ENTITIES.register("sleeping_player", () -> EntityType.Builder.of(SleepingPlayer::new, MobCategory.MISC).noSummon().sized(0.6F, 1.8F).clientTrackingRange(32).updateInterval(2).build(Dreamlands.modId + ":sleeping_player"));

    /// vehicles
    public static final RegistryObject<EntityType<DreamBoat>> BOAT = registerBoat("boat", DreamBoat::new);
    public static final RegistryObject<EntityType<DreamChestBoat>> CHEST_BOAT = registerBoat("chest_boat", DreamChestBoat::new);

    private static <E extends Entity> RegistryObject<EntityType<E>> registerBoat(String name, EntityType.EntityFactory<E> factory) {
        return ENTITIES.register(name, () -> EntityType.Builder.of(factory, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build(Dreamlands.modId + ":" + name));
    }

    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(FAWN.get(), Fawn.createAttributes().build());
        event.put(FOREST_FOX.get(), ForestFox.createAttributes().build());
        event.put(GNOME.get(), Gnome.createAttributes().build());
        event.put(COTTON_CANDY_SHEEP.get(), CottonCandySheep.createAttributes().build());
        event.put(SLEEPING_PLAYER.get(), SleepingPlayer.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerEntitySpawns(SpawnPlacementRegisterEvent event) {
        event.register(FAWN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(FOREST_FOX.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(GNOME.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(COTTON_CANDY_SHEEP.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }

    @Mod.EventBusSubscriber(modid = Dreamlands.modId, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class Client {
        @SubscribeEvent
        public static void registerEntityModels(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(DreamModelLayers.FAWN, FawnModel::createBodyLayer);
            event.registerLayerDefinition(DreamModelLayers.FOREST_FOX, ForestFoxModel::createBodyLayer);
            event.registerLayerDefinition(DreamModelLayers.GNOME, GnomeModel::createBodyLayer);
            event.registerLayerDefinition(DreamModelLayers.COTTON_CANDY_SHEEP, CottonCandySheepModel::createBodyLayer);
            event.registerLayerDefinition(DreamModelLayers.SLEEPING_PLAYER, () -> LayerDefinition.create(PlayerModel.createMesh(CubeDeformation.NONE, true), 64, 64));

            for (DreamBoat.Type type : DreamBoat.Type.values()) {
                if (type.isRaft()) {
                    event.registerLayerDefinition(DreamBoatRenderer.createBoatModelName(type), RaftModel::createBodyModel);
                    event.registerLayerDefinition(DreamBoatRenderer.createChestBoatModelName(type), ChestRaftModel::createBodyModel);
                } else {
                    event.registerLayerDefinition(DreamBoatRenderer.createBoatModelName(type), BoatModel::createBodyModel);
                    event.registerLayerDefinition(DreamBoatRenderer.createChestBoatModelName(type), ChestBoatModel::createBodyModel);
                }
            }
        }

        @SubscribeEvent
        public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(DreamEntities.FAWN.get(), FawnRenderer::new);
            event.registerEntityRenderer(DreamEntities.FOREST_FOX.get(), ForestFoxRenderer::new);
            event.registerEntityRenderer(DreamEntities.GNOME.get(), GnomeRenderer::new);
            event.registerEntityRenderer(DreamEntities.COTTON_CANDY_SHEEP.get(), CottonCandySheepRenderer::new);
            event.registerEntityRenderer(DreamEntities.SLEEPING_PLAYER.get(), context -> new SleepingPlayerRenderer(context, true));

            event.registerEntityRenderer(DreamEntities.BOAT.get(), context -> new DreamBoatRenderer(context, false));
            event.registerEntityRenderer(DreamEntities.CHEST_BOAT.get(), context -> new DreamBoatRenderer(context, true));
        }
    }

}