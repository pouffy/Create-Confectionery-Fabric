package com.pouffydev.create_confectionery.util.data.recipe;

import com.pouffydev.create_confectionery.Confectionery;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CCRecipeProvider extends FabricRecipeProvider {

	protected final List<GeneratedRecipe> all = new ArrayList<>();

	public CCRecipeProvider(FabricDataGenerator generator) {
		super(generator);
	}

	@Override
	protected void generateRecipes(Consumer<FinishedRecipe> p_200404_1_) {
		all.forEach(c -> c.register(p_200404_1_));
		Confectionery.LOGGER.info(getName() + " registered " + all.size() + " recipe" + (all.size() == 1 ? "" : "s"));
	}

	protected GeneratedRecipe register(GeneratedRecipe recipe) {
		all.add(recipe);
		return recipe;
	}

	@FunctionalInterface
	public interface GeneratedRecipe {
		void register(Consumer<FinishedRecipe> consumer);
	}

	protected static class Marker {
	}
}
