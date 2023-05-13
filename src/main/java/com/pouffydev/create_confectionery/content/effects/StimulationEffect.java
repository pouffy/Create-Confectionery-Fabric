package com.pouffydev.create_confectionery.content.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

import org.jetbrains.annotations.NotNull;

public class StimulationEffect extends MobEffect {
	public StimulationEffect() {
		super(MobEffectCategory.BENEFICIAL, -10278906);
	}
	@Override
	public @NotNull String getDescriptionId() {
		return "effect.create_confectionery.stimulation";
	}
	@Override
	public void applyEffectTick(LivingEntity lEntity, int amplifier) {
		LivingEntity entity;
		entity = (LivingEntity) lEntity;
		entity.removeEffect(MobEffects.DIG_SLOWDOWN);
		entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
