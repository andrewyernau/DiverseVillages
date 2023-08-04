package net.andrewyernau.tutorialmod.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.andrewyernau.tutorialmod.TutorialMod;
import net.andrewyernau.tutorialmod.energy.PlayerMana;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

import java.util.HashMap;
import java.util.Map;

public class ManaHUDOverlay {
    private static final ResourceLocation FILLED_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/filled_mana.png");
    private static final ResourceLocation EMPTY_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/empty_mana.png");
    private static final ResourceLocation TW_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/25_mana.png");
    private static final ResourceLocation FT_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/50_mana.png");
    private static final ResourceLocation SF_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/75_mana.png");
    private static final ResourceLocation O_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/100_mana.png");
    private static final ResourceLocation OTW_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/125_mana.png");
    private static final ResourceLocation OFT_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/150_mana.png");
    private static final ResourceLocation OSF_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/175_mana.png");
    private static final ResourceLocation T_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/200_mana.png");
    private static final ResourceLocation TTW_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/225_mana.png");
    private static final ResourceLocation TFT_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/250_mana.png");
    private static final ResourceLocation TSF_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/275_mana.png");
    private static final ResourceLocation TH_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/300_mana.png");
    private static final ResourceLocation THTW_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/325_mana.png");
    private static final ResourceLocation THFT_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/350_mana.png");
    private static final ResourceLocation THSF_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/375_mana.png");
    private static final ResourceLocation F_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/400_mana.png");
    private static final ResourceLocation FTW_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/425_mana.png");
    private static final ResourceLocation FFT_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/450_mana.png");
    private static final ResourceLocation FSF_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/475_mana.png");
    private static final ResourceLocation FI_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/500_mana.png");
    private static final ResourceLocation FITW_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/525_mana.png");
    private static final ResourceLocation FIFT_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/550_mana.png");
    private static final ResourceLocation FISF_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/575_mana.png");
    private static final ResourceLocation S_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/600_mana.png");
    private static final ResourceLocation STW_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/625_mana.png");
    private static final ResourceLocation SFT_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/650_mana.png");
    private static final ResourceLocation SSF_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/675_mana.png");
    private static final ResourceLocation SE_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/700_mana.png");
    private static final ResourceLocation SETW_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/725_mana.png");
    private static final ResourceLocation SEFT_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/750_mana.png");
    private static final ResourceLocation SESF_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/775_mana.png");
    private static final ResourceLocation E_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/800_mana.png");
    private static final ResourceLocation ETW_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/825_mana.png");
    private static final ResourceLocation EFT_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/850_mana.png");
    private static final ResourceLocation ESF_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/875_mana.png");
    private static final ResourceLocation N_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/900_mana.png");
    private static final ResourceLocation NTW_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/925_mana.png");
    private static final ResourceLocation NFT_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/950_mana.png");
    private static final ResourceLocation NSF_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/975_mana.png");

    private static final ResourceLocation OO_MANA= new ResourceLocation(TutorialMod.MOD_ID,"textures/mana/1000_mana.png");
    private static final Map<Integer, ResourceLocation> MANA_TEXTURES = new HashMap<>();

    static {
        // Initialize the MANA_TEXTURES map
        MANA_TEXTURES.put(0, EMPTY_MANA);
        MANA_TEXTURES.put(25, TW_MANA);
        MANA_TEXTURES.put(50, FT_MANA);
        MANA_TEXTURES.put(75, SF_MANA);
        MANA_TEXTURES.put(100, O_MANA);
        MANA_TEXTURES.put(125, OTW_MANA);
        MANA_TEXTURES.put(150, OFT_MANA);
        MANA_TEXTURES.put(175, OSF_MANA);
        MANA_TEXTURES.put(200, T_MANA);
        MANA_TEXTURES.put(225, TTW_MANA);
        MANA_TEXTURES.put(250, TFT_MANA);
        MANA_TEXTURES.put(275, TSF_MANA);
        MANA_TEXTURES.put(300, TH_MANA);
        MANA_TEXTURES.put(325, THTW_MANA);
        MANA_TEXTURES.put(350, THFT_MANA);
        MANA_TEXTURES.put(375, THSF_MANA);
        MANA_TEXTURES.put(400, F_MANA);
        MANA_TEXTURES.put(425, FTW_MANA);
        MANA_TEXTURES.put(450, FFT_MANA);
        MANA_TEXTURES.put(475, FSF_MANA);
        MANA_TEXTURES.put(500, FI_MANA);
        MANA_TEXTURES.put(525, FITW_MANA);
        MANA_TEXTURES.put(550, FIFT_MANA);
        MANA_TEXTURES.put(575, FISF_MANA);
        MANA_TEXTURES.put(600, S_MANA);
        MANA_TEXTURES.put(625, STW_MANA);
        MANA_TEXTURES.put(650, SFT_MANA);
        MANA_TEXTURES.put(675, SSF_MANA);
        MANA_TEXTURES.put(700, SE_MANA);
        MANA_TEXTURES.put(725, SETW_MANA);
        MANA_TEXTURES.put(750, SEFT_MANA);
        MANA_TEXTURES.put(775, SESF_MANA);
        MANA_TEXTURES.put(800, E_MANA);
        MANA_TEXTURES.put(825, ETW_MANA);
        MANA_TEXTURES.put(850, EFT_MANA);
        MANA_TEXTURES.put(875, ESF_MANA);
        MANA_TEXTURES.put(900, N_MANA);
        MANA_TEXTURES.put(925, NTW_MANA);
        MANA_TEXTURES.put(950, NFT_MANA);
        MANA_TEXTURES.put(975, NSF_MANA);
        MANA_TEXTURES.put(999, OO_MANA);
        MANA_TEXTURES.put(1000, FILLED_MANA);

    }
    public static final IGuiOverlay HUD_MANA = ((gui, poseStack, partialTick, width, height) -> {
        int x = width / 2;
        int y = height;

        int playerMana = ClientManaData.getPlayerMana();

        RenderSystem.setShader(GameRenderer::getPositionShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        for (int manaValue : MANA_TEXTURES.keySet()) {
            if (playerMana >= manaValue) {
                ResourceLocation texture = MANA_TEXTURES.get(manaValue);
                RenderSystem.setShaderTexture(0, texture);
                GuiComponent.blit(poseStack, x + 240, y - 85, 0, 0, 10, 78, 10, 78);
            }
        }

        //Check for playerMana is greater than the maximum value in MANA_TEXTURES, use FILLED_MANA
        if (playerMana > MANA_TEXTURES.keySet().stream().max(Integer::compareTo).orElse(0)) {
            RenderSystem.setShaderTexture(0, FILLED_MANA);
            GuiComponent.blit(poseStack, x + 240, y - 85, 0, 0, 10, 78, 10, 78);
        }
    });

}
