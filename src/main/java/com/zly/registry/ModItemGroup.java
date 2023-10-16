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
    public static RegistryKey<ItemGroup> WATERMASTER = RegistryKey.of(RegistryKeys.ITEM_GROUP,
            new Identifier(ZlyMod.MOD_ID,"watermaster"));
    public static void registerModItemGroup(){
        ZlyMod.LOGGER.debug("Registering mod items for"+ZlyMod.MOD_ID);
        Registry.register(Registries.ITEM_GROUP,WATERMASTER,
                FabricItemGroup.builder()
                        .displayName(Text.translatable("itemgroup.zly-mod.watermaster"))
                        .icon(()->new ItemStack(ModItems.WATERMASTER))
                        .build());
    }
}
