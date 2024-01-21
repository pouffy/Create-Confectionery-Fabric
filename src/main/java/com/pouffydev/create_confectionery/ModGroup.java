package com.pouffydev.create_confectionery;


import com.pouffydev.create_confectionery.content.registry.ItemRegistry;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModGroup {
	public static CreativeModeTab MAIN = FabricItemGroupBuilder.build(new ResourceLocation(Confectionery.ID, "main"), () -> new ItemStack(ItemRegistry.BAR_OF_CARAMEL.get()));
}
