package gregofnothing.common.Items;

import gregofnothing.common.Items.tools.MetaItem_Tools;
import gregtech.api.items.toolitem.ToolMetaItem;

// hoist all my metaitem references
public class MetaItems {

    // ********* TOOLS **********
    public static ToolMetaItem<?>.MetaToolValueItem CROOK;
    public static ToolMetaItem<?>.MetaToolValueItem CROOK_LV;

    public static ToolMetaItem<?>.MetaToolValueItem EX_HAMMER;
    public static ToolMetaItem<?>.MetaToolValueItem EX_HAMMER_LV;

    public static void init() {
        MetaItem_Tools.instance = new MetaItem_Tools();
        MetaItem_Tools.instance.setRegistryName("gon_meta_tool");
    }

}
