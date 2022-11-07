package gregofnothing.proxy;

import gregofnothing.Greg_Of_Nothing;
import gregofnothing.common.Items.MetaItems;
import gregofnothing.common.Items.tools.MetaItem_Tools;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Greg_Of_Nothing.MODID)
public class CommonProxy {
    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    }

    public void preInit() {
        MetaItems.init();
    }

    public void init() {
    }

    public void postInit() {
    }
}
