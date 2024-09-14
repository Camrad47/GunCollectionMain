package concreteguy.guncollection.common.item;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.RegistryObject;

public class EnchantmentWrapperGC {
    public RegistryObject<Enchantment> enchantment;
    public int level;

    public EnchantmentWrapperGC(RegistryObject<Enchantment> enchantment, int i) {
        this.enchantment = enchantment;
        this.level = i;
    }
}