package de.melanx.ultimatools.blocks.TileEntity;

import de.melanx.ultimatools.SkyblockUltimaTools;
import de.melanx.ultimatools.util.ModGuiHandler;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;

public class BlockWoodGenerator extends BlockTileEntity<TileEntityWoodGenerator> {

    public BlockWoodGenerator() {
        super(Material.ROCK, "woodgenerator");
    }

    @Override
    @Deprecated
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }


    @Override
    public Class<TileEntityWoodGenerator> getTileEntityClass() {
        return TileEntityWoodGenerator.class;
    }

    @Nullable
    @Override
    public TileEntityWoodGenerator createTileEntity(World world, IBlockState state) {
        return new TileEntityWoodGenerator();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileEntityWoodGenerator tile = getTileEntity(world, pos);
            if (player.isSneaking()) {
                tile.markDirty();
            } else {
                player.openGui(SkyblockUltimaTools.instance, ModGuiHandler.WOODGENERATOR, world, pos.getX(), pos.getY(), pos.getZ());
            }
        }
        return true;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntityWoodGenerator tile = getTileEntity(world, pos);
        IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        ItemStack stack = itemHandler.getStackInSlot(0);
        if (!stack.isEmpty()) {
            EntityItem item = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
            world.spawnEntity(item);
        }
        super.breakBlock(world, pos, state);
    }

}
