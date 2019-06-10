package de.melanx.ultimatools.items.crystals.krypto;

import de.melanx.ultimatools.items.crystals.CrystalBase;
import de.melanx.ultimatools.util.ChangeBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class KryptoFarmer extends CrystalBase {

    public KryptoFarmer() {
        super("krypto_farmer");
    }

    @Nonnull
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, @Nonnull World world, BlockPos pos, @Nonnull EnumHand hand, @Nonnull EnumFacing side, float hitX, float hitY, float hitZ) {
        return ChangeBlocks.dirtToFarmland(player, world, pos, hand);
    }

}
