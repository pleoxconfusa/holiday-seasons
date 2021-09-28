package com.org.pleoxmods.holidayseasons.block;

import net.minecraft.block.Block;

public abstract class SeasonalBlock extends Block{
    public SeasonalBlock(Properties p) {
        super(p);
    }

    public abstract Block getBlock();
    public abstract void registerBlock();
}
