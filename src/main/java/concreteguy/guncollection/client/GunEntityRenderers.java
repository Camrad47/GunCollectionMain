package concreteguy.guncollection.client;

import com.mrcrayfish.guns.Reference;
import com.mrcrayfish.guns.client.render.entity.GrenadeRenderer;
import concreteguy.guncollection.client.render.entity.*;
import concreteguy.guncollection.entities.ExplosiveProjectileEntity;
import concreteguy.guncollection.entities.RifleGrenadeEntity;
import concreteguy.guncollection.GunCollection;
import concreteguy.guncollection.entities.rpgGrenadeEntity;
import concreteguy.guncollection.init.EntityInit;
import com.mrcrayfish.guns.client.render.entity.MissileRenderer;
import com.mrcrayfish.guns.client.render.entity.ProjectileRenderer;
import com.mrcrayfish.guns.client.render.entity.ThrowableGrenadeRenderer;
import com.mrcrayfish.guns.init.ModEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Author: MrCrayfish
 */
@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GunEntityRenderers
{
    @SubscribeEvent
    public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(ModEntities.PROJECTILE.get(), ProjectileRenderer::new);
        event.registerEntityRenderer(ModEntities.GRENADE.get(), GrenadeRenderer::new);
        event.registerEntityRenderer(EntityInit.GC_AMMO_RIFLE_GRENADE.get(), RifleGrenadeRenderer::new);
        event.registerEntityRenderer(EntityInit.GC_AMMO_VOG25.get(), RifleGrenadeRenderer::new);
        event.registerEntityRenderer(EntityInit.GC_AMMO_30X29.get(), RifleGrenadeRenderer::new);
        event.registerEntityRenderer(EntityInit.GC_AMMO_BOMB.get(), gcBombRenderer::new);
        event.registerEntityRenderer(EntityInit.GC_AMMO_PG7V.get(), rpgGrenadeRenderer::new);
        event.registerEntityRenderer(EntityInit.GC_AMMO_OG7V.get(), rpgGrenadeHERenderer::new);
        event.registerEntityRenderer(EntityInit.GC_AMMO_TBG7.get(), rpgGrenadeFAERenderer::new);
        event.registerEntityRenderer(EntityInit.GC_AMMO_PG7VR.get(), rpgGrenadeTandemRenderer::new);
        event.registerEntityRenderer(EntityInit.GC_AMMO_3X40.get(), agiGrenadeRenderer::new);
        event.registerEntityRenderer(EntityInit.GC_AMMO_762X39_AIRBURST.get(), ExplosiveProjectileRenderer::new);
        event.registerEntityRenderer(EntityInit.GC_AMMO_RSPRGR.get(), rpgGrenadeHERenderer::new);
        event.registerEntityRenderer(ModEntities.MISSILE.get(), MissileRenderer::new);
        event.registerEntityRenderer(ModEntities.THROWABLE_GRENADE.get(), ThrowableGrenadeRenderer::new);
        event.registerEntityRenderer(ModEntities.THROWABLE_STUN_GRENADE.get(), ThrowableGrenadeRenderer::new);
    }
}
