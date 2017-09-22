package org.maghtuireadh.Against_the_Darkness;





import org.maghtuireadh.Against_the_Darkness.CreativeTabs.TabATDBlocks;
import org.maghtuireadh.Against_the_Darkness.CreativeTabs.TabATDItems;
import org.maghtuireadh.Against_the_Darkness.Handlers.RecipeHandler;
import org.maghtuireadh.Against_the_Darkness.Init.ModBlocks;
import org.maghtuireadh.Against_the_Darkness.Init.ModItems;
import org.maghtuireadh.Against_the_Darkness.Proxy.CommonProxy;
import org.maghtuireadh.Against_the_Darkness.Utils.Reference;
import org.maghtuireadh.Against_the_Darkness.Utils.Utils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Against_the_darkness {

	public static final CreativeTabs blocks = new TabATDBlocks();
	public static final CreativeTabs items = new TabATDItems();
	
	org.maghtuireadh.Against_the_Darkness.Handlers.EventHandler eventHandler = new org.maghtuireadh.Against_the_Darkness.Handlers.EventHandler();
	
	@SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		ModItems.init();
		ModBlocks.init();
		ModItems.register();
		ModBlocks.register();
		
		proxy.registerRenders();
		Utils.getLogger().info("Pre Initializing");
	}
	@EventHandler
	public void Init(FMLInitializationEvent event){
		//RecipeHandler.removeRecipe(new ItemStack(Blocks.TORCH));
		RecipeHandler.registerRecipes();
		proxy.init();
		eventHandler.registerEvents();
		Utils.getLogger().info("Initializing");
		
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
			//RecipeHandler.removeRecipe(new ItemStack(Blocks.TORCH));
			GameRegistry.addShapedRecipe(new ResourceLocation("Atd Torch"), new ResourceLocation("Atd Torchs"), new ItemStack(Blocks.TORCH), new Object[] {"x", "y", 'x', ModBlocks.BlockAtdTorch, 'y', Items.STICK});
			

		Utils.getLogger().info("Post Initializing");
		
	}
}
