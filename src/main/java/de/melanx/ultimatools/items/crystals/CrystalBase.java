package de.melanx.ultimatools.items.crystals;

import de.melanx.ultimatools.SkyblockUltimaTools;
import de.melanx.ultimatools.util.Registry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CrystalBase extends Item {

    protected String name;

    public CrystalBase(String name) {
        this.name = name;
        Registry.registerItem(this, name);
        Registry.registerModel(this);
        setCreativeTab(SkyblockUltimaTools.creativeTab);
        setMaxStackSize(1);
    }

    public void registerItemModel() {
        SkyblockUltimaTools.PROXY.registerItemRenderer(this, 0, name);
    }

    @Override
    public CrystalBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

}
