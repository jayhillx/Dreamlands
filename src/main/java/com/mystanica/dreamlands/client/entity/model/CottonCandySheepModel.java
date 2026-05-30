package com.mystanica.dreamlands.client.entity.model;

import com.google.common.collect.ImmutableList;
import com.mystanica.dreamlands.client.entity.animation.CottonCandySheepAnimations;
import com.mystanica.dreamlands.common.entity.animal.CottonCandySheep;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class CottonCandySheepModel<T extends CottonCandySheep> extends DreamAnimatedModel<T> {
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart headWool;
    private final ModelPart body;
    private final ModelPart bodyWool;
    private final ModelPart leftFrontLeg;
    private final ModelPart leftFrontLegWool;
    private final ModelPart rightFrontLeg;
    private final ModelPart rightFrontLegWool;
    private final ModelPart leftHindLeg;
    private final ModelPart leftHindLegWool;
    private final ModelPart rightHindLeg;
    private final ModelPart rightHindLegWool;
    private float headXRot;

    public CottonCandySheepModel(ModelPart root) {
        this.root = root.getChild("root");
        this.head = this.root.getChild("head");
        this.headWool = this.head.getChild("head_wool");
        this.body = this.root.getChild("body");
        this.bodyWool = this.body.getChild("body_wool");
        this.leftFrontLeg = this.root.getChild("left_front_leg");
        this.leftFrontLegWool = this.leftFrontLeg.getChild("left_front_leg_wool");
        this.rightFrontLeg = this.root.getChild("right_front_leg");
        this.rightFrontLegWool = this.rightFrontLeg.getChild("right_front_leg_wool");
        this.leftHindLeg = this.root.getChild("left_hind_leg");
        this.leftHindLegWool = this.leftHindLeg.getChild("left_hind_leg_wool");
        this.rightHindLeg = this.root.getChild("right_hind_leg");
        this.rightHindLegWool = this.rightHindLeg.getChild("right_hind_leg_wool");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 14.0F, -1.0F));
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 2).addBox(-3.0F, -5.0F, -6.5F, 6.0F, 6.0F, 7.0F), PartPose.offset(0.0F, -2.5F, -4.0F));
        head.addOrReplaceChild("head_wool", CubeListBuilder.create().texOffs(27, 1).addBox(-3.5F, -5.5F, -5.5F, 7.0F, 7.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -0.5F, 0.5F));
        body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(0, 42).addBox(-4.0F, -6.5F, -2.5F, 8.0F, 13.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        PartDefinition body_wool = body.addOrReplaceChild("body_wool", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 0.0F));
        body_wool.addOrReplaceChild("body_wool_r1", CubeListBuilder.create().texOffs(0, 16).addBox(-5.0F, -8.0F, -4.5F, 10.0F, 16.0F, 9.0F), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 1.5708F, 0.0F, -3.1416F));
        PartDefinition leftFrontLeg = root.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(39, 30).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F), PartPose.offset(2.9F, 2.0F, -3.5F));
        leftFrontLeg.addOrReplaceChild("left_front_leg_wool", CubeListBuilder.create().texOffs(39, 21).addBox(-2.0F, 1.0F, -2.0F, 4.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition rightFrontLeg = root.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(39, 30).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F).mirror(false), PartPose.offset(-2.9F, 2.0F, -3.5F));
        rightFrontLeg.addOrReplaceChild("right_front_leg_wool", CubeListBuilder.create().texOffs(39, 21).mirror().addBox(-2.0F, 1.0F, -2.0F, 4.0F, 4.0F, 4.0F).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition leftHindLeg = root.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(39, 30).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F), PartPose.offset(2.9F, 2.0F, 5.5F));
        leftHindLeg.addOrReplaceChild("left_hind_leg_wool", CubeListBuilder.create().texOffs(39, 21).addBox(-2.0F, 1.0F, -2.0F, 4.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition rightHindLeg = root.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(39, 30).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F).mirror(false), PartPose.offset(-2.9F, 2.0F, 5.5F));
        rightHindLeg.addOrReplaceChild("right_hind_leg_wool", CubeListBuilder.create().texOffs(39, 21).mirror().addBox(-2.0F, 1.0F, -2.0F, 4.0F, 4.0F, 4.0F).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));
        return LayerDefinition.create(mesh, 64, 64);
    }

    @Override
    public void prepareMobModel(T entity, float limbSwing, float limbSwingAmount, float ageInTicks) {
        for (ModelPart part : this.woolParts()) {
            part.visible = !entity.isSheared();
        }

        this.head.y = 6.0F + entity.getHeadEatPositionScale(ageInTicks) * 9.0F;
        this.headXRot = entity.getHeadEatAngleScale(ageInTicks);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root.getAllParts().forEach(ModelPart::resetPose);
        this.head.xRot = headPitch * ((float)Math.PI / 180F);
        this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);

        this.animate(entity.idleAnimation, CottonCandySheepAnimations.SHEEP_IDLE, ageInTicks);
        this.animateWalk(CottonCandySheepAnimations.SHEEP_WALK, limbSwing, limbSwingAmount, 12.0F, 10.0F);
    }

    protected Iterable<ModelPart> woolParts() {
        return ImmutableList.of(this.headWool, this.bodyWool, this.leftFrontLegWool, this.rightFrontLegWool, this.leftHindLegWool, this.rightHindLegWool);
    }

    @Nonnull
    @Override
    public ModelPart root() {
        return this.root;
    }

}