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
    //注册水怪，最大堆叠数为1，稀有度：稀有，是否抗火：抗火，所属物品组：水怪，静态常量以便后续调用
    public static final WaterMaster WATERMASTER = (WaterMaster) registerItem("watermaster",
            new WaterMaster(new FabricItemSettings().maxCount(1).rarity(EPIC).fireproof()),
            ModItemGroup.WATERMASTER,ItemGroups.INGREDIENTS);
    //已注册对象，未放在创造模式物品栏
    public static final Item ZLYSWORD = registerItem("zlysword",
            new Item(new FabricItemSettings()));

    //注册蓝精灵猫，其他属性默认（如最大堆叠数），稀有度：稀有，作为食物：作为附魔金苹果（全部属性，实现效果与附魔金苹果一样），所属物品组：水怪
    public static final Item SMURFSCAT = registerItem("smurfscat",
            new Item(new FabricItemSettings().rarity(EPIC).food(ENCHANTED_GOLDEN_APPLE)),
            ModItemGroup.WATERMASTER,ItemGroups.INGREDIENTS);
    //批量注册物品，传参：物品名，物品对象，所属物品组（可以传入多个物品组）
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
