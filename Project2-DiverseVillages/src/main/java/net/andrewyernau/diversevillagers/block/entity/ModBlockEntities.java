package net.andrewyernau.diversevillagers.block.entity;

import net.andrewyernau.diversevillagers.DiverseVillagers;
import net.andrewyernau.diversevillagers.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>>BLOCK_ENTITIES=
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DiverseVillagers.MOD_ID);
    public static final RegistryObject<BlockEntityType<MiningTableBlockEntity>> MINING_TABLE=
            BLOCK_ENTITIES.register("mining_table",()->
                    BlockEntityType.Builder.of(MiningTableBlockEntity::new,
                            ModBlocks.MINING_TABLE.get()).build(null));


    public static void register(IEventBus eventbus){
        BLOCK_ENTITIES.register(eventbus);
    }
}
