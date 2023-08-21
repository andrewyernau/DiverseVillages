package net.andrewyernau.tutorialmod.block.entity;

import net.andrewyernau.tutorialmod.TutorialMod;
import net.andrewyernau.tutorialmod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>>BLOCK_ENTITIES=
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TutorialMod.MOD_ID);
   public static final RegistryObject<BlockEntityType<WizardTableBlockEntity>> WIZARD_TABLE=
           BLOCK_ENTITIES.register("wizard_table",()->
                   BlockEntityType.Builder.of(WizardTableBlockEntity::new,
                           ModBlocks.WIZARD_TABLE.get()).build(null));

    public static void register(IEventBus eventbus){
        BLOCK_ENTITIES.register(eventbus);
    }
}
