package com.mystanica.dreamlands.client.entity.model;

import com.mystanica.dreamlands.client.entity.animation.ForestFoxAnimations;
import com.mystanica.dreamlands.common.entity.animal.ForestFox;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class ForestFoxModel<T extends ForestFox> extends DreamAnimatedModel<T> {
	private final ModelPart root;
	private final ModelPart head;

	public ForestFoxModel(ModelPart root) {
		this.root = root.getChild("root");
		this.head = this.root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot().addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 17.0F, 0.0F));
		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -4.0F, -5.0F, 7.0F, 6.0F, 5.0F), PartPose.offset(0.0F, 0.0F, -5.0F));
		head.addOrReplaceChild("left_ear", CubeListBuilder.create().texOffs(27, 6).addBox(-1.0F, -2.0F, -0.5F, 2.0F, 2.0F, 1.0F), PartPose.offset(2.5F, -4.0F, -2.5F));
		head.addOrReplaceChild("right_ear", CubeListBuilder.create().texOffs(27, 6).mirror().addBox(-1.0F, -2.0F, -0.5F, 2.0F, 2.0F, 1.0F).mirror(false), PartPose.offset(-2.5F, -4.0F, -2.5F));
		head.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(27, 1).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 1.0F, -5.0F));
		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(0, 16).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 10.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 5.0F));
		tail.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(28, 17).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 9.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
		root.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(40, 1).addBox(-1.01F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F), PartPose.offset(2.0F, 2.0F, -3.0F));
		root.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(40, 1).mirror().addBox(-0.99F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F).mirror(false), PartPose.offset(-2.0F, 2.0F, -3.0F));
		root.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(40, 1).addBox(-1.01F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F), PartPose.offset(2.0F, 2.0F, 3.0F));
		root.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(40, 1).mirror().addBox(-0.99F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F).mirror(false), PartPose.offset(-2.0F, 2.0F, 3.0F));
		return LayerDefinition.create(mesh, 48, 32);
	}
	
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.head.xRot = headPitch * (float)Math.PI / 180F;
		this.head.yRot = netHeadYaw * (float)Math.PI / 180F;

		this.animate(entity.idleAnimationState, ForestFoxAnimations.FOREST_FOX_IDLE, ageInTicks);

		if (entity.onGround()) {
			this.animateWalk(ForestFoxAnimations.FOREST_FOX_WALK, limbSwing, limbSwingAmount, 10.0F, 8.5F);
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