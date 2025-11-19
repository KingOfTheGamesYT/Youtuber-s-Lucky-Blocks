package thvardhan.ytluckyblocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.minecraftforge.common.ToolType;
import thvardhan.ytluckyblocks.misc.ExtraFunctions;
import thvardhan.ytluckyblocks.misc.RegistrationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class YoutubeBlock extends Block {

    public YoutubeBlock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(0, 10000)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE));
    }

public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
    super.onBlockHarvested(worldIn, pos, state, player);
    if (!worldIn.isRemote) {
            Random rand = new Random();
            switch (rand.nextInt(2)) {
                case 0: {
                    ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(ExtraFunctions.randomBlock()));
                    break;
                }
                case 1: {
                    ExtraFunctions.summonBlockAsDrop(pos, worldIn, RegistrationHandler.GOLD_PLAY_BUTTON.get());
                    break;
                }
            }
        }
    }
}
