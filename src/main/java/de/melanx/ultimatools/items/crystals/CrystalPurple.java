package de.melanx.ultimatools.items.crystals;

import de.melanx.ultimatools.util.ToolUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;

import java.util.Random;

public class CrystalPurple extends CrystalBase {

    public CrystalPurple() {
        super("soothsayer");
    }

    public static final int SECONDS = 30;
    public static final int HEARTS = 5;

    public static final int DAMAGE = HEARTS * 2;
    public static final int DURATION = SECONDS * 20;

    @Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase living, EnumHand hand) {
        if(living.isEntityAlive() && !player.getCooldownTracker().hasCooldown(this)) {
            Random rand = new Random();
            int x = rand.nextInt(4);
            if(x==0)
                living.attackEntityFrom(DamageSource.MAGIC, DAMAGE);
            else if(x==1)
                living.addPotionEffect(new PotionEffect(MobEffects.POISON, DURATION));
            else if(x==2)
                living.addPotionEffect(new PotionEffect(MobEffects.WITHER, DURATION));
            else if(x==3)
                living.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, DURATION));
            else if(x==4)
                living.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, DURATION, 4));
            player.getCooldownTracker().setCooldown(this, ToolUtil.COOLDOWN);
            return true;
        }
        return false;
    }

}
