package thvardhan.ytluckyblocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class DiamondButton extends Block {

    public DiamondButton() {
        super(Properties.create(Material.ROCK)
                        .hardnessAndResistance(20, 10000)
                        .setLightLevel(state -> 12));

        //  this.setBlockBounds(0, 0.1F, 0.5F, 1, 0.8F, 0.6F);

    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return VoxelShapes.create(0, 0.1, 0.5, 1, 0.8, 0.6);
    }

}