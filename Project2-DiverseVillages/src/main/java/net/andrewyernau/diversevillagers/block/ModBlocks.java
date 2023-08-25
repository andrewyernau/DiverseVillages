package net.andrewyernau.diversevillagers.block;

import com.mojang.blaze3d.shaders.Uniform;
import net.andrewyernau.diversevillagers.DiverseVillagers;
import net.andrewyernau.diversevillagers.block.custom.MiningTable;
import net.andrewyernau.diversevillagers.item.ModCreativeModeTab;
import net.andrewyernau.diversevillagers.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS= DeferredRegister.create(ForgeRegistries.BLOCKS, DiverseVillagers.MOD_ID);

    public static final RegistryObject<Block> MINING_TABLE=registerBlock("mining_table",
            ()->new MiningTable(BlockBehaviour.Properties.of(Material.WOOD).strength(5f).sound(SoundType.WOOD).noOcclusion()), ModCreativeModeTab.DIVERSE_VILLAGERS_TAB);


    private static<T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T>toReturn=BLOCKS.register(name,block);
        registerBlockItem(name,toReturn,tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item>registerBlockItem(String name,RegistryObject<T> block,CreativeModeTab tab){
        return ModItems.ITEMS.register(name,()-> new BlockItem(block.get(),new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}