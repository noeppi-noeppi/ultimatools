package de.melanx.ultimatools;

import de.melanx.ultimatools.client.ultimatoolsTab;
import de.melanx.ultimatools.items.ModItems;
import de.melanx.ultimatools.lib.LibMisc;
import de.melanx.ultimatools.proxy.CommonProxy;
import de.melanx.ultimatools.util.Registry;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;

import java.util.Map;

@Mod(modid = LibMisc.MODID, name = LibMisc.NAME, version = LibMisc.VERSION)
public class SkyblockUltimaTools {

    public static final ultimatoolsTab creativeTab = new ultimatoolsTab();
    public static Logger logger;

    @SidedProxy(clientSide = LibMisc.PROXY_CLIENT, serverSide = LibMisc.PROXY_SERVER)
    public static CommonProxy PROXY;

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModItems.init();

            for(Item item : Registry.ITEMS_TO_REGISTER) {
                event.getRegistry().register(item);
                System.out.println(item.getRegistryName());
            }
        }

        @SubscribeEvent
        public static  void registerModels(ModelRegistryEvent event) {
                for(Map.Entry<ItemStack, ModelResourceLocation> entry : Registry.MODEL_LOCATIONS.entrySet()) {
                    ModelLoader.setCustomModelResourceLocation(entry.getKey().getItem(), entry.getKey().getItemDamage(), entry.getValue());
                }
        }

    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println(LibMisc.MODID + " is loading");
        logger = event.getModLog();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        System.out.println(LibMisc.MODID + " is finished.");
    }

}
