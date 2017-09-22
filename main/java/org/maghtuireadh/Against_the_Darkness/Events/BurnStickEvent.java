package org.maghtuireadh.Against_the_Darkness.Events;


import org.maghtuireadh.Against_the_Darkness.Init.ModBlocks;
import org.maghtuireadh.Against_the_Darkness.Init.ModItems;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

public class BurnStickEvent  {
	
	@SubscribeEvent
	public void onEvent(PlayerInteractEvent.RightClickBlock event) {
		EntityPlayer player = (EntityPlayer) event.getEntityPlayer();
		boolean IsBurning = event.getWorld().getBlockState(event.getPos()).getBlock().isBurning(event.getWorld(), event.getPos());
		boolean IsFireSource = event.getWorld().getBlockState(event.getPos()).getBlock().isFireSource(event.getWorld(), event.getPos(), event.getFace());
		boolean IsFire;
				if(event.getWorld().getBlockState(event.getPos()).getBlock().equals(Block.getBlockFromName("fire")) || event.getWorld().getBlockState(event.getPos()).getBlock().equals(Block.getBlockFromName("flowing_lava")) || event.getWorld().getBlockState(event.getPos()).getBlock().equals(Block.getBlockFromName("lava")) || event.getWorld().getBlockState(event.getPos()).getBlock().equals(Block.getBlockFromName("torch")) || event.getWorld().getBlockState(event.getPos()).getBlock().equals(ModBlocks.BlockAtdTorch) || event.getWorld().getBlockState(event.getPos()).getBlock().equals(Block.getBlockFromName("lit_furnace")) || event.getWorld().getBlockState(event.getPos()).getBlock().equals(Block.getBlockFromName("fire"))){
			 IsFire = true;
				}
				else 
				{
					 IsFire = false;
				}
		
		
		if(player.getHeldItemMainhand().getItem() == ModItems.Stick && IsBurning || IsFireSource || IsFire){
			
			
			BlockPos pos = event.getPos(); //Get the entity they hurt's position
			EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.STICK));	
			ItemStack IS = new ItemStack(ModBlocks.BlockAtdTorch, 1);
			player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, IS); //Spawns the item in the world. THIS METHOD WAS RENAMED IN 1.11.2 to spawnEntity not spawnEntityInWorld
			
		}
	

}}
