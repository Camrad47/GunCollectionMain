package concreteguy.guncollection.procedures;

import concreteguy.guncollection.GunCollection;
import concreteguy.guncollection.init.EntityInit;
import concreteguy.guncollection.client.handler.AnotherEventHandler;
import concreteguy.guncollection.core.registry.ItemRegistry;
import concreteguy.guncollection.network.GCVariables;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class NightVisionProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemRegistry.GC_SIGHT_NVG.get()) {
			if ((entity.getCapability(GCVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GCVariables.PlayerVariables())).nvg_1 == true) {
				AnotherEventHandler.queueServerWork(2, () -> {
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 2, 1, false, false));
				});
			}
		}
	}
}
