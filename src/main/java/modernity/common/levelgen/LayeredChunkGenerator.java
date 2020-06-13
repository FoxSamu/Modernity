package modernity.common.levelgen;

import net.minecraft.world.IWorld;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.WorldGenRegion;

public abstract class LayeredChunkGenerator<S extends GenerationSettings> extends ChunkGenerator<S> {
    private final int height;

    public LayeredChunkGenerator( IWorld world, BiomeProvider biomeProvider, S settings, int height ) {
        super( world, biomeProvider, settings );
        this.height = height;
    }

    @Override
    public void generateSurface( WorldGenRegion world, IChunk chunk ) {

    }

    @Override
    public void makeBase( IWorld world, IChunk chunk ) {

    }

    @Override
    public int func_222529_a( int x, int z, Heightmap.Type type ) {
        return world.getHeight( type, x, z );
    }

    @Override
    public int getMaxHeight() {
        return height;
    }
}
