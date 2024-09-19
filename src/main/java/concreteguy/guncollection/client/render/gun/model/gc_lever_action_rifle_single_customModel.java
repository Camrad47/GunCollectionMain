package concreteguy.guncollection.client.render.gun.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.mrcrayfish.guns.client.render.gun.IOverrideModel;
import com.mrcrayfish.guns.client.util.RenderUtil;
import com.mrcrayfish.guns.common.Gun;
import com.mrcrayfish.guns.init.ModItems;
import com.mrcrayfish.guns.item.attachment.IAttachment;
import concreteguy.guncollection.client.SpecialModels;
import concreteguy.guncollection.core.registry.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public class gc_lever_action_rifle_single_customModel implements IOverrideModel {

    @SuppressWarnings("resource")
    @Override
    public void render(float partialTicks, ItemDisplayContext display, ItemStack stack, ItemStack parent, @Nullable LivingEntity entity, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay)
    {
        float boltMovement = 0F;
        float boltPivot = 0F;
        float cooldownSigma = 0F;
        if (entity != null && entity.equals(Minecraft.getInstance().player)) {

            float cooldownDivider = 3.0F;
            float cooldownOffset1 = 1.0F;
            float intensity = 1.9F +1;
            float boltLeadTime = 0.4F;

            ItemCooldowns tracker = Minecraft.getInstance().player.getCooldowns();
            float cooldown = tracker.getCooldownPercent(stack.getItem(), Minecraft.getInstance().getFrameTime());
            float cooldown1 = tracker.getCooldownPercent(stack.getItem(), Minecraft.getInstance().getFrameTime());
            cooldown *= cooldownDivider;
            float cooldown_a = cooldown-cooldownOffset1;

            float cooldown_b = Math.min(Math.max(cooldown_a*intensity,0),1);
            float cooldown_c = Math.min(Math.max((-cooldown_a*intensity)+intensity,0),1);
            float cooldown_d = Math.min(cooldown_b,cooldown_c);

            float cooldown_e = Math.min(Math.max(cooldown_a*intensity+boltLeadTime,0),1);
            float cooldown_f = Math.min(Math.max((-cooldown_a*intensity+boltLeadTime)+intensity,0),1);
            float cooldown_g = Math.min(cooldown_e,cooldown_f);

            boltMovement = cooldown_d;
            boltPivot = cooldown_g;
            cooldownSigma = (float) easeInOutBack(cooldown_d);
        }

        poseStack.translate(0, -5.8 * 0.0625, 0);
        poseStack.mulPose(Axis.ZN.rotationDegrees(-30F * boltPivot));
        poseStack.mulPose(Axis.XN.rotationDegrees(-15F * boltPivot));
        poseStack.translate(-(boltMovement * 1.8) * 0.0625, 0, 0);
        poseStack.translate(0, 5.8 * 0.0625, 0);
        RenderUtil.renderModel(SpecialModels.GC_LEVER_ACTION_RIFLE_SINGLE_MAIN.getModel(), display, null, stack, parent, poseStack, buffer, light, overlay);

        poseStack.pushPose();
        poseStack.translate(0, -6.9 * 0.0625, 3.1 * 0.0625);
        poseStack.mulPose(Axis.XN.rotationDegrees(-40F * Math.min(boltPivot*2F,1)));
        poseStack.translate(0, 6.9 * 0.0625, -3.1 * 0.0625);
        RenderUtil.renderModel(SpecialModels.GC_LEVER_ACTION_RIFLE_SINGLE_BOLT.getModel(), display, null, stack, parent, poseStack, buffer, light, overlay);
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