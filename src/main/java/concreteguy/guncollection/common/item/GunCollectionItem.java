package concreteguy.guncollection.common.item;

import com.mrcrayfish.guns.common.Gun;
import com.mrcrayfish.guns.init.ModEnchantments;
import concreteguy.guncollection.common.item.GC_EnchantmentWrapper;
import concreteguy.guncollection.config.Config;
import concreteguy.guncollection.util.GC_NBTHelper;
import com.mrcrayfish.guns.item.GunItem;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import com.mrcrayfish.guns.util.GunEnchantmentHelper;
import net.minecraft.world.entity.player.Player;
import concreteguy.guncollection.common.item.EnchantmentWrapperGC;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Author: Autovw
 */
public class GunCollectionItem extends GunItem {
    public static int NewReloadInterval;

    private final boolean canColor;
    public final EnchantmentWrapperGC[] enchantments;
    /**
     * @param properties The item properties
     * @param canColor If the gun can be colored or not
     */
    public GunCollectionItem(Properties properties, boolean canColor, EnchantmentWrapperGC[] enchantments) {
        super(properties);
        this.canColor = canColor;
        this.enchantments = enchantments;

    }

    @Override
    public boolean canColor(ItemStack stack) {
        return this.canColor;
    }

    public static int getReloadInterval(ItemStack weapon) {
        int interval = 10;
        int level = NewReloadInterval;
        if (level > -99) {
            interval -= 3 * level;
        }

        return Math.max(interval, 100);
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
