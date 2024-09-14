
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package concreteguy.guncollection.init;

import concreteguy.guncollection.GunCollection;
import concreteguy.guncollection.client.handler.AnotherEventHandler;
import concreteguy.guncollection.network.NVGkeyMessage;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class GCKeyMappings {
	public static final KeyMapping NV_GKEY = new KeyMapping("key.testone.nv_gkey", GLFW.GLFW_MOUSE_BUTTON_2, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				AnotherEventHandler.PACKET_HANDLER.sendToServer(new NVGkeyMessage(0, 0));
				NVGkeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				NV_GKEY_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - NV_GKEY_LASTPRESS);
				AnotherEventHandler.PACKET_HANDLER.sendToServer(new NVGkeyMessage(1, dt));
				NVGkeyMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long NV_GKEY_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(NV_GKEY);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				NV_GKEY.consumeClick();
			}
		}
	}
}
