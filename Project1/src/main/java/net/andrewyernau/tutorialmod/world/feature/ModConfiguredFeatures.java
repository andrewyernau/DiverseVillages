package net.andrewyernau.tutorialmod.world.feature;

import com.google.common.base.Suppliers;
import net.andrewyernau.tutorialmod.TutorialMod;
import net.andrewyernau.tutorialmod.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.io.ObjectInputFilter;
import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?,?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, TutorialMod.MOD_ID);

  public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_BARITE_ORES = Suppliers.memoize(()->List.of(
          OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.BARITE_STONE_ORE.get().defaultBlockState()),
          OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.BARITE_DEEPSLATE_ORE.get().defaultBlockState())));
  /*PARA NETHER Y END no lo agrego porque no es mi plan de momento
  *  public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_BARITE_ORES = Suppliers.memoize(()->List.of(
          OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.BARITE_NETHER_ORE.get().defaultBlockState())));
          *
          *  public static final Supplier<List<OreConfiguration.TargetBlockState>> END_BARITE_ORES = Suppliers.memoize(()->List.of(
          OreConfiguration.target(new Block MatchTest(Blocks.END_STONE),ModBlocks.ENDSTONE_BARITE_ORE.get......
  * */
    public static final RegistryObject<ConfiguredFeature<?,?>> BARITE_ORE=CONFIGURED_FEATURES.register("barite_ore",
          ()-> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(OVERWORLD_BARITE_ORES.get(),7)));
    public static void  register(IEventBus eventBus){
        CONFIGURED_FEATURES.register(eventBus);
    }

}
