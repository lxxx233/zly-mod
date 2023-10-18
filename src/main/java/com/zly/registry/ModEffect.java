package com.zly.registry;

import com.zly.Effect.WMStatusEffect;
import com.zly.ZlyMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffect {
    //注册水怪的祝福效果，为静态常量，以便后续调用
    public static final StatusEffect WATERMASTER = registerEffect("watermaster",new WMStatusEffect());
    //批量注册效果，传参：效果名，效果对象
    public static StatusEffect registerEffect(String name,StatusEffect effect){
        StatusEffect registerEffect = Registry.register(Registries.STATUS_EFFECT, new Identifier(ZlyMod.MOD_ID,name),effect);
        return registerEffect;
    }
    public static void registerModEffect() {
        ZlyMod.LOGGER.debug("Registering mod items for"+ZlyMod.MOD_ID);
    }
}
