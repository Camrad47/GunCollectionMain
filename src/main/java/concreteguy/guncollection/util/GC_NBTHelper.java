package concreteguy.guncollection.util;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

public class GC_NBTHelper {

    public static CompoundTag getOrCreateCompound(CompoundTag tag, String name){
        if(!tag.contains(name))
            tag.put(name, new CompoundTag());
        return tag.getCompound(name);
    }

    public static CompoundTag getModMainTagForItemStack(ItemStack is){
        CompoundTag tag = is.getOrCreateTag();
        return getOrCreateCompound(tag, "efm");
    }

}
