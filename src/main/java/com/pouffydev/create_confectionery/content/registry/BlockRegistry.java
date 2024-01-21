package com.pouffydev.create_confectionery.content.registry;

import static com.pouffydev.create_confectionery.Confectionery.registrate;

import com.pouffydev.create_confectionery.ModGroup;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.TagGen;
import com.tterrag.registrate.util.entry.BlockEntry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;

public class BlockRegistry {
	private static final CreateRegistrate REGISTRATE = registrate()
			.creativeModeTab(() -> ModGroup.MAIN);

	public static final BlockEntry<Block> GINGERBREAD_BLOCK = REGISTRATE.block("gingerbread_block", Block::new)
			.properties(p -> p.strength(1.0F).sound(SoundType.TUFF).requiresCorrectToolForDrops())
			.transform(TagGen.pickaxeOnly())
			.simpleItem()
			.register();
	public static final BlockEntry<StairBlock> GINGERBREAD_STAIRS = REGISTRATE.block("gingerbread_stairs", (p) -> new StairBlock(GINGERBREAD_BLOCK.get().defaultBlockState(), p))
			.properties(p -> p.strength(1.0F).sound(SoundType.TUFF).requiresCorrectToolForDrops())
			.transform(TagGen.pickaxeOnly())
			.simpleItem()
			.register();
	public static final BlockEntry<SlabBlock> GINGERBREAD_SLAB = REGISTRATE.block("gingerbread_slab", SlabBlock::new)
			.properties(p -> p.strength(1.0F).sound(SoundType.TUFF).requiresCorrectToolForDrops())
			.transform(TagGen.pickaxeOnly())
			.simpleItem()
			.register();
	public static final BlockEntry<Block> GINGERBREAK_BRICKS = REGISTRATE.block("gingerbreak_bricks", Block::new)
			.properties(p -> p.strength(1.0F).sound(SoundType.TUFF).requiresCorrectToolForDrops())
			.transform(TagGen.pickaxeOnly())
			.simpleItem()
			.register();
	public static final BlockEntry<StairBlock> GINGERBREAD_BRICK_STAIRS = REGISTRATE.block("gingerbread_brick_stairs", (p) -> new StairBlock(GINGERBREAK_BRICKS.get().defaultBlockState(), p))
			.properties(p -> p.strength(1.0F).sound(SoundType.TUFF).requiresCorrectToolForDrops())
			.transform(TagGen.pickaxeOnly())
			.simpleItem()
			.register();
	public static final BlockEntry<SlabBlock> GINGERBREAD_BRICK_SLAB = REGISTRATE.block("gingerbread_brick_slab", SlabBlock::new)
			.properties(p -> p.strength(1.0F).sound(SoundType.TUFF).requiresCorrectToolForDrops())
			.transform(TagGen.pickaxeOnly())
			.simpleItem()
			.register();
	public static final BlockEntry<Block> BLACK_CHOCOLATE_BRICKS = REGISTRATE.block("black_chocolate_bricks", Block::new)
			.properties(p -> p.strength(1.0F).sound(SoundType.STONE).requiresCorrectToolForDrops())
			.transform(TagGen.pickaxeOnly())
			.simpleItem()
			.register();
	public static final BlockEntry<StairBlock> BLACK_CHOCOLATE_BRICKS_STAIRS = REGISTRATE.block("black_chocolate_bricks_stairs", (p) -> new StairBlock(BLACK_CHOCOLATE_BRICKS.get().defaultBlockState(), p))
			.properties(p -> p.strength(1.0F).sound(SoundType.STONE).requiresCorrectToolForDrops())
			.transform(TagGen.pickaxeOnly())
			.simpleItem()
			.register();
	public static final BlockEntry<SlabBlock> BLACK_CHOCOLATE_BRICKS_SLAB = REGISTRATE.block("black_chocolate_bricks_slab", SlabBlock::new)
			.properties(p -> p.strength(1.0F).sound(SoundType.STONE).requiresCorrectToolForDrops())
			.transform(TagGen.pickaxeOnly())
			.simpleItem()
			.register();

