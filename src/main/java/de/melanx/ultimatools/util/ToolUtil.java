package de.melanx.ultimatools.util;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.event.ForgeEventFactory;

import javax.annotation.Nullable;

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
        if(!player.isCreative())
            player.getCooldownTracker().setCooldown(itemStack.getItem(), COOLDOWN);
        return EnumActionResult.SUCCESS;
    }

    public static EnumActionResult changeBlockMoreCooldown(EntityPlayer player, World world, BlockPos pos, Block block1, EnumHand hand) {

        SoundType soundtype = block1.getSoundType(block1.getDefaultState(), world, pos, player);

        world.playSound(null, pos, soundtype.getStepSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);

        if(!world.isRemote) {
            world.setBlockState(pos, block1.getDefaultState());
        }
        ItemStack itemStack = player.getHeldItem(hand);
        if(!player.isCreative())
            player.getCooldownTracker().setCooldown(itemStack.getItem(), COOLDOWN * 2);
        return EnumActionResult.SUCCESS;
    }

    // stolen from Minecraft but without consuming
    public static boolean applyBonemeal(ItemStack itemStack, World world, BlockPos pos) {
        return world instanceof WorldServer ? applyBonemeal(itemStack, world, pos, FakePlayerFactory.getMinecraft((WorldServer)world), (EnumHand)null) : false;
    }

    public static boolean applyBonemeal(ItemStack itemStack, World world, BlockPos pos, EntityPlayer player, @Nullable EnumHand hand) {
        IBlockState iblockstate = world.getBlockState(pos);
        int hook = ForgeEventFactory.onApplyBonemeal(player, world, pos, iblockstate, itemStack, hand);
        if (hook != 0) {
            return hook > 0;
        } else {
            if (iblockstate.getBlock() instanceof IGrowable) {
                IGrowable igrowable = (IGrowable)iblockstate.getBlock();
                if (igrowable.canGrow(world, pos, iblockstate, world.isRemote)) {
                    if (!world.isRemote) {
                        if (igrowable.canUseBonemeal(world, world.rand, pos, iblockstate)) {
                            igrowable.grow(world, world.rand, pos, iblockstate);
                        }

                        // itemStack.shrink(1);
                    }

                    return true;
                }
            }

            return false;
        }
    }

    public static EnumActionResult useBetterBonemeal(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side) {
        ItemStack itemStack = player.getHeldItem(hand);

        if (!player.canPlayerEdit(pos.offset(side), side, itemStack)) {
            return EnumActionResult.FAIL;
        } else {
                if (applyBonemeal(itemStack, world, pos, player, hand)) {
                    if (!world.isRemote) {
                        world.playEvent(2005, pos, 0);
                    }
                    if(!player.isCreative())
                        player.getCooldownTracker().setCooldown(itemStack.getItem(), COOLDOWN);
                    return EnumActionResult.SUCCESS;
                }
            }
        return EnumActionResult.PASS;
    }

}
