package com.zly.registry;

import com.zly.ZlyMod;
import com.zly.items.WaterMaster;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import net.minecraft.registry.Registry;

import static net.minecraft.item.FoodComponents.ENCHANTED_GOLDEN_APPLE;
import static net.minecraft.util.Rarity.EPIC;

public class ModItems {
    //注册水怪，最大堆叠数为1
    public static final WaterMaster WATERMASTER = (WaterMaster) registerItem("watermaster",
            new WaterMaster(new FabricItemSettings().maxCount(1).rarity(EPIC).fireproof()),
            ModItemGroup.WATERMASTER,ItemGroups.INGREDIENTS);
    public static final Item ZLYSWORD = registerItem("zlysword",
            new Item(new FabricItemSettings()));

    public static final Item SMURFSCAT = registerItem("smurfscat",
            new Item(new FabricItemSettings().rarity(EPIC).food(ENCHANTED_GOLDEN_APPLE)),
            ModItemGroup.WATERMASTER,ItemGroups.INGREDIENTS);
    //注册物品组
    public static Item registerItem(String name, Item item, RegistryKey<ItemGroup>... itemGroups){
        Item registerItem = Registry.register(Registries.ITEM, new Identifier(ZlyMod.MOD_ID, name), item);
        for (RegistryKey<ItemGroup> itemGroup: itemGroups){
            ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.add(registerItem));
        }
        return registerItem;
    }
    public static void registerModItems(){
        ZlyMod.LOGGER.debug("Registering mod items for"+ZlyMod.MOD_ID);
    }


}
