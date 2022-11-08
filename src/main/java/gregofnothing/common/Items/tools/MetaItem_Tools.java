package gregofnothing.common.Items.tools;

import gregofnothing.Greg_Of_Nothing;
import gregofnothing.common.Items.MetaItems;
import gregtech.api.items.metaitem.ElectricStats;
import gregtech.api.items.toolitem.ToolMetaItem;
import gregtech.api.sound.GTSounds;

public class MetaItem_Tools extends ToolMetaItem<ToolMetaItem<?>.MetaToolValueItem> {

    public static MetaItem_Tools instance;

    public static void init() {
        Greg_Of_Nothing.logger.info("Starting MetaTool registration");
        MetaItem_Tools.instance = new MetaItem_Tools();
        MetaItem_Tools.instance.setRegistryName("gon_meta_tool");
    }

    @Override
    public void registerSubItems() {
        MetaItems.CROOK = addItem(0, "tools.crook")
                .setToolStats(new ToolCrook())
                .setFullRepairCost(1.0);
        MetaItems.CROOK_LV = addItem(1, "tools.crook.lv")
                .setToolStats(new ToolElectricCrook())
                .setFullRepairCost(2.0D)
                .addComponents(ElectricStats.createElectricItem(80000L, 1L))
                .setSound(GTSounds.CHAINSAW_TOOL); // TODO: add Crook sound
    }
}
