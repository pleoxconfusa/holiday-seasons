package com.org.pleoxmods.holidayseasons;
import com.org.pleoxmods.holidayseasons.block.BlockUtils;
import com.org.pleoxmods.holidayseasons.items.ItemUtils;
import com.org.pleoxmods.holidayseasons.seasons.SeasonHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import com.tterrag.registrate.Registrate;

@Mod(HolidaySeasons.MOD_ID)
public class HolidaySeasons {

    public static final String MOD_ID = "holidayseasons";
    public static final Logger LOGGER = LogManager.getLogger();

    private static final String PROTOCOL_VERSION = "1";

//    public static final Registrate REGISTRATE = Registrate.create(MOD_ID);

    public HolidaySeasons(){
        // registering set up method
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemUtils.register(eventBus);
        BlockUtils.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::enqueueIMC);
        eventBus.addListener(this::processIMC);
        eventBus.addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void loadSeasonalBlocks(){
        // this is it. this is the whole mod
        SeasonHelper seasonHelper = new SeasonHelper();
        seasonHelper.getSeasonalBlocks().stream().forEach(sb -> sb.registerBlock());
    }

    private void setup(final FMLCommonSetupEvent event){
        LOGGER.info("PREINIT STUFF");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
//        seasonHelper.loadSeasons(REGISTRATE);
    }

    private void doClientStuff(final FMLClientSetupEvent event){
        // for client only actions
    }

    private void enqueueIMC(final InterModEnqueueEvent event){
        InterModComms.sendTo("examplemod", "helloworld", () -> {
            LOGGER.info("Hello world from MDK");
            return "Hello world";
        });
    }

    private void processIMC(final InterModProcessEvent event){
    }


    // subscribe event to let event bus discover our methods
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event){
        LOGGER.info("Starting the server");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
