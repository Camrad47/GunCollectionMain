package concreteguy.guncollection.client.render.gun.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.mrcrayfish.guns.client.GunModel;
import com.mrcrayfish.guns.client.render.gun.IOverrideModel;
import com.mrcrayfish.guns.client.util.RenderUtil;
import com.mrcrayfish.guns.common.Gun;
import concreteguy.guncollection.client.SpecialModels;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public class gc_p38_airsoft_customModel implements IOverrideModel {

    @SuppressWarnings("resource")
    @Override
    public void render(float partialTicks, ItemDisplayContext display, ItemStack stack, ItemStack parent, @Nullable LivingEntity entity, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay)
    {
        BakedModel bakedModel = SpecialModels.GC_P38_AIRSOFT_MAIN.getModel();
        Minecraft.getInstance().getItemRenderer().render(stack, ItemDisplayContext.NONE, false, poseStack, buffer, light, overlay, GunModel.wrap(bakedModel));

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
        }

        float cooldown = 0F;
        if(entity != null && entity.equals(Minecraft.getInstance().player))
        {
            ItemCooldowns tracker = Minecraft.getInstance().player.getCooldowns();
            cooldown = tracker.getCooldownPercent(stack.getItem(), Minecraft.getInstance().getFrameTime());
            cooldown = (float) easeInOutBack(cooldown);
        }

        poseStack.pushPose();
        poseStack.translate(0, -5.8 * 0.0625, 0);
        poseStack.translate(0, 0, (boltMovement * 2.5) * 0.0625);
        poseStack.translate(0, 5.8 * 0.0625, 0);
        RenderUtil.renderModel(SpecialModels.GC_P38_BOLT.getModel(), display, null, stack, parent, poseStack, buffer, light, overlay);
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