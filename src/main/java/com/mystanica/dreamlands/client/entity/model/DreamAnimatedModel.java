package com.mystanica.dreamlands.client.entity.model;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.HashMap;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
public abstract class DreamAnimatedModel<T extends LivingEntity> extends HierarchicalModel<T> {
    private final Map<Integer, Map<ModelPart, PartPose>> previousPoses = new HashMap<>();

    /**
     * lerp each part to prevent limbs from snapping to a new position.
     * lower lerpFactor will be a smoother blend.
     *
     * @param lerpFactor is applied to an iterated list of a models root children.
     */
    protected void lerpBones(T entity, float lerpFactor) {
        Map<ModelPart, PartPose> poseMap = this.previousPoses.computeIfAbsent(entity.getId(), id -> new HashMap<>());

        for (ModelPart part : this.root().getAllParts().toList()) {
            PartPose previous = poseMap.computeIfAbsent(part, p -> PartPose.offsetAndRotation(part.x, part.y, part.z, part.xRot, part.yRot, part.zRot));
            part.x = Mth.lerp(lerpFactor, previous.x, part.x);
            part.y = Mth.lerp(lerpFactor, previous.y, part.y);
            part.z = Mth.lerp(lerpFactor, previous.z, part.z);
            part.xRot = this.lerpAngle(lerpFactor, previous.xRot, part.xRot);
            part.yRot = this.lerpAngle(lerpFactor, previous.yRot, part.yRot);
            part.zRot = this.lerpAngle(lerpFactor, previous.zRot, part.zRot);
            poseMap.put(part, PartPose.offsetAndRotation(part.x, part.y, part.z, part.xRot, part.yRot, part.zRot));
        }
    }

    private float lerpAngle(float lerpFactor, float previous, float target) {
        float i = (float)(Math.PI * 2.0);
        float delta = (target - previous) % i;
        if (delta < -Math.PI) delta += i;
        if (delta > Math.PI) delta -= i;
        return previous + lerpFactor * delta;
    }

    /**
     * @param entity remove if dead so they no longer are in the map.
     */
    protected void removeDead(T entity) {
        if (!entity.isAlive()) {
            this.previousPoses.remove(entity.getId());
        }
    }

}