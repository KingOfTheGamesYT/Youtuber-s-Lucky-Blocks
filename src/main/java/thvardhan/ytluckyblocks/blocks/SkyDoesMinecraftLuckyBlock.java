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

import thvardhan.ytluckyblocks.functions.ExtraFunctions;
import thvardhan.ytluckyblocks.misc.RegistrationHandler;

import java.util.Random;

public class SkyDoesMinecraftLuckyBlock extends Block {

    public SkyDoesMinecraftLuckyBlock(){
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

            worldIn.addParticle(ParticleTypes.PORTAL, d0, d1, d2, d3, d4, d5);
        }
    }

    @Override
    public void onBlockHarvested(World world, net.minecraft.util.math.BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBlockHarvested(world, pos, state, player);

        //Run only on the server
        if (!world.isRemote) {
            world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
            drops(world, pos, player);
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return VoxelShapes.create(0.1D, 0.0D, 0.0D, 0.9D, 1.0D, 1.0D);
    }

    private void drops(World worldIn, BlockPos pos, PlayerEntity player) {

        Random rand = new Random();

        switch (rand.nextInt(56)) {
            case 0: {
                ExtraFunctions.blockRain(worldIn, player.getPosition(), Blocks.ANVIL, 0, 10);
                break;
            }
            case 1: {
                ExtraFunctions.blockRain(worldIn, player.getPosition(), Blocks.ANVIL, 0, 10);
                break;
            }
            case 2: {
                ExtraFunctions.foodKit(worldIn, pos);
                break;
            }
            case 3: {
                ExtraFunctions.setOneBlock(worldIn, pos, Blocks.DIAMOND_BLOCK);
                break;
            }
            case 4: {
                ExtraFunctions.summonEnchantedItemAsDrop(worldIn, pos, Items.GOLD_INGOT, TextFormatting.GOLD + "Butter", Enchantments.KNOCKBACK, 10);
                break;
            }
            case 5: {
                ExtraFunctions.foodKit(worldIn, pos);
                break;
            }
            case 6: {
                  ExtraFunctions.buildTower(worldIn, pos, null,
                        new Block[] {
                               Blocks.IRON_BLOCK,
                                Blocks.DIAMOND_BLOCK,
                                Blocks.GOLD_BLOCK,
                                Blocks.EMERALD_BLOCK,
                                Blocks.BEACON,
                                Blocks.COAL_BLOCK,
                               Blocks.REDSTONE_BLOCK,
                               Blocks.DRAGON_EGG},
                        64);
                break;
            }
            case 7: {
                ExtraFunctions.redstoneKit(worldIn, pos);
                break;
            }
            case 8: {
                 ExtraFunctions.buildTower(worldIn, pos,
                      new Block[] {Blocks.REDSTONE_BLOCK,
                                Blocks.LAPIS_BLOCK,
                               Blocks.COAL_BLOCK,
                                Blocks.GOLD_BLOCK,
                                Blocks.IRON_BLOCK,
                                Blocks.EMERALD_BLOCK,
                                Blocks.DIAMOND_BLOCK,
                                Blocks.OBSIDIAN,
                                Blocks.DRAGON_EGG},
                              null,9);
                break;
            }
            case 9: {
                ExtraFunctions.tpPlayer(player);
                break;
            }
            case 10: {
               ExtraFunctions.setOneBlock(worldIn, pos, RegistrationHandler.POPULARMMOS_LUCKY_BLOCK.get());
                break;
            }
            case 11: {
                ExtraFunctions.summonMobs(EntityType.WITHER, 1, worldIn, pos, 0, null);
                break;
            }
            case 12: {
                ExtraFunctions.summonItemWithLoop(worldIn, pos, RegistrationHandler.DEVIL_SWORD.get(), 1, 0, 0);
                break;
            }
            case 13: {
                ExtraFunctions.summonMobs(RegistrationHandler.SKYDOESMINECRAFT.get(), 5, worldIn, pos, 0, null);
                break;
            }
            case 14: {
                ExtraFunctions.materialKit(worldIn, pos, rand);
                break;
            }
            case 15: {
                ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(Blocks.CAKE));
                break;
            }
            case 16: {
                ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(Blocks.DRAGON_EGG));
                break;
            }
            case 17: {
                ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(RegistrationHandler.YT_BOOTS.get()));
                break;
            }
            case 18: {
                ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(RegistrationHandler.YT_CHEST.get()));
                break;
            }
            case 19: {
                ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(RegistrationHandler.YT_HELM.get()));
                break;
            }
            case 20: {
                ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(RegistrationHandler.YT_LEGS.get()));
                break;
            }
            case 21: {
                ExtraFunctions.summonMobs(EntityType.CREEPER, 100, worldIn, pos, 30, null);
                break;
            }
            case 22: {
                ExtraFunctions.spawnTNT(worldIn, pos, player,1, 0, 0);
                break;
            }
            case 23: {
                 ExtraFunctions.summonMobs(RegistrationHandler.GHOST.get(), 5, worldIn, pos, 0, null);
                break;
            }
            case 24: {
                ExtraFunctions.spawnTNT(worldIn, pos, player,52, 20, 0);
                break;
            }
            case 25: {
                ExtraFunctions.mountain(worldIn, pos, Blocks.DIAMOND_BLOCK, rand);
                break;
            }
            case 26: {
                ExtraFunctions.summonMobs(RegistrationHandler.TRUEMU.get(), 10, worldIn, pos, 0, null);
                break;
            }
            case 27: {
                ExtraFunctions.burgerStruct(worldIn, pos, Blocks.BEACON.getDefaultState(), Blocks.DRAGON_EGG.getDefaultState(), Blocks.GLOWSTONE.getDefaultState());
                break;
            }
            case 28: {
                 ExtraFunctions.summonMobs(EntityType.WOLF, 1, worldIn, pos,0,
                       wolf -> {
                           wolf.setTamed(true);
                           wolf.setSitting(true);
                           wolf.setOwnerId(player.getUniqueID());
                       });
                break;
            }
            case 29: {
                ExtraFunctions.orcArmy(worldIn, pos, 25, rand);
                break;
            }
            case 30: {
                ExtraFunctions.setOneBlock(worldIn, pos, Blocks.YELLOW_BED);
                break;
            }
            case 31: {
                ExtraFunctions.summonMobs(RegistrationHandler.ANTVENNOM.get(), rand.nextInt(10) + 1, worldIn, pos, 0, null);
                break;
            }
            case 32: {
                ExtraFunctions.summonMobs(RegistrationHandler.SKYDOESMINECRAFT.get(), rand.nextInt(10) + 1, worldIn, pos, 0, null);
                break;
            }
            case 33: {
                Enchantment[] e = {Enchantments.SHARPNESS, Enchantments.KNOCKBACK, Enchantments.SMITE, Enchantments.BANE_OF_ARTHROPODS};
                ExtraFunctions.addEnchantsMany(new ItemStack(RegistrationHandler.DEVIL_SWORD.get()), e, 4, worldIn, pos);
                break;
            }
            case 34: {
                ExtraFunctions.burgerStruct(worldIn, pos, Blocks.EMERALD_BLOCK.getDefaultState(), Blocks.DIAMOND_BLOCK.getDefaultState(), Blocks.IRON_BLOCK.getDefaultState());
                break;
            }
            case 35: {
                ExtraFunctions.redstoneKit(worldIn, pos);
                break;
            }
            case 36: {
                ExtraFunctions.createHole(worldIn, pos, true);
                break;
            }
            case 37: {
                ExtraFunctions.setOneBlock(worldIn, pos, Blocks.LAVA);
                break;
            }
            case 38: {
                ExtraFunctions.materialKit(worldIn, pos, rand);
                break;
            }
            case 39: {
                ExtraFunctions.spawnTNT(worldIn, pos, player,5, 0, 0);
                break;
            }
            case 40: {
                ExtraFunctions.spawnTNT(worldIn, pos, player,5, 0, 10);
                break;
            }
            case 41: {
                ExtraFunctions.summonMobs(RegistrationHandler.SKYDOESMINECRAFT.get(), 35, worldIn, pos, 30, null);
                break;
            }
            case 42: {
                ExtraFunctions.endWellStruct(worldIn, pos, rand);
                break;
            }
            case 43: {
                ExtraFunctions.hellWellStructure(worldIn, pos, rand);
                break;
            }
            case 44: {
                ExtraFunctions.summonMobs(EntityType.ZOMBIE, 15, worldIn, pos, 30, null);
                break;
            }
            case 45: {
                ExtraFunctions.summonMobs(EntityType.IRON_GOLEM, 52, worldIn, pos, 30, null);
                break;
            }
            case 46: {
                ExtraFunctions.setOneBlock(worldIn, pos, Blocks.TNT);
                ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(Items.FLINT_AND_STEEL));
                break;
            }
            case 47: {
                ExtraFunctions.summonMobs(RegistrationHandler.CAPTAIN_SPARKLEZ.get(), 10, worldIn, pos, 0, null);
                break;
            }
            case 48: {
                ExtraFunctions.summonMobs(EntityType.GHAST, 25, worldIn, pos, 0, null);
                break;
            }
            case 49: {
                ExtraFunctions.summonBlockWithLoop(worldIn, pos, Blocks.GOLD_BLOCK, 64, 1, 25);
                break;
            }
            case 50: {
                ExtraFunctions.summonMobs(RegistrationHandler.SUPERGIRLYGAMER.get(), 1, worldIn, pos, 0, null);
                break;
            }
            case 51: {
                ExtraFunctions.summonCowNearby(worldIn, pos, 25, rand);
                break;
            }
            case 52: {
                ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(RegistrationHandler.SKY_BOOTS.get()));
                break;
            }
            case 53: {
                ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(RegistrationHandler.SKY_CHEST.get()));
                break;
            }
            case 54: {
                ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(RegistrationHandler.SKY_HELM.get()));
                break;
            }
            case 55: {
                ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(RegistrationHandler.SKY_LEGS.get()));
                break;
            }
        }
    }
//method ends
}