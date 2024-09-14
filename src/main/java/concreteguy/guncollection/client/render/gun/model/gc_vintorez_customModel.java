package concreteguy.guncollection.client.render.gun.model;

import com.mojang.blaze3d.vertex.PoseStack;
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

public class gc_vintorez_customModel implements IOverrideModel {

    @Override
    public void render(float partialTicks, ItemDisplayContext display, ItemStack stack, ItemStack parent, @Nullable LivingEntity entity, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay)
    {
        RenderUtil.renderModel(SpecialModels.GC_VINTOREZ_MAIN.getModel(), stack, poseStack, buffer, light, overlay);

        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_RIFLEMAN.get())
            RenderUtil.renderModel(SpecialModels.GC_VAL_USP1_BASE.getModel(), stack, poseStack, buffer, light, overlay);

        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_OPTIC.get())
            RenderUtil.renderModel(SpecialModels.GC_VAL_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_OPTIC_LONG.get())
            RenderUtil.renderModel(SpecialModels.GC_VAL_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_ACOG.get())
            RenderUtil.renderModel(SpecialModels.GC_VAL_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_OPTIC_HIGH.get())
            RenderUtil.renderModel(SpecialModels.GC_VAL_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_OPTIC_HIGH_LONG.get())
            RenderUtil.renderModel(SpecialModels.GC_VAL_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_ACOG_TAN.get())
            RenderUtil.renderModel(SpecialModels.GC_VAL_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_OPTIC_TAN.get())
            RenderUtil.renderModel(SpecialModels.GC_VAL_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_OPTIC_LONG_TAN.get())
            RenderUtil.renderModel(SpecialModels.GC_VAL_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_HOLO.get())
            RenderUtil.renderModel(SpecialModels.GC_VAL_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_HOLO_ALT.get())
            RenderUtil.renderModel(SpecialModels.GC_VAL_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_HOLO_TAN.get())
            RenderUtil.renderModel(SpecialModels.GC_VAL_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_HOLO_ALT_TAN.get())
            RenderUtil.renderModel(SpecialModels.GC_VAL_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_OPTIC_HIGH_TAN.get())
            RenderUtil.renderModel(SpecialModels.GC_VAL_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_OPTIC_HIGH_LONG_TAN.get())
            RenderUtil.renderModel(SpecialModels.GC_VAL_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_VALDAY.get())
            RenderUtil.renderModel(SpecialModels.GC_VAL_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_KOBRA.get())
            RenderUtil.renderModel(SpecialModels.GC_VAL_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_OKP.get())
            RenderUtil.renderModel(SpecialModels.GC_VAL_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_COMPACT.get())
            RenderUtil.renderModel(SpecialModels.GC_VAL_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_COMPACT_BROWN.get())
            RenderUtil.renderModel(SpecialModels.GC_VAL_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_RED_DOT.get())
            RenderUtil.renderModel(SpecialModels.GC_VAL_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_RED_DOT_HIGH.get())
            RenderUtil.renderModel(SpecialModels.GC_VAL_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_NVG.get())
            RenderUtil.renderModel(SpecialModels.GC_VAL_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ModItems.SHORT_SCOPE.get())
            RenderUtil.renderModel(SpecialModels.GC_VAL_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ModItems.LONG_SCOPE.get())
            RenderUtil.renderModel(SpecialModels.GC_VAL_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ModItems.MEDIUM_SCOPE.get())
            RenderUtil.renderModel(SpecialModels.GC_VAL_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);

        float cooldown = 0F;
        if(entity != null && entity.equals(Minecraft.getInstance().player))
        {
            ItemCooldowns tracker = Minecraft.getInstance().player.getCooldowns();
            cooldown = tracker.getCooldownPercent(stack.getItem(), Minecraft.getInstance().getFrameTime());
            cooldown = (float) easeInOutBack(cooldown);
        }

        poseStack.pushPose();
        poseStack.translate(0, -5.8 * 0.0625, 0);
        poseStack.translate(0, 0, cooldown/8);
        poseStack.translate(0, 5.8 * 0.0625, 0);
        RenderUtil.renderModel(SpecialModels.GC_VSS_BOLT.getModel(), display, null, stack, parent, poseStack, buffer, light, overlay);
        poseStack.popPose();
    }

    private double easeInOutBack(double x)
    {return 1 - Math.pow(1 - (2 * x), 4);}
}
