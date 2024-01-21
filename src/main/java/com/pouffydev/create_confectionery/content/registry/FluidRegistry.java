package com.pouffydev.create_confectionery.content.registry;

import static com.pouffydev.create_confectionery.Confectionery.REGISTRATE;
import static net.minecraft.world.item.Items.BUCKET;
import static net.minecraft.world.item.Items.GLASS_BOTTLE;

import javax.annotation.Nullable;

import com.pouffydev.create_confectionery.Confectionery;
import com.simibubi.create.AllTags;
import com.simibubi.create.Create;
import com.simibubi.create.content.contraptions.fluids.VirtualFluid;
import com.simibubi.create.content.palettes.AllPaletteStoneTypes;
import com.simibubi.create.foundation.fluid.FluidHelper;
import com.simibubi.create.foundation.utility.Iterate;
import com.tterrag.registrate.fabric.SimpleFlowableFluid;
import com.tterrag.registrate.util.entry.FluidEntry;

import io.github.fabricators_of_create.porting_lib.event.common.FluidPlaceBlockCallback;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariantAttributeHandler;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariantAttributes;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.EmptyItemFluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.FullItemFluidStorage;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

@SuppressWarnings("UnstableApiUsage")
public class FluidRegistry {

	public static final FluidEntry<SimpleFlowableFluid.Flowing> DARK_CHOCOLATE =
			REGISTRATE.standardFluid("black_chocolate"/*, NoColorFluidAttributes::new*/)
					.lang("Dark Chocolate")
					.tag(AllTags.forgeFluidTag("black_chocolate"), FluidTags.WATER) // fabric: water tag controls physics
					.fluidProperties(p -> p.levelDecreasePerBlock(2)
							.tickRate(25)
							.flowSpeed(3)
							.blastResistance(100f))
					.fluidAttributes(() -> new CreateAttributeHandler("fluid.create_confectionery.black_chocolate", 1500, 1400))
					.onRegisterAfter(Registry.ITEM_REGISTRY, black_chocolate -> {
						Fluid source = black_chocolate.getSource();
						// transfer values
						FluidStorage.combinedItemApiProvider(source.getBucket()).register(context ->
								new FullItemFluidStorage(context, bucket -> ItemVariant.of(BUCKET), FluidVariant.of(source), FluidConstants.BUCKET));
						FluidStorage.combinedItemApiProvider(BUCKET).register(context ->
								new EmptyItemFluidStorage(context, bucket -> ItemVariant.of(source.getBucket()), source, FluidConstants.BUCKET));
					})
					.register();
	public static final FluidEntry<SimpleFlowableFluid.Flowing> WHITE_CHOCOLATE =
			REGISTRATE.standardFluid("white_chocolate"/*, NoColorFluidAttributes::new*/)
					.lang("White Chocolate")
					.tag(AllTags.forgeFluidTag("white_chocolate"), FluidTags.WATER) // fabric: water tag controls physics
					.fluidProperties(p -> p.levelDecreasePerBlock(2)
							.tickRate(25)
							.flowSpeed(3)
							.blastResistance(100f))
					.fluidAttributes(() -> new CreateAttributeHandler("fluid.create_confectionery.white_chocolate", 1500, 1400))
					.onRegisterAfter(Registry.ITEM_REGISTRY, white_chocolate -> {
						Fluid source = white_chocolate.getSource();
						// transfer values
						FluidStorage.combinedItemApiProvider(source.getBucket()).register(context ->
								new FullItemFluidStorage(context, bucket -> ItemVariant.of(BUCKET), FluidVariant.of(source), FluidConstants.BUCKET));
						FluidStorage.combinedItemApiProvider(BUCKET).register(context ->
								new EmptyItemFluidStorage(context, bucket -> ItemVariant.of(source.getBucket()), source, FluidConstants.BUCKET));
					})
					.register();
	public static final FluidEntry<SimpleFlowableFluid.Flowing> RUBY_CHOCOLATE =
			REGISTRATE.standardFluid("ruby_chocolate"/*, NoColorFluidAttributes::new*/)
					.lang("Ruby Chocolate")
					.tag(AllTags.forgeFluidTag("ruby_chocolate"), FluidTags.WATER) // fabric: water tag controls physics
					.fluidProperties(p -> p.levelDecreasePerBlock(2)
							.tickRate(25)
							.flowSpeed(3)
							.blastResistance(100f))
					.fluidAttributes(() -> new CreateAttributeHandler("fluid.create_confectionery.ruby_chocolate", 1500, 1400))
					.onRegisterAfter(Registry.ITEM_REGISTRY, ruby_chocolate -> {
						Fluid source = ruby_chocolate.getSource();
						// transfer values
						FluidStorage.combinedItemApiProvider(source.getBucket()).register(context ->
								new FullItemFluidStorage(context, bucket -> ItemVariant.of(BUCKET), FluidVariant.of(source), FluidConstants.BUCKET));
						FluidStorage.combinedItemApiProvider(BUCKET).register(context ->
								new EmptyItemFluidStorage(context, bucket -> ItemVariant.of(source.getBucket()), source, FluidConstants.BUCKET));
					})
					.register();
	public static final FluidEntry<SimpleFlowableFluid.Flowing> CARAMEL =
			REGISTRATE.standardFluid("caramel"/*, NoColorFluidAttributes::new*/)
					.lang("Caramel")
					.tag(AllTags.forgeFluidTag("caramel"), FluidTags.WATER) // fabric: water tag controls physics
					.fluidProperties(p -> p.levelDecreasePerBlock(2)
							.tickRate(25)
							.flowSpeed(3)
							.blastResistance(100f))
					.fluidAttributes(() -> new CreateAttributeHandler("fluid.create_confectionery.caramel", 1500, 1400))
					.onRegisterAfter(Registry.ITEM_REGISTRY, caramel -> {
						Fluid source = caramel.getSource();
						// transfer values
						FluidStorage.combinedItemApiProvider(source.getBucket()).register(context ->
								new FullItemFluidStorage(context, bucket -> ItemVariant.of(BUCKET), FluidVariant.of(source), FluidConstants.BUCKET));
						FluidStorage.combinedItemApiProvider(BUCKET).register(context ->
								new EmptyItemFluidStorage(context, bucket -> ItemVariant.of(source.getBucket()), source, FluidConstants.BUCKET));
					})
					.register();
	public static final FluidEntry<VirtualFluid> HOT_CHOCOLATE = Confectionery.REGISTRATE.virtualFluid("hot_chocolate")
			.lang("Hot Chocolate")
			.tag(AllTags.forgeFluidTag("hot_chocolate"))
			.fluidAttributes(() -> new CreateAttributeHandler("fluid.create_confectionery.hot_chocolate"))
			.onRegisterAfter(Registry.ITEM_REGISTRY, hot_chocolate -> {
				Fluid still = hot_chocolate.getSource();
				FluidStorage.combinedItemApiProvider(ItemRegistry.HOT_CHOCOLATE.get()).register(context ->
						new FullItemFluidStorage(context, bottle -> ItemVariant.of(GLASS_BOTTLE), FluidVariant.of(still), FluidConstants.BOTTLE));
				FluidStorage.combinedItemApiProvider(GLASS_BOTTLE).register(context ->
						new EmptyItemFluidStorage(context, bottle -> ItemVariant.of(ItemRegistry.HOT_CHOCOLATE.get()), still, FluidConstants.BOTTLE));
			})
			.register();


