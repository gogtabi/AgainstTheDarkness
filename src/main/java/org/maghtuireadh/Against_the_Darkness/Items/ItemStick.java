package org.maghtuireadh.Against_the_Darkness.Items;

import org.maghtuireadh.Against_the_Darkness.Init.ModBlocks;
import org.maghtuireadh.Against_the_Darkness.Utils.Reference;
import org.maghtuireadh.Against_the_Darkness.Utils.Utils;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemStick extends Item {



	/**
	 * Says that the tool is not effective on any blocks
	 */
	
	public ItemStick(String unlocalizedName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));
		
	}
	
	
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		RayTraceResult raytraceresult = null;
		float f = playerIn.rotationPitch;
        float f1 = playerIn.rotationYaw;
        double d0 = playerIn.posX;
        double d1 = playerIn.posY + (double)playerIn.getEyeHeight();
        double d2 = playerIn.posZ;
        Vec3d vec3d = new Vec3d(d0, d1, d2);
        float f2 = MathHelper.cos(-f1 * 0.017453292F - (float)Math.PI);
        float f3 = MathHelper.sin(-f1 * 0.017453292F - (float)Math.PI);
        float f4 = -MathHelper.cos(-f * 0.017453292F);
        float f5 = MathHelper.sin(-f * 0.017453292F);
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        double d3 = 5.0D;
        if (playerIn instanceof net.minecraft.entity.player.EntityPlayerMP)
        {
            d3 = ((net.minecraft.entity.player.EntityPlayerMP)playerIn).interactionManager.getBlockReachDistance();
        }
        Vec3d vec3d1 = vec3d.addVector((double)f6 * d3, (double)f5 * d3, (double)f7 * d3);
    
         
         if (!Double.isNaN(vec3d.x) && !Double.isNaN(vec3d.y) && !Double.isNaN(vec3d.z))
         {
             if (!Double.isNaN(vec3d1.x) && !Double.isNaN(vec3d1.y) && !Double.isNaN(vec3d1.z))
             {
                 int i = MathHelper.floor(vec3d1.x);
                 int j = MathHelper.floor(vec3d1.y);
                 int k = MathHelper.floor(vec3d1.z);
                 int l = MathHelper.floor(vec3d.x);
                 int i1 = MathHelper.floor(vec3d.y);
                 int j1 = MathHelper.floor(vec3d.z);
                 BlockPos blockpos = new BlockPos(l, i1, j1);
                 IBlockState iblockstate = playerIn.getEntityWorld().getBlockState(blockpos);
                 Block block = iblockstate.getBlock();

                 if ((iblockstate.getCollisionBoundingBox(playerIn.getEntityWorld(), blockpos) != Block.NULL_AABB))
                 {
                     RayTraceResult Raytraceresult = iblockstate.collisionRayTrace(playerIn.getEntityWorld(), blockpos, vec3d, vec3d1);

                     if (Raytraceresult != null)
                     {
                         
                        raytraceresult = Raytraceresult;
                     }
                     else {raytraceresult = null;}
                 }
                 else {raytraceresult = null;}
             }
         }
		
		
		if (raytraceresult == null)
        {
			playerIn.playSound(SoundEvents.ITEM_BUCKET_FILL, 1.0F, 1.0F);
            return new ActionResult(EnumActionResult.PASS, itemStackIn);
        }
        else if (raytraceresult.typeOfHit != RayTraceResult.Type.BLOCK)
        {
        	playerIn.playSound(SoundEvents.ITEM_BUCKET_EMPTY, 1.0F, 1.0F);
            return new ActionResult(EnumActionResult.FAIL, itemStackIn);
            
        }
          
        else
        {
        	Utils.getLogger().info(raytraceresult.toString());
        	
        	
        	
            BlockPos blockpos = raytraceresult.getBlockPos();
            IBlockState iblockstate = worldIn.getBlockState(blockpos);
            Block block = iblockstate.getBlock();
            Material material = iblockstate.getMaterial();
            boolean IsBurning = block.isBurning(worldIn, blockpos);
            boolean IsFireSource = block.isFireSource(worldIn, blockpos, raytraceresult.sideHit);
            if (IsFireSource || IsBurning || block == Block.getBlockFromName("fire") || material == Material.FIRE || block == Block.getBlockFromName("lava") || block == Block.getBlockFromName("flowing_lava") || material == Material.LAVA || block == ModBlocks.BlockAtdTorch || block == Block.getBlockFromName("torch") || block.equals(Block.getBlockFromName("lit_furnace")) || block == Block.getBlockFromName("lit_furnace"))
            {
            	ItemStack IS = new ItemStack(ModBlocks.BlockAtdTorch, 1);
            	//playerIn.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, IS);
                return new ActionResult(EnumActionResult.SUCCESS, IS);
                
            }
            
            else
            {
            	playerIn.playSound(SoundEvents.BLOCK_CHEST_OPEN, 1.0F, 1.0F);
                return new ActionResult(EnumActionResult.FAIL, itemStackIn);
            }
		
            
	}}}
	






	

