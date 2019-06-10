package de.melanx.ultimatools.items.crystals.krypto;

import de.melanx.ultimatools.items.crystals.CrystalBase;
import de.melanx.ultimatools.util.ToolUtil;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.IFluidBlock;

import javax.annotation.Nonnull;

public class KryptoBeginner extends CrystalBase {

    public KryptoBeginner() {
        super("krypto_beginner");
    }

    // thanks to Botanias Open Bucket (https://github.com/Vazkii/Botania/blob/master/src/main/java/vazkii/botania/common/item/ItemOpenBucket.java)
    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand) {
        RayTraceResult rtr = rayTrace(world, player, true);
        ItemStack stack = player.getHeldItem(hand);

        if(rtr == null)
            return ActionResult.newResult(EnumActionResult.PASS, stack);
        else {
            if(rtr.typeOfHit == net.minecraft.util.math.RayTraceResult.Type.BLOCK) {
                BlockPos pos = rtr.getBlockPos();

                if(!world.isBlockModifiable(player, pos))
                    return ActionResult.newResult(EnumActionResult.PASS, stack);

                if(!player.canPlayerEdit(pos, rtr.sideHit, stack))
                    return ActionResult.newResult(EnumActionResult.PASS, stack);

                IBlockState state = world.getBlockState(pos);
                Fluid fluid = FluidRegistry.lookupFluidForBlock(state.getBlock());
                boolean isFull = state.getBlock() instanceof BlockLiquid && state.getValue(BlockLiquid.LEVEL) == 0
                        || state.getBlock() instanceof IFluidBlock && Math.abs(((IFluidBlock) state.getBlock()).getFilledPercentage(world, pos)) >= 1;

                if(fluid != null && isFull) {
                    player.playSound(fluid.getFillSound(world, pos), 1.0f, 1.0f);
                    world.setBlockToAir(pos);

                    for(int x = 0; x < 5; x++)
                        world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, pos.getX() + Math.random(), pos.getY() + Math.random(), pos.getZ() + Math.random(), 0, 0, 0);
                    if(!player.isCreative())
                        player.getCooldownTracker().setCooldown(this, ToolUtil.COOLDOWN);
                    return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
                }
            }

            return ActionResult.newResult(EnumActionResult.PASS, stack);
        }
    }

}
