package com.zly.Effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

import static net.minecraft.entity.effect.StatusEffects.RESISTANCE;


public class WMStatusEffect extends StatusEffect {
    public WMStatusEffect() {

        super(
                StatusEffectCategory.BENEFICIAL, // 药水效果是有益的还是有害的
                0xFF0000); // 显示的颜色

    }

    // 这个方法在每个 tick 都会调用，以检查是否应应用药水效果
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // 在我们的例子中，为了确保每一 tick 药水效果都会被应用，我们只要这个方法返回 true 就行了。
        return true;
    }

    // 这个方法在应用药水效果时会被调用，所以我们可以在这里实现自定义功能。
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {//调用方法
        if (entity instanceof PlayerEntity) {

            ((PlayerEntity) entity).addExperience(1 << amplifier); // 更高的 amplifier 会加快给予经验的速度
            entity.addStatusEffect(new StatusEffectInstance(RESISTANCE,200,4));
        }
    }
}
