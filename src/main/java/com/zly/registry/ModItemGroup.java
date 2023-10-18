package com.zly.registry;

import com.zly.ZlyMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    /*private static Object RegistryKeys;*/
    /*public static ItemGroup WATERMASTER = FabricItemGroup.builder()
                .displayName(Text.translatable("itemgroup.zly-mod.watermaster"))
                .icon(() -> new ItemStack(ModItems.WATERMASTER))
                .entries((context, entries) -> {
                    entries.add(ModItems.WATERMASTER);
                })
                .build();*/
    //注册zly-mod的物品组，使用图标及名称均为水怪，写为静态常量以便后续调用
    public static RegistryKey<ItemGroup> WATERMASTER = RegistryKey.of(RegistryKeys.ITEM_GROUP,
            new Identifier(ZlyMod.MOD_ID,"watermaster"));
    //注册物品组函数
    public static void registerModItemGroup(){
        ZlyMod.LOGGER.debug("Registering mod items for"+ZlyMod.MOD_ID);//debug输出函数，在控制台显示
        Registry.register(Registries.ITEM_GROUP,WATERMASTER,//水怪物品组注册，传参：物品组对象，自定义物品组对象
                FabricItemGroup.builder()                   //fabric物品组注册api
                        .displayName(Text.translatable("itemgroup.zly-mod.watermaster"))//物品组名设定
                        .icon(()->new ItemStack(ModItems.WATERMASTER))//图标设定
                        .build());
    }
}
