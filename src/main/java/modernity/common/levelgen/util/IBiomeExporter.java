package modernity.common.levelgen.util;

import net.minecraft.world.biome.Biome;

public interface IBiomeExporter {
    void set( int x, int y, int z, Biome biome );
    Biome get( int x, int y, int z );
    Biome last( int x, int y, int z );
}
