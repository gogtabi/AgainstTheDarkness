package org.maghtuireadh.Against_the_Darkness.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import org.maghtuireadh.Against_the_Darkness.Init.ModBlocks;
import org.maghtuireadh.Against_the_Darkness.Utils.Reference;

public class BlockPitchBucket extends Block  {
	
	
	
	public static int FillTime = 500;
	
	public BlockPitchBucket(String unlocalizedName) {
		super(Material.IRON);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));
		setLightLevel(0.0F);
	}
	
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		world.scheduleBlockUpdate(pos, this , FillTime, 0);
			 
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune) {
			return Item.getItemFromBlock(ModBlocks.BlockAtdTorch);
	}
	
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		
		world.setBlockToAir(pos);
	}
}