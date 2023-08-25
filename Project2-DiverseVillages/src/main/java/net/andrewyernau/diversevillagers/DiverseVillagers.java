package net.andrewyernau.diversevillagers;

import com.mojang.logging.LogUtils;
import net.andrewyernau.diversevillagers.block.ModBlocks;
import net.andrewyernau.diversevillagers.block.entity.ModBlockEntities;
import net.andrewyernau.diversevillagers.item.ModItems;
import net.andrewyernau.diversevillagers.recipe.ModRecipes;
import net.andrewyernau.diversevillagers.screen.MiningTableScreen;
import net.andrewyernau.diversevillagers.screen.ModMenuTypes;
import net.andrewyernau.diversevillagers.sound.ModSounds;
import net.andrewyernau.diversevillagers.villager.ModVillagers;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

@Mod(DiverseVillagers.MOD_ID)
public class DiverseVillagers
{

    public static final String MOD_ID = "diversevillagers";
    private static final Logger LOGGER = LogUtils.getLogger();

    public DiverseVillagers()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModVillagers.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModSounds.register(modEventBus);
        ModMenuTypes.register(modEventBus);


        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(()->{
            ModVillagers.registerPOIs();
        });
    }



    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
            MenuScreens.register(ModMenuTypes.MINING_TABLE_MENU.get(), MiningTableScreen::new);
        }
    }
}
