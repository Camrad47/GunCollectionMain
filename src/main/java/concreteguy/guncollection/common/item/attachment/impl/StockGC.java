package concreteguy.guncollection.common.item.attachment.impl;

import concreteguy.guncollection.interfaces.IGunModifierGC;

public class StockGC extends AttachmentGC {
    private StockGC(IGunModifierGC... modifier) {
        super(modifier);
    }

    public static StockGC create(IGunModifierGC... modifier) {
        return new StockGC(modifier);
    }
}
