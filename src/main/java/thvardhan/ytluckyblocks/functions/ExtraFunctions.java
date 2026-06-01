package thvardhan.ytluckyblocks.functions;

import net.minecraft.block.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.state.properties.BedPart;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import net.minecraftforge.server.command.TextComponentHelper;
import thvardhan.ytluckyblocks.misc.RegistrationHandler;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.function.Consumer;

public class ExtraFunctions {

    private static Block[] b = {RegistrationHandler.ALEXIRCRAFT_LUCKY_BLOCK.get(), //ModBlocks.antVenomLuckyBlock, ModBlocks.bajanCanadianLuckyBlock, ModBlocks.captainSparkelzLuckyBlock, ModBlocks.danTDMLuckyBlock, ModBlocks.exploadingTNTLuckyBlock,
             RegistrationHandler.FRIZZLEANDPOP_LUCKY_BLOCK.get(), RegistrationHandler.GAMING_WITH_JEN_LUCKY_BLOCK.get(),
           // ModBlocks.iBallisticSquidLuckyBlock, ModBlocks.iHasCupcakeLuckyBlock,
            RegistrationHandler.JEROMEASF_LUCKY_BLOCK.get(),
            //ModBlocks.lachlanLuckyBlock, ModBlocks.lDShadowLadyLuckyBlock, ModBlocks.youtubeLuckyBlock, ModBlocks.vikkstar123LuckyBlock, ModBlocks.trueMuLuckyBlock, ModBlocks.thnxCyaLuckyBlock,
            //ModBlocks.tewityLuckyBlock, ModBlocks.stampylongheadLuckyBlock, ModBlocks.sSundeeLuckyBlock,
             RegistrationHandler.SKY_DOES_MINECRAFT_LUCKY_BLOCK.get(), //ModBlocks.serialPlayerLuckyBlock, ModBlocks.prestonPlayzLuckyBlock, ModBlocks.mrwooflessLuckyBlock, ModBlocks.petaZahHuttLuckyBlock,
           // ModBlocks.pinkSheepYTLuckyBlock,
            RegistrationHandler.POPULARMMOS_LUCKY_BLOCK.get(), RegistrationHandler.BABY_DUCK_LUCKY_BLOCK.get(), //ModBlocks.babyLeahLuckyBlock, ModBlocks.babyMaxLuckyBlock, ModBlocks.donutTheDogLuckyBlock, ModBlocks.evilLittleKellyLuckyBlock, ModBlocks.littleAllyLuckyBlock, ModBlocks.littleCarlyMcLuckyBlock
          //  , ModBlocks.littleDonnyLuckyBlock, ModBlocks.littleKellyMcLuckyBlock, ModBlocks.littleLizardGamingLuckyBlock, ModBlocks.maxTheMonkeyLuckyBlock, ModBlocks.sharkyLuckyBlock, ModBlocks.tinyTurtleLuckyBlock, ModBlocks.aphmauLuckyBlock, ModBlocks.scubaSteveLuckyBlock, ModBlocks.littleRopoLuckyBlock,
          //  ModBlocks.mrCrainerLuckyBlock, ModBlocks.littleAngelLuckyBlock
      };

