package concreteguy.guncollection.client.render.gun.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mrcrayfish.guns.client.render.gun.IOverrideModel;
import com.mrcrayfish.guns.client.util.RenderUtil;
import com.mrcrayfish.guns.common.Gun;
import concreteguy.guncollection.client.SpecialModels;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public class gc_ak_zastava_m70_customModel implements IOverrideModel {

    @Override
    public void render(float partialTicks, ItemDisplayContext display, ItemStack stack, ItemStack parent, @Nullable LivingEntity entity, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay)
    {
        RenderUtil.renderModel(SpecialModels.GC_AK_ZASTAVA_M70_MAIN.getModel(), stack, poseStack, buffer, light, overlay);
        RenderUtil.renderModel(SpecialModels.GC_AK_ZASTAVA_M70_GL_SIGHT_DOWN.getModel(), stack, poseStack, buffer, light, overlay);

        float cooldown = 0F;
        if(entity != null && entity.equals(Minecraft.getInstance().player))
        {
            ItemCooldowns tracker = Minecraft.getInstance().player.getCooldowns();
            cooldown = tracker.getCooldownPercent(stack.getItem(), Minecraft.getInstance().getFrameTime());
            cooldown = (float) easeInOutBack(cooldown);
        }

        if (Gun.hasAmmo(stack)){
            poseStack.pushPose();
            poseStack.translate(0, -5.8 * 0.0625, 0);
            poseStack.translate(0, 0, cooldown/8);
            poseStack.translate(0, 5.8 * 0.0625, 0);
            RenderUtil.renderModel(SpecialModels.GC_AKM_BOLT.getModel(), display, null, stack, parent, poseStack, buffer, light, overlay);
            poseStack.popPose();
        } else {
            poseStack.translate(0, 0, 0.12);
            RenderUtil.renderModel(SpecialModels.GC_AKM_BOLT.getModel(), display, null, stack, parent, poseStack, buffer, light, overlay);
        }

    }

    private double easeInOutBack(double x)
    {
        return 1 - Math.pow(1 - (2 * x), 4);
    }
}
