package com.pouffydev.create_confectionery.content.item;

import com.pouffydev.create_confectionery.content.registry.EffectsRegistry;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

public enum ChocolateType {
	NORMAL(),
	WHITE("White", EffectsRegistry.REST),
	RUBY("Ruby", MobEffects.SATURATION),
	DARK("Dark", EffectsRegistry.STIMULATION),

	;

	public static ChocolateType fromString(String string) {
		return switch (string) {
			case "normal" -> NORMAL;
			case "white" -> WHITE;
			case "ruby" -> RUBY;
			case "dark" -> DARK;
			default -> null;
		};
	}

	public final String name;
	public final MobEffect effect;
	ChocolateType(String name, MobEffect effect) {
		this.name = name;
		this.effect = effect;
	}
	ChocolateType() {
		this.name = null;
		this.effect = null;
	}
}
