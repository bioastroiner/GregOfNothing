package gregofnothing.common.Items.tools;

import exnihilocreatio.items.tools.ICrook;
import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import gregtech.common.tools.ToolBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.Set;

public class ToolCrook extends ToolBase implements ICrook {
    @Override
    public boolean isCrook(ItemStack itemStack) {
        return true;
    }

    public boolean canApplyEnchantment(ItemStack stack, Enchantment enchantment) {
        return enchantment.type != null && enchantment.type.canEnchantItem(Items.IRON_SHOVEL);
    }

    public int getToolDamagePerBlockBreak(ItemStack stack) {
        return 1;
    }

    public float getDigSpeedMultiplier(ItemStack stack) {
        return 2.5F;
    }

    public boolean canMineBlock(IBlockState block, ItemStack stack) {
        //String tool = block.getBlock().getHarvestTool(block);
        return ExNihiloRegistryManager.CROOK_REGISTRY.isRegistered(block.getBlock());
    }

    @Override
    public Set<String> getToolClasses(ItemStack stack) {
        return super.getToolClasses(stack);
    }
}
