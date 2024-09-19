package concreteguy.guncollection.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mrcrayfish.guns.client.SpecialModels;
import com.mrcrayfish.guns.client.util.RenderUtil;
import concreteguy.guncollection.entities.agiGrenadeEntity;
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
public class agiGrenadeRenderer extends EntityRenderer<agiGrenadeEntity>
{
    public agiGrenadeRenderer(EntityRendererProvider.Context context)
    {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(agiGrenadeEntity entity)
    {
        return null;
    }

    @Override
    public void render(agiGrenadeEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource renderTypeBuffer, int light)
    {
        if(!entity.getProjectile().isVisible() || entity.tickCount <= 1)
        {
            return;
        }

        poseStack.pushPose();
        Minecraft.getInstance().getItemRenderer().renderStatic(entity.getItem(), ItemDisplayContext.NONE, 15728880, OverlayTexture.NO_OVERLAY, poseStack, renderTypeBuffer, entity.level, 0);
        poseStack.translate(0, -1, 0);
        RenderUtil.renderModel(SpecialModels.FLAME.getModel(), entity.getItem(), poseStack, renderTypeBuffer, 15728880, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
    }
}
