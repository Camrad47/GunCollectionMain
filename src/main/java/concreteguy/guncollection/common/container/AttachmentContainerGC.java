package concreteguy.guncollection.common.container;

import com.mrcrayfish.guns.common.Gun;
import com.mrcrayfish.guns.common.container.AttachmentContainer;
import com.mrcrayfish.guns.item.attachment.IAttachment;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

public class AttachmentContainerGC extends AttachmentContainer {

    public AttachmentContainerGC(int windowId, Inventory playerInventory, ItemStack stack) {
        super(windowId, playerInventory, stack);
    }

}
