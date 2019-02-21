package de.melanx.ultimatools;

import de.melanx.ultimatools.blocks.ModBlocks;
import de.melanx.ultimatools.client.ultimatoolsTab;
import de.melanx.ultimatools.items.ModItems;
import de.melanx.ultimatools.lib.LibMisc;
import de.melanx.ultimatools.proxy.CommonProxy;
import de.melanx.ultimatools.util.ModGuiHandler;
import de.melanx.ultimatools.util.Registry;
import net.minecraft.block.Block;
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
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

@Mod(modid = LibMisc.MODID, name = LibMisc.NAME, version = LibMisc.VERSION)
public class SkyblockUltimaTools {

    public static final ultimatoolsTab creativeTab = new ultimatoolsTab();
    public static Logger logger = LogManager.getFormatterLogger(LibMisc.MODID);

    @Mod.Instance(LibMisc.MODID)
    public static SkyblockUltimaTools instance;

    @SidedProxy(clientSide = LibMisc.PROXY_CLIENT, serverSide = LibMisc.PROXY_SERVER)
    public static CommonProxy PROXY;

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            ModBlocks.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModItems.init();
            ModBlocks.registerItemBlocks(event.getRegistry());

            for(Item item : Registry.ITEMS_TO_REGISTER) {
                event.getRegistry().register(item);
            }
        }

        @SubscribeEvent
        public static  void registerModels(ModelRegistryEvent event) {
                for(Map.Entry<ItemStack, ModelResourceLocation> entry : Registry.MODEL_LOCATIONS.entrySet()) {
                    ModelLoader.setCustomModelResourceLocation(entry.getKey().getItem(), entry.getKey().getItemDamage(), entry.getValue());
                }
            ModBlocks.registerModels();
        }

    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info(LibMisc.MODID + " is loading");
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new ModGuiHandler());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        logger.info(LibMisc.MODID + " finished loading.");
    }

}
