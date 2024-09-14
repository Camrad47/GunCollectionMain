package concreteguy.guncollection.client.render.gun.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.mrcrayfish.guns.client.render.gun.IOverrideModel;
import com.mrcrayfish.guns.client.util.RenderUtil;
import com.mrcrayfish.guns.common.Gun;
import concreteguy.guncollection.client.SpecialModels;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public class gc_sks_m59_66_gl_customModel implements IOverrideModel {


    @Override
    public void render(float partialTicks, ItemDisplayContext display, ItemStack stack, ItemStack parent, @Nullable LivingEntity entity, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay)
    {
        poseStack.pushPose();
        poseStack.mulPose(Axis.XN.rotationDegrees(-15F));
        RenderUtil.renderModel(SpecialModels.GC_SKS_M59_66_GL_MAIN.getModel(), stack, poseStack, buffer, light, overlay);
        poseStack.popPose();

        if (Gun.hasAmmo(stack)){
        poseStack.mulPose(Axis.XN.rotationDegrees(-15F));
        RenderUtil.renderModel(SpecialModels.GC_M70_RIFLE_GRENADE.getModel(), stack, poseStack, buffer, light, overlay);}
    }

    private double easeInOutBack(double x)
    {
        return 1 - Math.pow(1 - (2 * x), 4);
    }
}
