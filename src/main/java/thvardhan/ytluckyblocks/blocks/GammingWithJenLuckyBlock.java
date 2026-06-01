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

public class GammingWithJenLuckyBlock extends Block {

    public GammingWithJenLuckyBlock() {
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
                ExtraFunctions.burgerStruct(worldIn, pos, Blocks.BEACON.getDefaultState(), Blocks.DRAGON_EGG.getDefaultState(), Blocks.GLOWSTONE.getDefaultState());
                break;
            }
            case 4: {
                ExtraFunctions.summonMobs(RegistrationHandler.SUPERGIRLYGAMER.get(), 5, worldIn, pos, 0, null);
                break;
            }
            case 5: {
                ExtraFunctions.summonMobs(EntityType.SKELETON, 5, worldIn, pos, 30, null);
                break;
            }
            case 6: {
                ExtraFunctions.summonMobs(RegistrationHandler.SUPERGIRLYGAMER.get(), rand.nextInt(30) + 1, worldIn, pos, 0, null);
                break;
            }
            case 7: {
                ExtraFunctions.buildTower(worldIn, pos,
                        new Block[] {
                                Blocks.REDSTONE_BLOCK,
                                Blocks.LAPIS_BLOCK,
                                Blocks.COAL_BLOCK,
                                Blocks.GOLD_BLOCK,
                                Blocks.IRON_BLOCK,
                                Blocks.EMERALD_BLOCK,
                                Blocks.DIAMOND_BLOCK,
                                Blocks.OBSIDIAN,
                                Blocks.DRAGON_EGG},
                        null, 9);
                break;
            }
            case 8: {
                ExtraFunctions.hellWellStructure(worldIn, new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 2), rand);
                break;
            }
            case 9: {
                ExtraFunctions.createHole(worldIn, pos, false);
                break;
            }
            case 10: {
                ExtraFunctions.redstoneKit(worldIn, pos);
                break;
            }
            case 11: {
                ExtraFunctions.endWellStruct(worldIn, new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 2), rand);
                break;
            }
            case 12: {
             ExtraFunctions.summonMobs(EntityType.WOLF, 25, worldIn, pos, 30, null);
             ExtraFunctions.chat("Tame Them If You Want Them.", player);
             ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.BONE), 64, 0, 0);
             ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.BONE), 64, 1, 10);
                break;
            }
            case 13: {
                ExtraFunctions.burgerStruct(worldIn, pos, Blocks.EMERALD_BLOCK.getDefaultState(), Blocks.DIAMOND_BLOCK.getDefaultState(), Blocks.IRON_BLOCK.getDefaultState());
                break;
            }
            case 14: {
                ExtraFunctions.trollDiamondTrapWithChanceOfNotTroll(worldIn, pos, rand.nextBoolean());
                break;
            }
            case 15: {
                ExtraFunctions.musicKit(worldIn, pos);
                break;
            }
            case 16: {
               ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(Blocks.COMMAND_BLOCK));
                ExtraFunctions.chat("If You Are On Creative Then Nice Else Its Waste.", player);
                break;
            }
            case 17: {
                ExtraFunctions.summonCowNearby(worldIn, pos, 50, rand);
                break;
            }
            case 18: {
                ExtraFunctions.materialKit(worldIn, pos, rand);
                break;
            }
            case 19: {
                ExtraFunctions.chat("These Blocks Are Called GamingWithJen Lucky Blocks (In Case You Dont Know)", player);
                break;
            }
            case 20: {
                Enchantment[] e1 = {Enchantments.FIRE_ASPECT, Enchantments.KNOCKBACK};
                ExtraFunctions.addEnchantsMany(new ItemStack(Items.PINK_BED), e1, 10, worldIn, pos);
                break;
            }
            case 21: {
                ExtraFunctions.endWellStruct(worldIn, new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 2), rand);
                break;
            }
            case 22: {
                ExtraFunctions.spawnTNT(worldIn, pos, player, 200, 0, 0);
                break;
            }
            case 23: {
                ExtraFunctions.potionKit(worldIn, pos, rand);
                break;
            }
            case 24: {
                ExtraFunctions.chat(TextFormatting.DARK_RED + "BEEP BEEP NUKE =WARNING=", player);
                ExtraFunctions.spawnTNT(worldIn, pos, player,200, 20, 0);
                break;
            }
            case 25: {
                ExtraFunctions.orcArmy(worldIn, pos, 5, rand);
                break;
            }
            case 26: {
                ExtraFunctions.summonMobs(RegistrationHandler.SUPERGIRLYGAMER.get(), 30, worldIn, pos, 0, null);
                break;
            }
            case 27: {
                ExtraFunctions.summonMobs(EntityType.BLAZE, 25, worldIn, pos, 30, null);
                break;
            }
            case 28: {
                ExtraFunctions.summonMobs(RegistrationHandler.LOGDOTZIP.get(), 3, worldIn, pos, 0, null);
                break;
            }
            case 29: {
                ExtraFunctions.summonMobs(EntityType.IRON_GOLEM, rand.nextInt(25) + 1, worldIn, pos, 30, null);
                break;
            }
            case 30: {
                ExtraFunctions.buildTower(worldIn, pos,
                        new Block[] {
                                Blocks.REDSTONE_BLOCK,
                                Blocks.LAPIS_BLOCK,
                                Blocks.COAL_BLOCK,
                                Blocks.GOLD_BLOCK,
                                Blocks.IRON_BLOCK,
                                Blocks.EMERALD_BLOCK,
                                Blocks.DIAMOND_BLOCK,
                                Blocks.OBSIDIAN,
                                Blocks.DRAGON_EGG},
                        null, 9);
                break;
            }
            case 31: {
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
            case 32: {
                ExtraFunctions.foodKit(worldIn, pos);
                break;
            }
            case 33: {
                ExtraFunctions.mountain(worldIn, pos, Blocks.DIAMOND_BLOCK, rand);
                break;
            }
            case 34: {
                ExtraFunctions.blockRain(worldIn, player.getPosition(), Blocks.ANVIL, 0, 10);
                break;
            }
            case 35: {
                ExtraFunctions.setTntWithBlock(worldIn, pos, rand);
                break;
            }
            case 36: {
                ExtraFunctions.summonMobs(EntityType.GHAST, rand.nextInt(30) + 1, worldIn, pos, 0, null);
                break;
            }
            case 37: {
                ExtraFunctions.summonMobs(RegistrationHandler.ANTVENNOM.get(), rand.nextInt(10) + 1, worldIn, pos, 0, null);
                break;
            }
            case 38: {
                ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(RegistrationHandler.LEVIN_SWORD.get()));
                break;
            }
            case 39: {
                ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(RegistrationHandler.LOG_SWORD.get()));
                break;
            }
            case 40: {
                ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(RegistrationHandler.YT_LEGS.get()));
                break;
            }
            case 41: {
                ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(RegistrationHandler.YT_CHEST.get()));
                break;
            }
            case 42: {
                ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(RegistrationHandler.YT_HELM.get()));
                break;
            }
            case 43: {
                ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(RegistrationHandler.YT_BOOTS.get()));
                break;
            }
            case 44: {
                ExtraFunctions.burgerStruct(worldIn, pos, Blocks.BEACON.getDefaultState(), Blocks.DRAGON_EGG.getDefaultState(), Blocks.GLOWSTONE.getDefaultState());
                break;
            }
            case 45: {
                ExtraFunctions.createHole(worldIn, pos, true);
                break;
            }
            case 46: {
                ExtraFunctions.setOneBlock(worldIn, pos, RegistrationHandler.YOUTUBE_BLOCK.get());
                break;
            }
            case 47: {
                ExtraFunctions.setOneBlock(worldIn, pos, RegistrationHandler.SKY_DOES_MINECRAFT_LUCKY_BLOCK.get());
                break;
            }
            case 48: {
                ExtraFunctions.setOneBlock(worldIn, pos, Blocks.CAKE);
                break;
            }
            case 49: {
                ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(Blocks.CAKE));
                break;
            }
            case 50: {
                ExtraFunctions.summonMobs(RegistrationHandler.CAPTAIN_SPARKLEZ.get(), rand.nextInt(19) + 1, worldIn, pos, 0, null);
                break;
            }
            case 51: {
                ExtraFunctions.summonMobs(EntityType.RABBIT, 50, worldIn, pos, 0, rabbit -> {
                    rabbit.setRabbitType(99); //Killer rabbit
                });
                break;
            }
            case 52: {
                ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(RegistrationHandler.SUPER_BOOTS.get()));
                break;
            }
            case 53: {
                ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(RegistrationHandler.SUPER_CHEST.get()));
                break;
            }
            case 54: {
                ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(RegistrationHandler.SUPER_HELM.get()));
                break;
            }
            case 55: {
                ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(RegistrationHandler.SUPER_LEGS.get()));
                break;
            }
        }
    }//method ends
}