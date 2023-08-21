package net.andrewyernau.tutorialmod.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.andrewyernau.tutorialmod.TutorialMod;
import net.andrewyernau.tutorialmod.block.ModBlocks;
import net.andrewyernau.tutorialmod.recipe.WizardTableRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class WizardTableRecipeCategory implements IRecipeCategory<WizardTableRecipe> {
   public final static ResourceLocation UID= new ResourceLocation(TutorialMod.MOD_ID,"wizard_table");
   public final static ResourceLocation TEXTURE=
           new ResourceLocation(TutorialMod.MOD_ID,"textures/gui/wizard_table_gui.png");
   private final IDrawable background;
   private final IDrawable icon;

    public WizardTableRecipeCategory(IGuiHelper helper) {
        this.background =helper.createDrawable(TEXTURE,0,0,176,85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK,new ItemStack(ModBlocks.WIZARD_TABLE.get()));
    }

    @Override
    public RecipeType<WizardTableRecipe> getRecipeType() {
        return JEIModPlugin.INFUSION_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Wizard Table");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, WizardTableRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT,86,15).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.INPUT,86,15).addItemStack(recipe.getResultItem());
    }
}
