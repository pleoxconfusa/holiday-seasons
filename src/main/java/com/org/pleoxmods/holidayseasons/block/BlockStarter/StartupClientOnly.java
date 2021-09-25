package com.org.pleoxmods.holidayseasons.block.BlockStarter;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class StartupClientOnly {
    @SubscribeEvent
    public static void onClientStartupEvent(FMLClientSetupEvent event){
        RenderTypeLookup.setRenderLayer(StartupCommon.blockStarter, RenderType.getSolid());
    }
}
