package com.pouffydev.create_confectionery;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ConfectioneryData implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
		ExistingFileHelper helper = ExistingFileHelper.withResourcesFromArg();
		Confectionery.REGISTRATE.setupDatagen(generator, helper);
		Confectionery.gatherData(generator, helper);
	}
}
