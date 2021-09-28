package com.org.pleoxmods.holidayseasons.block.EARLY_WINTER;

import com.org.pleoxmods.holidayseasons.block.SeasonalBlock;
import net.minecraft.block.Block;

class EarlyWinterGrassSeasonalBlock extends SeasonalBlock{

    Block block;
    Registrate registrate;

    public EarlyWinterGrassSeasonalBlock(Properties p) {
        super(p);
    }

    public void registerBlock(){
    }

    @Override
    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }
}