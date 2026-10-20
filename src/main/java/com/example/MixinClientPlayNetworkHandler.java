package net.fabricmc.example;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPlayNetworkHandler;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class MixinClientPlayNetworkHandler {

    @Inject(method = "handleSetEntityMotion", at = @At("HEAD"), cancellable = true)
    private void onVelocityPacket(ClientboundSetEntityMotionPacket packet, CallbackInfo ci) {
        Minecraft mc = Minecraft.getInstance();
        
        if (mc.player != null && packet.getId() == mc.player.getId() && SuperVisuals.velocityEnabled) {
            ci.cancel();
        }
    }
}
