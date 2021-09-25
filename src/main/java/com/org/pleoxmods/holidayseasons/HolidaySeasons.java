package com.org.pleoxmods.holidayseasons;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(HolidaySeasons.MODID)
public class HolidaySeasons {

    public static final String MODID = "holidayseasons";
    public static final Logger LOGGER = LogManager.getFormatterLogger(HolidaySeasons.MODID);

    private static final String PROTOCOL_VERSION = "1";

    public HolidaySeasons(){
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        final ClientSideOnlyModEventRegistrar clientSideOnlyModEventRegistrar = new ClientSideOnlyModEventRegistrar(modEventBus);
        registerCommonEvents(modEventBus);
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> clientSideOnlyModEventRegistrar::registerClientOnlyEvents);
    }
    public void registerCommonEvents(IEventBus eventBus) {
        eventBus.register(com.org.pleoxmods.holidayseasons.block.BlockStarter.StartupCommon.class);
        //----------------
        // TODO: eventBus.register(com.org.pleoxmods.usefultools.debugging.StartupCommon.class);
    }
}
