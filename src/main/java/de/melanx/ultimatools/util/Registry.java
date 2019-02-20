package de.melanx.ultimatools.util;

import de.melanx.ultimatools.SkyblockUltimaTools;
import de.melanx.ultimatools.lib.LibMisc;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.*;

public class Registry {
    public static final List<Item> ITEMS_TO_REGISTER = new ArrayList<>();
    public static final Map<ItemStack, ModelResourceLocation> MODEL_LOCATIONS = new HashMap<>();

    public static void registerItem(Item item, String name) {
        item.setUnlocalizedName(name);
        item.setRegistryName(LibMisc.MODID, name);
        item.setCreativeTab(SkyblockUltimaTools.creativeTab);

        ITEMS_TO_REGISTER.add(item);
    }

    public static void registerModel(Object item) {
        if(item instanceof Item) {
            MODEL_LOCATIONS.put(new ItemStack((Item)item), new ModelResourceLocation(Objects.requireNonNull(((Item)item).getRegistryName()), "inventory"));
        } else {
            throw new IllegalArgumentException("item should be of type Item");
        }
    }
}
