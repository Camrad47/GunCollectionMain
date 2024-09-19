package concreteguy.guncollection.client.render.gun.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mrcrayfish.guns.client.GunModel;
import com.mrcrayfish.guns.client.render.gun.IOverrideModel;
import com.mrcrayfish.guns.client.util.RenderUtil;
import com.mrcrayfish.guns.common.Gun;
import com.mrcrayfish.guns.item.attachment.IAttachment;
import concreteguy.guncollection.client.SpecialModels;
import concreteguy.guncollection.core.registry.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public class gc_apb_pistol_customModel implements IOverrideModel {

    @SuppressWarnings("resource")
    @Override
    public void render(float partialTicks, ItemDisplayContext display, ItemStack stack, ItemStack parent, @Nullable LivingEntity entity, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay)
    {
        BakedModel bakedModel = SpecialModels.GC_APB_PISTOL_MAIN.getModel();
        Minecraft.getInstance().getItemRenderer().render(stack, ItemDisplayContext.NONE, false, poseStack, buffer, light, overlay, GunModel.wrap(bakedModel));

        float cooldown = 0F;
        if(entity != null && entity.equals(Minecraft.getInstance().player))
        {
            ItemCooldowns tracker = Minecraft.getInstance().player.getCooldowns();
            cooldown = tracker.getCooldownPercent(stack.getItem(), Minecraft.getInstance().getFrameTime());
            cooldown = (float) easeInOutBack(cooldown);
        }

        ItemStack attachmentStack = Gun.getAttachment(IAttachment.Type.STOCK, stack);
        if(!attachmentStack.isEmpty())
        {
            if(Gun.getAttachment(IAttachment.Type.STOCK, stack).getItem() == ItemRegistry.GC_WOOD_STOCK.get())
                RenderUtil.renderModel(SpecialModels.GC_APS_PISTOL_PARTS_WOOD.getModel(), stack, poseStack, buffer, light, overlay);
            if(Gun.getAttachment(IAttachment.Type.STOCK, stack).getItem() == ItemRegistry.GC_METAL_STOCK.get())
                RenderUtil.renderModel(SpecialModels.GC_APS_PISTOL_PARTS_METAL.getModel(), stack, poseStack, buffer, light, overlay);
            if(Gun.getAttachment(IAttachment.Type.STOCK, stack).getItem() == ItemRegistry.GC_POLYMER_STOCK.get())
                RenderUtil.renderModel(SpecialModels.GC_APS_PISTOL_PARTS_POLYMER.getModel(), stack, poseStack, buffer, light, overlay);
            if(Gun.getAttachment(IAttachment.Type.STOCK, stack).getItem() == ItemRegistry.GC_MARKSMAN_STOCK.get())
                RenderUtil.renderModel(SpecialModels.GC_APS_PISTOL_PARTS_MARKSMAN.getModel(), stack, poseStack, buffer, light, overlay);
            if(Gun.getAttachment(IAttachment.Type.STOCK, stack).getItem() == ItemRegistry.GC_ULTRA_LIGHT_STOCK.get())
                RenderUtil.renderModel(SpecialModels.GC_APS_PISTOL_PARTS_ULTRA_LIGHT.getModel(), stack, poseStack, buffer, light, overlay);
            if(Gun.getAttachment(IAttachment.Type.STOCK, stack).getItem() == ItemRegistry.GC_TACTICAL_SNIPER_STOCK.get())
                RenderUtil.renderModel(SpecialModels.GC_APS_PISTOL_PARTS_TACTICAL_SNIPER.getModel(), stack, poseStack, buffer, light, overlay);
        }

        ItemStack attachmentStack2 = Gun.getAttachment(IAttachment.Type.BARREL, stack);
        if(!attachmentStack2.isEmpty())
        {
            RenderUtil.renderModel(SpecialModels.GC_APB_PISTOL_SILENCER.getModel(), display, null, stack, parent, poseStack, buffer, light, overlay);
        }

        if (Gun.hasAmmo(stack)){
            poseStack.pushPose();
            poseStack.translate(0, -5.8 * 0.0625, 0);
            poseStack.translate(0, 0, cooldown/6);
            poseStack.translate(0, 5.8 * 0.0625, 0);
            RenderUtil.renderModel(SpecialModels.GC_APS_PISTOL_BOLT.getModel(), display, null, stack, parent, poseStack, buffer, light, overlay);
            poseStack.popPose();
        } else {
            poseStack.translate(0, 0, 0.12);
            RenderUtil.renderModel(SpecialModels.GC_APS_PISTOL_BOLT.getModel(), display, null, stack, parent, poseStack, buffer, light, overlay);
        }
    }

    /**
     * Easing function based on code from https://easings.net/#easeInOutBack
     */
    private double easeInOutBack(double x)
    {
        return 1 - Math.pow(1 - (2 * x), 4);
    }
}