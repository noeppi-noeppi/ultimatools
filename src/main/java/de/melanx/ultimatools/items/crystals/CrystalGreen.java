package de.melanx.ultimatools.items.crystals;

import de.melanx.ultimatools.util.ToolUtil;
import net.minecraft.entity.player.EntityPlayer;
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
        return ToolUtil.useBetterBonemeal(player, worldIn, pos, hand, facing);
    }

}
