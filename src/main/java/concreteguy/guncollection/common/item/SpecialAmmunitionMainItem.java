package concreteguy.guncollection.common.item;

import com.mrcrayfish.guns.item.AttachmentItem;
import com.mrcrayfish.guns.item.IColored;
import concreteguy.guncollection.common.item.attachment.impl.SpecialAmmunitionMain;
import concreteguy.guncollection.common.item.attachment.ISpecialAmmunitionMain;
import com.mrcrayfish.guns.item.attachment.IStock;
import concreteguy.guncollection.common.item.attachment.IAttachmentGC;
import com.mrcrayfish.guns.item.attachment.impl.Stock;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

/**
 * A basic stock attachment item implementation with color support
 *
 * Author: MrCrayfish
 */
public class SpecialAmmunitionMainItem extends AttachmentItem implements ISpecialAmmunitionMain, IColored
{
    private final SpecialAmmunitionMain special_ammunition_main;
    private final boolean colored;

    public SpecialAmmunitionMainItem(SpecialAmmunitionMain special_ammunition_main, Properties properties)
    {
        super(properties);
        this.special_ammunition_main = special_ammunition_main;
        this.colored = true;
    }

    public SpecialAmmunitionMainItem(SpecialAmmunitionMain special_ammunition_main, Properties properties, boolean colored)
    {
        super(properties);
        this.special_ammunition_main = special_ammunition_main;
        this.colored = colored;
    }

    @Override
    public SpecialAmmunitionMain getProperties()
    {
        return this.special_ammunition_main;
    }

    @Override
    public boolean canColor(ItemStack stack)
    {
        return this.colored;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment)
    {
        return enchantment == Enchantments.BINDING_CURSE || super.canApplyAtEnchantingTable(stack, enchantment);
    }
}
