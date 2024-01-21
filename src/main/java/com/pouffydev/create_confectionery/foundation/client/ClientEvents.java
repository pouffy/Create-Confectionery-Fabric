package com.pouffydev.create_confectionery.foundation.client;

import com.pouffydev.create_confectionery.content.registry.FluidRegistry;
import com.simibubi.create.AllFluids;

import com.simibubi.create.AllItems;
import com.simibubi.create.foundation.fluid.FluidHelper;

import io.github.fabricators_of_create.porting_lib.event.client.FogEvents;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

public class ClientEvents {

	public static float getFogDensity(Camera info, float currentDensity) {
		Level level = Minecraft.getInstance().level;
		BlockPos blockPos = info.getBlockPosition();
		FluidState fluidState = level.getFluidState(blockPos);
		if (info.getPosition().y > blockPos.getY() + fluidState.getHeight(level, blockPos))
			return currentDensity;
		Fluid fluid = fluidState.getType();

		if (FluidRegistry.DARK_CHOCOLATE.get()
				.isSame(fluid)) {
			return 5f;
		}

		if (FluidRegistry.WHITE_CHOCOLATE.get()
				.isSame(fluid)) {
			return 5f;
		}
		if (FluidRegistry.RUBY_CHOCOLATE.get()
				.isSame(fluid)) {
			return 5f;
		}
		if (FluidRegistry.CARAMEL.get()
				.isSame(fluid)) {
			return 5f;
		}
		return currentDensity;
	}
	public static void getFogColor(FogEvents.ColorData event, float partialTicks) {
		Camera info = event.getCamera();
		Level level = Minecraft.getInstance().level;
		BlockPos blockPos = info.getBlockPosition();
		FluidState fluidState = level.getFluidState(blockPos);
		if (info.getPosition().y > blockPos.getY() + fluidState.getHeight(level, blockPos))
			return;

		Fluid fluid = fluidState.getType();

		if (FluidRegistry.DARK_CHOCOLATE.get()
				.isSame(fluid)) {
			event.setRed(75 / 255f);
			event.setGreen(23 / 255f);
			event.setBlue(1 / 255f);
			return;
		}

		if (FluidRegistry.WHITE_CHOCOLATE.get()
				.isSame(fluid)) {
			event.setRed(221 / 255f);
			event.setGreen(163 / 255f);
			event.setBlue(108 / 255f);
			return;
		}

		if (FluidRegistry.RUBY_CHOCOLATE.get()
				.isSame(fluid)) {
			event.setRed(228 / 255f);
			event.setGreen(116 / 255f);
			event.setBlue(175 / 255f);
			return;
		}

		if (FluidRegistry.CARAMEL.get()
				.isSame(fluid)) {
			event.setRed(190 / 255f);
			event.setGreen(101 / 255f);
			event.setBlue(38 / 255f);
			return;
		}
	}

	public static void register() {
		FogEvents.SET_DENSITY.register(ClientEvents::getFogDensity);
		FogEvents.SET_COLOR.register(ClientEvents::getFogColor);
	}
}
