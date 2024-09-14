package concreteguy.guncollection.client.render.gun.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.mrcrayfish.guns.client.render.gun.IOverrideModel;
import com.mrcrayfish.guns.client.render.gun.model.MiniGunModel;
import com.mrcrayfish.guns.client.util.RenderUtil;
import com.mrcrayfish.guns.common.Gun;
import com.mrcrayfish.guns.init.ModItems;
import com.mrcrayfish.guns.item.attachment.IAttachment;

import concreteguy.guncollection.client.SpecialModels;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mrcrayfish.guns.client.GunModel;
import com.mrcrayfish.guns.client.render.gun.IOverrideModel;
import com.mrcrayfish.guns.client.util.RenderUtil;
import com.mrcrayfish.guns.common.Gun;
import com.mrcrayfish.guns.init.ModSyncedDataKeys;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import javax.annotation.Nullable;
import java.util.WeakHashMap;

import concreteguy.guncollection.core.registry.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms.Deserializer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;

public class gc_mosin_sniper_customModel implements IOverrideModel {

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

            cooldownSigma = (float) easeInOutBack(cooldown1);
            boltMovement = cooldown_d;
            boltPivot = cooldown_g;
        }

        poseStack.translate(0, -5.8 * 0.0625, 0);
        poseStack.mulPose(Axis.ZN.rotationDegrees(-5F * cooldownSigma));
        poseStack.translate(0, 5.8 * 0.0625, 0);
        RenderUtil.renderModel(SpecialModels.GC_MOSIN_SNIPER_MAIN.getModel(), display, null, stack, parent, poseStack, buffer, light, overlay);

        ItemStack attachmentStack = Gun.getAttachment(IAttachment.Type.STOCK, stack);
        if(!attachmentStack.isEmpty())
        {
            if(Gun.getAttachment(IAttachment.Type.STOCK, stack).getItem() == ItemRegistry.GC_WOOD_STOCK.get())
                RenderUtil.renderModel(SpecialModels.GC_MOSIN_SNIPER_PARTS_WOOD.getModel(), stack, poseStack, buffer, light, overlay);
            if(Gun.getAttachment(IAttachment.Type.STOCK, stack).getItem() == ItemRegistry.GC_METAL_STOCK.get())
                RenderUtil.renderModel(SpecialModels.GC_MOSIN_SNIPER_PARTS_METAL.getModel(), stack, poseStack, buffer, light, overlay);
            if(Gun.getAttachment(IAttachment.Type.STOCK, stack).getItem() == ItemRegistry.GC_MARKSMAN_STOCK.get()) {
                RenderUtil.renderModel(SpecialModels.GC_MOSIN_SNIPER_PARTS_MARKSMAN.getModel(), stack, poseStack, buffer, light, overlay);
                if (Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_SIMPLE.get()) {
                    RenderUtil.renderModel(SpecialModels.GC_PU_SNIPER_CAMO.getModel(), stack, poseStack, buffer, light, overlay);}
            }
            if(Gun.getAttachment(IAttachment.Type.STOCK, stack).getItem() == ItemRegistry.GC_POLYMER_STOCK.get())
                RenderUtil.renderModel(SpecialModels.GC_MOSIN_SNIPER_PARTS_POLYMER.getModel(), stack, poseStack, buffer, light, overlay);
            if(Gun.getAttachment(IAttachment.Type.STOCK, stack).getItem() == ItemRegistry.GC_ULTRA_LIGHT_STOCK.get())
                RenderUtil.renderModel(SpecialModels.GC_MOSIN_SNIPER_PARTS_ULTRA_LIGHT.getModel(), stack, poseStack, buffer, light, overlay);
            if(Gun.getAttachment(IAttachment.Type.STOCK, stack).getItem() == ItemRegistry.GC_TACTICAL_SNIPER_STOCK.get()) {
                RenderUtil.renderModel(SpecialModels.GC_MOSIN_SNIPER_PARTS_TACTICAL_SNIPER.getModel(), stack, poseStack, buffer, light, overlay);
                if (Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_SIMPLE.get()) {
                    RenderUtil.renderModel(SpecialModels.GC_PU_SNIPER_CAMO1.getModel(), stack, poseStack, buffer, light, overlay);}
            }
        }
        else
        {
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_SNIPER_PARTS_MAIN.getModel(), display, null, stack, parent, poseStack, buffer, light, overlay);
        }

        poseStack.pushPose();
        poseStack.translate(0, -5.8 * 0.0625, 0);
        poseStack.mulPose(Axis.ZN.rotationDegrees(-90F * Math.min(boltPivot*2F,1)));
        poseStack.translate(0, 0, (boltMovement * 2.5) * 0.0625);
        poseStack.translate(0, 5.8 * 0.0625, 0);
        RenderUtil.renderModel(SpecialModels.GC_MOSIN_SNIPER_BOLT.getModel(), display, null, stack, parent, poseStack, buffer, light, overlay);
        poseStack.popPose();

        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_RIFLEMAN.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_USP1_BASE.getModel(), stack, poseStack, buffer, light, overlay);

        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_SIMPLE.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_PU_BASE.getModel(), stack, poseStack, buffer, light, overlay);

        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_OPTIC.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_OPTIC_LONG.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_ACOG.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_OPTIC_HIGH.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_OPTIC_HIGH_LONG.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_ACOG_TAN.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_OPTIC_TAN.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_OPTIC_LONG_TAN.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_HOLO.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_HOLO_ALT.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_HOLO_TAN.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_HOLO_ALT_TAN.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_OPTIC_HIGH_TAN.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_OPTIC_HIGH_LONG_TAN.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_VALDAY.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_KOBRA.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_OKP.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_COMPACT.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_COMPACT_BROWN.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_RED_DOT.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_RED_DOT_HIGH.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ItemRegistry.GC_SIGHT_NVG.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ModItems.SHORT_SCOPE.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ModItems.LONG_SCOPE.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.SCOPE, stack).getItem() == ModItems.MEDIUM_SCOPE.get())
            RenderUtil.renderModel(SpecialModels.GC_MOSIN_SIGHT_RAIL.getModel(), stack, poseStack, buffer, light, overlay);

    }

    private double easeInOutBack(double x)
    {
        return 1 - Math.pow(1 - (2 * x), 4);
    }
}
