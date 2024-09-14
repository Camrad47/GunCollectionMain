
package concreteguy.guncollection.network;

import com.mrcrayfish.guns.common.Gun;
import concreteguy.guncollection.GunCollection;
import concreteguy.guncollection.client.handler.AnotherEventHandler;
import concreteguy.guncollection.init.EntityInit;
import concreteguy.guncollection.core.registry.ItemRegistry;
import concreteguy.guncollection.network.GCVariables;
import concreteguy.guncollection.procedures.NVGkeyOnKeyPressedProcedure;
import concreteguy.guncollection.procedures.NVGkeyOnKeyReleasedProcedure;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NVGkeyMessage {
	int type, pressedms;

	public NVGkeyMessage(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public NVGkeyMessage(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(NVGkeyMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(NVGkeyMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			pressAction(context.getSender(), message.type, message.pressedms);
		});
		context.setPacketHandled(true);
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;
		if (type == 0) {

			NVGkeyOnKeyPressedProcedure.execute(entity);
		}
		if (type == 1) {

			NVGkeyOnKeyReleasedProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		AnotherEventHandler.addNetworkMessage(NVGkeyMessage.class, NVGkeyMessage::buffer, NVGkeyMessage::new, NVGkeyMessage::handler);
	}
}
