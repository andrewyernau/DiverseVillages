package net.andrewyernau.diversevillagers.recipe;

import net.andrewyernau.diversevillagers.DiverseVillagers;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS=
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, DiverseVillagers.MOD_ID);

    public static final RegistryObject<RecipeSerializer<MiningTableRecipe>> MINING_TABLE_SERIALIZER=
            SERIALIZERS.register("mining_table",()->MiningTableRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus){
        SERIALIZERS.register(eventBus);
    }
}
