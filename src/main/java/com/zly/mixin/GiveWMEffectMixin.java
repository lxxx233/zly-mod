package com.zly.mixin;

import com.zly.event.GiveWMEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SheepEntity.class)
public class GiveWMEffectMixin {//已弃用该Mixin方法，此方法用于修改剪羊毛掉落钻石事件
    //@Inject(at = @At(value = "INVOKE",target = "Lnet/minecraft/entity/passive/SheepEntity;dropItems()V"),method = "interact",cancellable = true)
    private void onEffect(Entity player, Hand hand, CallbackInfoReturnable<ActionResult> info  ){
        ActionResult result = GiveWMEffect.EVENT.invoker().interact((PlayerEntity)player, (SheepEntity) (Object) this);
        if(result == ActionResult.FAIL){
            info.cancel();
        }
    }
}