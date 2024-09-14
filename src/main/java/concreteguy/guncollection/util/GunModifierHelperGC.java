package concreteguy.guncollection.util;

import com.mrcrayfish.guns.common.Gun;
import com.mrcrayfish.guns.interfaces.IGunModifier;
import com.mrcrayfish.guns.item.attachment.IAttachment;
import com.mrcrayfish.guns.util.GunModifierHelper;
import concreteguy.guncollection.common.GunGC;
import concreteguy.guncollection.common.item.attachment.IAttachmentGC;
import concreteguy.guncollection.interfaces.IGunModifierGC;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;

public class GunModifierHelperGC extends GunModifierHelper {

    private static final IGunModifierGC[] EMPTY = {};

    private static IGunModifierGC[] getModifiers(ItemStack weapon, IAttachmentGC.Type type)
    {
        ItemStack stack = GunGC.getAttachment(type, weapon);
        if(!stack.isEmpty() && stack.getItem() instanceof IAttachmentGC<?> attachment)
        {
            return attachment.getProperties().getModifiers();
        }
        return EMPTY;
    }

    public static float getProjectileAmount(ItemStack weapon)
    {
        float projectileAmount = 0.0F;
        for(int i = 0; i < IAttachmentGC.Type.values().length; i++)
        {
            IGunModifierGC[] modifiers = getModifiers(weapon, IAttachmentGC.Type.values()[i]);
            for(IGunModifierGC modifier : modifiers)
            {
                projectileAmount += modifier.moreProjectileAmount();
            }
        }
        return Mth.clamp(projectileAmount, 1, Integer.MAX_VALUE);
    }

}
