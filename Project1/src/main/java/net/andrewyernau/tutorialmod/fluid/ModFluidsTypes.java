package net.andrewyernau.tutorialmod.fluid;

import com.mojang.math.Vector3f;
import net.andrewyernau.tutorialmod.TutorialMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluidsTypes {
    public static final ResourceLocation WATER_STILL_RL= new ResourceLocation("block/water_still");

    public static final ResourceLocation WATER_FLOWING_RL= new ResourceLocation("block/water_flow");

    public static final ResourceLocation SOAP_OVERLAY_RL= new ResourceLocation("misc/in_soap_water");

    public static final DeferredRegister<FluidType> FLUID_TYPES=
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, TutorialMod.MOD_ID);

    public static final RegistryObject<FluidType>SOAP_WATER_FLUID_TYPE=register("soap_water_fluid",
            FluidType.Properties.create().lightLevel(3).viscosity(10).density(10).sound(SoundAction.get("drink"), SoundEvents.HONEY_BLOCK_FALL));

    public static RegistryObject<FluidType>register (String name,FluidType.Properties properties){
        return FLUID_TYPES.register(name,()-> new BaseFluidType(WATER_STILL_RL,WATER_FLOWING_RL,SOAP_OVERLAY_RL,
                0xA128d4ff,new Vector3f(40f/255f,212f/255f,255f/255f),properties));
    }
    public static void register(IEventBus eventBus){
        FLUID_TYPES.register(eventBus);
    }
}
