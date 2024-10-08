package concreteguy.guncollection.common.item;

import com.mrcrayfish.guns.item.AttachmentItem;
import com.mrcrayfish.guns.item.IColored;
import com.mrcrayfish.guns.item.attachment.IScope;
import com.mrcrayfish.guns.item.attachment.impl.Scope;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

/**
 * A basic scope attachment item implementation with color support
 *
 * Author: MrCrayfish
 */
public class NightScopeItem extends AttachmentItem implements IScope, IColored
{
    private final Scope scope;
    private final boolean colored;

    public NightScopeItem(Scope scope, Properties properties)
    {
        super(properties);
        this.scope = scope;
        this.colored = true;
    }

    public NightScopeItem(Scope scope, Properties properties, boolean colored)
    {
        super(properties);
        this.scope = scope;
        this.colored = colored;
    }

    @Override
    public Scope getProperties()
    {
        return this.scope;
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
