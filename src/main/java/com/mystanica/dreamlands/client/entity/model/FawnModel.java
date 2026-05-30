package com.mystanica.dreamlands.client.entity.model;

import com.mystanica.dreamlands.client.entity.animation.FawnAnimations;
import com.mystanica.dreamlands.common.entity.animal.Fawn;
import com.mystanica.dreamlands.common.entity.animal.FawnStates;
import net.minecraft.Util;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.util.EnumMap;

@OnlyIn(Dist.CLIENT)
public class FawnModel<T extends Fawn> extends DreamAnimatedModel<T> {
    private static final EnumMap<FawnStates, AnimationDefinition> ANIMATIONS = Util.make(new EnumMap<>(FawnStates.class), map -> {
        map.put(FawnStates.EATING_START, FawnAnimations.FAWN_EATING_START);
        map.put(FawnStates.EATING, FawnAnimations.FAWN_EATING);
        map.put(FawnStates.EATING_STOP, FawnAnimations.FAWN_EATING_STOP);
    });
    private final ModelPart root;
    private final ModelPart head;

    public FawnModel(ModelPart root) {
        this.root = root.getChild("root");
        ModelPart neckRoot = this.root.getChild("neck_root");
        this.head = neckRoot.getChild("head_root");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition neckRoot = root.addOrReplaceChild("neck_root", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, -6.0F));
        neckRoot.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(1, 14).addBox(-3.0F, -9.5F, -3.0F, 6.0F, 12.0F, 5.0F), PartPose.offset(0.0F, -2.5F, -2.0F));
        PartDefinition headRoot = neckRoot.addOrReplaceChild("head_root", CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, -2.5F));
        headRoot.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.5F, 6.0F, 6.0F, 6.0F).texOffs(25, 6).addBox(-2.0F, -3.0F, -5.5F, 4.0F, 3.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition leftAntler = headRoot.addOrReplaceChild("left_antler", CubeListBuilder.create(), PartPose.offset(2.0F, -6.0F, -0.5F));
        leftAntler.addOrReplaceChild("left_antler_r1", CubeListBuilder.create().texOffs(34, 53).addBox(-1.0F, -10.0F, 0.0F, 14.0F, 10.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
        PartDefinition rightAntler = headRoot.addOrReplaceChild("right_antler", CubeListBuilder.create(), PartPose.offset(-2.0F, -6.0F, -0.5F));
        rightAntler.addOrReplaceChild("right_antler_r1", CubeListBuilder.create().texOffs(34, 53).mirror().addBox(-13.0F, -10.0F, 0.0F, 14.0F, 10.0F, 0.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
        headRoot.addOrReplaceChild("left_ear", CubeListBuilder.create().texOffs(40, 9).addBox(-1.0F, -1.0019F, -0.4716F, 4.0F, 2.0F, 1.0F), PartPose.offset(3.0F, -3.9981F, -0.0284F));
        headRoot.addOrReplaceChild("right_ear", CubeListBuilder.create().texOffs(40, 9).mirror().addBox(-3.0F, -1.0019F, -0.4716F, 4.0F, 2.0F, 1.0F).mirror(false), PartPose.offset(-3.0F, -3.9981F, -0.0284F));
        PartDefinition bodyRoot = root.addOrReplaceChild("body_root", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        bodyRoot.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(25, 14).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 14.0F, 3.0F), PartPose.offset(2.4F, 4.0F, -7.5F));
        bodyRoot.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(25, 14).mirror().addBox(-1.5F, -1.0F, -1.5F, 3.0F, 14.0F, 3.0F).mirror(false), PartPose.offset(-2.4F, 4.0F, -7.5F));
        bodyRoot.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(38, 14).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 14.0F, 3.0F), PartPose.offset(2.4F, 4.0F, 7.5F));
        bodyRoot.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(38, 14).mirror().addBox(-1.5F, -1.0F, -1.5F, 3.0F, 14.0F, 3.0F).mirror(false), PartPose.offset(-2.4F, 4.0F, 7.5F));
        PartDefinition body = bodyRoot.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(0, 35).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 20.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 3.1416F));
        body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(51, 6).addBox(-2.0F, -6.5F, 10.0F, 4.0F, 4.0F, 2.0F), PartPose.offset(0.0F, 0.5F, 0.0F));
        return LayerDefinition.create(mesh, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.head.xRot = headPitch * (float)Math.PI / 180F;
        this.head.yRot = netHeadYaw * (float)Math.PI / 180F;

        this.animate(entity.idleAnimationState, FawnAnimations.FAWN_IDLE, ageInTicks);
        for (FawnStates state : FawnStates.values()) {
            AnimationDefinition animation = ANIMATIONS.get(state);

            if (animation != null) {
                this.animate(entity.stateManager.getAnimationFromState(state), animation, ageInTicks);
            }
        }

        if (entity.onGround()) {
            this.animateWalk(FawnAnimations.FAWN_WALK, limbSwing, limbSwingAmount, 10.0F, 8.5F);
        }

        //this.lerpBones(entity, 0.05F);
        //this.removeDead(entity);
    }

    @Nonnull
    @Override
    public ModelPart root() {
        return this.root;
    }

}