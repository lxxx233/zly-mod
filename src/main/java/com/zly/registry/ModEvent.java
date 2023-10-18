package com.zly.registry;

import com.zly.event.GiveWMEffect;
import com.zly.items.WaterMaster;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;


public class ModEvent {//自定义事件接口的实现，已弃用
    public static void registerModEvent(){


        GiveWMEffect.EVENT.register(
                (
                    (player,sheep) -> {
                        sheep.setSheared(true);

                        // 在绵羊的位置妴钻石
                        ItemStack stack = new ItemStack(Items.DIAMOND);
                        ItemEntity itemEntity = new ItemEntity(player.getWorld(), sheep.getX(), sheep.getY(), sheep.getZ(), stack);
                        player.getWorld().spawnEntity(itemEntity);

                        return ActionResult.FAIL;
                    }
                )

        );
    }
}
