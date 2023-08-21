package net.andrewyernau.tutorialmod.entity.client;

import net.andrewyernau.tutorialmod.TutorialMod;
import net.andrewyernau.tutorialmod.entity.custom.GloomjawEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GloomjawModel extends AnimatedGeoModel<GloomjawEntity> {
    @Override
    public ResourceLocation getModelResource(GloomjawEntity object) {
        return new ResourceLocation(TutorialMod.MOD_ID,"geo/gloomjaw.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GloomjawEntity object) {
        return new ResourceLocation(TutorialMod.MOD_ID,"textures/entity/gloomjaw_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GloomjawEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID,"animations/gloomjaw.animation.json");
    }
}
