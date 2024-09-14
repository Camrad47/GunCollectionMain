package concreteguy.guncollection.common.item;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.RegistryObject;

public class GC_EnchantmentWrapper {
    public RegistryObject<Enchantment> enchantment;
    public int level;

    public GC_EnchantmentWrapper(RegistryObject<Enchantment> enchantment, int i) {
        this.enchantment = enchantment;
        this.level = i;
    }
}