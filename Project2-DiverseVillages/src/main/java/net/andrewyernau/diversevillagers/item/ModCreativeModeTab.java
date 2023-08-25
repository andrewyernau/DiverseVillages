package net.andrewyernau.diversevillagers.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModCreativeModeTab {
    public static final CreativeModeTab DIVERSE_VILLAGERS_TAB= new CreativeModeTab("diverse_villagers_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.CARROT);
        }
    };
}
