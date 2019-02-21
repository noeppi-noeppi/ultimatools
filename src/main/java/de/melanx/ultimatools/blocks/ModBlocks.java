package de.melanx.ultimatools.blocks;

import de.melanx.ultimatools.blocks.TileEntity.BlockWoodGenerator;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {

    public static BlockWoodGenerator woodGenerator = new BlockWoodGenerator();

    public static void register(IForgeRegistry<Block> registry) {

        registry.registerAll(
                woodGenerator
        );

        GameRegistry.registerTileEntity(woodGenerator.getTileEntityClass(), woodGenerator.getRegistryName().toString());

    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {

        registry.registerAll(
                woodGenerator.createItemBlock()
        );

    }

    public static void registerModels() {

        woodGenerator.registerItemModel(Item.getItemFromBlock(woodGenerator));

    }

}
