package net.andrewyernau.diversevillagers.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.andrewyernau.diversevillagers.DiverseVillagers;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.client.event.ScreenEvent;

public class MiningTableScreen extends AbstractContainerScreen<MiningTableMenu> {
    private static final ResourceLocation TEXTURE=
            new ResourceLocation(DiverseVillagers.MOD_ID,"textures/gui/mining_table_gui.png");//not added yet
    public MiningTableScreen(MiningTableMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
    }

    @Override
    protected void renderBg(PoseStack stack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionShader);
        RenderSystem.setShaderColor(1.0F,1.0F,1.0F,1.0F);
        RenderSystem.setShaderTexture(0,TEXTURE);
        int x=(width-imageWidth)/2;
        int y=(height-imageHeight)/2;

        this.blit(stack,x,y,0,0,imageWidth,imageHeight);
        renderProgressArrow(stack,x,y);
    }

    private void renderProgressArrow(PoseStack pPoseStack,int x, int y){
        if(menu.isCrafting()){
            blit(pPoseStack,x+105,y+33,176,0,8, menu.getScaledProgress());
        }
    }
    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY,float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack,mouseX,mouseY,delta);
        renderTooltip(pPoseStack,mouseX,mouseY);
    }

}
