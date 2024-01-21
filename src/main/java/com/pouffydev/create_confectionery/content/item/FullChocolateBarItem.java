package com.pouffydev.create_confectionery.content.item;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;

import org.jetbrains.annotations.NotNull;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

@ParametersAreNonnullByDefault
public class FullChocolateBarItem extends Item {
	public FullChocolateBarItem() {
		super(new Item.Properties().stacksTo(1).defaultDurability(16));
	}
	@Override
	public int getUseDuration(ItemStack stack) {
		return 32;
	}
	@Override
	public @NotNull UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.EAT;
	}
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
		ItemStack thisItemStack = player.getItemInHand(usedHand);
		player.startUsingItem(usedHand);
		thisItemStack.hurtAndBreak(1, player, (entity) -> {
			entity.broadcastBreakEvent(usedHand);
		});
		return InteractionResultHolder.success(thisItemStack);
	}
}
