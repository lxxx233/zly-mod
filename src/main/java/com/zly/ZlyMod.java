package com.zly;

import com.zly.registry.*;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZlyMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "zly-mod";
    public static final Logger LOGGER = LoggerFactory.getLogger("zly-mod");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		ModItemGroup.registerModItemGroup();//调用物品组注册
		ModItems.registerModItems();//调用物注册
		ModEffect.registerModEffect();//调用自定义效果注册
		ModEvent.registerModEvent();//调用自定义事件注册，已弃用，该事件为修改剪羊毛掉落钻石事件
		ModBlocks.registerModBlocks();//调用方块注册
	}
}