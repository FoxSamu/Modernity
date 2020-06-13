package modernity.common.levelgen.biome;

import com.google.common.collect.Sets;
import it.unimi.dsi.fastutil.longs.Long2ObjectLinkedOpenHashMap;
import modernity.common.levelgen.util.IBiomeExporter;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;

public class LayeredBiomeProvider extends BiomeProvider {


    public LayeredBiomeProvider() {
        super( Sets.newHashSet() );
    }

    @Override
    public Biome getNoiseBiome( int x, int y, int z ) {
        return y * 4 > 128 ? Biomes.THE_VOID : Biomes.THE_END;
    }
}
