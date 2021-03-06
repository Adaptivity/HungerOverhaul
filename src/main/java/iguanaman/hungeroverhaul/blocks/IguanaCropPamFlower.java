package iguanaman.hungeroverhaul.blocks;

import iguanaman.hungeroverhaul.IguanaConfig;

import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

import com.pam.weeeflowers.BlockPamFlowerCrop;
import com.pam.weeeflowers.weeeflowers;

import cpw.mods.fml.common.Loader;

public class IguanaCropPamFlower extends BlockPamFlowerCrop {

	public IguanaCropPamFlower() {
		super();

		if (Loader.isModLoaded("Thaumcraft"))
			if (!ThaumcraftApi.exists(Item.getItemFromBlock(this), -1))
				ThaumcraftApi.registerObjectTag(new ItemStack(this), new int[] {-1}, new AspectList().add(Aspect.CROP, 2).add(Aspect.HUNGER, 1));
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		int sunlightModifier = par1World.isDaytime() && par1World.canBlockSeeTheSky(par2, par3, par4) ? 1 : IguanaConfig.noSunlightRegrowthMultiplier;
		if (sunlightModifier == 0) return;
		if (par5Random.nextInt(IguanaConfig.flowerRegrowthMultiplier) != 0) return;
		super.updateTick(par1World, par2, par3, par4, par5Random);
	}

	/**
	 * Harvest crops by right clicking on them (also bone meal)
	 */
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {

		if(!par1World.isRemote) {
			Random random = new Random();
			int meta = par1World.getBlockMetadata(par2, par3, par4);
			{
				int cropDrops = random.nextInt(2) + 1;
				if(meta == 2) {
					par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
					par1World.spawnEntityInWorld(new EntityItem(par1World, par2 + 0.5D, par3 + 0.7D, par4 + 0.5D, new ItemStack(weeeflowers.pamFlower, cropDrops, meta)));
				}
				return true;
			}
		}
		return false;
	}
}
