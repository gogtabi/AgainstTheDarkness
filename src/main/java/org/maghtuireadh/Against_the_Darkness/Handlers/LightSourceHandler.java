package org.maghtuireadh.Against_the_Darkness.Handlers;

import java.util.ArrayList;
import java.util.List;

import org.maghtuireadh.Against_the_Darkness.Config.ConfigHandler;
import org.maghtuireadh.Against_the_Darkness.Utils.Utils;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class LightSourceHandler {

	public static List<Item> lightSources = new ArrayList<Item>();

	public static void registerLightSources() {
		int lightSourceBlocks = 0;
		if (ConfigHandler.registerLightSourceBlocks) {
			//for (Block block : Block.REGISTRY) {
				//IBlockState blockState = block.getDefaultState();
				//if (blockState.getLightValue( , pos) > ConfigHandler.lightSourceRegistryThreshold){
					//lightSources.add(Item.getItemFromBlock(block));
					//lightSourceBlocks++;
				//}
			//}
		} else {
			for (String blockName : ConfigHandler.lightSourceItems) {
				final Block block = (Block) Block.getBlockFromName(blockName);
				if (block != null) {
					lightSources.add(Item.getItemFromBlock(block));
					lightSourceBlocks++;
				}
			}
		}

		int lightSourceItems = 0;
		for (String itemName : ConfigHandler.lightSourceItems) {
			final Item item = Item.REGISTRY.getObject(new ResourceLocation(itemName));
			if (item != null) {
				lightSources.add(item);
				lightSourceItems++;
			}
		}

		Utils.getLogger().info("Registered " + lightSourceBlocks + " blocks and " + lightSourceItems + " items as light sources.");
	}

	public static boolean isLightSource(Item item) {
		return lightSources.contains(item);
	}

	public static boolean containsLightSource(Iterable<ItemStack> items) {
		if (items != null) {
			for (ItemStack stack : items) {
				if (isLightSource(stack.getItem())) {
					return true;
				}
			}
		}

		return false;
	}

}
