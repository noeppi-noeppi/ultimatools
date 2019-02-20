package de.melanx.ultimatools.items.crystals;

import de.melanx.ultimatools.util.ToolUtil;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;

public class CrystalBlack extends CrystalBase {

    public CrystalBlack() {
        super("cursed_knight");
    }

    public static final int HEARTS = 30;
    public static final int DAMAGE = HEARTS * 2;

    @Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase living, EnumHand hand) {
        if(living.isEntityAlive() && !player.getCooldownTracker().hasCooldown(this)) {
            living.attackEntityFrom(DamageSource.MAGIC, DAMAGE);
            player.getCooldownTracker().setCooldown(this, ToolUtil.COOLDOWN);
            return true;
        }
        return false;
    }

}
