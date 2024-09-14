package concreteguy.guncollection.common.item.attachment.impl;

import com.mrcrayfish.guns.interfaces.IGunModifier;
import com.mrcrayfish.guns.item.attachment.impl.Attachment;
import concreteguy.guncollection.common.item.attachment.IAttachmentGC;
import com.mrcrayfish.guns.item.attachment.impl.Stock;
import concreteguy.guncollection.interfaces.IGunModifierGC;


public class SpecialAmmunitionMain extends AttachmentGC
{
    private SpecialAmmunitionMain(IGunModifierGC... modifier)
    {
        super(modifier);
    }

    public static SpecialAmmunitionMain create(IGunModifierGC... modifier)
    {
        return new SpecialAmmunitionMain(modifier);
    }
}
