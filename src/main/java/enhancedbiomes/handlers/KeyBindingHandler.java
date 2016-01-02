package enhancedbiomes.handlers;

import java.util.EnumSet;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import enhancedbiomes.EnhancedBiomesMod;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;

import org.lwjgl.input.Keyboard;

public class KeyBindingHandler
{
	public static KeyBinding biomeInfo = new KeyBinding(StatCollector.translateToLocal("enhancedbiomes.keybinding.togglebiomeinformation"), Keyboard.KEY_I, EnhancedBiomesMod.MOD_NAME);

	public KeyBindingHandler() {
		ClientRegistry.registerKeyBinding(biomeInfo);
	}

	@SubscribeEvent
	public void KeyInputEvent(cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent event) {
		if(biomeInfo.isPressed()) {
			EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
			if(player == null) return;

			if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD7)) {
				player.getEntityData().setInteger("biomeInfoPos", 0);
			}
			else if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD9)) {
				player.getEntityData().setInteger("biomeInfoPos", 1);
			}
			else if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD1)) {
				player.getEntityData().setInteger("biomeInfoPos", 2);
			}
			else if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD3)) {
				player.getEntityData().setInteger("biomeInfoPos", 3);
			}
			else {
				player.getEntityData().setBoolean("biomeInfoDisplay", !player.getEntityData().getBoolean("biomeInfoDisplay"));
			}
		}
	}
}