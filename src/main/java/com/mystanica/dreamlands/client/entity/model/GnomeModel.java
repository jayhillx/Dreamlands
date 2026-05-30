package com.mystanica.dreamlands.client.entity.model;

import com.mystanica.dreamlands.client.entity.animation.GnomeAnimations;
import com.mystanica.dreamlands.common.entity.animal.Gnome;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class GnomeModel<T extends Gnome> extends DreamAnimatedModel<T> {
	private final ModelPart root;
	private final ModelPart headRoot;

	public GnomeModel(ModelPart root) {
		this.root = root.getChild("root");
		this.headRoot = this.root.getChild("body_root").getChild("head_root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.5F, 24.0F, 0.0F));
		PartDefinition bodyRoot = root.addOrReplaceChild("body_root", CubeListBuilder.create(), PartPose.offset(-0.5F, -3.0F, 0.0F));
		PartDefinition headRoot = bodyRoot.addOrReplaceChild("head_root", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, -1.0F));
		PartDefinition hat = headRoot.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(25, 54).addBox(-3.5F, -5.0F, -2.0F, 7.0F, 4.0F, 5.0F), PartPose.offset(0.0F, -2.0F, 1.0F));
		hat.addOrReplaceChild("hat_bottom", CubeListBuilder.create().texOffs(5, 37).addBox(-2.5F, -5.5F, -1.515F, 3.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(1.0F, -5.6F, 0.6F, -0.2182F, 0.0F, 0.0F));
		hat.addOrReplaceChild("hat_middle", CubeListBuilder.create().texOffs(1, 43).addBox(-3.5F, -3.5F, -2.49F, 5.0F, 3.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(1.0F, -5.7F, 0.6F, -0.2182F, 0.0F, 0.0F));
		hat.addOrReplaceChild("hat_tip", CubeListBuilder.create().texOffs(0, 52).addBox(-3.5F, -0.5F, -2.57F, 7.0F, 6.0F, 5.0F, new CubeDeformation(-0.009F)), PartPose.offsetAndRotation(0.0F, -5.8F, 0.7F, -0.2182F, 0.0F, 0.0F));
		headRoot.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -2.0F, -3.0F, 7.0F, 3.0F, 6.0F), PartPose.offset(0.0F, -1.0F, 1.0F));
		headRoot.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(36, 3).addBox(-1.5F, -1.5F, -4.5F, 3.0F, 3.0F, 2.0F), PartPose.offset(0.0F, -1.0F, 1.0F));
		PartDefinition beardRoot = headRoot.addOrReplaceChild("beard_root", CubeListBuilder.create(), PartPose.offset(-0.5F, 0.0F, -3.0F));
		beardRoot.addOrReplaceChild("beard", CubeListBuilder.create().texOffs(37, 14).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 6.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offset(0.5F, 3.0F, 1.5F));
		beardRoot.addOrReplaceChild("beard_layer", CubeListBuilder.create().texOffs(34, 23).addBox(-3.5F, -3.0F, -3.0F, 7.0F, 6.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offset(0.5F, 3.0F, 4.0F));
		beardRoot.addOrReplaceChild("mustache", CubeListBuilder.create().texOffs(27, 4).addBox(-2.5F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F).texOffs(27, 4).mirror().addBox(0.5F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F).mirror(false), PartPose.offset(0.5F, -0.5F, 0.0F));
		bodyRoot.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 10).addBox(-3.5F, -8.0F, -3.0F, 7.0F, 6.0F, 6.0F), PartPose.offset(0.0F, 3.0F, 0.0F));
		bodyRoot.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(27, 9).mirror().addBox(0.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F).mirror(false), PartPose.offset(3.5F, -4.0F, 0.0F));
		bodyRoot.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(27, 9).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offset(-3.5F, -4.0F, 0.0F));
		root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(27, 17).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F).mirror(false), PartPose.offset(1.0F, -3.0F, 0.0F));
		root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(27, 17).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F), PartPose.offset(-2.0F, -3.0F, 0.0F));
		return LayerDefinition.create(mesh, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.headRoot.xRot = headPitch * (float)Math.PI / 180F;
		this.headRoot.yRot = netHeadYaw * (float)Math.PI / 180F;

		this.animate(entity.idleAnimationState, GnomeAnimations.GNOME_IDLE, ageInTicks);

		if (entity.onGround()) {
			this.animateWalk(GnomeAnimations.GNOME_WALK, limbSwing, limbSwingAmount, 10.0F, 8.5F);
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