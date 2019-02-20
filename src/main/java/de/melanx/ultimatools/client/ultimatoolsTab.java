package de.melanx.ultimatools.client;

import de.melanx.ultimatools.items.ModItems;
import de.melanx.ultimatools.lib.LibMisc;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ultimatoolsTab extends CreativeTabs {

    public ultimatoolsTab() {
        super(LibMisc.MODID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.crystalCyan);
    }

}
