package enhancedbiomes.handlers;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.FuelBurnTimeEvent;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import static enhancedbiomes.blocks.EnhancedBiomesBlocks.*;

public class FuelHandler {

	@SubscribeEvent
	public void onFurnaceBurnTime(FuelBurnTimeEvent event) {
		ItemStack fuel = event.fuel;
		if (fuel != null) {
			Block block = Block.getBlockFromItem(fuel.getItem());

			if (block == saplingEB) {
				event.burnTime = 100;
				event.setResult(Result.ALLOW);
			}
			
			if (block == slab1 || block == slab2) {
				event.burnTime = 150;
				event.setResult(Result.ALLOW);
			}
		}
	}
}