package concreteguy.guncollection.interfaces;

public interface IGunModifierGC {
    default float modifyFireSoundVolume(float volume) {
        return volume;
    }

    default boolean silencedFire() {
        return false;
    }

    default double modifyFireSoundRadius(double radius) {
        return radius;
    }

    default float additionalDamage() {
        return 0.0F;
    }

    default float modifyProjectileDamage(float damage) {
        return damage;
    }

    default double modifyProjectileSpeed(double speed) {
        return speed;
    }

    default float modifyProjectileSpread(float spread) {
        return spread;
    }

    default double additionalProjectileGravity() {
        return 0.0;
    }

    default double modifyProjectileGravity(double gravity) {
        return gravity;
    }

    default int modifyProjectileLife(int life) {
        return life;
    }

    default float recoilModifier() {
        return 1.0F;
    }

    default float kickModifier() {
        return 1.0F;
    }

    default double moreProjectileAmount() {
        return 0.0F;
    }

    /** @deprecated */
    @Deprecated(
            since = "1.3.0",
            forRemoval = true
    )
    default double modifyMuzzleFlashSize(double size) {
        return size;
    }

    default double modifyMuzzleFlashScale(double scale) {
        return scale;
    }

    default double modifyAimDownSightSpeed(double speed) {
        return speed;
    }

    default int modifyFireRate(int rate) {
        return rate;
    }

    default float criticalChance() {
        return 0.0F;
    }
}

