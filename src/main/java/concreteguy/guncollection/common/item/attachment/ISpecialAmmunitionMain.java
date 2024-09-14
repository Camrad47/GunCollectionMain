package concreteguy.guncollection.common.item.attachment;

import com.mrcrayfish.guns.item.attachment.IAttachment;
import concreteguy.guncollection.common.item.attachment.IAttachmentGC;
import concreteguy.guncollection.common.item.attachment.impl.SpecialAmmunitionMain;
import com.mrcrayfish.guns.item.attachment.impl.Stock;

/**
 * An interface to turn an any item into a stock attachment. This is useful if your item extends a
 * custom item class otherwise {@link com.mrcrayfish.guns.item.StockItem} can be used instead of
 * this interface.
 * <p>
 * Author: MrCrayfish
 */
public interface ISpecialAmmunitionMain extends IAttachmentGC<SpecialAmmunitionMain>
{
    /**
     * @return The type of this attachment
     */
    @Override
    default Type getType()
    {
        return Type.SPECIAL_AMMUNITION_MAIN;
    }
}
