package thvardhan.ytluckyblocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

import thvardhan.ytluckyblocks.entity.*;
import thvardhan.ytluckyblocks.misc.ExtraFunctions;
import thvardhan.ytluckyblocks.misc.RegistrationHandler;

import java.util.Random;

public class BabyDuckLuckyBlock extends Block {

    private static Random rand = new Random();

    public BabyDuckLuckyBlock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(0, 10000)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateTick(BlockState state, World worldIn, net.minecraft.util.math.BlockPos pos, Random rand) {
        for (int i = 0; i < 3; ++i) {
            int j = rand.nextInt(2) * 2 - 1;
            int k = rand.nextInt(2) * 2 - 1;

            double d0 = (double) pos.getX() + 0.5D + 0.25D * (double) j;
            double d1 = (double) pos.getY() + rand.nextFloat();
            double d2 = (double) pos.getZ() + 0.5D + 0.25D * (double) k;
            double d3 = (double) (rand.nextFloat() * (float) j);
            double d4 = ((double) rand.nextFloat() - 0.5D) * 0.125D;
            double d5 = (double) (rand.nextFloat() * (float) k);

            worldIn.addParticle(ParticleTypes.CRIT, d0, d1, d2, d3, d4, d5);
        }
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBlockHarvested(world, pos, state, player);

        //Run only on the logical server
        if (!world.isRemote) {
            drops(world, pos, player);
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return VoxelShapes.create(0.1D, 0.0D, 0.0D, 0.9D, 1.0D, 1.0D);
    }

    private void drops(World worldIn, BlockPos pos, PlayerEntity player) {

        Enchantment[] e = new Enchantment[5];
        e[0] = Enchantments.FLAME;
        e[1] = Enchantments.KNOCKBACK;
        e[2] = Enchantments.POWER;
        e[3] = Enchantments.THORNS;
        e[4] = Enchantments.LOOTING;

        Random rand = new Random();

        switch (rand.nextInt(56)) {

            case 0: {
                ExtraFunctions.addEnchantsMany(new ItemStack(Items.DIAMOND_SWORD), e, 5, worldIn, pos);
                break;
            }
            case 1: {
                  ExtraFunctions.addEnchantsMany(new ItemStack(Items.DIAMOND_SWORD), e, 5, worldIn, pos);
                break;
            }
            case 2: {
                 ExtraFunctions.mountain(worldIn, pos, rand);
                break;
            }
            case 3: {
                 ExtraFunctions.summonMobsNearby(RegistrationHandler.GHOST.get(), 5, worldIn, pos, rand);
                break;
            }
            case 4: {
                  ExtraFunctions.summonMobsNearby(RegistrationHandler.GHOST.get(), 20, worldIn, pos, rand);
                break;
            }
            case 5: {
                ExtraFunctions.summonMobsNearby(RegistrationHandler.CAPTAIN_SPARKLEZ.get(), 5, worldIn, pos, rand);
                break;
            }
            case 6: {
                  ExtraFunctions.endWellStruct(worldIn, new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 2), rand);
                break;
            }
            case 7: {
                  ExtraFunctions.hellWellStructure(worldIn, new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 2), rand);
                break;
            }
            case 8: {
                    ExtraFunctions.redstoneKit(worldIn, pos);
                break;
            }
            case 9: {
                  ExtraFunctions.foodKit(worldIn, pos);
                break;
            }
            case 10: {
                    ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(RegistrationHandler.YT_BOOTS.get()), 1, 0, 0);
                break;
            }
            case 11: {
                     ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(RegistrationHandler.YT_CHEST.get()), 1, 0, 0);
                break;
            }
            case 12: {
                 ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(RegistrationHandler.YT_LEGS.get()), 1, 0, 0);
                break;
            }
            case 13: {
                  ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(RegistrationHandler.YT_HELM.get()), 1, 0, 0);
                break;
            }
            case 14: {
                 ExtraFunctions.summonMobsOnBreakBlock(EntityType.BLAZE, 5, worldIn, pos, null);
                break;
            }
            case 15: {
                 ExtraFunctions.summonMobsNearby(EntityType.SKELETON, 15, worldIn, pos, rand);
                break;
            }
            case 16: {
                 ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(RegistrationHandler.DEVIL_SWORD.get()), 1, 0, 0);
                break;
            }
            case 17: {
                 ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(RegistrationHandler.LEVIN_SWORD.get()), 1, 0, 0);
                break;
            }
            case 18: {
                ExtraFunctions.summonMobsOnBreakBlock(RegistrationHandler.LOGDOTZIP.get(), 1, worldIn, pos, null);
                break;
            }
            case 19: {
                  ExtraFunctions.summonMobsOnBreakBlock(RegistrationHandler.POPULARMMOS.get(), 5, worldIn, pos, null);
                break;
            }
            case 20: {
                  ExtraFunctions.chat("Something Is Not Right Here....", player);
                break;
            }
            case 21: {
                   ExtraFunctions.chat("Something Is Not Right Here....", player);
                 ExtraFunctions.materialKit(worldIn, pos, rand);
                break;
            }
            case 22: {
                   ExtraFunctions.summonMobsOnBreakBlock(RegistrationHandler.ANTVENNOM.get(), rand.nextInt(10) + 1, worldIn, pos, null);
                break;
            }
            case 23: {
                 ExtraFunctions.tpPlayer(player);
                ExtraFunctions.chat("Fresh Air :'D", player);
                break;
            }
            case 24: {
                  ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(Blocks.DRAGON_EGG), 50, 1, 5);
                ExtraFunctions.chat("How Are You Going To Train These Many Dragons?", player);
                break;
            }
            case 25: {
                 ExtraFunctions.summonMobsOnBreakBlock(RegistrationHandler.DANTDM.get(), 2, worldIn, pos, null);
                break;
            }
            case 26: {
                  ExtraFunctions.summonMobsOnBreakBlock(RegistrationHandler.GHOST.get(), rand.nextInt(10), worldIn, pos, null);
                break;
            }
            case 27: {
                   ExtraFunctions.endWellStruct(worldIn, new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 2), rand);
                break;
            }
            case 28: {
                   ExtraFunctions.burgerStruct(worldIn, pos);
                break;
            }
            case 29: {
                   ExtraFunctions.setOneBlock(worldIn, pos, Blocks.COMMAND_BLOCK);
                ExtraFunctions.chat(TextFormatting.GOLD + "I Wonder If You Can Do Anything With This Command Block..", player);
                break;
            }
            case 30: {
                 ExtraFunctions.toVoid(worldIn, pos);
                break;
            }
            case 31: {
                 ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(Blocks.MELON), 25, 0, 0);
                break;
            }
            case 32: {
                 ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(Blocks.PUMPKIN), 25, 0, 0);
                break;
            }
            case 33: {
                ExtraFunctions.summonMobsOnBreakBlock(RegistrationHandler.SERIALPLAYER.get(), 30, worldIn, pos, null);
                break;
            }
            case 34: {
                 ExtraFunctions.materialKit(worldIn, pos, rand);
                break;
            }
            case 35: {
                  ItemStack[] i = {new ItemStack(Items.APPLE), new ItemStack(Items.ARROW), new ItemStack(Items.BAKED_POTATO)
                       , new ItemStack(Items.BLAZE_POWDER), new ItemStack(Items.MAP), new ItemStack(Items.DIAMOND_AXE),
                       new ItemStack(Items.DIAMOND_HORSE_ARMOR)};
               ExtraFunctions.addRandomEnchtToRandomItems(worldIn, i, e, 8, pos, rand);
                break;
            }
            case 36: {
                ExtraFunctions.summonItemWithLoop(worldIn, pos, Items.BAKED_POTATO, 50, 1, 10);
                ExtraFunctions.chat("ItS PoTaT RaIn!", player);
                break;
            }
            case 37: {
                ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.IRON_AXE), 5, 1, 50);
                break;
            }
            case 38: {
                 ExtraFunctions.orcArmy(worldIn, pos, rand.nextInt(50), rand);
                break;
            }
            case 39: {
                  ExtraFunctions.addEnchantsMany(new ItemStack(RegistrationHandler.LOG_SWORD.get()), e, 8, worldIn, pos);
                break;
            }
            case 40: {
                   ExtraFunctions.redstoneKit(worldIn, pos);
                break;
            }
            case 41: {
                  ExtraFunctions.foodKit(worldIn, pos);
                break;
            }
            case 42: {
                ExtraFunctions.hellWellStructure(worldIn, new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 2), rand);
                break;
            }
            case 43: {
                ExtraFunctions.setTntWithBlock(worldIn, pos, rand);
                break;
            }
            case 44: {
                 ExtraFunctions.lookUp(worldIn, player);
                break;
            }
            case 45: {
               // ExtraFunctions.setOneBlock(worldIn, pos, ModBlocks.captainSparkelzLuckyBlock);
                break;
            }
            case 46: {
                ExtraFunctions.setOneBlock(worldIn, pos, RegistrationHandler.GAMING_WITH_JEN_LUCKY_BLOCK.get());
                break;
            }
            case 47: {
                  ExtraFunctions.setOneBlock(worldIn, pos, Blocks.TNT);
                ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(Items.FLINT_AND_STEEL));
                break;
            }
            case 48: {
                ExtraFunctions.summonMobsOnBreakBlock(RegistrationHandler.BABY_DUCK.get(), 30, worldIn, pos, null);
                break;
            }
            case 49: {
                ExtraFunctions.endWellStruct(worldIn, new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 2), rand);
                break;
            }
            case 50: {
                  ExtraFunctions.holeDeathTrap(worldIn, pos);
                break;
            }
            case 51: {
                ExtraFunctions.summonMobsOnBreakBlock(RegistrationHandler.BABY_DUCK.get(), 40, worldIn, pos, null);
                break;
            }
            case 52: {
                  ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(RegistrationHandler.DUCK_BOOTS.get()));
                break;
            }
            case 53: {
                ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(RegistrationHandler.DUCK_CHEST.get()));
                break;
            }
            case 54: {
                ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(RegistrationHandler.DUCK_HELM.get()));
                break;
            }
            case 55: {
                ExtraFunctions.summonItemAsDrop(pos, worldIn, new ItemStack(RegistrationHandler.DUCK_LEGS.get()));
                break;
            }
        }
    }
}