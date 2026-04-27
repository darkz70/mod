package com.darkz.nightvision;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class NightVisionClient implements ClientModInitializer {
    private static final String MOD_ID = "nightvisiontoggle";
    private static final String CATEGORY = "category." + MOD_ID + ".main";

    private static final KeyBinding TOGGLE_KEY = KeyBindingHelper.registerKeyBinding(
            new KeyBinding(
                    "key." + MOD_ID + ".toggle",
                    InputUtil.Type.KEYSYM,
                    GLFW.GLFW_KEY_G,
                    CATEGORY
            )
    );

    private static boolean enabled = false;

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (TOGGLE_KEY.wasPressed()) {
                enabled = !enabled;

                if (client.player != null) {
                    if (!enabled) {
                        client.player.removeStatusEffect(StatusEffects.NIGHT_VISION);
                    }

                    client.player.sendMessage(
                            Text.translatable(enabled
                                    ? "message." + MOD_ID + ".enabled"
                                    : "message." + MOD_ID + ".disabled"),
                            true
                    );
                }
            }

            if (enabled && client.player != null) {
                client.player.addStatusEffect(
                        new StatusEffectInstance(StatusEffects.NIGHT_VISION, 220, 0, true, false, false)
                );
            }
        });
    }
}
