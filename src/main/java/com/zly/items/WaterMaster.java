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

public class WaterMaster extends Item {
    public WaterMaster(Settings settings){
        super(settings);
    }

    private final int maxDamage = 64;
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        /*if (this.isFood()) {
            ItemStack itemStack = user.getStackInHand(hand);
            if (user.canConsume(this.getFoodComponent().isAlwaysEdible())) {
                user.setCurrentHand(hand);
                return TypedActionResult.consume(itemStack);
            }
            return TypedActionResult.fail(itemStack);
        }*/
        if(hand == Hand.MAIN_HAND){
            user.playSound(BlockSoundGroup.ANVIL.getPlaceSound(),3,4);
            user.setHealth(50.0f);
            //world.createExplosion(user,user.getX(),user.getY(),user.getZ(),10.0,true,Explosion.DestructionType.DESTROY);
            Explosion.DestructionType x ;
            Explosion.DestructionType y = Explosion.DestructionType.DESTROY;
            world.createExplosion(user, user.getX(), user.getY() ,user.getZ() ,10.0f, true , World.ExplosionSourceType.TNT);
        }
        //手持物品增加watermaster效果
        user.addStatusEffect(new StatusEffectInstance(ModEffect.WATERMASTER,200,1));
        return TypedActionResult.pass(user.getStackInHand(hand));
    }
}
