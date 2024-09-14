package concreteguy.guncollection.client;

import com.mrcrayfish.guns.Config;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import org.lwjgl.glfw.GLFW;

/**
 * Author: MrCrayfish
 */
public class MoreKeyBinds
{
    public static final KeyMapping KEY_ALTERNATE = new KeyMapping("key.guncollection.alternate", GLFW.GLFW_KEY_J, "key.categories.cgm");

    public static void registerKeyMappings(RegisterKeyMappingsEvent event)
    {
        event.register(KEY_ALTERNATE);
    }

}
