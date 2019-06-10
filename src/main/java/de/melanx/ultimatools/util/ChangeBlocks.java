package de.melanx.ultimatools.util;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockNewLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

import static de.melanx.ultimatools.util.ToolUtil.*;

public class ChangeBlocks {

    public static IBlockState LOG_OAK = Blocks.LOG.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.OAK);
    public static IBlockState LOG_ACACIA = Blocks.LOG.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.ACACIA);
    public static IBlockState LOG_JUNGLE = Blocks.LOG.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.JUNGLE);
    public static IBlockState LOG_BIRCH = Blocks.LOG.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.BIRCH);


    public static EnumActionResult generateOre(EntityPlayer player, World world, BlockPos pos, EnumHand hand) {
        Block block = world.getBlockState(pos).getBlock();
        if(block == Blocks.COBBLESTONE || block == Blocks.STONE) {
            Random rand = new Random();
            int x = rand.nextInt(99);
            if(x <= 49) {
                Block block1 = Blocks.IRON_ORE;
                return changeBlock(player, world, pos, block1, hand);
            } else if(x <= 74) {
                Block block1 = Blocks.GOLD_ORE;
                return changeBlock(player, world, pos, block1, hand);
            } else if(x <= 79) {
                Block block1 = Blocks.DIAMOND_ORE;
                return changeBlock(player, world, pos, block1, hand);
            } else if(x <= 89) {
                Block block1 = Blocks.REDSTONE_ORE;
                return changeBlock(player, world, pos, block1, hand);
            } else if(x <= 98) {
                Block block1 = Blocks.LAPIS_ORE;
                return changeBlock(player, world, pos, block1, hand);
            } else {
                Block block1 = Blocks.EMERALD_ORE;
                return changeBlock(player, world, pos, block1, hand);
            }
        }
        return EnumActionResult.SUCCESS;
    }

    public static EnumActionResult upgradeOre(EntityPlayer player, World world, BlockPos pos, EnumHand hand) {
        Block block = world.getBlockState(pos).getBlock();

        if(block == Blocks.IRON_ORE) {
            Block block1 = Blocks.GOLD_ORE;
            return changeBlock(player, world, pos, block1, hand);
        }
        if(block == Blocks.GOLD_ORE) {
            Block block1 = Blocks.REDSTONE_ORE;
            return changeBlock(player, world, pos, block1, hand);
        }
        if(block == Blocks.REDSTONE_ORE || block == Blocks.LIT_REDSTONE_ORE) {
            Block block1 = Blocks.LAPIS_ORE;
            return changeBlock(player, world, pos, block1, hand);
        }
        if(block == Blocks.LAPIS_ORE) {
            Block block1 = Blocks.DIAMOND_ORE;
            return changeBlock(player, world, pos, block1, hand);
        }
        if(block == Blocks.DIAMOND_ORE) {
            Block block1 = Blocks.EMERALD_ORE;
            return changeBlock(player, world, pos, block1, hand);
        }
        return EnumActionResult.PASS;
    }

    public static EnumActionResult grassToStone(EntityPlayer player, World world, BlockPos pos, EnumHand hand) {
        Block block = world.getBlockState(pos).getBlock();
        if(block == Blocks.GRASS) {
            Block block1 = Blocks.STONE;
            return changeBlock(player, world, pos, block1, hand);
        }
        return EnumActionResult.SUCCESS;
    }

    public static EnumActionResult dirtToFarmland(EntityPlayer player, World world, BlockPos pos, EnumHand hand) {
        Block block = world.getBlockState(pos).getBlock();
        if(block == Blocks.DIRT) {
            Block block1 = Blocks.FARMLAND;
            return changeBlock(player, world, pos, block1, hand);
        }
        return EnumActionResult.SUCCESS;
    }

    public static EnumActionResult dirtToGrass(EntityPlayer player, World world, BlockPos pos, EnumHand hand) {
        Block block = world.getBlockState(pos).getBlock();
        if(block == Blocks.DIRT) {
            Block block1 = Blocks.GRASS;
            return changeBlock(player, world, pos, block1, hand);
        }
        return EnumActionResult.SUCCESS;
    }

    public static EnumActionResult stoneToCoalore(EntityPlayer player, World world, BlockPos pos, EnumHand hand) {
        Block block = world.getBlockState(pos).getBlock();

        if(block == Blocks.STONE) {
            Block block1 = Blocks.COAL_ORE;
            return changeBlockMoreCooldown(player, world, pos, block1, hand);
        }
        return EnumActionResult.SUCCESS;
    }

    public static EnumActionResult oakToAcacia(EntityPlayer player, World world, BlockPos pos, EnumHand hand) {
        Block block = world.getBlockState(pos).getBlock();
        IBlockState state = block.getDefaultState();

        if(block == LOG_OAK) { // oak
            System.out.println("I bims activated!");
//            Block block1 = LOG_ACACIA; // acacia
//            return changeBlock(player, world, pos, block1, hand);
        }
        return EnumActionResult.SUCCESS;
    }
}
