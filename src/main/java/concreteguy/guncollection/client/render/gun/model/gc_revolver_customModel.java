package concreteguy.guncollection.client.render.gun.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.mrcrayfish.guns.client.GunModel;
import com.mrcrayfish.guns.client.render.gun.IOverrideModel;
import com.mrcrayfish.guns.client.util.RenderUtil;
import concreteguy.guncollection.client.SpecialModels;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public class gc_revolver_customModel implements IOverrideModel {

    @SuppressWarnings("resource")
    @Override
    public void render(float partialTicks, ItemDisplayContext display, ItemStack stack, ItemStack parent, @Nullable LivingEntity entity, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay)
    {
        BakedModel bakedModel = SpecialModels.GC_REVOLVER_MAIN.getModel();
        Minecraft.getInstance().getItemRenderer().render(stack, ItemDisplayContext.NONE, false, poseStack, buffer, light, overlay, GunModel.wrap(bakedModel));

        // Get the item's cooldown from the user entity, then do some math to make a suitable animation.
        // In this case, we multiply the cooldown value by itself to create a smooth animation.
        boolean isPlayer = (entity != null && entity.equals(Minecraft.getInstance().player) ? true : false);
        float cooldown = 0F;
        if(isPlayer)
        {
            ItemCooldowns tracker = Minecraft.getInstance().player.getCooldowns();
            cooldown = tracker.getCooldownPercent(stack.getItem(), Minecraft.getInstance().getFrameTime());
            cooldown = Math.max((cooldown*2)-1,0);
            cooldown*= cooldown;
        }

        // Rotating cylinder. Cylinder rotates (err, simulates rotation) to its next chamber after firing.
        // Push pose so we can make do transformations without affecting the models above.
        poseStack.pushPose();
        // Now we apply our transformations.
        if(isPlayer)
        {
            // First we set the rotation pivot point by translating the model.
            poseStack.translate(0, -4.42 * 0.0625, 0);
            // Then we rotate the model based on the cooldown variable, creating a smooth rotation effect.
            poseStack.mulPose(Axis.ZN.rotationDegrees(-60F * cooldown));
            // Finally we translate the model back to its intended position.
            poseStack.translate(0, 4.42 * 0.0625, 0);
        }
        // Our transformations are done - now we can render the model.
        RenderUtil.renderModel(SpecialModels.GC_REVOLVER_CYLINDER.getModel(), display, null, stack, parent, poseStack, buffer, light, overlay);
        // Pop pose to compile everything in the render matrix.
        poseStack.popPose();
    }

    /**
     * Easing function based on code from https://easings.net/#easeInOutBack
     */
    private double easeInOutBack(double x)
    {
        return 1 - Math.pow(1 - (2 * x), 4);
    }
}