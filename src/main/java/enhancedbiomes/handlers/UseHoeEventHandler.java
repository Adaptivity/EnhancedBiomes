package enhancedbiomes.handlers;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import enhancedbiomes.blocks.EnhancedBiomesBlocks;
import enhancedbiomes.world.MapGenCavesEnhancedBiomes;
import enhancedbiomes.world.MapGenRavineEnhancedBiomes;
import net.minecraft.block.Block;
import net.minecraft.world.gen.MapGenBase;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent.EventType;

public class UseHoeEventHandler
{
	@SubscribeEvent(priority=EventPriority.LOWEST)
	public void tillDirt(UseHoeEvent e) {
		if (e.getResult() != Result.DEFAULT || e.isCanceled())
			return;

		e.setResult(Result.DEFAULT);
		if(e.world.getBlock(e.x, e.y + 1, e.z).isAir(e.world, e.x, e.y + 1, e.z) && (e.world.getBlock(e.x, e.y, e.z) == EnhancedBiomesBlocks.dirtEB || e.world.getBlock(e.x, e.y, e.z) == EnhancedBiomesBlocks.grassEB)) {
			e.world.setBlock(e.x, e.y, e.z, EnhancedBiomesBlocks.farmlandEB[e.world.getBlockMetadata(e.x, e.y, e.z)], 0, 2);
			e.world.playSoundEffect(e.x + 0.5F, e.y + 0.5F, e.z + 0.5F, Block.soundTypeGravel.getStepResourcePath(), 1.0F, 0.8F);
			e.setResult(Result.ALLOW);
		}
	}
}
