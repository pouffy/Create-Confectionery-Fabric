package com.pouffydev.create_confectionery.content.registry;

import com.pouffydev.create_confectionery.ModGroup;
import com.pouffydev.create_confectionery.content.item.ChocolateType;
import com.pouffydev.create_confectionery.content.item.DrinkItem;
import com.pouffydev.create_confectionery.content.item.FullChocolateBarItem;
import com.simibubi.create.AllTags;
import com.simibubi.create.Create;
import com.simibubi.create.content.AllSections;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.ItemEntry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;

import static com.pouffydev.create_confectionery.Confectionery.registrate;

public class ItemRegistry {
	private static final CreateRegistrate REGISTRATE = registrate()
			.creativeModeTab(() -> ModGroup.MAIN);
	public static final ItemEntry<Item> CRUSHED_COCOA =
			REGISTRATE.item("crushed_cocoa", Item::new)
					.register();
	public static final ItemEntry<Item> COCOA_BUTTER =
			REGISTRATE.item("cocoa_butter", Item::new)
					.register();
	public static final ItemEntry<Item> COCOA_POWDER =
			REGISTRATE.item("cocoa_powder", Item::new)
					.register();
	//public static final ItemEntry<Item> BAR_OF_DARK_CHOCOLATE =
	//		REGISTRATE.item("bar_of_black_chocolate", Item::new)
	//				.properties(p -> p.food(new FoodProperties.Builder()
	//						.nutrition(6)
	//						.saturationMod(0.3F)
	//						.effect(new MobEffectInstance(EffectsRegistry.STIMULATION, 120, 0), 1.0F)
	//						.build()))
	//				.lang("Bar of Dark Chocolate")
	//				.register();
	//public static final ItemEntry<Item> BAR_OF_WHITE_CHOCOLATE =
	//		REGISTRATE.item("bar_of_white_chocolate", Item::new)
	//				.properties(p -> p.food(new FoodProperties.Builder()
	//						.nutrition(6)
	//						.saturationMod(0.3F)
	//						.effect(new MobEffectInstance(EffectsRegistry.REST, 600, 0), 1.0F)
	//						.build()))
	//				.lang("Bar of White Chocolate")
	//				.register();
	//public static final ItemEntry<Item> BAR_OF_RUBY_CHOCOLATE =
	//		REGISTRATE.item("bar_of_ruby_chocolate", Item::new)
	//				.properties(p -> p.food(new FoodProperties.Builder()
	//						.nutrition(6)
	//						.saturationMod(0.3F)
	//						.effect(new MobEffectInstance(MobEffects.SATURATION, 40, 0), 1.0F)
	//						.build()))
	//				.lang("Bar of Ruby Chocolate")
	//				.register();
	public static final ItemEntry<Item> BAR_OF_CARAMEL =
			REGISTRATE.item("bar_of_caramel", Item::new)
					.properties(p -> p.food(new FoodProperties.Builder()
							.nutrition(6)
							.saturationMod(0.3F)
							.effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0), 1.0F)
							.build()))
					.lang("Bar of Caramel")
					.register();
	public static final ItemEntry<DrinkItem> HOT_CHOCOLATE =
			REGISTRATE.item("hot_chocolate_bottle", DrinkItem::new)
					.properties(p -> p.food(new FoodProperties.Builder()
							.nutrition(4)
							.saturationMod(0.3F)
							.effect(new MobEffectInstance(MobEffects.REGENERATION, 120, 0), 1.0F)
							.build())
							.stacksTo(16)
					)
					.lang("Hot Chocolate")
					.register();
	public static final ItemEntry<DrinkItem> SOOTHING_HOT_CHOCOLATE =
			REGISTRATE.item("soothing_hot_chocolate", DrinkItem::new)
					.properties(p -> p.food(new FoodProperties.Builder()
									.nutrition(6)
									.saturationMod(0.4F)
									.effect(new MobEffectInstance(MobEffects.REGENERATION, 120, 1), 1.0F)
									.build())
							.stacksTo(16)
					)
					.lang("Soothing Hot Chocolate")
					.register();
	public static final ItemEntry<Item> MARSHMALLOW =
			REGISTRATE.item("marshmallow", Item::new)
					.properties(p -> p.food(new FoodProperties.Builder()
							.nutrition(2)
							.saturationMod(0.1F)
							.build()))
					.lang("Marshmallow")
					.register();
	public static final ItemEntry<Item> MARSHMALLOWS_ON_A_STICK =
			REGISTRATE.item("marshmallows_on_a_stick", Item::new)
					.properties(p -> p.food(new FoodProperties.Builder()
							.nutrition(7)
							.saturationMod(0.7F)
							.build()))
					.lang("Marshmallows on a Stick")
					.register();
	public static final ItemEntry<Item> CARAMELIZED_MARSHMALLOWS_ON_A_STICK =
			REGISTRATE.item("caramelized_marshmallows_on_a_stick", Item::new)
					.properties(p -> p.food(new FoodProperties.Builder()
							.nutrition(8)
							.saturationMod(0.9F)
									.effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0), 1.0F)
							.build()))
					.lang("Caramelized Marshmallows on a Stick")
					.register();
	//TODO: Don't forget to go through the item classes and get their properties right
	public static final ItemEntry<Item> GINGERDOUGH =
			REGISTRATE.item("gingerdough", Item::new)
					.properties(p -> p)
					.lang("Gingerdough")
					.register();
	public static final ItemEntry<Item> GINGERBREAD =
			REGISTRATE.item("gingerbread", Item::new)
					.properties(p -> p.food(new FoodProperties.Builder()
							.nutrition(4)
							.saturationMod(0.3F)
							.build()))
					.lang("Gingerbread")
					.register();
	public static final ItemEntry<Item> GINGERBREAD_MAN =
			REGISTRATE.item("gingerbread_man", Item::new)
					.properties(p -> p.food(new FoodProperties.Builder()
							.nutrition(2)
							.saturationMod(0.3F)
							.build()))
					.lang("Gingerbread Man")
					.register();

	public static final ItemEntry<SpawnEggItem> LITTLE_GINGERBREAD_MAN_SPAWN_EGG =
			REGISTRATE.item("little_gingerbread_man_spawn_egg", (p) -> new SpawnEggItem(EntityRegistry.LITTLE_GINGERBREAD_MAN.get(), -5611197, -2435116, p))
					.properties(p -> p)
					.lang("Gingerbread Man Spawn Egg")
					.register();

	//public static final ItemEntry<FullChocolateBarItem> FULL_CHOCOLATE_BAR =
	//		REGISTRATE.item("full_chocolate_bar", FullChocolateBarItem::new)
	//				.properties(p -> p)
	//				.lang("Full Chocolate Bar")
	//				.register();
	//public static final ItemEntry<FullChocolateBarItem> FULL_BLACK_CHOCOLATE_BAR =
	//		REGISTRATE.item("full_black_chocolate_bar", (p) -> new FullChocolateBarItem(p, new MobEffectInstance(EffectsRegistry.STIMULATION, 120, 0)))
	//				.properties(p -> p)
	//				.lang("Full Black Chocolate Bar")
	//				.register();
	//public static final ItemEntry<FullChocolateBarItem> FULL_WHITE_CHOCOLATE_BAR =
	//		REGISTRATE.item("full_white_chocolate_bar", (p) -> new FullChocolateBarItem(p, new MobEffectInstance(EffectsRegistry.REST, 120, 0)))
	//				.properties(p -> p)
	//				.lang("Full White Chocolate Bar")
	//				.register();
	//public static final ItemEntry<FullChocolateBarItem> FULL_RUBY_CHOCOLATE_BAR =
	//		REGISTRATE.item("full_ruby_chocolate_bar", (p) -> new FullChocolateBarItem(p, new MobEffectInstance(MobEffects.SATURATION, 120, 0)))
	//				.properties(p -> p)
	//				.lang("Full Ruby Chocolate Bar")
	//				.register();



	public static ItemEntry<Item> chocolateBar(ChocolateType type) {
		String typeName = type != ChocolateType.BLACK ? type.name : "Dark";
		String name = type.name != null ? "bar_of_" + type.name.toLowerCase() + "_chocolate" : "bar_of_chocolate";
		String lang = type.name != null ? "Bar of " + typeName + " Chocolate" : "Bar of Chocolate";
		if (type == ChocolateType.NORMAL)
			return REGISTRATE.item(name, Item::new)
					.properties(p -> p.food(new FoodProperties.Builder()
							.nutrition(6)
							.saturationMod(0.3F)
							.build()))
					.lang(lang)
					.register();
		else
			return REGISTRATE.item(name, Item::new)
					.properties(p -> p.food(new FoodProperties.Builder()
							.nutrition(6)
							.saturationMod(0.3F)
							.effect(new MobEffectInstance(type.effect, 120, 0), 1.0F)
							.build()))
					.lang(lang)
					.register();
	}
	public static ItemEntry<FullChocolateBarItem> fullChocolateBar(ChocolateType type) {
		String typeName = type != ChocolateType.BLACK ? type.name : "Dark";
		String name = type.name != null ? "full_" + type.name.toLowerCase() + "_chocolate_bar" : "full_chocolate_bar";
		String lang = type.name != null ? "Full " + typeName + " Chocolate Bar" : "Full Chocolate Bar";
		if (type == ChocolateType.NORMAL)
			return REGISTRATE.item(name, FullChocolateBarItem::new)
					.properties(p -> p)
					.lang(lang)
					.register();
		else
			return REGISTRATE.item(name, (p) -> new FullChocolateBarItem(p, type.effect))
					.properties(p -> p)
					.lang(lang)
					.register();
	}

	public static ItemEntry<Item> glazedBerries(ChocolateType type) {
		String typeName = type != ChocolateType.BLACK ? type.name : "Dark";
		String name = type.name != null ? type.name.toLowerCase() + "_chocolate_glazed_berries" : "chocolate_glazed_berries";
		String lang = type.name != null ? typeName + " Chocolate Glazed Berries" : "Chocolate Glazed Berries";
		if (type == ChocolateType.NORMAL)
			return REGISTRATE.item(name, Item::new)
					.properties(p -> p.food(new FoodProperties.Builder()
							.nutrition(7)
							.saturationMod(0.8F)
							.build()))
					.lang(lang)
					.register();
		else
			return REGISTRATE.item(name, Item::new)
					.properties(p -> p.food(new FoodProperties.Builder()
							.nutrition(7)
							.saturationMod(0.8F)
							.effect(new MobEffectInstance(type.effect, 120, 0), 1.0F)
							.build()))
					.lang(lang)
					.register();
	}
	public static ItemEntry<Item> glazedMarshmallow(ChocolateType type) {
		String typeName = type != ChocolateType.BLACK ? type.name : "Dark";
		String name = type.name != null ? type.name.toLowerCase() + "_chocolate_glazed_marshmallow" : "chocolate_glazed_marshmallow";
		String lang = type.name != null ? typeName + " Chocolate Glazed Marshmallow" : "Chocolate Glazed Marshmallow";
		if (type == ChocolateType.NORMAL)
			return REGISTRATE.item(name, Item::new)
					.properties(p -> p.food(new FoodProperties.Builder()
							.nutrition(5)
							.saturationMod(0.6F)
							.build()))
					.lang(lang)
					.register();
		else
			return REGISTRATE.item(name, Item::new)
					.properties(p -> p.food(new FoodProperties.Builder()
							.nutrition(5)
							.saturationMod(0.6F)
							.effect(new MobEffectInstance(type.effect, 120, 0), 1.0F)
							.build()))
					.lang(lang)
					.register();
	}
	public static ItemEntry<Item> chocolateCandyDark(ChocolateType type, String name) {
		if (type == ChocolateType.NORMAL)
			return REGISTRATE.item(name, Item::new)
					.properties(p -> p.food(new FoodProperties.Builder()
							.nutrition(3)
							.saturationMod(0.2F)
							.build()))
					.lang("Dark Chocolate Candy")
					.register();
		else
			return REGISTRATE.item(name, Item::new)
					.properties(p -> p.food(new FoodProperties.Builder()
							.nutrition(3)
							.saturationMod(0.2F)
							.effect(new MobEffectInstance(type.effect, 120, 0), 1.0F)
							.build()))
					.lang("Dark Chocolate Candy")
					.register();
	}
	public static ItemEntry<Item> chocolateCandy(ChocolateType type, String name) {
		return REGISTRATE.item(name, Item::new)
				.properties(p -> p.food(new FoodProperties.Builder()
						.nutrition(3)
						.saturationMod(0.2F)
						.effect(new MobEffectInstance(type.effect, 120, 0), 1.0F)
						.build()))
				.lang("Chocolate Candy")
				.register();
	}
	public static ItemEntry<Item> chocolateCandyWhite(ChocolateType type, String name) {
		if (type == ChocolateType.NORMAL)
			return REGISTRATE.item(name, Item::new)
					.properties(p -> p.food(new FoodProperties.Builder()
							.nutrition(3)
							.saturationMod(0.2F)
							.build()))
					.lang("White Chocolate Candy")
					.register();
		else
			return REGISTRATE.item(name, Item::new)
					.properties(p -> p.food(new FoodProperties.Builder()
							.nutrition(3)
							.saturationMod(0.2F)
							.effect(new MobEffectInstance(type.effect, 120, 0), 1.0F)
							.build()))
					.lang("White Chocolate Candy")
					.register();
	}
	public static ItemEntry<Item> chocolateCandyRuby(ChocolateType type, String name) {
		if (type == ChocolateType.NORMAL)
			return REGISTRATE.item(name, Item::new)
					.properties(p -> p.food(new FoodProperties.Builder()
							.nutrition(3)
							.saturationMod(0.2F)
							.build()))
					.lang("Ruby Chocolate Candy")
					.register();
		else
			return REGISTRATE.item(name, Item::new)
					.properties(p -> p.food(new FoodProperties.Builder()
							.nutrition(3)
							.saturationMod(0.2F)
							.effect(new MobEffectInstance(type.effect, 120, 0), 1.0F)
							.build()))
					.lang("Ruby Chocolate Candy")
					.register();
	}
	public static int candyInt(ChocolateType exterior, ChocolateType interior) {
		if (exterior == ChocolateType.NORMAL) {
			if (interior == ChocolateType.NORMAL)
				return exterior.candyIntNormal;
			if (interior == ChocolateType.WHITE)
				return exterior.candyIntWhite;
			if (interior == ChocolateType.RUBY)
				return exterior.candyIntRuby;
			if (interior == ChocolateType.BLACK)
				return exterior.candyIntDark;
		} else if (exterior == ChocolateType.WHITE) {
			if (interior == ChocolateType.NORMAL)
				return exterior.candyIntNormal;
			if (interior == ChocolateType.WHITE)
				return exterior.candyIntWhite;
			if (interior == ChocolateType.RUBY)
				return exterior.candyIntRuby;
			if (interior == ChocolateType.BLACK)
				return exterior.candyIntDark;
		} else if (exterior == ChocolateType.RUBY) {
			if (interior == ChocolateType.NORMAL)
				return exterior.candyIntNormal;
			if (interior == ChocolateType.WHITE)
				return exterior.candyIntWhite;
			if (interior == ChocolateType.RUBY)
				return exterior.candyIntRuby;
			if (interior == ChocolateType.BLACK)
				return exterior.candyIntDark;
		} else if (exterior == ChocolateType.BLACK) {
			if (interior == ChocolateType.NORMAL)
				return exterior.candyIntNormal;
			if (interior == ChocolateType.WHITE)
				return exterior.candyIntWhite;
			if (interior == ChocolateType.RUBY)
				return exterior.candyIntRuby;
			if (interior == ChocolateType.BLACK)
				return exterior.candyIntDark;
		}
		return 0;
	}
	public static void registerChocolate() {
		for (ChocolateType type : ChocolateType.values()) {
			if (type != ChocolateType.NORMAL) {
				if (type != ChocolateType.CARAMEL) {
					chocolateBar(type);

				}
				chocolateCandy(type, candyInt(ChocolateType.NORMAL, type) != 0 ? "chocolate_candy_" + candyInt(ChocolateType.NORMAL, type) : "chocolate_candy");
			}
			if (type != ChocolateType.WHITE)
				chocolateCandyWhite(type, candyInt(ChocolateType.WHITE, type) != 0 ? "white_chocolate_candy_" + candyInt(ChocolateType.WHITE, type) : "white_chocolate_candy");
			if (type != ChocolateType.RUBY)
				chocolateCandyRuby(type, candyInt(ChocolateType.RUBY, type) != 0 ? "ruby_chocolate_candy_" + candyInt(ChocolateType.RUBY, type) : "ruby_chocolate_candy");
			if (type != ChocolateType.BLACK)
				chocolateCandyDark(type, candyInt(ChocolateType.BLACK, type) != 0 ? "black_chocolate_candy_" + candyInt(ChocolateType.BLACK, type) : "black_chocolate_candy");
			if (type != ChocolateType.CARAMEL) {
				fullChocolateBar(type);
				glazedMarshmallow(type);
			}
			glazedBerries(type);
		}
	}

	public Item get(ResourceLocation name) {
		return Registry.ITEM.get(name);
	}


	public static void register() {
		registerChocolate();
		Create.REGISTRATE.addToSection(CRUSHED_COCOA, AllSections.UNASSIGNED);
	}
}
