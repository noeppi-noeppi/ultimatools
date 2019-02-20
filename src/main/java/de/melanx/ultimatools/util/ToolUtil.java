package de.melanx.ultimatools.util;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class ToolUtil {

    public static final int SECONDS = 5;
    public static final int COOLDOWN = SECONDS * 20;

    public static EnumActionResult changeBlock(EntityPlayer player, World world, BlockPos pos, Block block1, EnumHand hand) {

        SoundType soundtype = block1.getSoundType(block1.getDefaultState(), world, pos, player);

        world.playSound(null, pos, soundtype.getStepSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);

        if(!world.isRemote) {
            world.setBlockState(pos, block1.getDefaultState());
        }
        ItemStack itemStack = player.getHeldItem(hand);
        player.getCooldownTracker().setCooldown(itemStack.getItem(), COOLDOWN);
        return EnumActionResult.SUCCESS;
    }

    public static EnumActionResult replace(EntityPlayer player, World world, BlockPos pos, EnumHand hand) {
        Block block = world.getBlockState(pos).getBlock();
        if(block == Blocks.DIRT) {
            Block block1 = Blocks.GRASS;
            return changeBlock(player, world, pos, block1, hand);
        }
        return EnumActionResult.SUCCESS;
    }

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

}
