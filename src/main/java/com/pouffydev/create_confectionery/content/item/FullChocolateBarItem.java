package com.pouffydev.create_confectionery.content.item;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;

import org.jetbrains.annotations.NotNull;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

@ParametersAreNonnullByDefault
public class FullChocolateBarItem extends Item {
	private final MobEffect effect;
	public FullChocolateBarItem(Properties properties, MobEffect effect) {
		super(properties.stacksTo(1).defaultDurability(16));
		this.effect = effect;
	}
	public FullChocolateBarItem(Properties properties) {
		super(properties.stacksTo(1).defaultDurability(16));
		this.effect = null;
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

		return InteractionResultHolder.success(thisItemStack);
	}
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
		super.finishUsingItem(stack, level, livingEntity);
		if (this.effect != null)
			livingEntity.addEffect(new MobEffectInstance(this.effect, 120, 0));
		return stack.isEmpty() ? new ItemStack(this) : stack;
	}
}
