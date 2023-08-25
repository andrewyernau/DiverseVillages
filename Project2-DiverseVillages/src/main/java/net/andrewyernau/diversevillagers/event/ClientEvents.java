package net.andrewyernau.diversevillagers.event;

import net.andrewyernau.diversevillagers.DiverseVillagers;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;

import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = DiverseVillagers.MOD_ID,value = Dist.CLIENT)
    public static class ClientForgeEvents{
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event){

        }
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event){// KEY PRESSED IN THE CLIENT BUT SENT TO THE SERVER

        }
    }
    @Mod.EventBusSubscriber(modid=DiverseVillagers.MOD_ID,value=Dist.CLIENT,bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
    }

}
