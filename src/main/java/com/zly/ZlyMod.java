package com.zly;

import com.zly.registry.ModEffect;
import com.zly.registry.ModEvent;
import com.zly.registry.ModItemGroup;
import com.zly.registry.ModItems;
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
		ModItemGroup.registerModItemGroup();
		ModItems.registerModItems();
		ModEffect.registerModEffect();
		ModEvent.registerModEvent();
	}
}