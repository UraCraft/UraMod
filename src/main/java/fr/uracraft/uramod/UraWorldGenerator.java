package fr.uracraft.uramod;

import fr.uracraft.uramod.blocks.BlockStone;
import fr.uracraft.uramod.blocks.UraBlocks;
import fr.uracraft.uramod.utils.UraWorldGeneratorConfiguration;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class UraWorldGenerator implements IWorldGenerator {

    @SubscribeEvent
    public void populateChunkEvent(PopulateChunkEvent event) {
        Chunk chunk = event.getWorld().getChunkFromChunkCoords(event.getChunkX(), event.getChunkZ());

        for (ExtendedBlockStorage storage : chunk.getBlockStorageArray()) {
            if (storage != null) {
                for (int x = 0; x < 16; x++) {
                    for (int y = 0; y < 16; y++) {
                        for (int z = 0; z < 16; z++) {
                            replace(storage, x, y, z);
                        }
                    }
                }
            }
        }
        chunk.setModified(true);
    }

    private void replaceBlock(ExtendedBlockStorage storage, int x, int y, int z, IBlockState blockOut, IBlockState... blockIn) {
        for (IBlockState block : blockIn) {
            if (storage.get(x, y, z).equals(block)) storage.set(x, y, z, blockOut);
        }
    }

    private void addOre(IBlockState block, Block blockIn, int maxSize, int chance, int minHeight, int maxHeight, Random random, int chunkX, int chunkZ, World world) {
        if (minHeight > maxHeight || minHeight < 0 || minHeight > 256)
            throw new IllegalArgumentException("Ore Generated out of bounds");

        int heightDiff = maxHeight - minHeight + 1;

        for (int i = 0; i < chance; i++) {
            int x = chunkX * 16 + random.nextInt(16);
            int y = minHeight + random.nextInt(heightDiff);
            int z = chunkZ * 16 + random.nextInt(16);

            WorldGenerator generator = new WorldGenMinable(block, maxSize, BlockMatcher.forBlock(blockIn));
            generator.generate(world, random, new BlockPos(x, y, z));
        }
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator generator, IChunkProvider provider) {
        addOre(UraBlocks.BLOCK_STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.COAL), Blocks.STONE, UraWorldGeneratorConfiguration.coalMaxSize, UraWorldGeneratorConfiguration.coalChance, UraWorldGeneratorConfiguration.coalMinY, UraWorldGeneratorConfiguration.coalMaxY, random, chunkX, chunkZ, world);
        addOre(UraBlocks.BLOCK_STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.REDSTONE), Blocks.STONE, UraWorldGeneratorConfiguration.redstoneMaxSize, UraWorldGeneratorConfiguration.redstoneChance, UraWorldGeneratorConfiguration.redstoneMinY, UraWorldGeneratorConfiguration.redstoneMaxY, random, chunkX, chunkZ, world);
        addOre(UraBlocks.BLOCK_STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.IRON), Blocks.STONE, UraWorldGeneratorConfiguration.ironMaxSize, UraWorldGeneratorConfiguration.ironChance, UraWorldGeneratorConfiguration.ironMinY, UraWorldGeneratorConfiguration.ironMaxY, random, chunkX, chunkZ, world);
        addOre(UraBlocks.BLOCK_STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GOLD), Blocks.STONE, UraWorldGeneratorConfiguration.goldMaxSize, UraWorldGeneratorConfiguration.goldChance, UraWorldGeneratorConfiguration.goldMinY, UraWorldGeneratorConfiguration.goldMaxY, random, chunkX, chunkZ, world);
        addOre(UraBlocks.BLOCK_STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.LAPIS), Blocks.STONE, UraWorldGeneratorConfiguration.lapisMaxSize, UraWorldGeneratorConfiguration.lapisChance, UraWorldGeneratorConfiguration.lapisMinY, UraWorldGeneratorConfiguration.lapisMaxY, random, chunkX, chunkZ, world);
        if(world.getBiome(new BlockPos(chunkX, 0, chunkZ)).equals(Biomes.EXTREME_HILLS)) {
            addOre(UraBlocks.BLOCK_STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.EMERALD), Blocks.STONE, UraWorldGeneratorConfiguration.emeraldMaxSize, UraWorldGeneratorConfiguration.emeraldChance, UraWorldGeneratorConfiguration.emeraldMinY, UraWorldGeneratorConfiguration.emeraldMaxY, random, chunkX, chunkZ, world);
        }
        addOre(UraBlocks.BLOCK_STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIAMOND), Blocks.STONE, UraWorldGeneratorConfiguration.diamondMaxSize, UraWorldGeneratorConfiguration.diamondChance, UraWorldGeneratorConfiguration.diamondMinY, UraWorldGeneratorConfiguration.diamondMaxY, random, chunkX, chunkZ, world);
        addOre(UraBlocks.BLOCK_STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.SILVER), Blocks.STONE, UraWorldGeneratorConfiguration.silverMaxSize, UraWorldGeneratorConfiguration.silverChance, UraWorldGeneratorConfiguration.silverMinY, UraWorldGeneratorConfiguration.silverMaxY, random, chunkX, chunkZ, world);
        addOre(UraBlocks.BLOCK_STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.COPPER), Blocks.STONE, UraWorldGeneratorConfiguration.copperMaxSize, UraWorldGeneratorConfiguration.copperChance, UraWorldGeneratorConfiguration.copperMinY, UraWorldGeneratorConfiguration.copperMaxY, random, chunkX, chunkZ, world);
        addOre(UraBlocks.BLOCK_STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.TIN), Blocks.STONE, UraWorldGeneratorConfiguration.tinMaxSize, UraWorldGeneratorConfiguration.tinChance, UraWorldGeneratorConfiguration.tinMinY, UraWorldGeneratorConfiguration.tinMaxY, random, chunkX, chunkZ, world);
        addOre(UraBlocks.BLOCK_STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.NEODYMIUM), Blocks.STONE, UraWorldGeneratorConfiguration.neodymiumMaxSize, UraWorldGeneratorConfiguration.neodymiumChance, UraWorldGeneratorConfiguration.neodymiumMinY, UraWorldGeneratorConfiguration.neodymiumMaxY, random, chunkX, chunkZ, world);
        addOre(UraBlocks.BLOCK_STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.RANDOM), Blocks.STONE, UraWorldGeneratorConfiguration.randomMaxSize, UraWorldGeneratorConfiguration.randomChance, UraWorldGeneratorConfiguration.randomMinY, UraWorldGeneratorConfiguration.randomMaxY, random, chunkX, chunkZ, world);
        addOre(UraBlocks.BLOCK_STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.URA), Blocks.STONE, UraWorldGeneratorConfiguration.uraMaxSize, UraWorldGeneratorConfiguration.uraChance, UraWorldGeneratorConfiguration.uraMinY, UraWorldGeneratorConfiguration.uraMaxY, random, chunkX, chunkZ, world);
    }

    private void replace(ExtendedBlockStorage storage, int x, int y, int z) {
        replaceBlock(storage, x, y, z, UraBlocks.BLOCK_STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.BASIC), Blocks.STONE.getDefaultState());
        replaceBlock(storage, x, y, z, UraBlocks.BLOCK_STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.BASIC), Blocks.COAL_ORE.getDefaultState());
        replaceBlock(storage, x, y, z, UraBlocks.BLOCK_STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.BASIC), Blocks.REDSTONE_ORE.getDefaultState());
        replaceBlock(storage, x, y, z, UraBlocks.BLOCK_STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.BASIC), Blocks.IRON_ORE.getDefaultState());
        replaceBlock(storage, x, y, z, UraBlocks.BLOCK_STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.BASIC), Blocks.GOLD_ORE.getDefaultState());
        replaceBlock(storage, x, y, z, UraBlocks.BLOCK_STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.BASIC), Blocks.LAPIS_ORE.getDefaultState());
        replaceBlock(storage, x, y, z, UraBlocks.BLOCK_STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.BASIC), Blocks.EMERALD_ORE .getDefaultState());
        replaceBlock(storage, x, y, z, UraBlocks.BLOCK_STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.BASIC), Blocks.DIAMOND_ORE.getDefaultState());
    }
}