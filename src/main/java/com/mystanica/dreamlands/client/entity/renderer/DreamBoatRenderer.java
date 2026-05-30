package com.mystanica.dreamlands.client.entity.renderer;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import com.mystanica.dreamlands.Dreamlands;
import com.mystanica.dreamlands.common.entity.vehicle.DreamBoat;
import com.mystanica.dreamlands.common.entity.vehicle.DreamChestBoat;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.stream.Stream;

@OnlyIn(Dist.CLIENT)
public class DreamBoatRenderer extends BoatRenderer {
    private final Map<DreamBoat.Type, Pair<ResourceLocation, ListModel<Boat>>> boatResources;

    public DreamBoatRenderer(EntityRendererProvider.Context context, boolean hasChest) {
        super(context, false);
        this.boatResources = Stream.of(DreamBoat.Type.values()).collect(ImmutableMap.toImmutableMap((key) -> key, (model) -> Pair.of(Dreamlands.modLoc(getTextureLocation(model, hasChest)), this.createBoatModel(context, model, hasChest))));
    }

    @Nonnull
    @Override
    public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
        if (boat instanceof DreamChestBoat) {
            return this.boatResources.get(((DreamChestBoat)boat).getModel());
        } else {
            return this.boatResources.get(((DreamBoat)boat).getModel());
        }
    }

    private static String getTextureLocation(DreamBoat.Type type, boolean hasChest) {
        return hasChest ? "textures/entity/boats/chest/" + type.getName() + ".png" : "textures/entity/boats/" + type.getName() + ".png";
    }

    private static ModelLayerLocation createLocation(String name) {
        return new ModelLayerLocation(Dreamlands.modLoc(name), "main");
    }

    public static ModelLayerLocation createBoatModelName(DreamBoat.Type type) {
        return createLocation("boats/" + type.getName());
    }

    public static ModelLayerLocation createChestBoatModelName(DreamBoat.Type type) {
        return createLocation("boats/chest/" + type.getName());
    }

    private ListModel<Boat> createBoatModel(EntityRendererProvider.Context context, DreamBoat.Type type, boolean hasChest) {
        ModelLayerLocation location = hasChest ? createChestBoatModelName(type) : createBoatModelName(type);
        ModelPart baked = context.bakeLayer(location);
        if (type.isRaft()) {
            return hasChest ? new ChestRaftModel(baked) : new RaftModel(baked);
        } else {
            return hasChest ? new ChestBoatModel(baked) : new BoatModel(baked);
        }
    }
    
}