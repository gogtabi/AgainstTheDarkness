package org.maghtuireadh.Against_the_Darkness.Init;

import org.maghtuireadh.Against_the_Darkness.Against_the_darkness;
import org.maghtuireadh.Against_the_Darkness.Blocks.BlockAtdTorch;
import org.maghtuireadh.Against_the_Darkness.Utils.Reference;
import org.maghtuireadh.Against_the_Darkness.Utils.Utils;
import org.maghtuireadh.Against_the_Darkness.Blocks.BlockPitchBucket;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModBlocks {
	

	public static Block BlockAtdTorch;
	public static Block BlockPitchBucket;
	
	public static void init() {
		
		BlockAtdTorch = new BlockAtdTorch("Atd_Torch");
		BlockPitchBucket = new BlockPitchBucket("Pitch_Bucket");
	}
	public static void register() {
		registerBlock(BlockAtdTorch);
		registerBlock(BlockPitchBucket);
	}
	

	
	public static void registerRenders() {
		//registerRender(BlockAtdTorch);
		//registerRender(BlockPitchBucket);
	}
	
	
	public static void registerBlock(Block block) {
		block.setCreativeTab(Against_the_darkness.blocks);
		ForgeRegistries.BLOCKS.register(block);
		ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		Utils.getLogger().info("Registered Block: " + block.getRegistryName());
		
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
		Utils.getLogger().info("Registered render for " + block.getRegistryName());
	}
	
	
	
	/**
	 * Registers the blocks renders
	 * @param block The block
	 */
	public static void registerRender(Block block) {
		//ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
		
	}
	

}
