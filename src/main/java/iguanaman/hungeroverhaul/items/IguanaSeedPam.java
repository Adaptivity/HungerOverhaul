package iguanaman.hungeroverhaul.items;

import iguanaman.hungeroverhaul.IguanaConfig;
import iguanaman.hungeroverhaul.blocks.IguanaCropPam;
import iguanaman.hungeroverhaul.module.PamsModsHelper;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.BiomeDictionary.Type;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import cpw.mods.fml.common.Loader;

public class IguanaSeedPam extends ItemSeeds {

	public IguanaSeedPam(Block i, Block j) {
		super(i, j);

		if (Loader.isModLoaded("Thaumcraft"))
			if (!ThaumcraftApi.exists(this, -1))
				ThaumcraftApi.registerObjectTag(new ItemStack(this), new int[] {-1}, new AspectList().add(Aspect.PLANT, 1));
	}

	/**
	 * allows items to add custom lines of information to the mouseover description
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if (IguanaConfig.wrongBiomeRegrowthMultiplier > 1)
		{
			Type[] theBiomes = null;
			for(Block block : PamsModsHelper.PamCrops) {
				if (block instanceof IguanaCropPam) {
					int cropID = PamsModsHelper.crops.get(block);
					theBiomes = IguanaCropPam.biomes[cropID];
				}

				if (theBiomes != null) {
					String tooltip = "";
					for(Type biomeType : theBiomes)
						tooltip += biomeType.toString().substring(0, 1).toUpperCase() + biomeType.toString().substring(1).toLowerCase() + ", ";
					par3List.add("Crop grows best in:");
					par3List.add(tooltip.substring(0, tooltip.length() - 2));
				}
			}
		}
	}

}
