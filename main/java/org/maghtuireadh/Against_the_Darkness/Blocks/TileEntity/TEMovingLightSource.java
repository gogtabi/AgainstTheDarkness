package org.maghtuireadh.Against_the_Darkness.Blocks.TileEntity;

import java.util.UUID;

import javax.annotation.Nullable;

import org.maghtuireadh.Against_the_Darkness.Blocks.BlockMovingLightSource;
import org.maghtuireadh.Against_the_Darkness.Handlers.LightSourceHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TEMovingLightSource extends TileEntity implements ITickable {

	public static final String NAME = "te_moving_light_source";

	private UUID playerUUID;

	public TEMovingLightSource() {

	}

	@Override
	public void update() {
		if (shouldKill() && world.getBlockState(pos).getBlock() instanceof BlockMovingLightSource) {
			world.setBlockToAir(pos);
			world.removeTileEntity(pos);
		}
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);

		if (playerUUID != null) {
			tag.setString("PlayerUUID", playerUUID.toString());
		}

		return tag;
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);

		if (tag.hasKey("PlayerUUID")) {
			playerUUID = UUID.fromString(tag.getString("PlayerUUID"));
		}
	}

	public boolean shouldKill() {
		final EntityPlayer player = findLightSourceCreator();
		return player == null || player.getDistance(pos.getX(), pos.getY(), pos.getZ()) > 2.0D || !LightSourceHandler.containsLightSource(player.getHeldEquipment());
	}

	public TEMovingLightSource setPlayer(EntityPlayer player) {
		if (player != null) {
			playerUUID = player.getGameProfile() != null ? player.getGameProfile().getId() : null;
		}

		return this;
	}

	@Nullable
	public EntityPlayer findLightSourceCreator() {
		if (playerUUID != null) {
			return world.getPlayerEntityByUUID(playerUUID);
		}

		return world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 2.0D, false);
	}

}
