package de.melanx.ultimatools.items.crystals;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class CrystalPink extends CrystalBase {

    public CrystalPink() {
        super("blood_magician");
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote) {
            Block block = worldIn.getBlockState(pos).getBlock();
            if(block == Blocks.GRASS || block == Blocks.DIRT) {
                Random rand = new Random();
                int x = rand.nextInt(10);
                if(x == 0) {
                    EntityCow entityCow = new EntityCow(worldIn);
                    entityCow.setGrowingAge(-24000);
                    entityCow.setLocationAndAngles(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 0, 0);
                    worldIn.spawnEntity(entityCow);
                } else if(x == 1) {
                    EntityChicken entityChicken = new EntityChicken(worldIn);
                    entityChicken.setGrowingAge(-24000);
                    entityChicken.setLocationAndAngles(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 0, 0);
                    worldIn.spawnEntity(entityChicken);
                } else if(x == 2) {
                    EntityDonkey entityDonkey = new EntityDonkey(worldIn);
                    entityDonkey.setGrowingAge(-24000);
                    entityDonkey.setLocationAndAngles(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 0, 0);
                    worldIn.spawnEntity(entityDonkey);
                } else if(x == 3) {
                    EntityHorse entityHorse = new EntityHorse(worldIn);
                    entityHorse.setGrowingAge(-24000);
                    entityHorse.setLocationAndAngles(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 0, 0);
                    worldIn.spawnEntity(entityHorse);
                } else if(x == 4) {
                    EntityMule entityMule = new EntityMule(worldIn);
                    entityMule.setGrowingAge(-24000);
                    entityMule.setLocationAndAngles(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 0, 0);
                    worldIn.spawnEntity(entityMule);
                } else if(x == 5) {
                    EntityOcelot entityOcelot = new EntityOcelot(worldIn);
                    entityOcelot.setGrowingAge(-24000);
                    entityOcelot.setLocationAndAngles(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 0, 0);
                    worldIn.spawnEntity(entityOcelot);
                } else if(x == 6) {
                    EntityParrot entityParrot = new EntityParrot(worldIn);
                    entityParrot.setGrowingAge(-24000);
                    entityParrot.setLocationAndAngles(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 0, 0);
                    worldIn.spawnEntity(entityParrot);
                } else if(x == 7) {
                    EntityParrot entityParrot = new EntityParrot(worldIn);
                    entityParrot.setGrowingAge(-24000);
                    entityParrot.setLocationAndAngles(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 0, 0);
                    worldIn.spawnEntity(entityParrot);
                } else if(x == 8) {
                    EntityPig entityPig = new EntityPig(worldIn);
                    entityPig.setGrowingAge(-24000);
                    entityPig.setLocationAndAngles(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 0, 0);
                    worldIn.spawnEntity(entityPig);
                } else if(x == 9) {
                    EntityRabbit entityRabbit = new EntityRabbit(worldIn);
                    entityRabbit.setGrowingAge(-24000);
                    entityRabbit.setLocationAndAngles(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 0, 0);
                    worldIn.spawnEntity(entityRabbit);
                } else if(x == 10) {
                    EntitySheep entitySheep = new EntitySheep(worldIn);
                    entitySheep.setGrowingAge(-24000);
                    entitySheep.setLocationAndAngles(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 0, 0);
                    worldIn.spawnEntity(entitySheep);
                }
                playerIn.getCooldownTracker().setCooldown(this, 6000);
                return EnumActionResult.SUCCESS;
            }
        }
        return EnumActionResult.SUCCESS;
    }

}