    /**
     * Summon Blocks As Drop With Loops
     * Par World,BlockPos,Block,loop(how many items you want to summon),style(1=down-top, anything else simple.),skip(ONLY USE FOR STYLE=1)
     */
    public static void summonBlockWithLoop(World worldIn, BlockPos pos, Block block, int loop, int style, int skip) {

        float f = 0.5F;
        double d0 = (double) (worldIn.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
        double d1 = (double) (worldIn.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
        double d2 = (double) (worldIn.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;

        ItemEntity entityitem = new ItemEntity(worldIn, (double) pos.getX() + d0, (double) pos.getY() + d1, (double) pos.getZ() + d2, new ItemStack(block));
        entityitem.setDefaultPickupDelay();
        for (int i = 0; i <= loop - 1; i++) {

            if (style == 1) {
                ItemEntity entityitem1 = new ItemEntity(worldIn, (double) pos.getX(), (double) pos.getY() + i + skip, (double) pos.getZ(), new ItemStack(block));
                worldIn.addEntity(entityitem1);
            } else {
                ItemEntity entityitem1 = new ItemEntity(worldIn, (double) pos.getX() + d0, (double) pos.getY() + d1, (double) pos.getZ() + d2, new ItemStack(block));
                worldIn.addEntity(entityitem1);
            }
        }
    }

    /**
     * Summons A Block/Item Like A Drop
     */
    public static void summonDrop(BlockPos pos, World worldIn, ItemStack stack) {

        float f = 0.5F;

        double d0 = worldIn.rand.nextFloat() * f + (1.0F - f) * 0.5D;
        double d1 = worldIn.rand.nextFloat() * f + (1.0F - f) * 0.5D;
        double d2 = worldIn.rand.nextFloat() * f + (1.0F - f) * 0.5D;

        ItemEntity entityItem = new ItemEntity(worldIn, pos.getX() + d0, pos.getY() + d1, pos.getZ() + d2, stack);

        entityItem.setDefaultPickupDelay();
        worldIn.addEntity(entityItem);
    }

    /**
     * Set TNT on top of random block.
     * from location of block broken to x+5 x-5 z+5 z-5
     */

    public static void setTntWithBlock(World worldIn, BlockPos pos, Random rand) {
        //Pick a random base block from this list
        Block[] possibleBlocks = {
                Blocks.DIAMOND_BLOCK,
                Blocks.OBSIDIAN,
                Blocks.DIRT,
                Blocks.OAK_LOG,
                Blocks.ANVIL,
                Blocks.DRAGON_EGG
        };

        Block random = possibleBlocks[rand.nextInt(possibleBlocks.length)];

        for (int i = 0; i <= 4; i++) {
            BlockPos a = new BlockPos(pos.getX() + 5, pos.getY(), pos.getZ() - 2 + i);
            setBlocksForTNT(worldIn, random, a);
        }
        for (int i = 0; i <= 4; i++) {
            BlockPos a = new BlockPos(pos.getX() - 5, pos.getY(), pos.getZ() + 2 - i);
            setBlocksForTNT(worldIn, random, a);
        }
        for (int i = 0; i <= 4; i++) {
            BlockPos a = new BlockPos(pos.getX() - 2 + i, pos.getY(), pos.getZ() + 5);
            setBlocksForTNT(worldIn, random, a);
        }
        for (int i = 0; i <= 4; i++) {
            BlockPos a = new BlockPos(pos.getX() + 2 - i, pos.getY(), pos.getZ() - 5);
            setBlocksForTNT(worldIn, random, a);
        }
    }

    private static void setBlocksForTNT(World worldIn, Block random, BlockPos a) {
        worldIn.setBlockState(a, random.getDefaultState(), 3);
        BlockPos b = new BlockPos(a.getX(), a.getY() + 1, a.getZ());
        worldIn.setBlockState(b, Blocks.TNT.getDefaultState(), 3);
        BlockPos c = new BlockPos(b.getX(), b.getY() + 1, b.getZ());
        worldIn.setBlockState(c, Blocks.FIRE.getDefaultState(), 3);
    }

    public static void summonEnchantedItemAsDrop(World worldIn, BlockPos pos, Item i, String name, Enchantment e, int amp) {
        ItemStack itemE = new ItemStack(i);
        itemE.addEnchantment(e, amp);
        itemE.setDisplayName(new StringTextComponent(name));
        summonDrop(pos, worldIn, itemE);
    }

    /**
     * Tp to Random Loc.
     */

    public static void tpPlayer(PlayerEntity player) {
        if (player == null || player.world.isRemote) return;

        if (player instanceof PlayerEntity) {
            ServerPlayerEntity sp = (ServerPlayerEntity) player;
            ServerWorld world = sp.getServerWorld();

            double newY = sp.getPosY() + 500;
            if (newY > world.getHeight()) {
                newY = world.getHeight() - 1;
            }
            double x = sp.getPosX();
            double z = sp.getPosZ();

            sp.teleport(world, x, newY, z, sp.rotationYaw, sp.rotationPitch);
        }
    }

    public static void setOneBlock(World worldIn, BlockPos pos, Block block) {

        if (worldIn.isRemote) return;

        BlockPos basePos = pos.east();

        if (block instanceof BedBlock) {
            placeBed(worldIn, basePos, (BedBlock) block);
            return;
        }

        if (block instanceof DoorBlock) {
            placeDoor(worldIn, basePos, (DoorBlock) block);
            return;
        }

        if (block instanceof TallFlowerBlock || block instanceof TallGrassBlock) {
            placeDoublePlant(worldIn, basePos, block);
            return;
        }
        worldIn.setBlockState(basePos, block.getDefaultState(), 3);
    }

    private static void placeDoor(World worldIn, BlockPos pos, DoorBlock door) {

        Direction facing = Direction.NORTH;

        worldIn.setBlockState(
                pos,
                door.getDefaultState()
                        .with(DoorBlock.HALF, DoubleBlockHalf.LOWER)
                        .with(DoorBlock.FACING, facing), 3
        );

        worldIn.setBlockState(
                pos.up(),
                door.getDefaultState()
                        .with(DoorBlock.HALF, DoubleBlockHalf.UPPER)
                        .with(DoorBlock.FACING, facing), 3
        );
    }

    private static void placeDoublePlant(World worldIn, BlockPos pos, Block block) {

        worldIn.setBlockState(
                pos,
                block.getDefaultState()
                        .with(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER), 3
        );

        worldIn.setBlockState(
                pos.up(),
                block.getDefaultState()
                        .with(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER), 3
        );
    }

    private static void placeBed(World worldIn, BlockPos pos, BedBlock bed) {

        Direction facing = Direction.NORTH;

        worldIn.setBlockState(pos, bed.getDefaultState()
                        .with(BedBlock.PART, BedPart.FOOT)
                        .with(BedBlock.HORIZONTAL_FACING, facing), 3
        );

        worldIn.setBlockState(pos.offset(facing), bed.getDefaultState()
                        .with(BedBlock.PART, BedPart.HEAD)
                        .with(BedBlock.HORIZONTAL_FACING, facing), 3
        );
    }

    /**
     * Summon Items As Drop With Loops
     * Par World,BlockPos,Item,loop(how many items you want to summon),style(1=down-top, anything else simple.),skip(ONLY USE FOR STYLE=1)
     */

    public static void summonItemWithLoop(World worldIn, BlockPos pos, Item item, int loop, int style, int skip) {

        float f = 0.5F;
        double d0 = (double) (worldIn.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
        double d1 = (double) (worldIn.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
        double d2 = (double) (worldIn.rand.nextFloat() * f) + (double) (1.0F - f) * 0.5D;

        for (int i = 0; i <= loop - 1; i++) {

            if (style == 1) {
                ItemEntity entityitem1 = new ItemEntity(worldIn, (double) pos.getX(), (double) pos.getY() + i + skip, (double) pos.getZ(), new ItemStack(item));
                entityitem1.setDefaultPickupDelay();
                worldIn.addEntity(entityitem1);
            } else {
                ItemEntity entityitem1 = new ItemEntity(worldIn, (double) pos.getX() + d0, (double) pos.getY() + d1, (double) pos.getZ() + d2, new ItemStack(item));
                entityitem1.setDefaultPickupDelay();
                worldIn.addEntity(entityitem1);
            }
        }
    }

    /**
     * Summon ItemsStack As Drop With Loops
     * Par World,BlockPos,Itemstack,loop(how many items you want to summon),style(1=down-top, anything else simple.),skip(ONLY USE FOR STYLE=1. Lowers the start height)
     */

    public static void summonItemStackWithLoop(World worldIn, BlockPos pos, ItemStack item, int loop, int style, int skip) {
        float f = 0.5F;
        double d0 = (double)(worldIn.rand.nextFloat() * f) + (1.0D - f) * 0.5D;
        double d1 = (double)(worldIn.rand.nextFloat() * f) + (1.0D - f) * 0.5D;
        double d2 = (double)(worldIn.rand.nextFloat() * f) + (1.0D - f) * 0.5D;

        for (int i = 0; i < loop; i++) {
            ItemStack stackCopy = item.copy();
            ItemEntity entityItem;

            if (style == 1) {
                entityItem = new ItemEntity(worldIn, pos.getX(), pos.getY() + i + skip, pos.getZ(), stackCopy);
            } else {
                entityItem = new ItemEntity(worldIn, pos.getX() + d0, pos.getY() + d1, pos.getZ() + d2, stackCopy);
            }
            entityItem.setDefaultPickupDelay();
            worldIn.addEntity(entityItem);
        }
    }

    /**
     * lets make a troll chat XD
     */
    public static void trollChat(PlayerEntity player) {
        if (!player.world.isRemote) { //Only execute on server side
            TextComponent message = TextComponentHelper.createComponentTranslation(player, "message.troll", player.getDisplayName());
            message.mergeStyle(TextFormatting.BLUE);
            player.sendMessage(message, player.getUniqueID());
        }
    }

    public static void createHole(World worldIn, BlockPos pos, boolean includeBottom) {

        if (worldIn.isRemote) return;

        int h = pos.getY();

        int limit = includeBottom ? h : h - 1;

        for (int i = 0; i <= limit; i++) {

            BlockPos target = pos.down(i);

            worldIn.setBlockState(target, Blocks.AIR.getDefaultState(), 2);
        }
    }

    /**
     * Kits!
     */

    public static void redstoneKit(World worldIn, BlockPos pos) {
        summonItemWithLoop(worldIn, pos, Items.REDSTONE, 64, 0, 0);
        summonBlockWithLoop(worldIn, pos, Blocks.STICKY_PISTON, 20, 0, 0);
        summonItemWithLoop(worldIn, pos, Items.SLIME_BALL, 40, 1, 5);
        summonItemWithLoop(worldIn, pos, Items.REPEATER, 10, 0, 0);
    }

    public static void foodKit(World worldIn, BlockPos pos) {
        summonDrop(pos, worldIn, new ItemStack(Blocks.CAKE));
        summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.ENCHANTED_GOLDEN_APPLE, 1), 10, 1, 30);
        summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.BREAD), 16, 1, 10);
        summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.APPLE), 5, 0, 0);
        summonDrop(pos, worldIn, new ItemStack(Items.GOLDEN_APPLE));
        summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.COOKED_BEEF), 34, 0, 0);
    }

    public static void materialKit(World worldIn, BlockPos pos, Random rand) {
        summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.DIAMOND), rand.nextInt(50) + 1, 1, rand.nextInt(5));
        summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.GOLD_INGOT), rand.nextInt(50) + 1, 1, rand.nextInt(15));
        summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.IRON_INGOT), rand.nextInt(30) + 1, 1, rand.nextInt(10));
        summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.EMERALD), rand.nextInt(40) + 1, 1, rand.nextInt(4));
        summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.COAL), rand.nextInt(10) + 1, 1, rand.nextInt(30));
        summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.CHEST_MINECART), rand.nextInt(10) + 1, 0, 0);
        summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.BLAZE_POWDER), rand.nextInt(64) + 1, 1, rand.nextInt(15));
    }

    public static void potionKit(World worldIn, BlockPos pos, Random rand) {

        ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.ENDER_PEARL), rand.nextInt(50) + 1, 0, 0);
        ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.ENDER_EYE), rand.nextInt(50) + 1, 0, 0);
        ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.MAGMA_CREAM), rand.nextInt(50) + 1, 0, 0);
        ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.BREWING_STAND), 1, 0, 0);
        ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.FERMENTED_SPIDER_EYE), rand.nextInt(50) + 1, 0, 0);
        ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.GLISTERING_MELON_SLICE), rand.nextInt(50) + 1, 0, 0);
        ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.GOLD_NUGGET), rand.nextInt(50) + 1, 0, 0);
        ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.SPIDER_EYE), rand.nextInt(50) + 1, 0, 0);
        ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.NETHER_WART), rand.nextInt(50) + 1, 0, 0);
        ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.GLASS_BOTTLE), rand.nextInt(50) + 1, 0, 0);
        ExtraFunctions.summonItemStackWithLoop(worldIn, pos, new ItemStack(Items.BLAZE_ROD), rand.nextInt(50) + 1, 0, 0);
    }

    public static void musicKit(World worldIn, BlockPos pos) {
        ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(Blocks.JUKEBOX));
        ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(Items.MUSIC_DISC_11));
        ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(Items.MUSIC_DISC_13));
        ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(Items.MUSIC_DISC_BLOCKS));
        ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(Items.MUSIC_DISC_CAT));
        ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(Items.MUSIC_DISC_CHIRP));
        ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(Items.MUSIC_DISC_FAR));
        ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(Items.MUSIC_DISC_MALL));
        ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(Items.MUSIC_DISC_MELLOHI));
        ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(Items.MUSIC_DISC_STAL));
        ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(Items.MUSIC_DISC_STRAD));
        ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(Items.MUSIC_DISC_WAIT));
        ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(Items.MUSIC_DISC_WARD));
        ExtraFunctions.summonDrop(pos, worldIn, new ItemStack(Items.MUSIC_DISC_PIGSTEP));
    }

    public static void hellWellStructure(World worldIn, BlockPos pos, Random rand) {

        if (worldIn.isRemote) {
            return;
        }

        //Shift structure 2 blocks east
        BlockPos basePos = pos.east(2);

        //Center lava
        worldIn.setBlockState(basePos, Blocks.LAVA.getDefaultState(), 3);

        //Bottom ring
        worldIn.setBlockState(basePos.add(0, 0, 1), Blocks.NETHER_BRICKS.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(0, 0, -1), Blocks.NETHER_BRICKS.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(-1, 0, -1), Blocks.NETHER_BRICKS.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(-1, 0, 0), Blocks.NETHER_BRICKS.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(1, 0, 0), Blocks.NETHER_BRICKS.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(1, 0, -1), Blocks.NETHER_BRICKS.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(-1, 0, 1), Blocks.NETHER_BRICKS.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(1, 0, 1), Blocks.NETHER_BRICKS.getDefaultState(), 3);

        int r = rand.nextInt(5) + 1;

        //Fence pillars
        for (int i = 0; i < r; i++) {

            worldIn.setBlockState(basePos.add(1, 1 + i, 1), Blocks.NETHER_BRICK_FENCE.getDefaultState(), 3);
            worldIn.setBlockState(basePos.add(-1, 1 + i, -1), Blocks.NETHER_BRICK_FENCE.getDefaultState(), 3);
            worldIn.setBlockState(basePos.add(1, 1 + i, -1), Blocks.NETHER_BRICK_FENCE.getDefaultState(), 3);
            worldIn.setBlockState(basePos.add(-1, 1 + i, 1), Blocks.NETHER_BRICK_FENCE.getDefaultState(), 3);
        }

        //Roof center
        worldIn.setBlockState(basePos.add(0, r + 1, 0), Blocks.GLOWSTONE.getDefaultState(), 3);

        //Roof corners
        worldIn.setBlockState(basePos.add(1, r + 1, 1), Blocks.NETHERRACK.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(-1, r + 1, -1), Blocks.NETHERRACK.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(-1, r + 1, 1), Blocks.NETHERRACK.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(1, r + 1, -1), Blocks.NETHERRACK.getDefaultState(), 3);

        //Top decorations
        worldIn.setBlockState(basePos.add(0, r + 2, 0), RegistrationHandler.LUCKY_PRESSURE_PLATE.get().getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(1, r + 2, 1), Blocks.FIRE.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(-1, r + 2, -1), Blocks.FIRE.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(-1, r + 2, 1), Blocks.FIRE.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(1, r + 2, -1), Blocks.FIRE.getDefaultState(), 3);

        //Roof sides
        worldIn.setBlockState(basePos.add(0, r + 1, -1), Blocks.NETHER_BRICKS.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(0, r + 1, 1), Blocks.NETHER_BRICKS.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(-1, r + 1, 0), Blocks.NETHER_BRICKS.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(1, r + 1, 0), Blocks.NETHER_BRICKS.getDefaultState(), 3);
    }

    public static void endWellStruct(World worldIn, BlockPos pos, Random rand) {

        if (worldIn.isRemote) {
            return;
        }

        //Shift structure east
        BlockPos basePos = pos.east(2);

        //Center water
        worldIn.setBlockState(basePos, Blocks.WATER.getDefaultState(), 3);

        //Bottom ring
        worldIn.setBlockState(basePos.add(0, 0, 1), Blocks.END_STONE.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(0, 0, -1), Blocks.END_STONE.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(-1, 0, -1), Blocks.END_STONE.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(-1, 0, 0), Blocks.END_STONE.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(1, 0, 0), Blocks.END_STONE.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(1, 0, -1), Blocks.END_STONE.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(-1, 0, 1), Blocks.END_STONE.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(1, 0, 1), Blocks.END_STONE.getDefaultState(), 3);
        int r = rand.nextInt(6) + 1;

        //Fence pillars
        for (int i = 0; i < r; i++) {

            worldIn.setBlockState(basePos.add(1, 1 + i, 1), Blocks.BIRCH_FENCE.getDefaultState(), 3);
            worldIn.setBlockState(basePos.add(-1, 1 + i, -1), Blocks.BIRCH_FENCE.getDefaultState(), 3);
            worldIn.setBlockState(basePos.add(1, 1 + i, -1), Blocks.BIRCH_FENCE.getDefaultState(), 3);
            worldIn.setBlockState(basePos.add(-1, 1 + i, 1), Blocks.BIRCH_FENCE.getDefaultState(), 3);
        }

        //Roof center
        worldIn.setBlockState(basePos.add(0, r + 1, 0), Blocks.BEACON.getDefaultState(), 3);

        //Roof corners
        worldIn.setBlockState(basePos.add(1, r + 1, 1), Blocks.OBSIDIAN.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(-1, r + 1, -1), Blocks.OBSIDIAN.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(-1, r + 1, 1), Blocks.OBSIDIAN.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(1, r + 1, -1), Blocks.OBSIDIAN.getDefaultState(), 3);

        //Top decorations
        worldIn.setBlockState(basePos.add(1, r + 2, 1), Blocks.END_PORTAL_FRAME.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(0, r + 2, 0), RegistrationHandler.LUCKY_PRESSURE_PLATE.get().getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(-1, r + 2, -1), Blocks.END_PORTAL_FRAME.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(-1, r + 2, 1), Blocks.END_PORTAL_FRAME.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(1, r + 2, -1), Blocks.END_PORTAL_FRAME.getDefaultState(), 3);

        //Roof sides
        worldIn.setBlockState(basePos.add(0, r + 1, -1), Blocks.END_STONE.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(0, r + 1, 1), Blocks.END_STONE.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(-1, r + 1, 0), Blocks.END_STONE.getDefaultState(), 3);
        worldIn.setBlockState(basePos.add(1, r + 1, 0), Blocks.END_STONE.getDefaultState(), 3);
    }

    public static void addEnchantsMany(ItemStack stack, Enchantment[] e, int amp, World worldIn, BlockPos pos) {

        for (Enchantment anE : e) {
            stack.addEnchantment(anE, amp);
        }
        summonDrop(pos, worldIn, stack);
    }

    public static void addRandomEnchtToRandomItems(World worldIn, ItemStack[] stack, Enchantment[] ench, int ampUpperLimit, BlockPos pos, Random rand) {
        if (stack.length == 0 || ench.length == 0) return;

        int r = rand.nextInt(stack.length);
        int a = rand.nextInt(stack.length);

        //Ensure the loop has a valid range
        if (a > r) {
            int temp = a;
            a = r;
            r = temp;
        } else if (a == r) {
            //If they're equal, sometimes spawn 1 item, sometimes none
            if (rand.nextBoolean()) {
                //Keep it as a single-item spawn
            } else if (a > 0) {
                a -= 1;
            } else if (r < stack.length - 1) {
                r += 1;
            }
        }

        //Randomly decide if we’ll skip spawning anything at all
        if (rand.nextInt(10) == 0) {
            // ~10% chance to skip entirely
            return;
        }

        //Loop through the chosen item range
        for (int i = Math.max(0, a); i <= r && i < stack.length; i++) {

            int y = rand.nextInt(ench.length);
            int z = rand.nextInt(ench.length);

            if (z > y) {
                int temp = y;
                y = z;
                z = temp;
            } else if (y == z && z > 0) {
                z -= 1;
            }
            for (int j = z; j < y && j < ench.length; j++) {
                if (rand.nextInt(3) != 0) { //About 66% chance to apply each potential enchant
                    int n = rand.nextInt(ench.length);
                    stack[i].addEnchantment(ench[n], rand.nextInt(ampUpperLimit) + 1);
                }
            }
            summonItemStackWithLoop(worldIn, pos, stack[i], 1, 0, 0);
        }
    }

    public static void mountain(World worldIn, BlockPos pos, Block block, Random rand) {

        if (worldIn.isRemote) return;

        int height = rand.nextInt(6) + 1;

        for (int y = 0; y < height; y++) {
            for (int offset = 0; offset < 3; offset++) {

                worldIn.setBlockState(pos.add(1 + offset, y, offset), block.getDefaultState(), 2);
            }
        }
    }

    public static void chat(String chat, PlayerEntity player) {

        if (!player.world.isRemote) { //Only send from server side
            player.sendMessage(new StringTextComponent(chat), player.getUniqueID());
        }
    }

    public static void burgerStruct(World worldIn, BlockPos pos, BlockState top, BlockState middle, BlockState bottom) {

        BlockPos basePos = pos.east();

        BlockState[] layers = new BlockState[] { bottom, middle, top };

        for (int y = 0; y < layers.length; y++) {
            BlockState state = layers[y];

            for (int x = 0; x < 3; x++) {
                for (int z = 0; z < 3; z++) {
                    worldIn.setBlockState(basePos.add(x, y, z), state, 3);
                }
            }
        }
    }

    public static void orcArmy(World worldIn, BlockPos pos, int loop, Random rand) {

        for (int i = 0; i <= loop - 1; i++) {

            ZombieEntity e = new ZombieEntity(worldIn);
            e.setPosition(pos.getX(), pos.getY(), pos.getZ());
            e.setCustomNameVisible(true);
            e.setCustomName(new StringTextComponent("Orc Army"));

            e.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(RegistrationHandler.YT_HELM.get()));

            switch (rand.nextInt(5)) {
                case 1: {
                    e.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
                    break;
                }
                case 2: {
                    e.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
                    break;
                }
                case 3: {
                    e.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.STONE_AXE));
                    break;
                }
                case 0: {
                    e.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.IRON_SWORD));
                    break;
                }

                case 4: {
                    e.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(RegistrationHandler.DEVIL_SWORD.get()));

                }
            }
            double offsetX = (worldIn.rand.nextDouble() - 0.5) * 3.0;
            double offsetZ = (worldIn.rand.nextDouble() - 0.5) * 3.0;

            e.setPosition(pos.getX() + 0.5 + offsetX, pos.getY(), pos.getZ() + 0.5 + offsetZ);
            worldIn.addEntity(e);
        }
    }

    public static void spawnTNT(World worldIn, BlockPos pos, PlayerEntity player, int amount, int radius, int heightSpacing)
    {
        for (int i = 0; i < amount; i++) {

            double x = pos.getX() + 0.5;
            double y = pos.getY() + (heightSpacing * i);
            double z = pos.getZ() + 0.5;

            if (radius > 0) {

                x += worldIn.rand.nextInt(radius * 2 + 1) - radius;
                z += worldIn.rand.nextInt(radius * 2 + 1) - radius;
            }

            TNTEntity tnt = new TNTEntity(worldIn, x, y, z, player);

            tnt.setFuse(worldIn.rand.nextInt(tnt.getFuse() / 4) + tnt.getFuse() / 8);

            worldIn.addEntity(tnt);
        }
    }

    public static void buildTower(World worldIn, BlockPos pos, Block[] fixedLayers, Block[] palette, int height) {

        BlockPos base = pos.east();

        for (int i = 0; i < height; i++) {

            BlockPos target = base.up(i);

            Block block;

            if (fixedLayers != null) {
                block = fixedLayers[Math.min(i, fixedLayers.length - 1)];
            } else {
                block = palette[worldIn.rand.nextInt(palette.length)];
            }

            worldIn.setBlockState(target, block.getDefaultState(), 3);
        }
    }

    public static void trollDiamondTrapWithChanceOfNotTroll(World worldIn, BlockPos pos, boolean isTrap) {

        if (isTrap) {
            setBlocksForTrollTrap(worldIn, pos);
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY() - 4, pos.getZ()), Blocks.LAVA.getDefaultState(), 3);

        } else {
            setBlocksForTrollTrap(worldIn, pos);
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY() - 4, pos.getZ()), Blocks.WATER.getDefaultState(), 3);
        }
    }

    private static void setBlocksForTrollTrap(World worldIn, BlockPos pos) {
        worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()), Blocks.DIAMOND_ORE.getDefaultState(), 3);
        worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY() - 2, pos.getZ()), Blocks.DIAMOND_ORE.getDefaultState(), 3);
        worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY() - 3, pos.getZ()), Blocks.DIAMOND_ORE.getDefaultState(), 3);
    }

    public static void summonCowNearby(World worldIn, BlockPos pos, int loop, Random rand) {

        for (int i = 0; i <= loop - 1; i++) {

            CowEntity e = new CowEntity(EntityType.COW,worldIn);
            e.setPosition(pos.getX() + rand.nextInt(30), pos.getY(), pos.getZ() + rand.nextInt(30));
            e.setCustomNameVisible(true);
            e.setDropChance(EquipmentSlotType.MAINHAND, 100F);
            e.setDropChance(EquipmentSlotType.HEAD,100F);
            e.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.GOLDEN_APPLE));
            e.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Items.GOLD_INGOT));
            e.setCustomName(new StringTextComponent("I AM SPECIAL"));
            worldIn.addEntity(e);
        }
    }

    public static void luckyBlockTower(World worldIn, BlockPos pos) {

        for (int i = 0; i < b.length; i++) {
            setOneBlock(worldIn, new BlockPos(pos.getX(), pos.getY() + i, pos.getZ()), b[i]);
        }
    }

    public static void effectPlayer(PlayerEntity player, EffectInstance effect) {
        player.addPotionEffect(effect);
    }

    public static void setHoleWithMites(World worldIn, PlayerEntity player) {

        double x = player.getPosX() - 1;
        double y = player.getPosY();
        double z = player.getPosZ() - 1;

        worldIn.setBlockState(new BlockPos(x, y - 1, z), Blocks.AIR.getDefaultState());
        worldIn.setBlockState(new BlockPos(x, y - 2, z), Blocks.AIR.getDefaultState());
        worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), Blocks.AIR.getDefaultState());
        worldIn.setBlockState(new BlockPos(x + 1, y - 2, z), Blocks.AIR.getDefaultState());
        worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), Blocks.AIR.getDefaultState());
        worldIn.setBlockState(new BlockPos(x, y - 2, z + 1), Blocks.AIR.getDefaultState());
        worldIn.setBlockState(new BlockPos(x + 1, y - 1, z + 1), Blocks.AIR.getDefaultState());
        worldIn.setBlockState(new BlockPos(x + 1, y - 2, z + 1), Blocks.AIR.getDefaultState());

        ExtraFunctions.summonMobs(EntityType.ENDERMITE, 50, worldIn, new BlockPos(x, y, z), 0,null);
    }

    public static void flyingIsle(World worldIn, BlockPos pos) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                worldIn.setBlockState(new BlockPos(pos.getX() + i, pos.getY() + 40, pos.getZ() + j), Blocks.DIAMOND_BLOCK.getDefaultState(), 3);
        }
    }

    public static void blockRain(World worldIn, BlockPos pos, Block block, int radius, int height) {

        if (worldIn.isRemote) return;

        if (radius <= 0) {
            worldIn.setBlockState(pos.up(height), block.getDefaultState(), 2);
            return;
        }

        for (int x = -radius; x < radius; x++) {
            for (int z = -radius; z < radius; z++) {

                worldIn.setBlockState(pos.add(x, height, z), block.getDefaultState(), 2);
            }
        }
    }

    public static void slimeFort(World worldIn, PlayerEntity player) {
        worldIn.setBlockState(new BlockPos(player.getPosX(), player.getPosY() - 1, player.getPosZ()), Blocks.SLIME_BLOCK.getDefaultState());
        worldIn.setBlockState(new BlockPos(player.getPosX() + 1, player.getPosY() - 1, player.getPosZ()), Blocks.SLIME_BLOCK.getDefaultState());
        worldIn.setBlockState(new BlockPos(player.getPosX() - 1, player.getPosY() - 1, player.getPosZ()), Blocks.SLIME_BLOCK.getDefaultState());
        worldIn.setBlockState(new BlockPos(player.getPosX(), player.getPosY() - 1, player.getPosZ() + 1), Blocks.SLIME_BLOCK.getDefaultState());
        worldIn.setBlockState(new BlockPos(player.getPosX(), player.getPosY() - 1, player.getPosZ() - 1), Blocks.SLIME_BLOCK.getDefaultState());
        worldIn.setBlockState(new BlockPos(player.getPosX() + 1, player.getPosY() - 1, player.getPosZ() + 1), Blocks.SLIME_BLOCK.getDefaultState());
        worldIn.setBlockState(new BlockPos(player.getPosX() - 1, player.getPosY() - 1, player.getPosZ() - 1), Blocks.SLIME_BLOCK.getDefaultState());
        worldIn.setBlockState(new BlockPos(player.getPosX() - 1, player.getPosY() - 1, player.getPosZ() + 1), Blocks.SLIME_BLOCK.getDefaultState());
        worldIn.setBlockState(new BlockPos(player.getPosX() + 1, player.getPosY() - 1, player.getPosZ() - 1), Blocks.SLIME_BLOCK.getDefaultState());
        }

    //Summons 40 blocks in each dir.

    public static void parabolaStruct(World worldIn, BlockPos pos) {
        for (int i = 0; i < 80; i++) {
            ExtraFunctions.setOneBlock(worldIn, new BlockPos(pos.getX(), pos.getY() + i, pos.getZ() + i), Blocks.ACACIA_PLANKS);
        }
        for (int i = 0; i < 80; i++) {
            ExtraFunctions.setOneBlock(worldIn, new BlockPos(pos.getX() + i, pos.getY() + i, pos.getZ()), Blocks.COAL_ORE);
        }
        for (int i = 0; i < 80; i++) {
            ExtraFunctions.setOneBlock(worldIn, new BlockPos(pos.getX() - i, pos.getY() + i, pos.getZ()), Blocks.QUARTZ_BLOCK);
        }
        for (int i = 0; i < 80; i++) {
            ExtraFunctions.setOneBlock(worldIn, new BlockPos(pos.getX(), pos.getY() + i, pos.getZ() - i), Blocks.OBSIDIAN);
        }
    }//TODO ENHANCE THIS THING.

    public static void saflyTeleportPlayer(World worldIn, ServerPlayerEntity player) {
        flyingIsle(worldIn, new BlockPos(player.getPosX(), player.getPosY(), player.getPosZ()));
        tpPlayer(player);
    }

    public static void tntPlaceNearby(World worldIn, BlockPos pos, int amOfTNT, Random rand) {
        for (int i = 0; i < amOfTNT; i++) {
            worldIn.setBlockState(new BlockPos(pos.getX() + rand.nextInt(30), pos.getY() + rand.nextInt(30), pos.getZ() + rand.nextInt(30)), Blocks.TNT.getDefaultState(), 2);
        }
    }

    public static void luckyBlockBox(World worldIn, BlockPos pos, Random r) {

        for (int k = 0; k < 4; k++)
            for (int i = -1; i < 4; i++)
                for (int j = 0; j < 5; j++)
                    ExtraFunctions.setOneBlock(worldIn, new BlockPos(pos.getX() - 2 + j, pos.getY() - 1 + k, pos.getZ() + i), Blocks.RED_SANDSTONE);

        for (int k = 0; k < 2; k++)
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    ExtraFunctions.setOneBlock(worldIn, new BlockPos(pos.getX() - 1 + j, pos.getY() + k, pos.getZ() + i), b[r.nextInt(b.length)]);
    }

    //TODO fake apple
    //TODO Invisible set
    //TODO armr--ghst
    //

    public static void deathHole(World worldIn, PlayerEntity player) {
        double x = player.getPosX();
        double y = player.getPosY();
        double z = player.getPosZ();

        for (int i = 1; i < (int) y; i++) {
            setOneBlock(worldIn, new BlockPos(x, y - i, z), Blocks.COBWEB);
        }
    }
    /*
	 * IT SAYS SOMETHING AND DOES SOMETHING

    public static void tornadoStruct(World worldIn, BlockPos pos, Random r) {
        summonItemAsDrop(pos, worldIn, new ItemStack(b[r.nextInt(b.length)]));
    }*/

    public static Item randomBlock() {
        Random rand = new Random();
        return Item.getItemFromBlock(b[rand.nextInt(b.length)]);
    }

    public static void fireCamp(World worldIn, PlayerEntity player) {

        setOneBlock(worldIn, new BlockPos(player.getPosX(), player.getPosY() - 1, player.getPosZ()), Blocks.NETHERRACK);
        setOneBlock(worldIn, new BlockPos(player.getPosX(), player.getPosY(), player.getPosZ()), Blocks.FIRE);
        double x = player.getPosX();
        double y = player.getPosY();
        double z = player.getPosZ();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++)
                    setOneBlock(worldIn, new BlockPos(x - 3 + j, y - 3 + i, z + k), Blocks.TNT);
            }
        }
        ExtraFunctions.spawnTNT(worldIn, new BlockPos(x,y,z), player, 1, 0, 0);
    }

    public static void tpPlayerInGround(PlayerEntity player) {
        double x = player.getPosX();
        double y = player.getPosY() - 3; //Move the player down by 3 blocks.
        double z = player.getPosZ();

        player.setPositionAndUpdate(x, y, z);
    }

    public static void obsidianCageStruct(World worldIn, PlayerEntity player) {
        double x = player.getPosX();
        double y = player.getPosY();
        double z = player.getPosZ();

        setOneBlock(worldIn, new BlockPos(x + 1, y, z), Blocks.OBSIDIAN);
        setOneBlock(worldIn, new BlockPos(x + 1, y + 1, z), Blocks.OBSIDIAN);

        setOneBlock(worldIn, new BlockPos(x - 1, y, z), Blocks.OBSIDIAN);
        setOneBlock(worldIn, new BlockPos(x - 1, y + 1, z), Blocks.OBSIDIAN);

        setOneBlock(worldIn, new BlockPos(x, y, z + 1), Blocks.OBSIDIAN);
        setOneBlock(worldIn, new BlockPos(x, y + 1, z + 1), Blocks.OBSIDIAN);

        setOneBlock(worldIn, new BlockPos(x, y, z - 1), Blocks.OBSIDIAN);
        setOneBlock(worldIn, new BlockPos(x, y + 1, z - 1), Blocks.OBSIDIAN);

        setOneBlock(worldIn, new BlockPos(x, y - 1, z), Blocks.OBSIDIAN);
        setOneBlock(worldIn, new BlockPos(x, y + 2, z), Blocks.OBSIDIAN);
    }

    public static <T extends MobEntity> void summonMobs(EntityType<T> type, int loop, World worldIn, BlockPos pos, int radius, @Nullable Consumer<T> customizer) {

        if (worldIn.isRemote) return;

        ServerWorld serverWorld = (ServerWorld) worldIn;

        for (int i = 0; i < loop; i++) {

            T mob = type.create(serverWorld);
            if (mob == null) continue;

            double x;
            double y;
            double z;

            if (radius <= 0) {
                x = pos.getX() + 0.5D;
                y = pos.getY() + 1.1D;
                z = pos.getZ() + 0.5D;
            } else {
                double offsetX = (serverWorld.rand.nextDouble() - 0.5D) * radius;
                double offsetZ = (serverWorld.rand.nextDouble() - 0.5D) * radius;

                x = pos.getX() + offsetX;
                y = pos.getY();
                z = pos.getZ() + offsetZ;
            }

            BlockPos spawnPos = new BlockPos(x, y, z);

            mob.setPosition(x, y, z);

            while (!serverWorld.hasNoCollisions(mob) && spawnPos.getY() < serverWorld.getHeight()) {
                spawnPos = spawnPos.up();
                mob.setPosition(spawnPos.getX() + 0.5D, spawnPos.getY(), spawnPos.getZ() + 0.5D);
            }

            mob.setLocationAndAngles(spawnPos.getX() + 0.5D, spawnPos.getY(), spawnPos.getZ() + 0.5D, serverWorld.rand.nextFloat() * 360F, 0F);
            mob.onInitialSpawn(serverWorld, serverWorld.getDifficultyForLocation(spawnPos), SpawnReason.EVENT, null, null);

            if (customizer != null) {
                customizer.accept(mob);
            }

            serverWorld.addEntity(mob);
        }
    }
}//CLASS END HERE