package net.andrewyernau.tutorialmod.world.feature;

import net.andrewyernau.tutorialmod.TutorialMod;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, TutorialMod.MOD_ID);

    public static final RegistryObject<PlacedFeature>BARITE_ORE_PLACED=PLACED_FEATURES.register("barite_ore_placed",
            ()->new PlacedFeature(ModConfiguredFeatures.BARITE_ORE.getHolder().get(),
                    commonOrePlacement(7,//venas por chunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80),
                                    VerticalAnchor.aboveBottom(80)))));

    public static List<PlacementModifier> orePlacement(PlacementModifier placementModifier,PlacementModifier placementModifier2){
        return List.of(placementModifier, InSquarePlacement.spread(),placementModifier2, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int integer,PlacementModifier placementModifier){
        return orePlacement(CountPlacement.of(integer),placementModifier);
    }

    public static List<PlacementModifier> rareOrePlacement(int integer,PlacementModifier placementModifier){
        return orePlacement(RarityFilter.onAverageOnceEvery(integer),placementModifier);
    }
    public static void  register(IEventBus eventBus){
        PLACED_FEATURES.register(eventBus);
    }

}
