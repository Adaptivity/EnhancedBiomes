package enhancedbiomes.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockHalfSlabEB extends BlockSlab
{
	/** The type of tree this slab came from. */
	public static String[] woodType0;
	public static String[] woodType1;
	public boolean doubleSlab;

	public BlockHalfSlabEB(boolean isDoubleSlab) {
		super(isDoubleSlab, Material.wood);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.useNeighborBrightness = true;
		doubleSlab = isDoubleSlab;
		woodType0 = new String[] {BlockLogOak.woodType[0], BlockLogOak.woodType[1], BlockLogOak.woodType[2], BlockLogOak.woodType[3], BlockLogSpruce.woodType[0], BlockLogSpruce.woodType[1], BlockLogSpruce.woodType[2], BlockLogSpruce.woodType[3]};
		woodType1 = new String[] {BlockLogBirch.woodType[0], BlockLogBirch.woodType[1], BlockLogBirch.woodType[2], BlockLogBirch.woodType[3], BlockLogJungle.woodType[0], BlockLogJungle.woodType[1], BlockLogJungle.woodType[2], BlockLogJungle.woodType[3]};
	}

	@SideOnly(Side.CLIENT)
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	@Override
	public IIcon getIcon(int side, int meta) {
		return EnhancedBiomesBlocks.planksEB.getIcon(side, meta % 8 + (this == EnhancedBiomesBlocks.slab2 || this == EnhancedBiomesBlocks.doubleSlab2 ? 8 : 0));
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3) {
		return this == EnhancedBiomesBlocks.slab2 || this == EnhancedBiomesBlocks.doubleSlab2 ? Item.getItemFromBlock(EnhancedBiomesBlocks.slab2) : Item.getItemFromBlock(EnhancedBiomesBlocks.slab1);
	}

	/**
	 * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage and is ignored for blocks which do not support subtypes. Blocks which cannot be
	 * harvested should return null.
	 */
	@Override
	protected ItemStack createStackedBlock(int par1) {
		Block block = this == EnhancedBiomesBlocks.slab2 || this == EnhancedBiomesBlocks.doubleSlab2 ? EnhancedBiomesBlocks.slab2 : EnhancedBiomesBlocks.slab1;
		return new ItemStack(block, 2, par1 & 7);
	}

	@SideOnly(Side.CLIENT)
	@Override
	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		for(int j = 0; j < 8; ++j) {
			if(woodType1[j] != "" && woodType1[j] != "") {
				list.add(new ItemStack(item, 1, j));
			}
		}
	}

	@SideOnly(Side.CLIENT)
	/**
	 * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
	 */
	@Override
	public Item getItem(World world, int par2, int par3, int par4) {
		return Item.getItemFromBlock((this == EnhancedBiomesBlocks.doubleSlab1 ? EnhancedBiomesBlocks.slab1 : (this == EnhancedBiomesBlocks.doubleSlab2 ? EnhancedBiomesBlocks.slab2 : this)));
	}

	@Override
	public String func_150002_b(int var1) {
		return null;
	}
}
