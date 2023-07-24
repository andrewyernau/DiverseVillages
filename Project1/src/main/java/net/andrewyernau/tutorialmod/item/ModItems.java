package net.andrewyernau.tutorialmod.item;

import net.andrewyernau.tutorialmod.TutorialMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
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
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
