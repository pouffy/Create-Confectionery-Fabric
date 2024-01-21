package com.pouffydev.create_confectionery.content.entity;

import java.util.Objects;

import com.pouffydev.create_confectionery.CreateConfectioneryEntities;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class LittleGingerbreadManEntity extends TamableAnimal {
	private static final EntityDataAccessor<Integer> tagEat;
	public LittleGingerbreadManEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
		super(entityType, level);
		this.maxUpStep = 0.6F;
		this.xpReward = 0;
		this.setNoAi(false);
		this.setPersistenceRequired();
	}
	static {
		tagEat = SynchedEntityData.defineId(LittleGingerbreadManEntity.class, EntityDataSerializers.INT);
	}
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.2));
		this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 1.0, 10.0F, 2.0F, false));
		this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1.0));
		this.goalSelector.addGoal(4, new OwnerHurtByTargetGoal(this));
		this.goalSelector.addGoal(5, new OwnerHurtTargetGoal(this));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(7, new FloatGoal(this));
	}
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}
	public static FabricEntityTypeBuilder<?> build(FabricEntityTypeBuilder<?> builder) {
		return builder.dimensions(EntityDimensions.fixed(0.5F, 1.0F));
	}
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}
	public SoundEvent getHurtSound(DamageSource ds) {
		return Registry.SOUND_EVENT.get(new ResourceLocation("block.gravel.hit"));
	}

	public SoundEvent getDeathSound() {
		return Registry.SOUND_EVENT.get(new ResourceLocation("block.gravel.break"));
	}
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_FLAGS_ID, (byte)0);
		this.entityData.define(tagEat, 3);
	}
	public boolean hurt(DamageSource source, float amount) {
		doAfterHurt(this.level, source.getEntity());
		return super.hurt(source, amount);
	}
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level.isClientSide());
		Item item = itemstack.getItem();
		if (itemstack.getItem() instanceof SpawnEggItem) {
			retval = super.mobInteract(sourceentity, hand);
		} else if (this.level.isClientSide()) {
			retval = (!this.isTame() || !this.isOwnedBy(sourceentity)) && !this.isFood(itemstack) ? InteractionResult.PASS : InteractionResult.sidedSuccess(this.level.isClientSide());
		} else if (this.isTame()) {
			if (this.isOwnedBy(sourceentity)) {
				if (item.isEdible() && this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
					this.usePlayerItem(sourceentity, hand, itemstack);
					this.heal((float)item.getFoodProperties().getNutrition());
					retval = InteractionResult.sidedSuccess(this.level.isClientSide());
				} else if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
					this.usePlayerItem(sourceentity, hand, itemstack);
					this.heal(4.0F);
					retval = InteractionResult.sidedSuccess(this.level.isClientSide());
				} else {
					retval = super.mobInteract(sourceentity, hand);
				}
			}

		} else if (this.isFood(itemstack)) {
			this.usePlayerItem(sourceentity, hand, itemstack);
			if (this.random.nextInt(3) == 0 && !this.isTame()) {
				this.tame(sourceentity);
				this.level.broadcastEntityEvent(this, (byte)7);
			} else {
				this.level.broadcastEntityEvent(this, (byte)6);
			}

			this.setPersistenceRequired();
			retval = InteractionResult.sidedSuccess(this.level.isClientSide());
		} else {
			retval = super.mobInteract(sourceentity, hand);
			if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME) {
				this.setPersistenceRequired();
			}
		}

		return retval;
	}

	public void baseTick() {
		super.baseTick();
		onEntityTick(this);
	}

	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		LittleGingerbreadManEntity retval = (LittleGingerbreadManEntity)((EntityType) CreateConfectioneryEntities.LITTLE_GINGERBREAD_MAN.get()).create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return retval;
	}

	public boolean isFood(ItemStack stack) {
		return Objects.equals(Items.SUGAR, stack.getItem());
	}

	public static void init() {
	}
	public static void onEntityTick(Entity entity) {
		if (entity != null) {
			float var10000;
			if (entity instanceof LivingEntity lEntity) {
				var10000 = lEntity.getHealth();
			} else {
				var10000 = -1.0F;
			}
			if (var10000 <= 3.0F) {
				entity.getEntityData().set(tagEat, 3);
			} else {
				LivingEntity lEntity = (LivingEntity) entity;
				var10000 = lEntity.getHealth();

				if (var10000 <= 5.0F) {
					entity.getEntityData().set(tagEat, 2);
				} else {
					var10000 = lEntity.getHealth();

					if (var10000 <= 8.0F) {
						entity.getEntityData().set(tagEat, 1);
					} else {
						entity.getEntityData().set(tagEat, 0);
					}
				}
			}

		}
	}
    public static void doAfterHurt(LevelAccessor world, Entity sourceentity) {
		if (sourceentity != null) {
			if (sourceentity instanceof Player player) {
				FoodData var10000 = player.getFoodData();
				int var10001;
				var10001 = player.getFoodData().getFoodLevel();
				var10000.setFoodLevel(var10001 + 3);
			}

			if (world instanceof Level level) {
				if (!level.isClientSide()) {
					level.playSound(null, BlockPos.of(BlockPos.asLong((int) sourceentity.getX(), (int) sourceentity.getY(), (int) sourceentity.getZ())), SoundEvents.PLAYER_BURP, SoundSource.NEUTRAL, 1.0F, 1.0F);
				} else {
					level.playLocalSound(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ(), SoundEvents.PLAYER_BURP, SoundSource.NEUTRAL, 1.0F, 1.0F, false);
				}
			}

		}
    }
	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 10.0);
		builder = builder.add(Attributes.ARMOR, 0.0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3.0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16.0);
		return builder;
	}
}
