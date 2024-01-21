package com.pouffydev.create_confectionery;


import com.pouffydev.create_confectionery.content.entity.LittleGingerbreadManModel;
import com.pouffydev.create_confectionery.foundation.client.ClientEvents;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;

public class ConfectioneryClient implements ClientModInitializer {


	@Override
	public void onInitializeClient() {
		ClientEvents.register();
		EntityModelLayerRegistry.registerModelLayer(LittleGingerbreadManModel.LAYER_LOCATION, LittleGingerbreadManModel::createBodyLayer);
	}
}
