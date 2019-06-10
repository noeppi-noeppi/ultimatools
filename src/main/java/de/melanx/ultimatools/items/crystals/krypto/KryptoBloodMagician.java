package de.melanx.ultimatools.items.crystals.krypto;

import de.melanx.ultimatools.items.crystals.CrystalBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class KryptoBloodMagician extends CrystalBase {

    public KryptoBloodMagician() {
        super("krypto_blood_magician");
    }

    final Potion potion = Potion.getPotionFromResourceLocation("regeneration");

    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        player.addPotionEffect(new PotionEffect(potion, 100, 1));
        if(!player.isCreative())
            player.getCooldownTracker().setCooldown(this, 600);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }

}
