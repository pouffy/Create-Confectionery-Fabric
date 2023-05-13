package com.pouffydev.create_confectionery;

import com.pouffydev.create_confectionery.content.registry.EffectsRegistry;
import com.pouffydev.create_confectionery.content.registry.FluidRegistry;
import com.pouffydev.create_confectionery.content.registry.ItemRegistry;
import com.pouffydev.create_confectionery.util.data.recipe.CCStandardRecipeGen;
import com.simibubi.create.Create;

import com.simibubi.create.foundation.data.CreateRegistrate;

import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.resources.ResourceLocation;

import net.minecraftforge.common.data.ExistingFileHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Confectionery implements ModInitializer {
	public static final String ID = "create_confectionery";
	public static final String NAME = "Create: Confectionery";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
	public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ID);
	@Override
	public void onInitialize() {
		LOGGER.info("Create addon mod [{}] is loading alongside Create [{}]!", NAME, Create.VERSION);
		LOGGER.info(EnvExecutor.unsafeRunForDist(
				() -> () -> "{} is accessing Porting Lib from the client!",
				() -> () -> "{} is accessing Porting Lib from the server!"
		), NAME);


		ItemRegistry.register();
		EffectsRegistry.registerEffects();
		FluidRegistry.register();
		REGISTRATE.register();
	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(ID, path);
	}
	public static ResourceLocation asResource(String path) {
		return new ResourceLocation(ID, path);
	}
	public static void gatherData(FabricDataGenerator gen, ExistingFileHelper helper) {
		gen.addProvider(new CCStandardRecipeGen(gen));
		//gen.addProvider(new LangMerger(gen, ID, "Rotae Ex Astris", AstraLangPartials.values()));
	}
	public static CreateRegistrate registrate() {
		return REGISTRATE;
	}
}
