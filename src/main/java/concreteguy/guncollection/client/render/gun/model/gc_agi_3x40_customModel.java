package concreteguy.guncollection.client.render.gun.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mrcrayfish.guns.client.render.gun.IOverrideModel;
import com.mrcrayfish.guns.client.util.RenderUtil;
import com.mrcrayfish.guns.common.Gun;
import com.mrcrayfish.guns.init.ModItems;
import com.mrcrayfish.guns.item.attachment.IAttachment;
import concreteguy.guncollection.client.SpecialModels;
import concreteguy.guncollection.core.registry.ItemRegistry;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public class gc_agi_3x40_customModel implements IOverrideModel {

    public static int getAmmoCount(ItemStack gunStack) {
        CompoundTag tag = gunStack.getOrCreateTag();
        if (tag.getBoolean("IgnoreAmmo")) {
            return Integer.MAX_VALUE; // or some large number to indicate unlimited ammo
        }
        return tag.getInt("AmmoCount");
    }

    @Override
    public void render(float partialTicks, ItemDisplayContext display, ItemStack stack, ItemStack parent, @Nullable LivingEntity entity, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay)
    {


            RenderUtil.renderModel(SpecialModels.GC_AGI_3X40_MAIN.getModel(), stack, poseStack, buffer, light, overlay);

        int ammoCount = getAmmoCount(stack);

        if (ammoCount > 0) {
            RenderUtil.renderModel(SpecialModels.GC_AGI_3X40_1_LOADED.getModel(), stack, poseStack, buffer, light, overlay);
        }
        if (ammoCount > 1) {
            RenderUtil.renderModel(SpecialModels.GC_AGI_3X40_2_LOADED.getModel(), stack, poseStack, buffer, light, overlay);
        }
        if (ammoCount > 2) {
            RenderUtil.renderModel(SpecialModels.GC_AGI_3X40_3_LOADED.getModel(), stack, poseStack, buffer, light, overlay);
        }

    }

    private double easeInOutBack(double x)
    {
        return 1 - Math.pow(1 - (2 * x), 4);
    }
}
