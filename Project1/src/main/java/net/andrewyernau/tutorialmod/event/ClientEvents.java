package net.andrewyernau.tutorialmod.event;

import net.andrewyernau.tutorialmod.TutorialMod;
import net.andrewyernau.tutorialmod.client.ManaHUDOverlay;
import net.andrewyernau.tutorialmod.networking.ModMessages;
import net.andrewyernau.tutorialmod.networking.packet.CanalizeC2SPacket;
import net.andrewyernau.tutorialmod.networking.packet.TEMPLATEC2SPacket;
import net.andrewyernau.tutorialmod.util.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID,value = Dist.CLIENT)
    public static class ClientForgeEvents{
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event){
            event.register(KeyBinding.CANALIZING_KEY);
        }
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event){// KEY PRESSED IN THE CLIENT BUT SENT TO THE SERVER
            if(KeyBinding.CANALIZING_KEY.consumeClick()) {
                ModMessages.sendToServer(new CanalizeC2SPacket());
            }
        }
    }
    @Mod.EventBusSubscriber(modid=TutorialMod.MOD_ID,value=Dist.CLIENT,bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents{
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event){
            event.register(KeyBinding.CANALIZING_KEY);
        }
        @SubscribeEvent
        public static void registerGuiOverlays(RegisterGuiOverlaysEvent event){
            event.registerAboveAll("mana", ManaHUDOverlay.HUD_MANA);
        }
        }

}
