package modernity.common.levelgen.layer;

import modernity.common.levelgen.util.IBiomeExporter;
import modernity.common.levelgen.util.INoiseExporter;
import net.minecraft.world.IWorld;

import java.util.Random;

public interface IGeneratorLayer {
    default void init( Random rand ) {

    }

    default void makeNoise( INoiseExporter exporter, Random rand, int x, int y, int z ) {

    }

    default void makeBiomes( IBiomeExporter exporter, Random rand, int x, int y, int z ) {

    }

    default void makeSurface( IWorld world, Random rand, int x, int y, int z ) {

    }

    default void makeDecoration( IWorld world, Random rand, int x, int y, int z ) {

    }

}
