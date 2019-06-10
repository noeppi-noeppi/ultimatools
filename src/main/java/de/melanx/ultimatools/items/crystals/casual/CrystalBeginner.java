package de.melanx.ultimatools.items.crystals.casual;

import de.melanx.ultimatools.items.crystals.CrystalBase;
import de.melanx.ultimatools.util.ToolUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class CrystalBeginner extends CrystalBase {

    public CrystalBeginner() {
        super("beginner");
    }

    @Nonnull
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side, float par8, float par9, float par10) {
        ItemStack stack = player.getHeldItem(hand);
        if (!world.provider.doesWaterVaporize()) {
            // Adapted from bucket code
            RayTraceResult mop = rayTrace(world, player, false);

            if (mop != null && mop.typeOfHit == RayTraceResult.Type.BLOCK) {
                BlockPos hitPos = mop.getBlockPos();
                if(!world.isBlockModifiable(player, hitPos))
                    return EnumActionResult.FAIL;
                BlockPos placePos = hitPos.offset(mop.sideHit);
                if(player.canPlayerEdit(placePos, mop.sideHit, stack)) {
                    if (((ItemBucket) Items.WATER_BUCKET).tryPlaceContainedLiquid(player, world, placePos)) {
                        if(!player.isCreative())
                            player.getCooldownTracker().setCooldown(this, ToolUtil.COOLDOWN);
                        return EnumActionResult.SUCCESS;
                    }
                }

            }
            return EnumActionResult.FAIL;
        }

        return EnumActionResult.PASS;
    }

}
