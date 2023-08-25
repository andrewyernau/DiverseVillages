package net.andrewyernau.diversevillagers.villager;

import com.google.common.collect.ImmutableSet;
import net.andrewyernau.diversevillagers.DiverseVillagers;
import net.andrewyernau.diversevillagers.block.ModBlocks;
import net.andrewyernau.diversevillagers.DiverseVillagers;
import net.andrewyernau.diversevillagers.block.ModBlocks;
import net.andrewyernau.diversevillagers.sound.ModSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, DiverseVillagers.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS,DiverseVillagers.MOD_ID);

    public static final RegistryObject<PoiType> MINING_TABLE_POI =POI_TYPES.register("mining_table_poi",
            ()->new PoiType(ImmutableSet.copyOf(ModBlocks.MINING_TABLE.get().getStateDefinition().getPossibleStates()),1,1));
    public static final RegistryObject<VillagerProfession>MINE_MASTER =VILLAGER_PROFESSIONS.register("miner",
            ()-> new VillagerProfession("miner",x->x.get()== MINING_TABLE_POI.get(),
                    x->x.get()== MINING_TABLE_POI.get(),ImmutableSet.of(),ImmutableSet.of(),
                    SoundEvents.BEEHIVE_WORK));

    public static void registerPOIs(){
        try{
            ObfuscationReflectionHelper.findMethod(PoiType.class,"registerBlockStates", PoiType.class)
                    .invoke(null, MINING_TABLE_POI.get());
        }catch  (InvocationTargetException | IllegalAccessException exception){
            exception.printStackTrace();
        }
    }
    public static void register (IEventBus eventBus){
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
