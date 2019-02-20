package de.melanx.ultimatools.items.crystals;

import de.melanx.ultimatools.util.ToolUtil;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Random;

public class CrystalGay extends CrystalBase {

    public CrystalGay() {
        super("ultima_god");
    }

    @Nonnull
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        ItemStack stack = player.getHeldItem(hand);
        Block block = world.getBlockState(pos).getBlock();

        // cyan crystal
        if(block != Blocks.DIRT && block != Blocks.GRASS) {
            if(player.isSneaking()) {
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


        // lime crystal
        else if(!player.isSneaking()) {
            if(block == Blocks.DIRT) {
                return ToolUtil.replace(player, world, pos, hand);
            } else {
                // green crystal
                if (!player.canPlayerEdit(pos.offset(side), side, stack)) {
                    return EnumActionResult.FAIL;
                } else if (block != Blocks.STONE && block != Blocks.COBBLESTONE) {
                    if (ItemDye.applyBonemeal(stack, world, pos, player, hand)) {
                        if (!world.isRemote) {
                            world.playEvent(2005, pos, 0);
                        }
                        player.getCooldownTracker().setCooldown(this, ToolUtil.COOLDOWN);
                        return EnumActionResult.SUCCESS;
                    }
                }
            }
        }

        // pink crystal
        else if(!world.isRemote) {
            if(player.isSneaking()) {
                if(block == Blocks.GRASS || block == Blocks.DIRT) {
                    Random rand = new Random();
                    int x = rand.nextInt(10);
                    if(x == 0) {
                        EntityCow entityCow = new EntityCow(world);
                        entityCow.setGrowingAge(-24000);
                        entityCow.setLocationAndAngles(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 0, 0);
                        world.spawnEntity(entityCow);
                    } else if(x == 1) {
                        EntityChicken entityChicken = new EntityChicken(world);
                        entityChicken.setGrowingAge(-24000);
                        entityChicken.setLocationAndAngles(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 0, 0);
                        world.spawnEntity(entityChicken);
                    } else if(x == 2) {
                        EntityDonkey entityDonkey = new EntityDonkey(world);
                        entityDonkey.setGrowingAge(-24000);
                        entityDonkey.setLocationAndAngles(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 0, 0);
                        world.spawnEntity(entityDonkey);
                    } else if(x == 3) {
                        EntityHorse entityHorse = new EntityHorse(world);
                        entityHorse.setGrowingAge(-24000);
                        entityHorse.setLocationAndAngles(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 0, 0);
                        world.spawnEntity(entityHorse);
                    } else if(x == 4) {
                        EntityMule entityMule = new EntityMule(world);
                        entityMule.setGrowingAge(-24000);
                        entityMule.setLocationAndAngles(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 0, 0);
                        world.spawnEntity(entityMule);
                    } else if(x == 5) {
                        EntityOcelot entityOcelot = new EntityOcelot(world);
                        entityOcelot.setGrowingAge(-24000);
                        entityOcelot.setLocationAndAngles(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 0, 0);
                        world.spawnEntity(entityOcelot);
                    } else if(x == 6) {
                        EntityParrot entityParrot = new EntityParrot(world);
                        entityParrot.setGrowingAge(-24000);
                        entityParrot.setLocationAndAngles(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 0, 0);
                        world.spawnEntity(entityParrot);
                    } else if(x == 7) {
                        EntityParrot entityParrot = new EntityParrot(world);
                        entityParrot.setGrowingAge(-24000);
                        entityParrot.setLocationAndAngles(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 0, 0);
                        world.spawnEntity(entityParrot);
                    } else if(x == 8) {
                        EntityPig entityPig = new EntityPig(world);
                        entityPig.setGrowingAge(-24000);
                        entityPig.setLocationAndAngles(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 0, 0);
                        world.spawnEntity(entityPig);
                    } else if(x == 9) {
                        EntityRabbit entityRabbit = new EntityRabbit(world);
                        entityRabbit.setGrowingAge(-24000);
                        entityRabbit.setLocationAndAngles(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 0, 0);
                        world.spawnEntity(entityRabbit);
                    } else if(x == 10) {
                        EntitySheep entitySheep = new EntitySheep(world);
                        entitySheep.setGrowingAge(-24000);
                        entitySheep.setLocationAndAngles(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 0, 0);
                        world.spawnEntity(entitySheep);
                    }
                    player.getCooldownTracker().setCooldown(this, 1200);
                    return EnumActionResult.SUCCESS;
                }
            }

        }

        // rainbow crystal
        if((block == Blocks.COBBLESTONE || block == Blocks.STONE) && !player.isSneaking()) {
            return ToolUtil.generateOre(player, world, pos, hand);
        }
        return EnumActionResult.SUCCESS;
    }

    // purple crystal
    public static final int SECONDS = 30;
    public static final int HEARTS = 30;

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