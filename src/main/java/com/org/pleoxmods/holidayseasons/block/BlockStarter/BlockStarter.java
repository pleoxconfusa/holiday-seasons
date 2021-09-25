package com.org.pleoxmods.holidayseasons.block.BlockStarter;


import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;

public class BlockStarter extends Block{
    public BlockStarter(){
        super(Block.Properties.create(Material.ROCK));
    }

    @Override
    public BlockRenderType getRenderType(BlockState blockState) {
        return BlockRenderType.MODEL;
    }
}
