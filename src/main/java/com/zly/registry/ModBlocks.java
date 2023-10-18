package com.zly.registry;

import com.zly.ZlyMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import static net.minecraft.util.Rarity.EPIC;

public class ModBlocks {
    //水怪方块常量,硬度4.0f,抗性4.0f
    public static final Block WATERMASTER_BLOCK=registerBlocks("watermaster_block",//水怪方块常量
            new Block(FabricBlockSettings.create()                                          //可掉落经验方块
                    .hardness(0.4f).strength(0.4f)                                      //硬度4.0f,抗性4.0f
                    .requiresTool()),                                                   //可被工具采集
            EPIC,true,                                                         //稀有级别，防火
            ModItemGroup.WATERMASTER);                                                  //所属物品组

    //方块批量注册函数，传参：方块名，方块对象，方块稀有度，方块是否抗火，所属物品组对象
    public static Block registerBlocks(String name, Block block, Rarity rarity,boolean isfireproof, RegistryKey<ItemGroup>... itemGroups){
        if(isfireproof){//物品是否防火
            ModItems.registerItem(name,new BlockItem(block,new FabricItemSettings().rarity(rarity).fireproof()),itemGroups);
        }else{
            ModItems.registerItem(name,new BlockItem(block,new FabricItemSettings().rarity(rarity)),itemGroups);
        }
        return Registry.register(Registries.BLOCK,new Identifier(ZlyMod.MOD_ID,name),block);
    }

    public static void registerModBlocks(){
        ZlyMod.LOGGER.debug("Registering mod blocks for"+ZlyMod.MOD_ID);
    }
}
