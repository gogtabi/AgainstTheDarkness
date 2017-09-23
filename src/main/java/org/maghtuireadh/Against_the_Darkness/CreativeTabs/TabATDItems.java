package org.maghtuireadh.Against_the_Darkness.CreativeTabs;

import org.maghtuireadh.Against_the_Darkness.Init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabATDItems extends CreativeTabs{



public TabATDItems() {
		super("atditems");
	}


@Override
public ItemStack getTabIconItem() {
	return new ItemStack(ModItems.AtdTorch);
}

}