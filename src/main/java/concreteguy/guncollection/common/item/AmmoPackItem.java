package concreteguy.guncollection.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Author: Autovw
 */
public class AmmoPackItem extends Item {
    public AmmoPackItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltips, TooltipFlag flag) {
        super.appendHoverText(stack, world, tooltips, flag);

        if (!Screen.hasShiftDown()) {
            tooltips.add(Component.translatable("tooltip.guncollection.hold_shift_key", Component.literal("[SHIFT]").withStyle(ChatFormatting.YELLOW)));
        } else {
            tooltips.add(Component.translatable("tooltip.guncollection.ammo_pack_info").withStyle(ChatFormatting.RED));
        }
    }
}
