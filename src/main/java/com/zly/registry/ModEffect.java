package com.zly.registry;

import com.zly.Effect.WMStatusEffect;
import com.zly.ZlyMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffect {
    public static final StatusEffect WATERMASTER = new WMStatusEffect();

    public static void registerModEffect() {
        Registry.register(Registries.STATUS_EFFECT, new Identifier(ZlyMod.MOD_ID, "watermaster"), WATERMASTER);
    }
}
