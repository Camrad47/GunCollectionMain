package concreteguy.guncollection.init;

import com.mrcrayfish.guns.entity.GrenadeEntity;
import com.mrcrayfish.guns.entity.ThrowableGrenadeEntity;
import concreteguy.guncollection.GunCollection;
import concreteguy.guncollection.entities.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.BiFunction;

/**
 * This class is where all of the mod's entities are registered.
 */
/**
 */
public class EntityInit {
	
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, GunCollection.ID);
	
	public static final RegistryObject<EntityType<RifleGrenadeEntity>> GC_AMMO_RIFLE_GRENADE = registerBasic("gc_ammo_rifle_grenade", RifleGrenadeEntity::new);
	public static final RegistryObject<EntityType<RifleGrenadeEntity>> GC_AMMO_VOG25 = registerBasic("gc_ammo_vog25", RifleGrenadeEntity::new);
	public static final RegistryObject<EntityType<RifleGrenadeEntity>> GC_AMMO_30X29 = registerBasic("gc_ammo_30x29", RifleGrenadeEntity::new);
	public static final RegistryObject<EntityType<gcBombEntity>> GC_AMMO_BOMB = registerBasic("gc_ammo_bomb", gcBombEntity::new);
	public static final RegistryObject<EntityType<rpgGrenadeEntity>> GC_AMMO_PG7V = registerBasic("gc_ammo_pg7v", rpgGrenadeEntity::new);
	public static final RegistryObject<EntityType<rpgGrenadeHEEntity>> GC_AMMO_OG7V = registerBasic("gc_ammo_og7v", rpgGrenadeHEEntity::new);
	public static final RegistryObject<EntityType<rpgGrenadeFAEEntity>> GC_AMMO_TBG7 = registerBasic("gc_ammo_tbg7", rpgGrenadeFAEEntity::new);
	public static final RegistryObject<EntityType<rpgGrenadeTandemEntity>> GC_AMMO_PG7VR = registerBasic("gc_ammo_pg7vr", rpgGrenadeTandemEntity::new);
	public static final RegistryObject<EntityType<agiGrenadeEntity>> GC_AMMO_3X40 = registerBasic("gc_ammo_3x40", agiGrenadeEntity::new);
	public static final RegistryObject<EntityType<ExplosiveProjectileEntity>> GC_AMMO_762X39_AIRBURST = registerBasic("gc_ammo_762x39_airburst", ExplosiveProjectileEntity::new);
	public static final RegistryObject<EntityType<ExplosiveProjectileEntity>> GC_AMMO_23HENSAP = registerBasic("gc_ammo_23hensap", ExplosiveProjectileEntity::new);
	public static final RegistryObject<EntityType<rpgGrenadeHEEntity>> GC_AMMO_RSPRGR = registerBasic("gc_ammo_rsprgr", rpgGrenadeHEEntity::new);


	/**
     * This is a helper method when registering projectiles.
     * All of the stuff in this method can be written each time we create a new projectile - but that isn't needed.
     * With this we can register things with much more ease.
     * 
     * @author Mr. Pineapple
     */
	private static <T extends Entity> RegistryObject<EntityType<T>> registerBasic(String id, BiFunction<EntityType<T>, Level, T> function) {
		
        return ENTITIES.register(id, () -> EntityType.Builder.of(function::apply, MobCategory.MISC)
                .sized(0.25F, 0.25F)
                .setTrackingRange(100)
                .setUpdateInterval(1)
                .noSummon()
                .fireImmune()
                .setShouldReceiveVelocityUpdates(true).build(id));
        
    }

}