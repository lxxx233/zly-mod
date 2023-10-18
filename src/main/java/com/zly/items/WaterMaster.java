package com.zly.items;

import com.zly.registry.ModEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class WaterMaster extends Item {//水怪的物品属性修改
    public WaterMaster(Settings settings){
        super(settings);
    }

    //private final int maxDamage = 64;
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {//重写item主类的use方法用于自定义use事件，
                                                                                        // 使得玩家使用物品产生自定义效果
        /*if (this.isFood()) {
            ItemStack itemStack = user.getStackInHand(hand);
            if (user.canConsume(this.getFoodComponent().isAlwaysEdible())) {
                user.setCurrentHand(hand);
                return TypedActionResult.consume(itemStack);
            }
            return TypedActionResult.fail(itemStack);
        }*/
        if(hand == Hand.MAIN_HAND){//在主手上使用物品时发生10倍于tnt的爆炸，并产生火焰，播放铁砧的声音，增加玩家50生命值
            user.playSound(BlockSoundGroup.ANVIL.getPlaceSound(),3,4);//使用物品时播放铁砧的声音
            user.setHealth(50.0f);                                                  //增加玩家50生命值

            //world.createExplosion(user,user.getX(),user.getY(),user.getZ(),10.0,true,Explosion.DestructionType.DESTROY);
            //Explosion.DestructionType x ;
            //Explosion.DestructionType y = Explosion.DestructionType.DESTROY;

            world.createExplosion(                                              //产生爆炸
                    user, user.getX(), user.getY() ,user.getZ() ,               //传入玩家及坐标参数，用于在玩家脚下爆炸
                    10.0f, true , World.ExplosionSourceType.TNT);      //参数：爆炸强度10，产生火焰：是，爆炸类型：tnt
        }
        //手持并使用物品增加watermaster效果
        user.addStatusEffect(new StatusEffectInstance(ModEffect.WATERMASTER,200,1));
        return TypedActionResult.pass(user.getStackInHand(hand));
    }
}
