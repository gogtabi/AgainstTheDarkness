package org.maghtuireadh.Against_the_Darkness.CreativeTabs;

import org.maghtuireadh.Against_the_Darkness.Init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;



public class TabATDBlocks extends CreativeTabs {

	
	public TabATDBlocks() {
		super("atdblocks");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.AtdTorch);
	}



}
