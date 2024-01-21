package com.pouffydev.create_confectionery.content.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class DrinkItem extends Item {

	public DrinkItem(Properties properties) {
		super(properties);
	}
	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.DRINK;
	}
	@Override
	public int getUseDuration(ItemStack stack) {
		return 32;
	}

}
