package concreteguy.guncollection.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.mrcrayfish.guns.entity.GrenadeEntity;
import concreteguy.guncollection.entities.RifleGrenadeEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;

/**
 * Author: MrCrayfish
 */
public class RifleGrenadeRenderer extends EntityRenderer<RifleGrenadeEntity>
{
    public RifleGrenadeRenderer(EntityRendererProvider.Context context)
    {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(RifleGrenadeEntity entity)
    {
        return null;
    }

    @Override
    public void render(RifleGrenadeEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource renderTypeBuffer, int light)
    {
        if(!entity.getProjectile().isVisible() || entity.tickCount <= 1)
        {
            return;
        }

        poseStack.pushPose();
        poseStack.mulPose(Axis.XP.rotationDegrees(180F));
        poseStack.mulPose(Axis.XP.rotationDegrees(entityYaw));
        poseStack.mulPose(Axis.XP.rotationDegrees(entity.getXRot()));

        /* Offsets to the center of the grenade before applying rotation */
        float rotation = entity.tickCount + partialTicks;
        poseStack.translate(0.0, 0.0, 0);
        poseStack.mulPose(Axis.XN.rotationDegrees(rotation * 20));
        poseStack.translate(0, -0.15, 0);

        poseStack.translate(0.0, 0.5, 0.0);

        Minecraft.getInstance().getItemRenderer().renderStatic(entity.getItem(), ItemDisplayContext.NONE, light, OverlayTexture.NO_OVERLAY, poseStack, renderTypeBuffer, entity.level, 0);
        poseStack.popPose();
    }
}
