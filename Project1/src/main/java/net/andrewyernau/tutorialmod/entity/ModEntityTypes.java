package net.andrewyernau.tutorialmod.entity;

import net.andrewyernau.tutorialmod.TutorialMod;
import net.andrewyernau.tutorialmod.entity.custom.GloomjawEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TutorialMod.MOD_ID);

    public static final RegistryObject<EntityType<GloomjawEntity>> GLOOMJAW =
            ENTITY_TYPES.register("gloomjaw",
                    () -> EntityType.Builder.of(GloomjawEntity::new, MobCategory.MONSTER)
                            .sized(2f, 2f)
                            .build(new ResourceLocation(TutorialMod.MOD_ID, "gloomjaw").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}