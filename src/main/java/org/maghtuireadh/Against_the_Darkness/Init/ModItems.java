package org.maghtuireadh.Against_the_Darkness.Init;

import org.maghtuireadh.Against_the_Darkness.Against_the_darkness;
import org.maghtuireadh.Against_the_Darkness.Items.ItemAtdTorch;
import org.maghtuireadh.Against_the_Darkness.Items.ItemBucket;
import org.maghtuireadh.Against_the_Darkness.Items.ItemStick;
import org.maghtuireadh.Against_the_Darkness.Utils.Utils;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModItems {

/**
*	 * State the items
*/	 
	public static ItemAtdTorch AtdTorch;
	public static ItemStick Stick;
	public static ItemBucket Bucket;
/**
*	
*	
*	 * Initialize the items
*/
	public static void init() {
		//AtdTorch = new ItemAtdTorch("atd_torch");
		Stick = new ItemStick("Stick");
		Bucket = new ItemBucket(Block.getBlockFromName("air"), "Bucket");
		
		return;
	}
	
	/**
	 * Register the items
	 */
	public static void register() {
		//registerItem(AtdTorch);
		registerItem(Stick);
		registerItem(Bucket);
		
		return;
	}
	
	/**
	 * Register the items renders
	 */
	public static void registerRenders() {
		//registerRender(AtdTorch);
		//registerRender(Stick);
		//registerRender(Bucket);
		/**for(int i = 0; i < EnumHandler.ChipTypes.values().length; i++) {
		*	registerRender(chip, i, "chip_" + EnumHandler.ChipTypes.values()[i].getName());
		*/
		return;
		}
	
	
	/**
	 * Register an item
	 * @param item The item
	 */
	public static void registerItem(Item item) {
		item.setCreativeTab(Against_the_darkness.items); //Sets the creative tab
		ForgeRegistries.ITEMS.register(item);
		Utils.getLogger().info("Registered item: " + item.getRegistryName());
		
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		Utils.getLogger().info("Register render for " + item.getRegistryName());
	}
	
	/**
	 * Registers the item render MUST BE CALLED IN THE PRE INIT METHOD IN YOUR MAIN CLASS
	 * @param item The item
	 */
	public static void registerRender(Item item) {
		
	}
	
	/**
	 * Registers the item render for an item which has meta data
	 * @param item The item
	 * @param meta The meta data
	 * @param fileName The file name
	 */
	/*public static void registerRender(Item item, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(Reference.MODID, fileName), "inventory"));
		Utils.getLogger().info("Register render for " + item.getUnlocalizedName().substring(5));
	}*/
}
