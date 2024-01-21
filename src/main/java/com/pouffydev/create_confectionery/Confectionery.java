package com.pouffydev.create_confectionery;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.pouffydev.create_confectionery.content.registry.BlockRegistry;
import com.pouffydev.create_confectionery.content.registry.EntityRegistry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pouffydev.create_confectionery.content.registry.EffectsRegistry;
import com.pouffydev.create_confectionery.content.registry.FluidRegistry;
import com.pouffydev.create_confectionery.content.registry.ItemRegistry;
import com.simibubi.create.Create;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.LangMerger;

import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

public class Confectionery implements ModInitializer {
	public static final String ID = "create_confectionery";
	public static final String NAME = "Create: Confectionery";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
	public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ID);
	public static final Gson GSON = new GsonBuilder().setPrettyPrinting()
			.disableHtmlEscaping()
			.create();
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
		EntityRegistry.register();
		BlockRegistry.register();
		CreateConfectioneryEntities.register();
		REGISTRATE.register();

		Confectionery.init();

	}
	public static void init() {
		FluidRegistry.registerFluidInteractions();
	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(ID, path);
	}
	public static ResourceLocation asResource(String path) {
		return new ResourceLocation(ID, path);
	}
	public static void gatherData(FabricDataGenerator gen, ExistingFileHelper helper) {
		//gen.addProvider(new CCStandardRecipeGen(gen));
		gen.addProvider(new LangMerger(gen, ID, "Create: Confectionery", ConfectioneryLangPartials.values()));
	}
	public static CreateRegistrate registrate() {
		return REGISTRATE;
	}
}
