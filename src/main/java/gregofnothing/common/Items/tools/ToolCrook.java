package gregofnothing.common.Items.tools;

import exnihilocreatio.config.ModConfig;
import exnihilocreatio.items.tools.ICrook;
import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import exnihilocreatio.registries.types.CrookReward;
import gregtech.common.tools.ToolBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;
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
        return block.getMaterial() == Material.LEAVES;
    }

    @Override
    public void onBlockDestroyed(ItemStack stack, World world, IBlockState state, BlockPos pos, EntityLivingBase entity) {
        super.onBlockDestroyed(stack, world, state, pos, entity);

    }

    @Override
    public float getSaplingModifier(ItemStack stack, World world, EntityPlayer player, BlockPos pos) {
        return 0.85F;
    }

    @Override
    public void convertBlockDrops(World world, BlockPos blockPos, IBlockState blockState, EntityPlayer player, List<ItemStack> dropList, ItemStack toolStack) {
        if (!player.isSneaking()) {
            this.onBreakingUse(toolStack, world, blockPos);
            if (!world.isRemote && player != null) {
                List<CrookReward> rewards = ExNihiloRegistryManager.CROOK_REGISTRY.getRewards(blockState);
                int i;
                if (rewards.size() > 0) {
                    dropList.clear();
                    i = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, toolStack);
                    Iterator var5 = rewards.iterator();

                    while (var5.hasNext()) {
                        CrookReward reward = (CrookReward) var5.next();
                        if (world.rand.nextFloat() <= reward.getChance() + reward.getFortuneChance() * (float) i) {
                            dropList.add(reward.getStack().copy());
                        }
                    }
                }

                if (blockState.getBlock() instanceof BlockLeaves) {
                    for (i = 0; i < ModConfig.crooking.numberOfTimesToTestVanillaDrops + 1; ++i) {
                        Block block = blockState.getBlock();
                        int fortune = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, toolStack);
                        List<ItemStack> items = block.getDrops(world, blockPos, blockState, fortune);
                        Iterator var8 = items.iterator();

                        //float dropChance = ForgeEventFactory.fireBlockHarvesting(dropList,world,blockPos,blockState,fortune)
                        while (var8.hasNext()) {
                            ItemStack item = (ItemStack) var8.next();
                            if (world.rand.nextFloat() <= 1f) { //TODO replace the float with dropChance somehow
                                Block.spawnAsEntity(world, blockPos, item);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public Set<String> getToolClasses(ItemStack stack) {
        return super.getToolClasses(stack);
    }
}
