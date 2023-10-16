package com.zly.event;


import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

public interface GiveWMEffect {

    Event<GiveWMEffect> EVENT =
            EventFactory.createArrayBacked(
                            GiveWMEffect.class,
                            (listeners)->
                                    (player,sheep)->{
                                            for(GiveWMEffect listener : listeners){
                                                    ActionResult result = listener.interact(player,sheep);
                                                    if(result != ActionResult.PASS) {
                                                        return result;
                                                    }
                                            }
                            return ActionResult.PASS;
                            }

                            );

    ActionResult interact(PlayerEntity player, SheepEntity sheep);

}
