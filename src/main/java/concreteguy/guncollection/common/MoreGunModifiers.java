package concreteguy.guncollection.common;

import com.mrcrayfish.guns.interfaces.IGunModifier;
import concreteguy.guncollection.interfaces.IGunModifierGC;
import net.minecraft.util.Mth;

/**
 * Author: Beton
 */
public class MoreGunModifiers
{
    public static final IGunModifier EASY_CONTROL = new IGunModifier()
    {
        @Override
        public float recoilModifier()
        {
            return 0.3F;
        }

        @Override
        public float kickModifier()
        {
            return 0.8F;
        }

        @Override
        public float modifyProjectileSpread(float spread)
        {
            return spread * 0.75F;
        }

        @Override
        public double modifyAimDownSightSpeed(double speed)
        {
            return speed * 0.95F;
        }
    };

    public static final IGunModifier LASER_POINTER = new IGunModifier()
    {
        @Override
        public float modifyProjectileSpread(float spread)
        {
            return spread * 0.95F;
        }

        @Override
        public double modifyAimDownSightSpeed(double speed)
        {
            return speed * 1.15F;
        }
    };

    public static final IGunModifier EVEN_LESS_ADS = new IGunModifier()
    {
        @Override
        public double modifyAimDownSightSpeed(double speed)
        {
            return speed * 0.4F;
        }
    };

    public static final IGunModifier EVEN_SLOWER_ADS = new IGunModifier() {
        public double modifyAimDownSightSpeed(double speed) {
            return speed * 0.75;
        }
    };

    public static final IGunModifier MORE_MORE_ADS = new IGunModifier()
    {
        @Override
        public double modifyAimDownSightSpeed(double speed)
        {
            return speed * 2.5F;
        }
    };

    public static final IGunModifier SLIGHTLY_LESS_DAMAGE = new IGunModifier()
    {
        @Override
        public float modifyProjectileDamage(float damage) {
            return damage * 0.95F;
        }
    };

    public static final IGunModifier ERGONOMIC_GRIP = new IGunModifier()
    {
        @Override
        public double modifyAimDownSightSpeed(double speed)
        {
            return speed * 1.3F;
        }
    };

    public static final IGunModifier THE_MUZZLE_BRAKE = new IGunModifier()
    {
        public int modifyFireRate(int rate) {
            return Mth.clamp((int)((double)rate * 0.8), rate - 1, Integer.MAX_VALUE);
        }
        public float recoilModifier() {
            return 1.25F;
        }

        public float kickModifier() {
            return 1.45F;
        }

        public double modifyAimDownSightSpeed(double speed) {
            return speed * 1.3000000476837158;
        }

        public float modifyProjectileSpread(float spread) {
            return spread * 0.9F;
        }
    };

    public static final IGunModifier WOOD_STOCK = new IGunModifier()
    {
        @Override
        public double modifyAimDownSightSpeed(double speed)
        {
            return speed * 0.8F;
        }
        @Override
        public float kickModifier() {
            return 0.95F;
        }
        public float modifyProjectileSpread(float spread) {
            return spread * 0.9F;
        }
    };

    public static final IGunModifier METAL_STOCK = new IGunModifier()
    {
        @Override
        public float kickModifier() {
            return 1.11F;
        }
        public float recoilModifier() {
            return 1.11F;
        }
        public float modifyProjectileSpread(float spread) {
            return spread * 1.09F;
        }
        @Override
        public double modifyAimDownSightSpeed(double speed)
        {
            return speed * 1.15F;
        }
    };

    public static final IGunModifier POLYMER_STOCK = new IGunModifier()
    {
        @Override
        public double modifyAimDownSightSpeed(double speed)
        {
            return speed * 1.05F;
        }
        @Override
        public float kickModifier() {
            return 1.05F;
        }
    };

    public static final IGunModifier MARKSMAN_STOCK = new IGunModifier()
    {
        @Override
        public double modifyAimDownSightSpeed(double speed)
        {
            return speed * 0.5F;
        }
        @Override
        public float kickModifier() {
            return 0.68F;
        }
        public float recoilModifier() {
            return 0.5F;
        }
        public float modifyProjectileSpread(float spread) {
            return spread * 0.5F;
        }
        public int modifyFireRate(int rate) {
            return Mth.clamp((int)((double)rate * 1.25), rate + 1, Integer.MAX_VALUE);
        }

    };

