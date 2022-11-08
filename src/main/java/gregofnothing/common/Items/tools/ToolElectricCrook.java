package gregofnothing.common.Items.tools;

import gregtech.api.capability.GregtechCapabilities;
import gregtech.api.capability.IElectricItem;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.common.items.MetaItems;
import net.minecraft.item.ItemStack;

public class ToolElectricCrook extends ToolCrook {

    public int getToolDamagePerBlockBreak(ItemStack stack) {
        return super.getToolDamagePerBlockBreak(stack);
    }

    public float getDigSpeedMultiplier(ItemStack stack) {
        return super.getDigSpeedMultiplier(stack) * 2;
    }

    @Override
    public float getMaxDurabilityMultiplier(ItemStack stack) {
        return super.getMaxDurabilityMultiplier(stack) * 2;
    }

    public ItemStack getBrokenStack(ItemStack stack) {
        IElectricItem electricItem = stack.getCapability(GregtechCapabilities.CAPABILITY_ELECTRIC_ITEM, null);
        MetaItem<?>.MetaValueItem powerUnit = null;
        powerUnit = MetaItems.POWER_UNIT_LV;

        return powerUnit == null ? ItemStack.EMPTY : powerUnit.getChargedStackWithOverride(electricItem);
    }
}
