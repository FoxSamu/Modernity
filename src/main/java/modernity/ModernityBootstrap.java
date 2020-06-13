package modernity;

import modernity.client.ModernityClient;
import modernity.common.Modernity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod( "modernity" )
public class ModernityBootstrap {
    public static final Logger LOGGER = LogManager.getLogger();

    private final Modernity proxy = DistExecutor.safeRunForDist( () -> ModernityClient::new, () -> Modernity::new );

    public ModernityBootstrap() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener( this::setup );
        FMLJavaModLoadingContext.get().getModEventBus().addListener( this::loadComplete );

        LOGGER.info( "Modernity loading" );

        MinecraftForge.EVENT_BUS.register( proxy );

        proxy.preInit();
    }

    private void setup( FMLCommonSetupEvent event ) {
        proxy.init();
    }

    private void loadComplete( FMLLoadCompleteEvent event ) {
        proxy.postInit();
    }
}
