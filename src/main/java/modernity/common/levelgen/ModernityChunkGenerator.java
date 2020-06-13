package modernity.common.levelgen;

import net.minecraft.world.World;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.NoiseChunkGenerator;

public class ModernityChunkGenerator extends NoiseChunkGenerator<GenerationSettings> {
    public ModernityChunkGenerator( World world, BiomeProvider biomeProvider, GenerationSettings settings ) {
        super( world, biomeProvider, 4, 8, 256, settings, false );
    }

    @Override
    protected void fillNoiseColumn( double[] noiseColumn, int noiseX, int noiseZ ) {
        double baseNoiseHScale = 684.412D;
        double baseNoiseVScale = 2053.236D;
        double mixNoiseHScale = 8.55515D;
        double mixNoiseVScale = 34.2206D;
        calcNoiseColumn( noiseColumn, noiseX, noiseZ, baseNoiseHScale, baseNoiseVScale, mixNoiseHScale, mixNoiseVScale, 3, - 10 );
    }

    @Override
    protected double[] getBiomeNoiseColumn( int noiseX, int noiseZ ) {
        return new double[] { 58, 0 }; // baseHeight, density
    }

    @Override
    protected double func_222545_a( double baseHeight, double density, int y ) {
        double height = Math.cos( y * Math.PI * 6 / noiseSizeY() ) * 2 + density;
        double hgt = y;
        if( y > noiseSizeY() / 2 ) {
            hgt = noiseSizeY() - 1 - y;
        } else {
            hgt -= baseHeight / 8 + 3;
        }

        if( hgt < 4 ) {
            hgt = 4 - hgt;
            height -= hgt * hgt * hgt * 10.0D;
        }

        return height;
    }

    @Override
    public int getGroundHeight() {
        return this.world.getSeaLevel() + 1;
    }

    @Override
    public int getMaxHeight() {
        return 256;
    }

    @Override
    public int getSeaLevel() {
        return 64;
    }
}