package org.maghtuireadh.Against_the_Darkness.Items;

import org.maghtuireadh.Against_the_Darkness.Utils.Reference;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;


	public class ItemAtdTorch extends Item {
		
		public ItemAtdTorch(String name) {
			this.setUnlocalizedName(name);
			this.setRegistryName(new ResourceLocation(Reference.MODID, name));
		}

	}
