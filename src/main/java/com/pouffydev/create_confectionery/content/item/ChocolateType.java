package com.pouffydev.create_confectionery.content.item;

import com.pouffydev.create_confectionery.content.registry.EffectsRegistry;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

public enum ChocolateType {
	NORMAL(),
	WHITE("White", EffectsRegistry.REST, 0, 1, -1, 3, 2),
	RUBY("Ruby", MobEffects.SATURATION, 0, 1, 2, -1, 3),
	BLACK("Black", EffectsRegistry.STIMULATION, 0, 1, 2, 3, -1),
	CARAMEL("Caramel", EffectsRegistry.REST, -1, -1, -1, -1, -1)

	;

	public static ChocolateType fromString(String string) {
		return switch (string) {
			case "normal" -> NORMAL;
			case "white" -> WHITE;
			case "ruby" -> RUBY;
			case "black" -> BLACK;
			default -> null;
		};
	}

	public final String name;
	public final MobEffect effect;
	public final int candyIntCaramel;
	public final int candyIntNormal;
	public final int candyIntWhite;
	public final int candyIntRuby;
	public final int candyIntDark;

	ChocolateType(String name, MobEffect effect, int candyIntCaramel, int candyIntNormal, int candyIntWhite, int candyIntRuby, int candyIntDark) {
		this.name = name;
		this.effect = effect;
		this.candyIntCaramel = candyIntCaramel;
		this.candyIntNormal = candyIntNormal;
		this.candyIntWhite = candyIntWhite;
		this.candyIntRuby = candyIntRuby;
		this.candyIntDark = candyIntDark;
	}
	ChocolateType() {
		this.name = null;
		this.effect = null;
		this.candyIntCaramel = 0;
		this.candyIntNormal = -1;
		this.candyIntWhite = 1;
		this.candyIntRuby = 2;
		this.candyIntDark = 3;
	}
}
