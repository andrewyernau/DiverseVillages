package net.andrewyernau.tutorialmod.block;

import com.mojang.blaze3d.shaders.Uniform;
import net.andrewyernau.tutorialmod.TutorialMod;
import net.andrewyernau.tutorialmod.block.custom.BariumLampBlock;
import net.andrewyernau.tutorialmod.block.custom.JumpyBlock;
import net.andrewyernau.tutorialmod.block.custom.*;
import net.andrewyernau.tutorialmod.fluid.ModFluids;
import net.andrewyernau.tutorialmod.item.ModCreativeModeTab;
import net.andrewyernau.tutorialmod.item.ModItems;
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
    public static final DeferredRegister<Block> BLOCKS= DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> BARIUM_BLOCK=registerBlock("barium_block",
            ()->new Block(BlockBehaviour.Properties.of(Material.METAL).strength(7f).requiresCorrectToolForDrops()), ModCreativeModeTab.TUTORIAL_TAB);
    public static final RegistryObject<Block> BARITE_STONE_ORE=registerBlock("barite_stone_ore",
            ()->new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.TUTORIAL_TAB);
    public static final RegistryObject<Block> BARITE_DEEPSLATE_ORE=registerBlock("barite_deepslate_ore",
            ()->new Block(BlockBehaviour.Properties.of(Material.STONE).strength(7f).requiresCorrectToolForDrops()), ModCreativeModeTab.TUTORIAL_TAB);
    public static final RegistryObject<Block> SERPENTINE=registerBlock("serpentine",
            ()->new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.TUTORIAL_TAB);
    public static final RegistryObject<Block> JUMPY_BLOCK=registerBlock("jumpy_block",
            ()->new JumpyBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.TUTORIAL_TAB);
    public static final RegistryObject<Block> BARIUM_LAMP=registerBlock("barium_lamp_block",
            ()->new BariumLampBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(3f).lightLevel(blockState->blockState.getValue(BariumLampBlock.LIT)?15:0)), ModCreativeModeTab.TUTORIAL_TAB);
    public static final RegistryObject<Block> NATURE_TABLE=registerBlock("nature_table",
            ()->new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f)), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> WIZARD_TABLE=registerBlock("wizard_table",
            ()->new WizardTable(BlockBehaviour.Properties.of(Material.WOOD).strength(6f).noOcclusion()), ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> RICE_CROP=BLOCKS.register("rice_crop",
            ()->new RiceCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<LiquidBlock> SOAP_WATER_BLOCK=BLOCKS.register("soap_water_block",
            ()-> new LiquidBlock(ModFluids.SOURCE_SOAP_WATER,BlockBehaviour.Properties.copy(Blocks.WATER)));

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
