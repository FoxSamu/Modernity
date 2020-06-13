package modernity.common.dimension;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.biome.FuzzedBiomeMagnifier;
import net.minecraft.world.biome.IBiomeMagnifier;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.function.BiFunction;

public final class MDDimensions {
    public static final ModDimension THE_MODERNITY = new ModDimension() {
        @Override
        public BiFunction<World, DimensionType, ? extends Dimension> getFactory() {
            return ModernityDimension::new;
        }

        @Override
        public IBiomeMagnifier getMagnifier() {
            return FuzzedBiomeMagnifier.INSTANCE;
        }
    };

    private MDDimensions() {
    }

    public static void registerDimensions( IForgeRegistry<ModDimension> registry ) {
        THE_MODERNITY.setRegistryName( "modernity:the_modernity" );
        registry.register( THE_MODERNITY );
    }

    @SubscribeEvent
    public static void setupDimensions( RegisterDimensionsEvent event ) {
        DimensionManager.registerOrGetDimension( new ResourceLocation( "modernity:the_modernity" ), THE_MODERNITY, null, false );
    }
}
