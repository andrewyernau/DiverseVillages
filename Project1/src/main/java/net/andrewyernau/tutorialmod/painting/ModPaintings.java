package net.andrewyernau.tutorialmod.painting;

import net.andrewyernau.tutorialmod.TutorialMod;

import net.minecraft.world.entity.decoration.PaintingVariant;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, TutorialMod.MOD_ID);


    public static final RegistryObject<PaintingVariant> TREE =  PAINTING_VARIANTS.register("tree",
            ()-> new PaintingVariant(64,48));
    public static final RegistryObject<PaintingVariant> WIZARD =  PAINTING_VARIANTS.register("wizard",
            ()-> new PaintingVariant(48,32));
    public static final RegistryObject<PaintingVariant> TULIP =  PAINTING_VARIANTS.register("tulip",
            ()-> new PaintingVariant(16,32));


    public static void register (IEventBus eventBus){
        PAINTING_VARIANTS.register(eventBus);
    }
}
