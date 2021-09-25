package com.org.pleoxmods.holidayseasons;

import net.minecraftforge.eventbus.api.IEventBus;

public class ClientSideOnlyModEventRegistrar {
    private final IEventBus eventBus;

    public ClientSideOnlyModEventRegistrar(IEventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void registerClientOnlyEvents(){
        eventBus.register(com.org.pleoxmods.holidayseasons.block.BlockStarter.StartupClientOnly.class);
    }
}
