package net.andrewyernau.tutorialmod.villager;

import com.google.common.collect.ImmutableSet;
import net.andrewyernau.tutorialmod.TutorialMod;
import net.andrewyernau.tutorialmod.block.ModBlocks;
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
    public static final DeferredRegister<PoiType> POIT_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, TutorialMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS,TutorialMod.MOD_ID);

  public static final RegistryObject<PoiType> NATURE_TABLE_POI =POIT_TYPES.register("nature_table_poi",
          ()->new PoiType(ImmutableSet.copyOf(ModBlocks.NATURE_TABLE.get().getStateDefinition().getPossibleStates()),1,1));
  public static final RegistryObject<VillagerProfession>NATURE_ENTHUSIAST =VILLAGER_PROFESSIONS.register("nature_enthusiast",()-> new VillagerProfession("nature_enthusiast",x->x.get()== NATURE_TABLE_POI.get(),
          x->x.get()== NATURE_TABLE_POI.get(),ImmutableSet.of(),ImmutableSet.of(),
          SoundEvents.VILLAGER_WORK_BUTCHER));

    public static void registerPOIs(){
        try{
            ObfuscationReflectionHelper.findMethod(PoiType.class,"registerBlockStates", PoiType.class).invoke(null, NATURE_TABLE_POI.get());
        }catch  (InvocationTargetException | IllegalAccessException exception){
            exception.printStackTrace();
        }
    }
    public static void register (IEventBus eventBus){
        POIT_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
