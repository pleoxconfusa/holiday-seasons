package com.org.pleoxmods.holidayseasons.items;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup HOLIDAY_SEASONS_GROUP = new ItemGroup("holidaySeasonsGroup"){
        @Override
        public ItemStack createIcon(){ return new ItemStack(ItemUtils.HSB01_STARTER_BLOCK.get());}
    };
}
