package com.pouffydev.create_confectionery.content.effects;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
@SuppressWarnings("unchecked")
public class RestEffect extends MobEffect {
	public RestEffect() {
		super(MobEffectCategory.HARMFUL, -2119568);
	}
	@Override
	public String getDescriptionId() {
		return "effect.create_confectionery.rest";
	}
	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		Vec3 _center = new Vec3(x, y, z);
		List<Entity> _entfound = (List)world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(4.0), (e) -> {
			return true;
		}).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
			return _entcnd.distanceToSqr(_center);
		})).collect(Collectors.toList());
		Iterator var9 = _entfound.iterator();

		while(var9.hasNext()) {
			Entity entityiterator = (Entity)var9.next();
			if (entityiterator instanceof Phantom) {
				if (!entityiterator.level.isClientSide()) {
					entityiterator.discard();
				}

				if (world instanceof ServerLevel) {
					ServerLevel _level = (ServerLevel)world;
					_level.sendParticles(ParticleTypes.CLOUD, entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), 4, 0.2, 0.2, 0.2, 0.0);
				}

				if (world instanceof Level) {
					Level _level = (Level)world;
					if (!_level.isClientSide()) {
						_level.playSound(null, x, y, z, (SoundEvent)SoundEvents.PHANTOM_DEATH, SoundSource.NEUTRAL, 1.0F, 1.0F);
					} else {
						_level.playLocalSound(x, y, z, (SoundEvent)SoundEvents.PHANTOM_DEATH, SoundSource.NEUTRAL, 1.0F, 1.0F, false);
					}
				}
			}
		}

	}

	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
