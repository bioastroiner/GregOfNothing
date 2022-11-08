package gregofnothing;

import gregofnothing.common.Items.MetaItems;
import gregofnothing.common.Items.ModItems;
import gregofnothing.common.ModBlocks;
import gregofnothing.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static gregofnothing.Greg_Of_Nothing.*;

@Mod(modid = MODID, name = MOD_NAME, version = VERSION,
        dependencies = "required-after:gregtech@[2.0-beta,);" +
                //"after:gregicality@[1.0,);" +
                "after:exnihilocreatio;")
public class Greg_Of_Nothing {

    @Mod.Instance("gregofnothing")
    public static Greg_Of_Nothing instance;

    public static final String MODID = "gregofnothing";
    public static final String MOD_NAME = "Greg Out of Nothing";
    public static final String VERSION = "@VERSION@";

    public static Logger logger = LogManager.getLogger("GREG_OF_NOTHING_LOGGER");

    @SidedProxy(
            modId = "gregofnothing",
            clientSide = "gregofnothing.proxy.ClientProxy",
            serverSide = "gregofnothing.proxy.CommonProxy")
    static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        MetaItems.init();
        proxy.preInit();
        MinecraftForge.EVENT_BUS.register(this);
        logger.info("GTN pre load finish");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
        logger.info("GTN Initialization finish");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
        logger.info("GTN PostInitialization finish");
    }
}

