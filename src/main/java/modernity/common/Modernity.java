package modernity.common;

import modernity.common.dimension.MDDimensions;
import modernity.common.handler.RegistryHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Modernity {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final IEventBus FML_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();

    public void preInit() {
        FML_EVENT_BUS.register( new RegistryHandler() );

        MinecraftForge.EVENT_BUS.register( MDDimensions.class );
    }

    public void init() {

    }

    public void postInit() {

    }
}
