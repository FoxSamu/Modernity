package modernity.common.handler;

import modernity.common.block.MDBlocks;
import modernity.common.dimension.MDDimensions;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RegistryHandler {
    @SubscribeEvent
    public void registerBlocks( RegistryEvent.Register<Block> event ) {
        MDBlocks.registerBlocks( event.getRegistry() );
    }

    @SubscribeEvent
    public void registerItems( RegistryEvent.Register<Item> event ) {
        MDBlocks.registerItems( event.getRegistry() );
    }

    @SubscribeEvent
    public void registerDimensions( RegistryEvent.Register<ModDimension> event ) {
        MDDimensions.registerDimensions( event.getRegistry() );
    }
}
