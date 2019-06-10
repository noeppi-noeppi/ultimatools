package de.melanx.ultimatools.items.crystals.krypto;

import de.melanx.ultimatools.items.crystals.CrystalBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class KryptoCursedKnight extends CrystalBase {

    public KryptoCursedKnight() {
        super("krypto_cursed_knight");
    }

    final Potion potion = Potion.getPotionFromResourceLocation("levitation");

    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        player.addPotionEffect(new PotionEffect(potion, 200, 10));
        if(!player.isCreative())
            player.getCooldownTracker().setCooldown(this, 1200);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }

}
