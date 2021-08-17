package fr.uracraft.uramod.events;

import fr.uracraft.uramod.blocks.BlockStone;
import fr.uracraft.uramod.blocks.UraBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

public class EventStone {

    List<String> oreList = new ArrayList<String>() {
        {
            add("coal");
            add("redstone");
            add("iron");
            add("gold");
            add("lapis");
            add("emerald");
            add("diamond");
            add("silver");
            add("copper");
            add("tin");
            add("neodymium");
            add("random");
            add("ura");
        }
    };

    @SubscribeEvent
    public void blockBreak(BlockEvent.BreakEvent event) {
        changeBlock(event.getPos(), event.getWorld());
    }

    public void changeBlock(BlockPos pos, World world) {
        for (int i = 0; i < 6; i++) {
            for (String s : oreList) {
                BlockPos orePos = getBlockFromPos(pos, i);
                if (world.getBlockState(orePos) == UraBlocks.BLOCK_STONE.getDefaultState().withProperty(BlockStone.VARIANT, getValueFromName(s))) {
                    world.setBlockState(orePos, getBlockFromName(s));
                }
            }
        }
    }

    public static BlockPos getBlockFromPos(BlockPos pos, int i) {
        switch (i) {
            case 0:
                return new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ());
            case 1:
                return new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
            case 2:
                return new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1);
            case 3:
                return new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ());
            case 4:
                return new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
            case 5:
                return new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1);
        }
        return pos;
    }

    public static IBlockState getBlockFromName(String name) {
        switch (name) {
            case "coal":
                return Blocks.COAL_ORE.getDefaultState();
            case "redstone":
                return Blocks.REDSTONE_ORE.getDefaultState();
            case "iron":
                return Blocks.IRON_ORE.getDefaultState();
            case "gold":
                return Blocks.GOLD_ORE.getDefaultState();
            case "lapis":
                return Blocks.LAPIS_ORE.getDefaultState();
            case "emerald":
                return Blocks.EMERALD_ORE.getDefaultState();
            case "diamond":
                return Blocks.DIAMOND_ORE.getDefaultState();
            case "silver":
                return UraBlocks.SILVER_ORE.getDefaultState();
            case "copper":
                return UraBlocks.COPPER_ORE.getDefaultState();
            case "tin":
                return UraBlocks.TIN_ORE.getDefaultState();
            case "neodymium":
                return UraBlocks.NEODYMIUM_ORE.getDefaultState();
            case "random":
                return UraBlocks.RANDOM_ORE.getDefaultState();
            case "ura":
                return UraBlocks.URA_ORE.getDefaultState();
        }
        return UraBlocks.BLOCK_STONE.getDefaultState();
    }

    public static BlockStone.EnumType getValueFromName(String name) {
        switch (name) {
            case "coal":
                return BlockStone.EnumType.COAL;
            case "redstone":
                return BlockStone.EnumType.REDSTONE;
            case "iron":
                return BlockStone.EnumType.IRON;
            case "gold":
                return BlockStone.EnumType.GOLD;
            case "lapis":
                return BlockStone.EnumType.LAPIS;
            case "emerald":
                return BlockStone.EnumType.EMERALD;
            case "diamond":
                return BlockStone.EnumType.DIAMOND;
            case "silver":
                return BlockStone.EnumType.SILVER;
            case "copper":
                return BlockStone.EnumType.COPPER;
            case "tin":
                return BlockStone.EnumType.TIN;
            case "neodymium":
                return BlockStone.EnumType.NEODYMIUM;
            case "random":
                return BlockStone.EnumType.RANDOM;
            case "ura":
                return BlockStone.EnumType.URA;
        }
        return BlockStone.EnumType.BASIC;
    }
}
