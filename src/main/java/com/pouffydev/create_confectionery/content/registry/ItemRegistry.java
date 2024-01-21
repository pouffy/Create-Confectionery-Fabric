package com.pouffydev.create_confectionery.content.registry;

import com.pouffydev.create_confectionery.ModGroup;
import com.pouffydev.create_confectionery.content.item.DrinkItem;
import com.simibubi.create.AllTags;
import com.simibubi.create.Create;
import com.simibubi.create.content.AllSections;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;

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
	public static final ItemEntry<Item> BAR_OF_DARK_CHOCOLATE =
			REGISTRATE.item("bar_of_black_chocolate", Item::new)
					.properties(p -> p.food(new FoodProperties.Builder()
							.nutrition(6)
							.saturationMod(0.3F)
							.effect(new MobEffectInstance(EffectsRegistry.STIMULATION, 120, 0), 1.0F)
							.build()))
					.lang("Bar of Dark Chocolate")
					.register();
	public static final ItemEntry<Item> BAR_OF_WHITE_CHOCOLATE =
			REGISTRATE.item("bar_of_white_chocolate", Item::new)
					.properties(p -> p.food(new FoodProperties.Builder()
							.nutrition(6)
							.saturationMod(0.3F)
							.effect(new MobEffectInstance(EffectsRegistry.REST, 600, 0), 1.0F)
							.build()))
					.lang("Bar of White Chocolate")
					.register();
	public static final ItemEntry<Item> BAR_OF_RUBY_CHOCOLATE =
			REGISTRATE.item("bar_of_ruby_chocolate", Item::new)
					.properties(p -> p.food(new FoodProperties.Builder()
							.nutrition(6)
							.saturationMod(0.3F)
							.effect(new MobEffectInstance(MobEffects.SATURATION, 40, 0), 1.0F)
							.build()))
					.lang("Bar of Ruby Chocolate")
					.register();
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
			REGISTRATE.item("hot_chocolate", DrinkItem::new)
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




	public static void register() {
		Create.REGISTRATE.addToSection(CRUSHED_COCOA, AllSections.UNASSIGNED);
	}
}
