package modernity.common.dimension;

import modernity.common.block.MDBlocks;
import modernity.common.levelgen.ModernityChunkGenerator;
import modernity.common.levelgen.biome.LayeredBiomeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.SingleBiomeProvider;
import net.minecraft.world.biome.provider.SingleBiomeProviderSettings;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;

import javax.annotation.Nullable;

public class ModernityDimension extends Dimension {
    public ModernityDimension( World world, DimensionType type ) {
        super( world, type, 0.1f );
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator() {
        return new ModernityChunkGenerator(
            world,
            new LayeredBiomeProvider(),
            Util.make( new GenerationSettings(), settings -> {
                settings.setDefaultBlock( MDBlocks.DARK_STONE.getDefaultState() );
                settings.setDefaultFluid( Blocks.WATER.getDefaultState() );
            } )
        );
    }

    @Nullable
    @Override
    public BlockPos findSpawn( ChunkPos chunkPos, boolean checkValid ) {
        return null;
    }

    @Nullable
    @Override
    public BlockPos findSpawn( int posX, int posZ, boolean checkValid ) {
        return null;
    }

    @Override
    public float calculateCelestialAngle( long worldTime, float partialTicks ) {
        return 0.5f;
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @Override
    public Vec3d getFogColor( float celestialAngle, float partialTicks ) {
        return new Vec3d( 18 / 255d, 20 / 255d, 28 / 255d );
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }

    @Override
    public boolean doesXZShowFog( int x, int z ) {
        return false;
    }

    @Override
    public boolean isNether() {
        return true;
    }
}
