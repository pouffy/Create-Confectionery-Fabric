package com.pouffydev.create_confectionery.util.data.recipe;

import com.google.gson.JsonObject;
import com.pouffydev.create_confectionery.Confectionery;
import com.simibubi.create.content.AllSections;

import com.simibubi.create.foundation.utility.Lang;
import com.simibubi.create.foundation.utility.RegisteredObjects;
import com.tterrag.registrate.util.entry.ItemProviderEntry;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.resource.conditions.v1.ConditionJsonProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.SpecialRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import net.minecraft.world.level.ItemLike;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class CCStandardRecipeGen extends CCRecipeProvider{

	private Marker MATERIALS = enterSection(AllSections.MATERIALS);








	String currentFolder = "";

	Marker enterSection(AllSections section) {
		currentFolder = Lang.asId(section.name());
		return new Marker();
	}

	Marker enterFolder(String folder) {
		currentFolder = folder;
		return new Marker();
	}

	GeneratedRecipeBuilder create(Supplier<ItemLike> result) {
		return new GeneratedRecipeBuilder(currentFolder, result);
	}

	GeneratedRecipeBuilder create(ResourceLocation result) {
		return new GeneratedRecipeBuilder(currentFolder, result);
	}

	GeneratedRecipeBuilder create(ItemProviderEntry<? extends ItemLike> result) {
		return create(result::get);
	}

	GeneratedRecipe createSpecial(Supplier<? extends SimpleRecipeSerializer<?>> serializer, String recipeType,
								  String path) {
		ResourceLocation location = Confectionery.asResource(recipeType + "/" + currentFolder + "/" + path);
		return register(consumer -> {
			SpecialRecipeBuilder b = SpecialRecipeBuilder.special(serializer.get());
			b.save(consumer, location.toString());
		});
	}

	class GeneratedRecipeBuilder {

		private String path;
		private String suffix;
		private Supplier<? extends ItemLike> result;
		private ResourceLocation compatDatagenOutput;
		List<ConditionJsonProvider> recipeConditions;

		private Supplier<ItemPredicate> unlockedBy;
		private int amount;

		private GeneratedRecipeBuilder(String path) {
			this.path = path;
			this.recipeConditions = new ArrayList<>();
			this.suffix = "";
			this.amount = 1;
		}

		public GeneratedRecipeBuilder(String path, Supplier<? extends ItemLike> result) {
			this(path);
			this.result = result;
		}

		public GeneratedRecipeBuilder(String path, ResourceLocation result) {
			this(path);
			this.compatDatagenOutput = result;
		}

		GeneratedRecipeBuilder returns(int amount) {
			this.amount = amount;
			return this;
		}

		GeneratedRecipeBuilder unlockedBy(Supplier<? extends ItemLike> item) {
			this.unlockedBy = () -> ItemPredicate.Builder.item()
					.of(item.get())
					.build();
			return this;
		}

		GeneratedRecipeBuilder unlockedByTag(Supplier<TagKey<Item>> tag) {
			this.unlockedBy = () -> ItemPredicate.Builder.item()
					.of(tag.get())
					.build();
			return this;
		}

		GeneratedRecipeBuilder whenModLoaded(String modid) {
			return withCondition(DefaultResourceConditions.allModsLoaded(modid));
		}

		GeneratedRecipeBuilder whenModMissing(String modid) {
			return withCondition(DefaultResourceConditions.not(DefaultResourceConditions.allModsLoaded(modid)));
		}

		GeneratedRecipeBuilder withCondition(ConditionJsonProvider condition) {
			recipeConditions.add(condition);
			return this;
		}

		GeneratedRecipeBuilder withSuffix(String suffix) {
			this.suffix = suffix;
			return this;
		}

		GeneratedRecipe viaShaped(UnaryOperator<ShapedRecipeBuilder> builder) {
			return register(consumer -> {
				ShapedRecipeBuilder b = builder.apply(ShapedRecipeBuilder.shaped(result.get(), amount));
				if (unlockedBy != null)
					b.unlockedBy("has_item", inventoryTrigger(unlockedBy.get()));
				b.save(consumer, createLocation("crafting"));
			});
		}

		GeneratedRecipe viaShapeless(UnaryOperator<ShapelessRecipeBuilder> builder) {
			return register(consumer -> {
				ShapelessRecipeBuilder b = builder.apply(ShapelessRecipeBuilder.shapeless(result.get(), amount));
				if (unlockedBy != null)
					b.unlockedBy("has_item", inventoryTrigger(unlockedBy.get()));
				b.save(consumer, createLocation("crafting"));
			});
		}
		private ResourceLocation createSimpleLocation(String recipeType) {
			return Confectionery.asResource(recipeType + "/" + getRegistryName().getPath() + suffix);
		}

		private ResourceLocation createLocation(String recipeType) {
			return Confectionery.asResource(recipeType + "/" + path + "/" + getRegistryName().getPath() + suffix);
		}

		private ResourceLocation getRegistryName() {
			return compatDatagenOutput == null ? RegisteredObjects.getKeyOrThrow(result.get()
					.asItem()) : compatDatagenOutput;
		}
		GeneratedCookingRecipeBuilder viaCooking(Supplier<? extends ItemLike> item) {
			return unlockedBy(item).viaCookingIngredient(() -> Ingredient.of(item.get()));
		}

		GeneratedCookingRecipeBuilder viaCookingTag(Supplier<TagKey<Item>> tag) {
			return unlockedByTag(tag).viaCookingIngredient(() -> Ingredient.of(tag.get()));
		}

		GeneratedCookingRecipeBuilder viaCookingIngredient(Supplier<Ingredient> ingredient) {
			return new GeneratedCookingRecipeBuilder(ingredient);
		}

		class GeneratedCookingRecipeBuilder {

			private Supplier<Ingredient> ingredient;
			private float exp;
			private int cookingTime;

			private final SimpleCookingSerializer<?> FURNACE = RecipeSerializer.SMELTING_RECIPE,
					SMOKER = RecipeSerializer.SMOKING_RECIPE, BLAST = RecipeSerializer.BLASTING_RECIPE,
					CAMPFIRE = RecipeSerializer.CAMPFIRE_COOKING_RECIPE;

			GeneratedCookingRecipeBuilder(Supplier<Ingredient> ingredient) {
				this.ingredient = ingredient;
				cookingTime = 200;
				exp = 0;
			}

			GeneratedCookingRecipeBuilder forDuration(int duration) {
				cookingTime = duration;
				return this;
			}

			GeneratedCookingRecipeBuilder rewardXP(float xp) {
				exp = xp;
				return this;
			}

			GeneratedRecipe inFurnace() {
				return inFurnace(b -> b);
			}

			GeneratedRecipe inFurnace(UnaryOperator<SimpleCookingRecipeBuilder> builder) {
				return create(FURNACE, builder, 1);
			}

			GeneratedRecipe inSmoker() {
				return inSmoker(b -> b);
			}

			GeneratedRecipe inSmoker(UnaryOperator<SimpleCookingRecipeBuilder> builder) {
				create(FURNACE, builder, 1);
				create(CAMPFIRE, builder, 3);
				return create(SMOKER, builder, .5f);
			}

			GeneratedRecipe inBlastFurnace() {
				return inBlastFurnace(b -> b);
			}

			GeneratedRecipe inBlastFurnace(UnaryOperator<SimpleCookingRecipeBuilder> builder) {
				create(FURNACE, builder, 1);
				return create(BLAST, builder, .5f);
			}

			private GeneratedRecipe create(SimpleCookingSerializer<?> serializer,
										   UnaryOperator<SimpleCookingRecipeBuilder> builder, float cookingTimeModifier) {
				return register(consumer -> {
					boolean isOtherMod = compatDatagenOutput != null;

					SimpleCookingRecipeBuilder b = builder.apply(
							SimpleCookingRecipeBuilder.cooking(ingredient.get(), isOtherMod ? Items.DIRT : result.get(),
									exp, (int) (cookingTime * cookingTimeModifier), serializer));
					if (unlockedBy != null)
						b.unlockedBy("has_item", inventoryTrigger(unlockedBy.get()));
					b.save(result -> {
						consumer.accept(
								isOtherMod ? new ModdedCookingRecipeResult(result, compatDatagenOutput, recipeConditions)
										: result);
					}, createSimpleLocation(RegisteredObjects.getKeyOrThrow(serializer)
							.getPath()));
				});
			}
		}
	}
	@Override
	public String getName() {
		return "Confectionery Recipe Generator";
	}

	public CCStandardRecipeGen(FabricDataGenerator p_i48262_1_) {
		super(p_i48262_1_);
	}

	private static class ModdedCookingRecipeResult implements FinishedRecipe {

		private FinishedRecipe wrapped;
		private ResourceLocation outputOverride;
		private List<ConditionJsonProvider> conditions;

		public ModdedCookingRecipeResult(FinishedRecipe wrapped, ResourceLocation outputOverride,
										 List<ConditionJsonProvider> conditions) {
			this.wrapped = wrapped;
			this.outputOverride = outputOverride;
			this.conditions = conditions;
		}

		@Override
		public ResourceLocation getId() {
			return wrapped.getId();
		}

		@Override
		public RecipeSerializer<?> getType() {
			return wrapped.getType();
		}

		@Override
		public JsonObject serializeAdvancement() {
			return wrapped.serializeAdvancement();
		}

		@Override
		public ResourceLocation getAdvancementId() {
			return wrapped.getAdvancementId();
		}

		@Override
		public void serializeRecipeData(JsonObject object) {
			wrapped.serializeRecipeData(object);
			object.addProperty("result", outputOverride.toString());

			ConditionJsonProvider.write(object, conditions.toArray(new ConditionJsonProvider[0]));
		}

	}
}
