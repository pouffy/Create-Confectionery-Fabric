package com.pouffydev.create_confectionery.content.registry;

import com.pouffydev.create_confectionery.Confectionery;
import com.pouffydev.create_confectionery.content.effects.RestEffect;
import com.pouffydev.create_confectionery.content.effects.StimulationEffect;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;

public class EffectsRegistry {

	public static MobEffect REST;
	public static MobEffect STIMULATION;

	public static MobEffect registerRestEffect(String name) {
		return Registry.register(Registry.MOB_EFFECT, new ResourceLocation(Confectionery.ID, name),
				new RestEffect());
	}
	public static MobEffect registerStimulationEffect(String name) {
		return Registry.register(Registry.MOB_EFFECT, new ResourceLocation(Confectionery.ID, name),
				new StimulationEffect());
	}

	public static void registerEffects() {
		REST = registerRestEffect("rest");
		STIMULATION = registerStimulationEffect("stimulation");
	}
}
