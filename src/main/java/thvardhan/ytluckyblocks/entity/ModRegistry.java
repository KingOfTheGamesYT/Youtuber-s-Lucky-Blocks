package thvardhan.ytluckyblocks.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraftforge.registries.IForgeRegistry;
import thvardhan.ytluckyblocks.Main;
import thvardhan.ytluckyblocks.blocks.BlockItemBase;
import thvardhan.ytluckyblocks.blocks.DiamondButton;
import thvardhan.ytluckyblocks.items.M_sword;

import static thvardhan.ytluckyblocks.items.ModItemTier.MSWORD;

public class ModRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Main.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);

    public static void init() {
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<EntityType<EntityScubaSteve>> SCUBA_STEVE = ENTITIES
            .register("scuba_steve",
                    () -> EntityType.Builder.<EntityScubaSteve>create(EntityScubaSteve::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "scuba_steve").toString()));

    public static final RegistryObject<EntityType<EntityAlexirCraft>> ALEXIRCRAFT = ENTITIES
            .register("alexircraft",
                    () -> EntityType.Builder.<EntityAlexirCraft>create(EntityAlexirCraft::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "alexircraft").toString()));

    public static final RegistryObject<EntityType<EntityAntVenom>> ANTVENNOM = ENTITIES
            .register("antvenom",
                    () -> EntityType.Builder.<EntityAntVenom>create(EntityAntVenom::new, EntityClassification.CREATURE)
                            .size(0.8F, 3.1F)
                            .build(new ResourceLocation(Main.MODID, "antvenom").toString()));

    public static final RegistryObject<EntityType<EntityAphmau>> APHMAU = ENTITIES
            .register("aphmau",
                    () -> EntityType.Builder.<EntityAphmau>create(EntityAphmau::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "aphmau").toString()));

    public static final RegistryObject<EntityType<EntityBabyAngel>> BABY_ANGEL = ENTITIES
            .register("baby_angel",
                    () -> EntityType.Builder.<EntityBabyAngel>create(EntityBabyAngel::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "baby_angel").toString()));

    public static final RegistryObject<EntityType<EntityBabyDuck>> BABY_DUCK = ENTITIES
            .register("baby_duck",
                    () -> EntityType.Builder.<EntityBabyDuck>create(EntityBabyDuck::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "baby_duck").toString()));

    public static final RegistryObject<EntityType<EntityBabyLeah>> BABY_LEAH = ENTITIES
            .register("baby_leah",
                    () -> EntityType.Builder.<EntityBabyLeah>create(EntityBabyLeah::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "baby_leah").toString()));

    public static final RegistryObject<EntityType<EntityBabyMax>> BABY_MAX = ENTITIES
            .register("baby_max",
                    () -> EntityType.Builder.<EntityBabyMax>create(EntityBabyMax::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "baby_max").toString()));

    public static final RegistryObject<EntityType<EntityBajanCanadian>> BABJANCANADIAN = ENTITIES
            .register("bajancanadian",
                    () -> EntityType.Builder.<EntityBajanCanadian>create(EntityBajanCanadian::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "bajancanadian").toString()));

    public static final RegistryObject<EntityType<EntityCaptainSparklez>> CAPTAIN_SPARKLEZ = ENTITIES
            .register("captain_sparklez",
                    () -> EntityType.Builder.<EntityCaptainSparklez>create(EntityCaptainSparklez::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "captain_sparklez").toString()));

    public static final RegistryObject<EntityType<EntityCassieTheCat>> CASSIE_THE_CAT = ENTITIES
            .register("cassie_the_cat",
                    () -> EntityType.Builder.<EntityCassieTheCat>create(EntityCassieTheCat::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "cassie_the_cat").toString()));
    public static final RegistryObject<EntityType<EntityDanTDM>> DANTDM = ENTITIES
            .register("dantdm",
                    () -> EntityType.Builder.<EntityDanTDM>create(EntityDanTDM::new, EntityClassification.CREATURE)
                            .size(1F, 5F)
                            .build(new ResourceLocation(Main.MODID, "dantdm").toString()));

    public static final RegistryObject<EntityType<EntityDonutTheDog>> DONUT_THE_DOG = ENTITIES
            .register("donutthedog",
                    () -> EntityType.Builder.<EntityDonutTheDog>create(EntityDonutTheDog::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "donutthedog").toString()));

    public static final RegistryObject<EntityType<EntityEvilLittleKelly>> EVIL_LITTLE_KELLY = ENTITIES
            .register("evil_little_kelly",
                    () -> EntityType.Builder.<EntityEvilLittleKelly>create(EntityEvilLittleKelly::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "evil_little_kelly").toString()));

    public static final RegistryObject<EntityType<EntityExplodingTNT>> EXPLODING_TNT = ENTITIES
            .register("exploding_tnt",
                    () -> EntityType.Builder.<EntityExplodingTNT>create(EntityExplodingTNT::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "exploding_tnt").toString()));

    public static final RegistryObject<EntityType<EntityFrizzleandpop>> FRIZZLEANDPOP = ENTITIES
            .register("frizzleandpop",
                    () -> EntityType.Builder.<EntityFrizzleandpop>create(EntityFrizzleandpop::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "frizzleandpop").toString()));

    public static final RegistryObject<EntityType<EntityIhasCupquake>> IHASCUPQUAKE = ENTITIES
            .register("ihascupquake",
                    () -> EntityType.Builder.<EntityIhasCupquake>create(EntityIhasCupquake::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "ihascupquake").toString()));

    public static final RegistryObject<EntityType<EntityISquid>> ISQUID = ENTITIES
            .register("isquid",
                    () -> EntityType.Builder.<EntityISquid>create(EntityISquid::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "isquid").toString()));

    public static final RegistryObject<EntityType<EntityJeromeASF>> JEROMEASF = ENTITIES
            .register("jeromeasf",
                    () -> EntityType.Builder.<EntityJeromeASF>create(EntityJeromeASF::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "jeromeasf").toString()));

    public static final RegistryObject<EntityType<EntityLachlan>> LACHLAN = ENTITIES
            .register("lachlan",
                    () -> EntityType.Builder.<EntityLachlan>create(EntityLachlan::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "lachlan").toString()));

    public static final RegistryObject<EntityType<EntityLDShadowLady>> LDSHADOWLADY = ENTITIES
            .register("ldshadowlady",
                    () -> EntityType.Builder.<EntityLDShadowLady>create(EntityLDShadowLady::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "ldshadowlady").toString()));

    public static final RegistryObject<EntityType<EntityLittleAlly>> LITTLEALLY = ENTITIES
            .register("little_ally",
                    () -> EntityType.Builder.<EntityLittleAlly>create(EntityLittleAlly::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "little_ally").toString()));

    public static final RegistryObject<EntityType<EntityLittleCarlyMC>> LITTLECARLYMC = ENTITIES
            .register("little_carlymc",
                    () -> EntityType.Builder.<EntityLittleCarlyMC>create(EntityLittleCarlyMC::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "little_carlymc").toString()));

    public static final RegistryObject<EntityType<EntityLittleDonny>> LITTLEDONNY= ENTITIES
            .register("little_donny",
                    () -> EntityType.Builder.<EntityLittleDonny>create(EntityLittleDonny::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "little_donny").toString()));

    public static final RegistryObject<EntityType<EntityLittleKellyMC>> LITTLEKELLYMC = ENTITIES
            .register("little_kellymc",
                    () -> EntityType.Builder.<EntityLittleKellyMC>create(EntityLittleKellyMC::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "little_kellymc").toString()));

    public static final RegistryObject<EntityType<EntityLittleLizardGaming>> LITTLELIZARDGAMING = ENTITIES
            .register("little_lizard_gaming",
                    () -> EntityType.Builder.<EntityLittleLizardGaming>create(EntityLittleLizardGaming::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "little_lizard_gaming").toString()));

    public static final RegistryObject<EntityType<EntityLittleRopo>> LITTLEROPO = ENTITIES
            .register("little_ropo",
                    () -> EntityType.Builder.<EntityLittleRopo>create(EntityLittleRopo::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "little_ropo").toString()));

    public static final RegistryObject<EntityType<EntityMaxTheMonkey>> MAXTHEMONKEY = ENTITIES
            .register("max_the_monkey",
                    () -> EntityType.Builder.<EntityMaxTheMonkey>create(EntityMaxTheMonkey::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "max_the_monkey").toString()));

    public static final RegistryObject<EntityType<EntityMrCrainer>> MRCRAINER = ENTITIES
            .register("mrcrainer",
                    () -> EntityType.Builder.<EntityMrCrainer>create(EntityMrCrainer::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "mrcrainer").toString()));

    public static final RegistryObject<EntityType<EntityMrWoofless>> MRWOOFLESS = ENTITIES
            .register("mrwoofless",
                    () -> EntityType.Builder.<EntityMrWoofless>create(EntityMrWoofless::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "mrwoofless").toString()));

    public static final RegistryObject<EntityType<EntityPeteZahHutt>> PETEZAHHUTT = ENTITIES
            .register("petezahhutt",
                    () -> EntityType.Builder.<EntityPeteZahHutt>create(EntityPeteZahHutt::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "petezahhutt").toString()));

    public static final RegistryObject<EntityType<EntityPinkSheep>> PINKSHEEP = ENTITIES
            .register("pink_sheep",
                    () -> EntityType.Builder.<EntityPinkSheep>create(EntityPinkSheep::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "pink_sheep").toString()));

    public static final RegistryObject<EntityType<EntityPrestonPlayz>> PRESTONPLAYZ = ENTITIES
            .register("preston_playz",
                    () -> EntityType.Builder.<EntityPrestonPlayz>create(EntityPrestonPlayz::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "preston_playz").toString()));

    public static final RegistryObject<EntityType<EntitySharky>> SHARKY = ENTITIES
            .register("sharky_lucky",
                    () -> EntityType.Builder.<EntitySharky>create(EntitySharky::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "sharky_luckyz").toString()));

    public static final RegistryObject<EntityType<EntityTinyTurtle>> TINYTURTLE = ENTITIES
            .register("tiny_turtle",
                    () -> EntityType.Builder.<EntityTinyTurtle>create(EntityTinyTurtle::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "tiny_turtle").toString()));

    public static final RegistryObject<EntityType<EntityVikkstar123>> VIKKSTAR123 = ENTITIES
            .register("vikkstar123",
                    () -> EntityType.Builder.<EntityVikkstar123>create(EntityVikkstar123::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "vikkstar123").toString()));

    public static final RegistryObject<EntityType<EntitySSundee>> SSUNDEE = ENTITIES
            .register("ssundee",
                    () -> EntityType.Builder.<EntitySSundee>create(EntitySSundee::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "ssundee").toString()));

    public static final RegistryObject<EntityType<EntityStampylonghead>> STAMPYLONGHEAD = ENTITIES
            .register("stampylonghead",
                    () -> EntityType.Builder.<EntityStampylonghead>create(EntityStampylonghead::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "stampylonghead").toString()));

    public static final RegistryObject<EntityType<EntityTewity>> TEWITY = ENTITIES
            .register("tewity",
                    () -> EntityType.Builder.<EntityTewity>create(EntityTewity::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "tewity").toString()));

    public static final RegistryObject<EntityType<EntityThnxCya>> THNXCYA = ENTITIES
            .register("thnxcya",
                    () -> EntityType.Builder.<EntityThnxCya>create(EntityThnxCya::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "thnxcya").toString()));

    public static final RegistryObject<EntityType<EntityLogDotZip>> LOGDOTZIP = ENTITIES
            .register("logdotzip",
                    () -> EntityType.Builder.<EntityLogDotZip>create(EntityLogDotZip::new, EntityClassification.CREATURE)
                            .size(0.6F, 1.95F)
                            .build(new ResourceLocation(Main.MODID, "logdotzip").toString()));

    public static final RegistryObject<EntityType<EntityPopularMMO>> POPULARMMOS = ENTITIES
            .register("popularmmos",
                    () -> EntityType.Builder.<EntityPopularMMO>create(EntityPopularMMO::new, EntityClassification.CREATURE)
                            .size(1F, 1.95F)
                            .build(new ResourceLocation(Main.MODID, "popularmmos").toString()));

    public static final RegistryObject<EntityType<EntitySerialPlayer>> SERIALPLAYER = ENTITIES
            .register("serial_player",
                    () -> EntityType.Builder.<EntitySerialPlayer>create(EntitySerialPlayer::new, EntityClassification.CREATURE)
                            .size(0.5F, 1F)
                            .build(new ResourceLocation(Main.MODID, "serial_player").toString()));

    public static final RegistryObject<EntityType<EntitySuperGirlyGamer>> SUPERGIRLYGAMER = ENTITIES
            .register("super_girly_gamer",
                    () -> EntityType.Builder.<EntitySuperGirlyGamer>create(EntitySuperGirlyGamer::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "super_girly_gamer").toString()));

    public static final RegistryObject<EntityType<EntitySkyDoesMinecraft>> SKYDOESMINECRAFT = ENTITIES
            .register("sky_does_minecraft",
                    () -> EntityType.Builder.<EntitySkyDoesMinecraft>create(EntitySkyDoesMinecraft::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "sky_does_minecraft").toString()));

    public static final RegistryObject<EntityType<EntityTruemu>> TRUEMU = ENTITIES
            .register("truemu",
                    () -> EntityType.Builder.<EntityTruemu>create(EntityTruemu::new, EntityClassification.CREATURE)
                            .size(0.6F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "truemu").toString()));

    public static final RegistryObject<EntityType<EntityGhost>> GHOST = ENTITIES
            .register("ghost",
                    () -> EntityType.Builder.<EntityGhost>create(EntityGhost::new, EntityClassification.CREATURE)
                            .size(0.8F, 2.0F)
                            .build(new ResourceLocation(Main.MODID, "ghost").toString()));

    public static final RegistryObject<Item> ALEXIRCRAFT_SPAWN_EGG = ITEMS.register("alexircraft_spawn_egg", () -> new ForgeSpawnEggItem(ModRegistry.ALEXIRCRAFT, 0xcc00cc, 0x330033, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> ANTVENOM_SPAWN_EGG = ITEMS.register("antvenom_spawn_egg", () -> new ForgeSpawnEggItem(ModRegistry.ANTVENNOM, 0x77b300, 0x111a00, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> SCUBA_STEVE_SPAWN_EGG = ITEMS.register("scuba_steve_spawn_egg", () -> new ForgeSpawnEggItem(ModRegistry.SCUBA_STEVE, 0xffcc00, 0xffff00, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> LITTLE_ROPO_SPAWN_EGG = ITEMS.register( "littleropo_spawn_egg", () -> new ForgeSpawnEggItem(ModRegistry.LITTLEROPO, 0xcc00cc, 0xffffb3, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> MRCRAINER_SPAWN_EGG = ITEMS.register( "mrcrainer_spawn_egg", () -> new ForgeSpawnEggItem(ModRegistry.MRCRAINER, 0x000000, 0xff944d, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> BABY_ANGEL_SPAWN_EGG = ITEMS.register("babyangel_spawn_egg", () -> new ForgeSpawnEggItem(ModRegistry.BABY_ANGEL, 0x999999, 0xe6e6e6, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> APHMAU_SPAWN_EGG = ITEMS.register( "aphmau_spawn_egg", () -> new ForgeSpawnEggItem(ModRegistry.APHMAU, 0x000000, 0xff944d, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> BABY_DUCK_SPAWN_EGG = ITEMS.register("babyduck_spawn_egg", () -> new ForgeSpawnEggItem(ModRegistry.BABY_DUCK, 0xffcc00, 0xffff00, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> BABY_LEAH_SPAWN_EGG = ITEMS.register( "babyleah_spawn_egg", () -> new ForgeSpawnEggItem(ModRegistry.BABY_LEAH, 0xcc00cc, 0xffffb3, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> BABY_MAX_SPAWN_EGG = ITEMS.register( "babymax_spawn_egg", () -> new ForgeSpawnEggItem(ModRegistry.BABY_MAX, 0x000000, 0xff944d, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> CASSIE_THE_CAT_SPAWN_EGG = ITEMS.register( "cassiethecat_spawn_egg", () -> new ForgeSpawnEggItem(ModRegistry.CASSIE_THE_CAT, 0x999999, 0xe6e6e6, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> DONUT_THE_DOG_SPAWN_EGG = ITEMS.register( "donutthedog_spawn_egg", () -> new ForgeSpawnEggItem(ModRegistry.DONUT_THE_DOG, 0x000000, 0xff944d, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> EVIL_LITTLE_KELLY_SPAWN_EGG = ITEMS.register( "evillittlekelly_spawn_egg", () -> new ForgeSpawnEggItem(ModRegistry.EVIL_LITTLE_KELLY, 0xff1a1a, 0xffffb3, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> LITTLE_ALLY_SPAWN_EGG = ITEMS.register( "littleally_spawn_egg", () -> new ForgeSpawnEggItem(ModRegistry.LITTLEALLY, 0xff8566, 0xffffb3, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> LITTLE_CARLY_SPAWN_EGG = ITEMS.register( "littlecarly_spawn_egg", () -> new ForgeSpawnEggItem(ModRegistry.LITTLECARLYMC,  0x66ccff, 0xffffb3, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> LITTLE_DONNY_SPAWN_EGG = ITEMS.register( "littledonny_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.LITTLEDONNY, 0x1ab2ff, 0xff8c1a, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> LITTLE_KELLY_SPAWN_EGG = ITEMS.register("littlekelly_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.LITTLEKELLYMC, 0xff99ff, 0x99ff66, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> LITTLE_LIZARD_GAMING_SPAWN_EGG = ITEMS.register("littlelizardgaming_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.LITTLELIZARDGAMING, 0x009933, 0xccffcc, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> MAX_THE_MONKEY_SPAWN_EGG = ITEMS.register( "maxthemonkey_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.MAXTHEMONKEY, 0xcc6600, 0xffcc99, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> EXPLOADINGTNT_SPAWN_EGG = ITEMS.register( "explodingtnt_spawn_egg", () -> new ForgeSpawnEggItem(ModRegistry.EXPLODING_TNT, 0xff0000, 0x000000,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> MR_WOOFLESS_SPAWN_EGG = ITEMS.register("mrwoofless_spawn_egg", () -> new ForgeSpawnEggItem(ModRegistry.MRWOOFLESS, 0x3366ff, 0xffaa80,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> LACHLAN_SPAWN_EGG = ITEMS.register( "lachlan_spawn_egg", () -> new ForgeSpawnEggItem(ModRegistry.LACHLAN,0xff944d, 0xffcc99,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> PEETAZAHUTT_SPAWN_EGG = ITEMS.register( "petazahhutt_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.PETEZAHHUTT, 0xccff99, 0x66ff66,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> PINK_SHEEP_SPAWN_EGG = ITEMS.register( "pinksheep_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.PINKSHEEP, 0xff00ff, 0x330033,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> PRESTON_PLAYZ_SPAWN_EGG = ITEMS.register( "prestonplayz_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.PRESTONPLAYZ, 0xff0000, 0xff6600,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> LSDHADOWLADY_SPAWN_EGG = ITEMS.register( "ldshadowlady_spawn_egg", () -> new ForgeSpawnEggItem(ModRegistry.LDSHADOWLADY,0xcc99ff, 0x000066,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> IHASCUPQUAKE_SPAWN_EGG = ITEMS.register( "ihascupquake_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.IHASCUPQUAKE, 0xff66ff, 0x66ff66,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> FRIZZLEANDPOP_SPAWN_EGG = ITEMS.register( "frizzleandpop_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.FRIZZLEANDPOP, 0xffcc00, 0x86b300,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> BAJANCANADIAN_SPAWN_EGG = ITEMS.register( "bajancanadian_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.BABJANCANADIAN, 0xe60000, 0x000000,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> JEROMEASF_SPAWN_EGG = ITEMS.register( "jerome_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.JEROMEASF, 0xb37700, 0xffad33,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> CAPTAINSPARKLEZ_SPAWN_EGG = ITEMS.register( "captainsparklez_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.CAPTAIN_SPARKLEZ, 0xff4d4d, 0xffffcc,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> ISQUID_SPAWN_EGG = ITEMS.register( "iballisticsquid_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.ISQUID, 0x000066, 0x000000,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> DANTDM_SPAWN_EGG = ITEMS.register( "dantdm_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.DANTDM, 0x000066, 0x000000,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> SHARKY_SPAWN_EGG = ITEMS.register( "sharky_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.SHARKY, 0x6666ff, 0x00ccff,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> TINYTURTLE_SPAWN_EGG = ITEMS.register( "tinyturtle_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.TINYTURTLE, 0x006600, 0x994d00,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> VICKSTAR_SPAWN_EGG = ITEMS.register( "vikkstar_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.VIKKSTAR123, 0x005ce6, 0xffcc00,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> SSUNDEE_SPAWN_EGG = ITEMS.register( "ssundee_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.SSUNDEE, 0x000000, 0xcc6600,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> STAMPYLONGHEAD_SPAWN_EGG = ITEMS.register( "stampylonghead_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.STAMPYLONGHEAD, 0xffcc00, 0xff9933,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> TEWTIY_SPAWN_EGG = ITEMS.register( "tewity_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.TEWITY, 0xffcc00, 0xffff1a,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> THNXCYA_SPAWN_EGG = ITEMS.register( "thnxcya_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.THNXCYA, 0x00cc66, 0x333300,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> LOGDOTZIP_SPAWN_EGG = ITEMS.register( "logdotzip_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.LOGDOTZIP, 0xff3333, 0xffaa00,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> POPULARMMOS_SPAWN_EGG = ITEMS.register( "popularmmos_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.POPULARMMOS,  0x262626, 0x005580,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> SERIALPLAYER_SPAWN_EGG = ITEMS.register( "thvardhan_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.SERIALPLAYER,  0xcc9900, 0xffff66,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> SKYDOESMINECRAFT_SPAWN_EGG = ITEMS.register( "skythekidrs_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.SKYDOESMINECRAFT,  0xffff33, 0x000000,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> SUPERGIRLYGAMER_SPAWN_EGG = ITEMS.register( "jen_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.SUPERGIRLYGAMER,  0xff33cc, 0xe6005c,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> TRUEMU_SPAWN_EGG = ITEMS.register( "truemu_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.TRUEMU,  0x0066ff, 0xff9933,new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> GHOST_SPAWN_EGG = ITEMS.register( "ghost_spawn_egg",() -> new ForgeSpawnEggItem(ModRegistry.GHOST,  0x4d0000, 0x000000,new Item.Properties().group(ItemGroup.MISC)));

    public static final RegistryObject<Item> MASTER_SWORD = ITEMS.register("m_sword", () -> new M_sword( MSWORD, 3, 0, new Item.Properties().group(ItemGroup.MISC)));


    public static final RegistryObject<Block> DIAMOND_PLAY_BUTTON = BLOCKS.register("diamond_button_block", DiamondButton::new);
    public static final RegistryObject<Item> DIAMOND_PLAY_BUTTON_BLOCK_ITEM = ITEMS.register("diamond_button_block", () -> new BlockItemBase(DIAMOND_PLAY_BUTTON.get()));
    public static final RegistryObject<Block> GOLD_PLAY_BUTTON = BLOCKS.register("gold_button_block", DiamondButton::new);
    public static final RegistryObject<Item> GOLD_PLAY_BUTTON_BLOCK_ITEM = ITEMS.register("gold_button_block", () -> new BlockItemBase(GOLD_PLAY_BUTTON.get()));
    public static final RegistryObject<Block> IRON_PLAY_BUTTON = BLOCKS.register("iron_button_block", DiamondButton::new);
    public static final RegistryObject<Item> IRON_PLAY_BUTTON_BLOCK_ITEM = ITEMS.register("iron_button_block", () -> new BlockItemBase(IRON_PLAY_BUTTON.get()));

}