package concreteguy.guncollection;

import concreteguy.guncollection.common.item.GunCollectionItem;
import concreteguy.guncollection.core.registry.ItemRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author Autovw
 */
public class GunCollectionTab {
    GunCollectionTab() {
    }

    @SubscribeEvent
    public void onRegisterCreativeModeTab(final CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(GunCollection.ID), builder -> {
            builder.title(Component.translatable("itemGroup." + GunCollection.ID));
            builder.icon(() -> {
                ItemStack stack = ItemRegistry.GC_PP2000.get().getDefaultInstance();
                stack.getOrCreateTag().putBoolean("IgnoreAmmo", true);
                return stack;
            });
            builder.displayItems((flags, entries) -> {
                ItemRegistry.ITEMS.getEntries().stream().map(RegistryObject::get).forEach((entry) -> {
                    if (entry instanceof GunCollectionItem gunItem) {
                        ItemStack stack = gunItem.getDefaultInstance();
                        stack.getOrCreateTag().putInt("AmmoCount", gunItem.getGun().getGeneral().getMaxAmmo());
                        entries.accept(stack);
                    } else {
                        entries.accept(entry);
                    }
                });
            });
        });
    }
}
