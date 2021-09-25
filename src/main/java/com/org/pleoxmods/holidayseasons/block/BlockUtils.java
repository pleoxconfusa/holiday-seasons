package com.org.pleoxmods.holidayseasons.block;

import com.org.pleoxmods.holidayseasons.HolidaySeasons;
import com.org.pleoxmods.holidayseasons.items.ItemUtils;
import com.org.pleoxmods.holidayseasons.items.ModItemGroup;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class BlockUtils {

    private static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, HolidaySeasons.MODID);

    public static final RegistryObject<Block> HSB01_STARTER_BLOCK = registerBlock("hsb01_block_starter",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
            .harvestLevel(2).setRequiresTool().harvestTool(ToolType.HOE).hardnessAndResistance(5f)));

    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItem(String name, Supplier<T> block){
        ItemUtils.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.HOLIDAY_SEASONS_GROUP)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
