package gregofnothing.common.Items;

import gregofnothing.Greg_Of_Nothing;
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
        Greg_Of_Nothing.logger.info("Starting MetaItems registration");
        MetaItem_Tools.init();
        OrePrefixItem.init();
    }

}
