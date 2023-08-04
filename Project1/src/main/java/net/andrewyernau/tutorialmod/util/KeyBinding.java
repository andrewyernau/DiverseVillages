package net.andrewyernau.tutorialmod.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final  String KEY_CATEGORY_TUTORIAL="key.category.tutorialmod.tutorial";
    public static final  String KEY_CANALIZE="key.category.tutorialmod.canalize";

    public static final KeyMapping CANALIZING_KEY= new KeyMapping(KEY_CANALIZE, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_R,KEY_CATEGORY_TUTORIAL);

}
