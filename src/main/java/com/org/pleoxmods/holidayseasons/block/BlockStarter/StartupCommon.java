package com.org.pleoxmods.holidayseasons.block.BlockStarter;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class StartupCommon {
    public static BlockStarter blockStarter;
    public static BlockItem itemBlockStarter;

    @SubscribeEvent
    public static void onBlocksRegistration(final RegistryEvent.Register<Block> blockRegisterEvent){
        blockStarter = (BlockStarter)(new BlockStarter().setRegistryName("holidayseasons", "hsb01_block_starter_registry_name"));
        blockRegisterEvent.getRegistry().register(blockStarter);
    }

    @SubscribeEvent
    public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent){
        // max stack of our holiday block
        final int MAXIMUM_STACK = 64;

        Item.Properties itemStarterProperties = new Item.Properties()
                .maxStackSize(MAXIMUM_STACK)
                .group(ItemGroup.BUILDING_BLOCKS);
        itemBlockStarter = new BlockItem(blockStarter, itemStarterProperties);
        itemBlockStarter.setRegistryName(blockStarter.getRegistryName());
        itemRegisterEvent.getRegistry().register(itemBlockStarter);
    }

    @SubscribeEvent
    public static void onCommonSetupEvent(FMLCommonSetupEvent event){
        // TODO:
    }
}