	public static void register() {
	}

	@Environment(EnvType.CLIENT)
	public static void initRendering() {

	}
	public static void registerFluidInteractions() {
		// fabric: no fluid interaction API, use legacy method
		FluidPlaceBlockCallback.EVENT.register(FluidRegistry::whenFluidsMeet);
	}
	public static BlockState whenFluidsMeet(LevelAccessor world, BlockPos pos, BlockState blockState) {
		FluidState fluidState = blockState.getFluidState();

		if (fluidState.isSource() && FluidHelper.isLava(fluidState.getType()))
			return null;

		for (Direction direction : Iterate.directions) {
			FluidState metFluidState =
					fluidState.isSource() ? fluidState : world.getFluidState(pos.relative(direction));
			if (!metFluidState.is(FluidTags.WATER))
				continue;
			BlockState lavaInteraction = FluidRegistry.getLavaInteraction(metFluidState);
			if (lavaInteraction == null)
				continue;
			return lavaInteraction;
		}
		return null;
	}

	@Nullable
	public static BlockState getLavaInteraction(FluidState fluidState) {
		Fluid fluid = fluidState.getType();
		if (fluid.isSame(DARK_CHOCOLATE.get()))
			return AllPaletteStoneTypes.DEEPSLATE.getBaseBlock()
					.get()
					.defaultBlockState();
		if (fluid.isSame(WHITE_CHOCOLATE.get()))
			return AllPaletteStoneTypes.DIORITE.getBaseBlock()
					.get()
					.defaultBlockState();
		if (fluid.isSame(RUBY_CHOCOLATE.get()))
			return AllPaletteStoneTypes.GRANITE.getBaseBlock()
					.get()
					.defaultBlockState();
		if (fluid.isSame(CARAMEL.get()))
			return AllPaletteStoneTypes.DRIPSTONE.getBaseBlock()
					.get()
					.defaultBlockState();
		return null;
	}
	private record CreateAttributeHandler(Component name, int viscosity, boolean lighterThanAir) implements FluidVariantAttributeHandler {
		private CreateAttributeHandler(String key, int viscosity, int density) {
			this(Component.translatable(key), viscosity, density <= 0);
		}

		public CreateAttributeHandler(String key) {
			this(key, FluidConstants.WATER_VISCOSITY, 1000);
		}

		@Override
		public Component getName(FluidVariant fluidVariant) {
			return name.copy();
		}

		@Override
		public int getViscosity(FluidVariant variant, @Nullable Level world) {
			return viscosity;
		}

		@Override
		public boolean isLighterThanAir(FluidVariant variant) {
			return lighterThanAir;
		}
	}
	private static class HotChocolateFluidVariantAttributeHandler implements FluidVariantAttributeHandler {
		@Override
		public Component getName(FluidVariant fluidVariant) {
			return Component.translatable("fluid.create_confectionery.hot_chocolate");
		}
	}
	private record FluidNameAttributeHandler(String key) implements FluidVariantAttributeHandler {
		@Override
		public Component getName(FluidVariant fluidVariant) {
			return Component.translatable(this.key);
		}
	}
}