    public static final IGunModifier TACTICAL_SNIPER_STOCK = new IGunModifier()
    {
        @Override
        public double modifyAimDownSightSpeed(double speed)
        {
            return speed * 0.7F;
        }
        @Override
        public float kickModifier() {
            return 0.79F;
        }
        public float recoilModifier() {
            return 0.62F;
        }
        public float modifyProjectileSpread(float spread) {
            return spread * 0.6F;
        }
        public int modifyFireRate(int rate) {
            return Mth.clamp((int)((double)rate * 1.25), rate + 1, Integer.MAX_VALUE);
        }

    };

    public static final IGunModifier ULTRA_LIGHT_STOCK = new IGunModifier()
    {
        @Override
        public float kickModifier() {
            return 1.33F;
        }
        public float recoilModifier() {
            return 1.51F;
        }
        public float modifyProjectileSpread(float spread) {
            return spread * 1.19F;
        }
        @Override
        public double modifyAimDownSightSpeed(double speed)
        {
            return speed * 1.75F;
        }
    };

    public static final IGunModifier MORE_CRIT = new IGunModifier()
    {
        @Override
        public float criticalChance() {
            return 2.0F;
        }
    };

    public static final IGunModifier MUZZLE_BRAKE = new IGunModifier()
    {
        @Override
        public double modifyAimDownSightSpeed(double speed)
        {
            return speed * 0.9F;
        }
        @Override
        public float kickModifier() {
            return 0.7F;
        }
        public float modifyProjectileSpread(float spread) {
            return spread * 0.7F;
        }
    };

    public static final IGunModifier SILENCED_1 = new IGunModifier() {
        public boolean silencedFire() {
            return true;
        }
        public double modifyMuzzleFlashScale(double scale) {
            return scale * 0;
        }
        public double modifyFireSoundRadius(double radius) {
            return radius * 0.25;
        }
    };

    public static final IGunModifier SOME_CONTROL = new IGunModifier()
    {
        @Override
        public double modifyAimDownSightSpeed(double speed)
        {
            return speed * 0.9F;
        }
        @Override
        public float kickModifier() {
            return 0.82F;
        }
    };

    public static final IGunModifier SMART_MODULE = new IGunModifier()
    {
        @Override
        public float criticalChance() {
            return 2.0F;
        }
        public float modifyProjectileDamage(float damage) {
            return damage * 1.15F;
        }
        public double modifyAimDownSightSpeed(double speed)
        {
            return speed * 0.8F;
        }
    };

    public static final IGunModifier ANATOMICALLY_AWARE_SCOPE = new IGunModifier()
    {
        @Override
        public float criticalChance() {
            return 1.5F;
        }
        public float modifyProjectileDamage(float damage) {
            return damage * 1.05F;
        }
        public double modifyProjectileSpeed(double speed) {
            return speed * 1.2F;
        }
        public float kickModifier() {
            return 1.23F;
        }
        public float recoilModifier() {
            return 1.21F;
        }
        public double modifyAimDownSightSpeed(double speed)
        {
            return speed * 0.8F;
        }
    };

    public static final IGunModifier HI_REZ_DIGITAL_SCOPE = new IGunModifier()
    {
        @Override
        public float criticalChance() {
            return 2.1F;
        }
        public float modifyProjectileSpread(float spread) {
            return spread * 0.8F;
        }
        public float kickModifier() {
            return 1.55F;
        }
        public float recoilModifier() {
            return 1.31F;
        }
        public double modifyAimDownSightSpeed(double speed)
        {
            return speed * 0.8F;
        }
    };

    // special ammo modules - SAM (special ammo main), SAS (shotgun), SAH (heavy), SAG (grenade)
    public static final IGunModifier SAM_HOLLOW_POINT = new IGunModifier()
    {
        @Override
        public float additionalDamage() {
            return 2.0F;
        }
        public double additionalProjectileGravity() {
            return 1.0;
        }
        public double modifyProjectileSpeed(double speed) {
            return speed * 0.9F;
        }
        public float modifyProjectileSpread(float spread) {
            return spread * 1.1F;
        }
    };

    public static final IGunModifier SAH_APDS = new IGunModifier()
    {
        public double modifyProjectileGravity(double gravity) {
            return gravity * 0.5F;
        }
        public double modifyProjectileSpeed(double speed) {
            return speed * 1.2F;
        }
        public float modifyProjectileSpread(float spread) {
            return spread * 0.5F;
        }
        public float criticalChance() {
            return 2.0F;
        }
    };

    public static final IGunModifierGC SAS_BIRDSHOT = new IGunModifierGC()
    {
        @Override
        public float modifyProjectileSpread(float spread) {
            return spread * 2F;
        }
        public double moreProjectileAmount() {
            return 6.0F;
        }
    };

}
