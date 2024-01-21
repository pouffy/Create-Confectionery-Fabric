package com.pouffydev.create_confectionery.content.entity;

import com.pouffydev.create_confectionery.Confectionery;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;

public class LittleGingerbreadManRenderer extends MobRenderer<LittleGingerbreadManEntity, LittleGingerbreadManModel<LittleGingerbreadManEntity>> {
	public LittleGingerbreadManRenderer(EntityRendererProvider.Context context) {
		super(context, new LittleGingerbreadManModel<>(context.bakeLayer(LittleGingerbreadManModel.LAYER_LOCATION)), 0.2F);
	}
	private static final EntityDataAccessor<Integer> tagEat;
	static {
		tagEat = SynchedEntityData.defineId(LittleGingerbreadManEntity.class, EntityDataSerializers.INT);
	}
	public ResourceLocation getTextureLocation(LittleGingerbreadManEntity entity) {
		if (entity.getEntityData().get(tagEat) == 3.0) {
			return Confectionery.asResource("textures/entities/gingerbread_man_3.png");
		} else if (entity.getEntityData().get(tagEat) == 2.0) {
			return Confectionery.asResource("textures/entities/gingerbread_man_2.png");
		} else {
			return entity.getEntityData().get(tagEat) == 1.0 ? Confectionery.asResource("textures/entities/gingerbread_man_1.png") : Confectionery.asResource("textures/entities/gingerbread_man_0.png");
		}
	}
}
