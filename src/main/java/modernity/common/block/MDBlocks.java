package modernity.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

import javax.annotation.Nonnull;
import java.util.Objects;

@ObjectHolder( "modernity" )
public final class MDBlocks {

    public static final Block DARK_STONE = injected();
    public static final Block GLOWY_STONE = injected();
    public static final Block DARK_BEDROCK = injected();

    private MDBlocks() {
    }

    public static void registerBlocks( IForgeRegistry<Block> registry ) {
        registry.registerAll(
            createBlock(
                "dark_stone",
                new Block( Block.Properties.create( Material.ROCK, MaterialColor.GRAY )
                                           .hardnessAndResistance( 1.5f, 6 ) )
            ),

            createBlock(
                "glowy_stone",
                new Block( Block.Properties.create( Material.ROCK, MaterialColor.SNOW )
                                           .lightValue( 15 )
                                           .hardnessAndResistance( 1.5f, 6 ) )
            ),

            createBlock(
                "dark_bedrock",
                new Block( Block.Properties.create( Material.ROCK, MaterialColor.BLACK )
                                           .hardnessAndResistance( - 1, 36000000 ) )
            )
        );
    }

    public static void registerItems( IForgeRegistry<Item> registry ) {
        registry.registerAll(
            createItem( DARK_STONE, ItemGroup.BUILDING_BLOCKS ),
            createItem( GLOWY_STONE, ItemGroup.BUILDING_BLOCKS ),
            createItem( DARK_BEDROCK, ItemGroup.BUILDING_BLOCKS )
        );
    }

    private static Block createBlock( String id, Block block ) {
        block.setRegistryName( "modernity:" + id );
        return block;
    }

    private static BlockItem createItem( Block block, Item.Properties props ) {
        BlockItem item = new BlockItem( block, props );
        item.setRegistryName( Objects.requireNonNull( block.getRegistryName() ) );
        return item;
    }

    private static BlockItem createItem( Block block, ItemGroup group ) {
        return createItem( block, new Item.Properties().group( group ) );
    }

    @Nonnull
    @SuppressWarnings( "ConstantConditions" )
    private static Block injected() {
        return null;
    }
}
