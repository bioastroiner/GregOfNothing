package gregofnothing.common.Items.tools;

import gregofnothing.common.Items.MetaItems;
import gregtech.api.items.metaitem.ElectricStats;
import gregtech.api.items.toolitem.ToolMetaItem;
import gregtech.api.sound.GTSounds;

public class MetaItem_Tools extends ToolMetaItem<ToolMetaItem<?>.MetaToolValueItem> {

    public static MetaItem_Tools instance;

    @Override
    public void registerSubItems() {
        MetaItems.CROOK = addItem(0, "tool.crook")
                .setToolStats(new ToolCrook())
                .setFullRepairCost(1.0);
        MetaItems.CROOK_LV = addItem(1, "tool.crook.lv")
                .setToolStats(new ToolCrook())
                .setFullRepairCost(2.0D)
                .addComponents(ElectricStats.createElectricItem(80000L, 1L))
                .setSound(GTSounds.CHAINSAW_TOOL); // TODO: add Crook sound
    }
}
