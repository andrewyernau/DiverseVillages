package net.andrewyernau.tutorialmod.item;

import net.andrewyernau.tutorialmod.TutorialMod;
import net.andrewyernau.tutorialmod.block.ModBlocks;
import net.andrewyernau.tutorialmod.fluid.ModFluids;
import net.andrewyernau.tutorialmod.item.custom.EightBallItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);
    public static final RegistryObject<Item> BARITE= ITEMS.register("barite",
            ()->new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> CRUSHED_BARITE= ITEMS.register("crushed_barite",
            ()->new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> BARIUM= ITEMS.register("barium",
            ()->new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));



    public static final RegistryObject<Item> WOODEN_STAFF= ITEMS.register("wooden_staff",
            ()->new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).stacksTo(1)));



    public static final RegistryObject<Item> RICE_SEEDS= ITEMS.register("rice_seeds",
            ()->new ItemNameBlockItem(ModBlocks.RICE_CROP.get(),new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> RICE= ITEMS.register("rice",
            ()->new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> COOKED_RICE= ITEMS.register("cooked_rice",
            ()->new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).food(new FoodProperties.Builder().nutrition(3).saturationMod(3f).build())));

    public static final RegistryObject<Item>SOAP_WATER_BUCKET= ITEMS.register("soap_water_bucket",
            ()->new BucketItem(ModFluids.SOURCE_SOAP_WATER,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
