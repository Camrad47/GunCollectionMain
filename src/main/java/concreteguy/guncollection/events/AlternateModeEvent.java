package concreteguy.guncollection.events;

import com.mrcrayfish.guns.event.GunFireEvent.Post;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.mrcrayfish.guns.network.PacketHandler;
import com.mrcrayfish.guns.network.message.C2SMessageUnload;
import concreteguy.guncollection.GunCollection;
import concreteguy.guncollection.client.MoreKeyBinds;
import concreteguy.guncollection.core.registry.ItemRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.mrcrayfish.guns.interfaces.IGunModifier;

/**
 * I am trying to do something but know nothing
 */
@Mod.EventBusSubscriber(modid = GunCollection.ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AlternateModeEvent {

    private int recoilAngle;
    private double recoilKick;

    @SubscribeEvent
    public static void on_press (Post event) {

        Player player = event.getEntity();
        ItemStack heldItem = player.getMainHandItem();
        CompoundTag tag = heldItem.getTag();

        if (heldItem.getItem() == ItemRegistry.GC_AKMS.get() && tag != null) {

            if(MoreKeyBinds.KEY_ALTERNATE.isDown());


        }

    }
    
}