	public static final BlockEntry<Block> WHITE_CHOCOLATE_BRICKS = REGISTRATE.block("white_chocolate_bricks", Block::new)
			.properties(p -> p.strength(1.0F).sound(SoundType.STONE).requiresCorrectToolForDrops())
			.transform(TagGen.pickaxeOnly())
			.simpleItem()
			.register();

	public static final BlockEntry<StairBlock> WHITE_CHOCOLATE_BRICKS_STAIRS = REGISTRATE.block("white_chocolate_bricks_stairs", (p) -> new StairBlock(WHITE_CHOCOLATE_BRICKS.get().defaultBlockState(), p))
			.properties(p -> p.strength(1.0F).sound(SoundType.STONE).requiresCorrectToolForDrops())
			.transform(TagGen.pickaxeOnly())
			.simpleItem()
			.register();

	public static final BlockEntry<SlabBlock> WHITE_CHOCOLATE_BRICKS_SLAB = REGISTRATE.block("white_chocolate_bricks_slab", SlabBlock::new)
			.properties(p -> p.strength(1.0F).sound(SoundType.STONE).requiresCorrectToolForDrops())
			.transform(TagGen.pickaxeOnly())
			.simpleItem()
			.register();

	public static final BlockEntry<Block> RUBY_CHOCOLATE_BRICKS = REGISTRATE.block("ruby_chocolate_bricks", Block::new)
			.properties(p -> p.strength(1.0F).sound(SoundType.STONE).requiresCorrectToolForDrops())
			.transform(TagGen.pickaxeOnly())
			.simpleItem()
			.register();

	public static final BlockEntry<StairBlock> RUBY_CHOCOLATE_BRICK_STAIRS = REGISTRATE.block("ruby_chocolate_brick_stairs", (p) -> new StairBlock(RUBY_CHOCOLATE_BRICKS.get().defaultBlockState(), p))
			.properties(p -> p.strength(1.0F).sound(SoundType.STONE).requiresCorrectToolForDrops())
			.transform(TagGen.pickaxeOnly())
			.simpleItem()
			.register();

	public static final BlockEntry<SlabBlock> RUBY_CHOCOLATE_BRICK_SLAB = REGISTRATE.block("ruby_chocolate_brick_slab", SlabBlock::new)
			.properties(p -> p.strength(1.0F).sound(SoundType.STONE).requiresCorrectToolForDrops())
			.transform(TagGen.pickaxeOnly())
			.simpleItem()
			.register();

	public static final BlockEntry<Block> CARAMEL_BRICKS = REGISTRATE.block("caramel_bricks", Block::new)
			.properties(p -> p.strength(1.0F).sound(SoundType.STONE).requiresCorrectToolForDrops())
			.transform(TagGen.pickaxeOnly())
			.simpleItem()
			.register();

	public static final BlockEntry<StairBlock> CARAMEL_BRICK_STAIRS = REGISTRATE.block("caramel_brick_stairs", (p) -> new StairBlock(CARAMEL_BRICKS.get().defaultBlockState(), p))
			.properties(p -> p.strength(1.0F).sound(SoundType.STONE).requiresCorrectToolForDrops())
			.transform(TagGen.pickaxeOnly())
			.simpleItem()
			.register();

	public static final BlockEntry<SlabBlock> CARAMEL_BRICK_SLAB = REGISTRATE.block("caramel_brick_slab", SlabBlock::new)
			.properties(p -> p.strength(1.0F).sound(SoundType.STONE).requiresCorrectToolForDrops())
			.transform(TagGen.pickaxeOnly())
			.simpleItem()
			.register();

	public static final BlockEntry<RotatedPillarBlock> CANDY_CANE_BLOCK = REGISTRATE.block("candy_cane_block", RotatedPillarBlock::new)
			.properties(p -> p.strength(1.0F, 2.0F).sound(SoundType.CALCITE).requiresCorrectToolForDrops())
			.transform(TagGen.pickaxeOnly())
			.simpleItem()
			.register();

	public static void register() {}
}
