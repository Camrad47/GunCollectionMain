package concreteguy.guncollection.client;

import com.mrcrayfish.guns.client.render.entity.ProjectileRenderer;
import com.mrcrayfish.guns.client.render.entity.ThrowableGrenadeRenderer;

import com.mrcrayfish.guns.entity.GrenadeEntity;
import concreteguy.guncollection.GunCollection;
import concreteguy.guncollection.init.EntityInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GunCollection.ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GunCollectionClient {
	
	/**
	 * lol
	 */
	@SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		
       event.registerEntityRenderer(EntityInit.GC_AMMO_RIFLE_GRENADE.get(), ProjectileRenderer::new);
	   event.registerEntityRenderer(EntityInit.GC_AMMO_VOG25.get(), ProjectileRenderer::new);
	   event.registerEntityRenderer(EntityInit.GC_AMMO_30X29.get(), ProjectileRenderer::new);
		event.registerEntityRenderer(EntityInit.GC_AMMO_BOMB.get(), ProjectileRenderer::new);
		event.registerEntityRenderer(EntityInit.GC_AMMO_PG7V.get(), ProjectileRenderer::new);
		event.registerEntityRenderer(EntityInit.GC_AMMO_OG7V.get(), ProjectileRenderer::new);
		event.registerEntityRenderer(EntityInit.GC_AMMO_TBG7.get(), ProjectileRenderer::new);
		event.registerEntityRenderer(EntityInit.GC_AMMO_PG7VR.get(), ProjectileRenderer::new);
		event.registerEntityRenderer(EntityInit.GC_AMMO_3X40.get(), ProjectileRenderer::new);
		event.registerEntityRenderer(EntityInit.GC_AMMO_762X39_AIRBURST.get(), ProjectileRenderer::new);
		event.registerEntityRenderer(EntityInit.GC_AMMO_23HENSAP.get(), ProjectileRenderer::new);
		event.registerEntityRenderer(EntityInit.GC_AMMO_RSPRGR.get(), ProjectileRenderer::new);
        
    }

}