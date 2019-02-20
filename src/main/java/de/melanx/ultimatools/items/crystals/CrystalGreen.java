package de.melanx.ultimatools.items.crystals;

import de.melanx.ultimatools.util.ToolUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CrystalGreen extends CrystalBase {

    public CrystalGreen() {
        super("farmer");
    }

    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack itemstack = player.getHeldItem(hand);

        if (!player.canPlayerEdit(pos.offset(facing), facing, itemstack)) {
            return EnumActionResult.FAIL;
        } else {
            if (ItemDye.applyBonemeal(itemstack, worldIn, pos, player, hand)) {
                if (!worldIn.isRemote) {
                    worldIn.playEvent(2005, pos, 0);
                }
                player.getCooldownTracker().setCooldown(this, ToolUtil.COOLDOWN);
            return EnumActionResult.SUCCESS;
            }
        }
        return EnumActionResult.PASS;
    }

}
