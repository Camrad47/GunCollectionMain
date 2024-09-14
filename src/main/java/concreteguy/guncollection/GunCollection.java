package concreteguy.guncollection;

import com.mrcrayfish.framework.api.client.FrameworkClientAPI;
import com.mrcrayfish.guns.client.KeyBinds;
import com.mrcrayfish.guns.client.MetaLoader;
import com.mrcrayfish.guns.client.handler.CrosshairHandler;
import com.mrcrayfish.guns.common.ProjectileManager;
import com.mrcrayfish.guns.entity.GrenadeEntity;
import com.mrcrayfish.guns.entity.ThrowableGrenadeEntity;
import com.mrcrayfish.guns.init.ModEntities;
import com.mrcrayfish.guns.init.ModItems;
import concreteguy.guncollection.entities.*;
import concreteguy.guncollection.init.EntityInit;
import concreteguy.guncollection.events.*;
import com.mrcrayfish.guns.network.PacketHandler;
import concreteguy.guncollection.client.ClientHandler;
import concreteguy.guncollection.client.MoreKeyBinds;
import concreteguy.guncollection.config.Config;
import concreteguy.guncollection.datagen.ModRecipeGenerator;
import concreteguy.guncollection.core.registry.ItemRegistry;
import concreteguy.guncollection.core.registry.SoundRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;


import static concreteguy.guncollection.init.EntityInit.GC_AMMO_RIFLE_GRENADE;
import static concreteguy.guncollection.init.EntityInit.GC_AMMO_VOG25;
import static concreteguy.guncollection.init.EntityInit.GC_AMMO_30X29;
import static concreteguy.guncollection.init.EntityInit.GC_AMMO_BOMB;
import static concreteguy.guncollection.init.EntityInit.GC_AMMO_PG7V;
import static concreteguy.guncollection.init.EntityInit.GC_AMMO_OG7V;
import static concreteguy.guncollection.init.EntityInit.GC_AMMO_TBG7;
import static concreteguy.guncollection.init.EntityInit.GC_AMMO_PG7VR;
import static concreteguy.guncollection.init.EntityInit.GC_AMMO_3X40;
import static concreteguy.guncollection.init.EntityInit.GC_AMMO_762X39_AIRBURST;
import static concreteguy.guncollection.init.EntityInit.GC_AMMO_RSPRGR;

/**
 * @author Beton
 */
@Mod(GunCollection.ID)
public class GunCollection
{
    public static final String ID = "guncollection";
    public static final Logger LOGGER = LogManager.getLogger("guncollection");

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ID);

    public GunCollection() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.clientConfig);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.register(this);
        bus.register(new GunCollectionTab());

        BLOCKS.register(bus);
        ItemRegistry.ITEMS.register(bus);
        SoundRegistry.SOUNDS.register(bus);
        ModEntities.REGISTER.register(bus);
        EntityInit.ENTITIES.register(bus);

        bus.addListener(this::clientSetup);
        bus.addListener(this::setup);
        bus.addListener(this::gatherData);
        bus.addListener(this::commonSetup);
        bus.addListener(MoreKeyBinds::registerKeyMappings);
    }


    private void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(ClientHandler::registerModelOverrides);
    }


    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(()->{
        });

    }

    private void setup(final FMLCommonSetupEvent event) {

        ProjectileManager.getInstance().registerFactory(ItemRegistry.GC_AMMO_RIFLE_GRENADE.get(), (worldIn, entity, weapon, item, modifiedGun) -> new RifleGrenadeEntity (GC_AMMO_RIFLE_GRENADE.get(), worldIn, entity, weapon, item, modifiedGun));
        ProjectileManager.getInstance().registerFactory(ItemRegistry.GC_AMMO_VOG25.get(), (worldIn, entity, weapon, item, modifiedGun) -> new RifleGrenadeEntity (GC_AMMO_VOG25.get(), worldIn, entity, weapon, item, modifiedGun));
        ProjectileManager.getInstance().registerFactory(ItemRegistry.GC_AMMO_30X29.get(), (worldIn, entity, weapon, item, modifiedGun) -> new RifleGrenadeEntity (GC_AMMO_30X29.get(), worldIn, entity, weapon, item, modifiedGun));
        ProjectileManager.getInstance().registerFactory(ItemRegistry.GC_AMMO_BOMB.get(), (worldIn, entity, weapon, item, modifiedGun) -> new gcBombEntity (GC_AMMO_BOMB.get(), worldIn, entity, weapon, item, modifiedGun));
        ProjectileManager.getInstance().registerFactory(ItemRegistry.GC_AMMO_PG7V.get(), (worldIn, entity, weapon, item, modifiedGun) -> new rpgGrenadeEntity(GC_AMMO_PG7V.get(), worldIn, entity, weapon, item, modifiedGun));
        ProjectileManager.getInstance().registerFactory(ItemRegistry.GC_AMMO_OG7V.get(), (worldIn, entity, weapon, item, modifiedGun) -> new rpgGrenadeHEEntity(GC_AMMO_OG7V.get(), worldIn, entity, weapon, item, modifiedGun));
        ProjectileManager.getInstance().registerFactory(ItemRegistry.GC_AMMO_TBG7.get(), (worldIn, entity, weapon, item, modifiedGun) -> new rpgGrenadeFAEEntity(GC_AMMO_TBG7.get(), worldIn, entity, weapon, item, modifiedGun));
        ProjectileManager.getInstance().registerFactory(ItemRegistry.GC_AMMO_PG7VR.get(), (worldIn, entity, weapon, item, modifiedGun) -> new rpgGrenadeTandemEntity(GC_AMMO_PG7VR.get(), worldIn, entity, weapon, item, modifiedGun));
        ProjectileManager.getInstance().registerFactory(ItemRegistry.GC_AMMO_3X40.get(), (worldIn, entity, weapon, item, modifiedGun) -> new agiGrenadeEntity(GC_AMMO_3X40.get(), worldIn, entity, weapon, item, modifiedGun));
        ProjectileManager.getInstance().registerFactory(ItemRegistry.GC_AMMO_762X39_AIRBURST.get(), (worldIn, entity, weapon, item, modifiedGun) -> new ExplosiveProjectileEntity(GC_AMMO_762X39_AIRBURST.get(), worldIn, entity, weapon, item, modifiedGun));
        ProjectileManager.getInstance().registerFactory(ItemRegistry.GC_AMMO_RSPRGR.get(), (worldIn, entity, weapon, item, modifiedGun) -> new rpgGrenadeHEEntity(GC_AMMO_RSPRGR.get(), worldIn, entity, weapon, item, modifiedGun));

    }

    private void gatherData(final GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        generator.addProvider(event.includeServer(), new ModRecipeGenerator(packOutput));
    }


    public static boolean isDebugging()
    {
        return false;//!FMLEnvironment.production;
    }
}
