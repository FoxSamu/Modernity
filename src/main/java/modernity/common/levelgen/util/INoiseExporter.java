package modernity.common.levelgen.util;

public interface INoiseExporter {
    void set( int x, int y, int z, double noise );
    void add( int x, int y, int z, double noise );
    void sub( int x, int y, int z, double noise );
    void mul( int x, int y, int z, double noise );
    void div( int x, int y, int z, double noise );
    double get( int x, int y, int z );
    double last( int x, int y, int z );
}
