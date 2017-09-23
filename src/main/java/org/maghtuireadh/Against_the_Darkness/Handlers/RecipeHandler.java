package org.maghtuireadh.Against_the_Darkness.Handlers;

import java.util.List;

import org.maghtuireadh.Against_the_Darkness.Init.ModBlocks;
import org.maghtuireadh.Against_the_Darkness.Init.ModItems;
import org.maghtuireadh.Against_the_Darkness.Utils.Utils;

import net.minecraft.client.gui.recipebook.RecipeList;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHandler {

	
	public static void registerRecipes() {
		GameRegistry.addShapedRecipe(new ResourceLocation("atd:Atd Torch"), new ResourceLocation("atd:Atd Torches"), new ItemStack(ModBlocks.BlockAtdTorch, 4), new Object [] {"C", "S", 'C', Items.COAL, 'S', ModItems.Stick});
	}
	
/*	public static void removeRecipe(ItemStack s) {
		int recipeCount = 0;
		final List<IRecipe> recipeList = new RecipeList().getRecipes();
		for (int i = 0; i < recipeList.size(); i++) {
			final IRecipe currentRecipe = recipeList.get(i);
			final ItemStack output = currentRecipe.getRecipeOutput();
			if (output != null && output.getItem() == s.getItem()) {
				recipeList.remove(i);
				recipeCount++;
			}
		}

		Utils.getLogger().info("Removed " + recipeCount + " torch recipe" + (recipeCount > 1 ? "s." : "."));
	}*/
}
