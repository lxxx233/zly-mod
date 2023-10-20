package com.zly.Entity.custom;
/*
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class CarEntity extends AnimalEntity implements GeoAnimatable {
    public static final RawAnimation CAR_MOVE = RawAnimation.begin().thenLoop("animation.car.drive");
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);
    public CarEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }


    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    protected <E extends CarEntity> PlayState predicate(final AnimationState<E> event){
        //if(event.isMoving())
            //return event.setAndContinue(CAR_MOVE);
        return PlayState.STOP;
    }
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        //controllerRegistrar.add(new AnimationController<>(this, "controller", 5, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }

    @Override
    public double getTick(Object o) {
        return 0;
    }
}
*/