package com.pouffydev.create_confectionery.content.registry;

import com.pouffydev.create_confectionery.ModGroup;
import com.simibubi.create.AllTags;
import com.simibubi.create.Create;
import com.simibubi.create.content.AllSections;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

import static com.pouffydev.create_confectionery.Confectionery.registrate;

public class ItemRegistry {
	private static final CreateRegistrate REGISTRATE = registrate()
			.creativeModeTab(() -> ModGroup.MAIN);
	public static final ItemEntry<Item> CRUSHED_COCOA =
			REGISTRATE.item("crushed_cocoa", Item::new)
					.register();
	public static final ItemEntry<Item> COCOA_BUTTER =
			REGISTRATE.item("crushed_cocoa", Item::new)
					.register();
	public static final ItemEntry<Item> BAR_OF_DARK_CHOCOLATE =
			REGISTRATE.item("bar_of_dark_chocolate", Item::new)
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





	public static void register() {
		Create.REGISTRATE.addToSection(CRUSHED_COCOA, AllSections.UNASSIGNED);
	}
}
