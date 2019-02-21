package de.melanx.ultimatools.items.crystals;

import de.melanx.ultimatools.util.ToolUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CrystalGray extends CrystalBase {

    public CrystalGray() {
        super("ore_better");
    }

    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return ToolUtil.upgradeOre(player, worldIn, pos, hand);
    }

}
