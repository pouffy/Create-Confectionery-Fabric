package com.pouffydev.create_confectionery;

import com.pouffydev.create_confectionery.content.entity.LittleGingerbreadManEntity;
import com.pouffydev.create_confectionery.content.entity.LittleGingerbreadManRenderer;
import com.simibubi.create.AllEntityTypes;
import com.simibubi.create.content.curiosities.weapons.PotatoProjectileEntity;
import com.simibubi.create.content.curiosities.weapons.PotatoProjectileRenderer;
import com.simibubi.create.foundation.data.CreateEntityBuilder;
import com.simibubi.create.foundation.utility.Lang;
import com.tterrag.registrate.util.entry.EntityEntry;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullSupplier;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class CreateConfectioneryEntities {

	public static final EntityEntry<LittleGingerbreadManEntity> LITTLE_GINGERBREAD_MAN =
			register("little_gingerbread_man", LittleGingerbreadManEntity::new, () -> LittleGingerbreadManRenderer::new,
					MobCategory.MONSTER, 64, 3, false, false, LittleGingerbreadManEntity::build).register();

	private static <T extends Entity> CreateEntityBuilder<T, ?> register(String name, EntityType.EntityFactory<T> factory,
																		 NonNullSupplier<NonNullFunction<EntityRendererProvider.Context, EntityRenderer<? super T>>> renderer,
																		 MobCategory group, int range, int updateFrequency, boolean sendVelocity, boolean immuneToFire,
																		 NonNullConsumer<FabricEntityTypeBuilder<T>> propertyBuilder) {
		String id = Lang.asId(name);
		return (CreateEntityBuilder<T, ?>) Confectionery.REGISTRATE
				.entity(id, factory, group)
				.properties(b -> b.trackRangeChunks(range)
						.trackedUpdateRate(updateFrequency)
						.forceTrackedVelocityUpdates(sendVelocity))
				.properties(propertyBuilder)
				.properties(b -> {
					if (immuneToFire)
						b.fireImmune();
				})
				.renderer(renderer);
	}
	public static void register() {}
}
