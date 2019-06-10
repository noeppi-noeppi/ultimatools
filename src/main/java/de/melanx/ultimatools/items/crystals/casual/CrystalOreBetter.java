package de.melanx.ultimatools.items.crystals.casual;

import de.melanx.ultimatools.items.crystals.CrystalBase;
import de.melanx.ultimatools.util.ChangeBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CrystalOreBetter extends CrystalBase {

    public CrystalOreBetter() {
        super("ore_better");
    }

    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return ChangeBlocks.upgradeOre(player, worldIn, pos, hand);
    }

}
