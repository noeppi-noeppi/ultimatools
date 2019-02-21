package de.melanx.ultimatools.util;

import de.melanx.ultimatools.blocks.TileEntity.ContainerWoodGenerator;
import de.melanx.ultimatools.blocks.TileEntity.GuiWoodGenerator;
import de.melanx.ultimatools.blocks.TileEntity.TileEntityWoodGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGuiHandler implements IGuiHandler {

    public static final int WOODGENERATOR = 0;

    @Override
    public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case WOODGENERATOR:
                return new ContainerWoodGenerator(player.inventory, (TileEntityWoodGenerator)world.getTileEntity(new BlockPos(x, y, z)));
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case WOODGENERATOR:
                return new GuiWoodGenerator(getServerGuiElement(ID, player, world, x, y, z), player.inventory);
            default:
                return null;
        }
    }

}
