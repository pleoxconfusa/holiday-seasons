package com.org.pleoxmods.holidayseasons.items;

import com.org.pleoxmods.holidayseasons.HolidaySeasons;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemUtils {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HolidaySeasons.MODID);

    public static final RegistryObject<Item> HSB01_STARTER_BLOCK = ITEMS.register("hsb01_block_starter_item",
            () -> new Item(new Item.Properties().group(ModItemGroup.HOLIDAY_SEASONS_GROUP)));

    public static void register(IEventBus eventBus) { ITEMS.register(eventBus);}
}
