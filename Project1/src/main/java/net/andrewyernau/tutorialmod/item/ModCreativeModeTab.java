package net.andrewyernau.tutorialmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab TUTORIAL_TAB= new CreativeModeTab("firsttab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.BARITE.get());
        }
    };
}
