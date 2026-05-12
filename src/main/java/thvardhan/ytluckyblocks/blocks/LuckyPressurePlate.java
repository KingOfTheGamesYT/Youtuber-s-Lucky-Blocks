package thvardhan.ytluckyblocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import net.minecraftforge.common.ToolType;

import thvardhan.ytluckyblocks.misc.ExtraFunctions;
import thvardhan.ytluckyblocks.misc.RegistrationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LuckyPressurePlate extends Block {

    private BlockPos pos;

    public LuckyPressurePlate() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(0, 10000)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return VoxelShapes.create(0.03f, 0, 0.03f, 0.93F, 0.2F, 0.93F);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> dropsOriginal = super.getDrops(state, builder);
        if (!dropsOriginal.isEmpty())
            return dropsOriginal;
        return Collections.singletonList(new ItemStack(this, 1));
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {

        if (!worldIn.isRemote && entityIn instanceof PlayerEntity) {

            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);

            //GOLDENAPPLE FAKE!

            Random rand = new Random();

            switch (rand.nextInt(52)) {

                case 0: {
                   ExtraFunctions.chat("EMPTY", (PlayerEntity) entityIn);
                    break;
                }
                case 1: {
                    ExtraFunctions.materialKit(worldIn, pos, rand);
                    break;
                }
                case 2: {
                     ExtraFunctions.deathHole(worldIn, (PlayerEntity) entityIn);
                    break;
                }
                case 3: {
                     ExtraFunctions.anvilRain(worldIn, pos);
                    break;
                }
                case 4: {
                      ExtraFunctions.trollDiamondTrapWithChanceOfNotTroll(worldIn, pos, false);
                    break;
                }
                case 5: {
                     ExtraFunctions.trollDiamondTrapWithChanceOfNotTroll(worldIn, pos, true);
                    break;
                }
                case 6: {
                       ExtraFunctions.fireCamp(worldIn, (PlayerEntity) entityIn);
                    break;
                }
                case 7: {
                    ExtraFunctions.summonTammedWolfs(worldIn, (PlayerEntity) entityIn, 21, pos);
                    break;
                }
                case 8: {
                    ExtraFunctions.tpPlayerInGround((PlayerEntity) entityIn);
                    break;
                }
                case 9: {
                       ExtraFunctions.tpPlayer((PlayerEntity) entityIn);
                    break;
                }
                case 10: {
                     ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.DIAMOND), 40, 1, 4);
                    break;
                }
                case 11: {
                      ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.EMERALD), 15, 1, 6);
                    break;
                }
                case 12: {
                   ExtraFunctions.setOneBlock(worldIn, pos, RegistrationHandler.BABY_DUCK_LUCKY_BLOCK.get());
                    break;
                }
                case 13: {
                        ExtraFunctions.flyingIsle(worldIn, pos);
                    ExtraFunctions.chat("Look Up ^", (PlayerEntity) entityIn);
                    break;
                }
                case 14: {
                    ExtraFunctions.setOneBlock(worldIn, new BlockPos(pos.getX(), pos.getY() + 2, pos.getZ()), Blocks.LAVA);
                    break;
                }
                case 15: {
                     ExtraFunctions.burgerStruct(worldIn, pos);
                    break;
                }
                case 16: {
                    ExtraFunctions.tntNearby(worldIn, pos, 150, (PlayerEntity) entityIn, rand);
                    break;
                }
                case 17: {
                     ExtraFunctions.musicKit(worldIn, pos);
                    break;
                }
                case 18: {
                    ExtraFunctions.luckyBlockTower(worldIn, pos);
                    break;
                }
                case 19: {
                    ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(Items.FLINT_AND_STEEL));
                    break;
                }
                case 20: {
                      ExtraFunctions.summonTammedWolfs(worldIn, (PlayerEntity) entityIn, 21, pos);
                    break;
                }
                case 21: {
                     ExtraFunctions.obsidianCageStruct(worldIn, (PlayerEntity) entityIn);
                    break;
                }
                case 22: {
                     ExtraFunctions.sandRain(worldIn, (PlayerEntity) entityIn);
                    break;
                }
                case 23: {
                      ExtraFunctions.tntFix(worldIn, pos, 5, (PlayerEntity) entityIn);
                    break;
                }
                case 24: {
                   ExtraFunctions.chat("DONT EAT ME! I BEG! :3", (PlayerEntity) entityIn);
                    ExtraFunctions.summonEnchantedItemAsDrop(worldIn, pos, Items.GOLDEN_APPLE, "apule", Enchantments.FIRE_ASPECT, 60);
                    break;
                }
                case 25: {
                     ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(ExtraFunctions.randomBlock()));
                    break;
                }
                case 26: {
                     ExtraFunctions.slimeFort(worldIn, (PlayerEntity) entityIn);
                    break;
                }
                case 27: {
                      ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(Items.DIAMOND_AXE));
                    break;
                }
                case 28: {
                      ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(Items.DIAMOND_PICKAXE));
                    break;
                }
                case 29: {
                     ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(Items.DIAMOND_SWORD));
                    break;
                }
                case 30: {
                      ExtraFunctions.summonEnchantedItemAsDrop(worldIn, pos, RegistrationHandler.RAINBOW_SWORD.get(), "Rainbow", Enchantments.SHARPNESS, 10);
                    break;
                }
                case 31: {
                    ExtraFunctions.potionKit(worldIn, pos, rand);
                    break;
                }
                case 32: {
                      ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(RegistrationHandler.YT_BOOTS.get()));
                    break;
                }
                case 33: {
                     ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(RegistrationHandler.YT_HAMMER.get()));
                    break;
                }
                case 34: {
                    ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(RegistrationHandler.YT_CHEST.get()));
                    break;
                }
                case 35: {
                       ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(RegistrationHandler.YT_HELM.get()));
                    break;
                }
                case 36: {
                    ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(RegistrationHandler.YT_LEGS.get()));
                    break;
                }
                case 37: {
                     ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(RegistrationHandler.IRON_PLAY_BUTTON.get()));
                    break;
                }
                case 38: {
                    ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(RegistrationHandler.GOLD_PLAY_BUTTON.get()));
                    break;
                }
                case 39: {
                     ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(RegistrationHandler.DIAMOND_PLAY_BUTTON.get()));
                    break;
                }
                case 40: {
                    ExtraFunctions.summonMobsOnBreakBlock(EntityType.WITHER, 1, worldIn, pos, null);
                    break;
                }
                case 41: {
                     ExtraFunctions.luckyBlockBox(worldIn, pos, rand);
                    break;
                }
                case 42: {
                        ExtraFunctions.summonLuckyMobs(worldIn, 5, pos);
                    break;
                }
                case 43: {
                     ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(Blocks.HAY_BLOCK));
                    break;
                }
                case 44: {
                       ExtraFunctions.setOneBlock(worldIn, pos, Blocks.JACK_O_LANTERN);
                    break;
                }
                case 45: {
                      ExtraFunctions.setOneBlock(worldIn, pos, Blocks.END_PORTAL);
                    break;
                }
                case 46: {
                     ExtraFunctions.setOneBlock(worldIn, pos, Blocks.ENDER_CHEST);
                    break;
                }
                case 47: {
                      ExtraFunctions.tpPlayerInGround((PlayerEntity) entityIn);
                    break;
                }
                case 48: {
                    ExtraFunctions.orcArmy(worldIn, pos, 25, rand);
                    break;
                }
                case 49: {
                       ExtraFunctions.redstoneKit(worldIn, pos);
                    break;
                }
                case 50: {
                    ExtraFunctions.summonMobsOnBreakBlock(EntityType.GHAST, 25, worldIn, pos, null);
                    break;
                }
                case 51: {
                    ExtraFunctions.fireCamp(worldIn, (PlayerEntity) entityIn);
                    break;
                }
            }
        }
        super.onEntityWalk(worldIn, pos, entityIn);
    }
}