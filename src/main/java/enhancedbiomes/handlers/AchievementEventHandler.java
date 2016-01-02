package enhancedbiomes.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import enhancedbiomes.blocks.BlockLogBirch;
import enhancedbiomes.blocks.BlockLogJungle;
import enhancedbiomes.blocks.BlockLogOak;
import enhancedbiomes.blocks.BlockLogSpruce;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.stats.AchievementList;

public class AchievementEventHandler 
{
	@SubscribeEvent
	public void onItemPickup(PlayerEvent.ItemPickupEvent event)
	{
		Item item = event.pickedUp.getEntityItem().getItem();
		Block block = Block.getBlockFromItem(item);
		
		if (block != null && block instanceof BlockLogBirch)
		{
			event.player.addStat(AchievementList.mineWood, 1);
		}
		
		if (block != null && block instanceof BlockLogJungle)
		{
			event.player.addStat(AchievementList.mineWood, 1);
		}
		
		if (block != null && block instanceof BlockLogOak)
		{
			event.player.addStat(AchievementList.mineWood, 1);
		}
		
		if (block != null && block instanceof BlockLogSpruce)
		{
			event.player.addStat(AchievementList.mineWood, 1);
		}
	}
}