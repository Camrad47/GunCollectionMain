package concreteguy.guncollection.common.item;

import com.mrcrayfish.guns.item.GunItem;
import concreteguy.guncollection.config.Config;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

/**
 * Author: Autovw
 */
public class GunCollection_alt_Item extends GunItem {

    private final boolean canColor;
    /**
     * @param properties The item properties
     * @param canColor If the gun can be colored or not
     */
    public GunCollection_alt_Item(Properties properties, boolean canColor) {
        super(properties);
        this.canColor = canColor;

    }

    @Override
    public boolean hasCraftingRemainingItem() {
        return true;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
        return new ItemStack(this);
    }

    /**
     * Makes it possible to disable the enchantment glint on guns client-side.
     */
    @Override
    public boolean isFoil(ItemStack stack) {
        if (stack.isEnchanted()) {
            return Config.Client.enableGunEnchantmentGlint.get();
        }
        else {
            return false;
        }
    }


}
