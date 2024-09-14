package concreteguy.guncollection.mixin;

import com.mrcrayfish.guns.common.Gun;
import com.mrcrayfish.guns.init.ModEnchantments;
import com.mrcrayfish.guns.item.GunItem;
import com.mrcrayfish.guns.util.GunEnchantmentHelper;
import concreteguy.guncollection.common.item.EnchantmentWrapperGC;
import concreteguy.guncollection.common.item.GunCollectionItem;
import concreteguy.guncollection.core.registry.ItemRegistry;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GunEnchantmentHelper.class)
public class GCGunEnchantmentHelperMixin {

}

