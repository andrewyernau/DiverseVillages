package net.andrewyernau.diversevillagers.item;

import net.andrewyernau.diversevillagers.DiverseVillagers;
import net.andrewyernau.diversevillagers.block.ModBlocks;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DiverseVillagers.MOD_ID);


    public static final RegistryObject<Item> BRUTE_DIAMOND= ITEMS.register("brute_diamond",
            ()->new Item(new Item.Properties().tab(ModCreativeModeTab.DIVERSE_VILLAGERS_TAB)));






    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
