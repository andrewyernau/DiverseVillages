package net.andrewyernau.tutorialmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.andrewyernau.tutorialmod.TutorialMod;
import net.andrewyernau.tutorialmod.entity.custom.GloomjawEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GloomjawRenderer extends GeoEntityRenderer<GloomjawEntity> {
    public GloomjawRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GloomjawModel());
        this.shadowRadius=0.9f;
    }

    @Override
    public ResourceLocation getTextureLocation(GloomjawEntity instance) {
        return new ResourceLocation(TutorialMod.MOD_ID,"textures/entity/gloomjaw_texture.png");
    }

    @Override
    public RenderType getRenderType(GloomjawEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {

        stack.scale(1f,1f,1f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
