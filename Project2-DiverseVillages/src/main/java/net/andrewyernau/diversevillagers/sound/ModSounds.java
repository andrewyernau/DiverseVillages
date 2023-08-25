package net.andrewyernau.diversevillagers.sound;

import net.andrewyernau.diversevillagers.DiverseVillagers;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS=
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DiverseVillagers.MOD_ID);

    public static final RegistryObject<SoundEvent>VILLAGER_FOUND_MINING_TABLE=
            registerSoundEvent("villager_found_mining_table");

    public static RegistryObject<SoundEvent> registerSoundEvent(String name){
        return SOUND_EVENTS.register(name,()->new SoundEvent(new ResourceLocation(DiverseVillagers.MOD_ID,name)));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
