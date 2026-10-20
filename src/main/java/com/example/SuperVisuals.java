package com.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.Minecraft;

public class SuperVisuals implements ClientModInitializer {
    public static boolean velocityEnabled = true;

    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            Minecraft mc = Minecraft.getInstance();
            if (mc.options.hideGui || mc.player == null) return;

            int fps = Minecraft.fps;
            String text = "§bWEXSIDE STYLE §7| §fFPS: " + fps;

            drawContext.fill(10, 10, drawContext.font().width(text) + 20, 25, 0x90000000);
            drawContext.drawString(mc.font, text, 15, 14, 0xFFFFFF, false);
        });
    }
}
