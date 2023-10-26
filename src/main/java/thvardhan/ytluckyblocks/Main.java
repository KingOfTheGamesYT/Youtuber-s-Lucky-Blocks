package thvardhan.ytluckyblocks;

import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import thvardhan.ytluckyblocks.entity.*;
import thvardhan.ytluckyblocks.entity.model.*;
import thvardhan.ytluckyblocks.entity.render.*;
import thvardhan.ytluckyblocks.handler.YTEventHandler;
import thvardhan.ytluckyblocks.init.ModItems;
import thvardhan.ytluckyblocks.init.ModTabs;
import thvardhan.ytluckyblocks.items.render.ItemRenderRegistry;


import net.minecraftforge.fml.common.Mod;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import thvardhan.ytluckyblocks.render.blocks.BlockRenderRegister;


@Mod(Main.MODID)
public class Main {
    public static final String MODID = "ytluckyblocks";
    public static final String VERSION = "6.1.2";
    public static final String NAME = "YouTuber's Lucky Blocks Mod";
    private static final Logger LOGGER = LogManager.getLogger();
    public static Main instance;

    public Main() {
        instance = this;
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(new YTEventHandler());
        ModRegistry.init();
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("Creating mod tabs");
       ModTabs.createTabs();
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModRegistry.SCUBA_STEVE.get(), EntityScubaSteve.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.ALEXIRCRAFT.get(), EntityAlexirCraft.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.ANTVENNOM.get(), EntityAntVenom.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.APHMAU.get(), EntityAphmau.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.BABY_ANGEL.get(), EntityBabyAngel.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.BABY_DUCK.get(), EntityBabyDuck.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.BABY_LEAH.get(), EntityBabyLeah.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.BABY_MAX.get(), EntityBabyMax.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.BABJANCANADIAN.get(), EntityBajanCanadian.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.CAPTAIN_SPARKLEZ.get(), EntityCaptainSparklez.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.CASSIE_THE_CAT.get(), EntityCassieTheCat.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.DONUT_THE_DOG.get(), EntityDonutTheDog.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.DANTDM.get(), EntityDanTDM.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.EVIL_LITTLE_KELLY.get(), EntityEvilLittleKelly.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.EXPLODING_TNT.get(), EntityExplodingTNT.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.FRIZZLEANDPOP.get(), EntityFrizzleandpop.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.IHASCUPQUAKE.get(), EntityIhasCupquake.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.ISQUID.get(), EntityISquid.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.JEROMEASF.get(), EntityJeromeASF.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.LACHLAN.get(), EntityLachlan.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.LDSHADOWLADY.get(), EntityLDShadowLady.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.LITTLEALLY.get(), EntityLittleAlly.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.LITTLECARLYMC.get(), EntityLittleCarlyMC.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.LITTLEDONNY.get(), EntityLittleDonny.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.LITTLEKELLYMC.get(), EntityLittleKellyMC.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.LITTLELIZARDGAMING.get(), EntityLittleLizardGaming.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.LITTLEROPO.get(), EntityLittleRopo.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.MAXTHEMONKEY.get(), EntityMaxTheMonkey.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.MRCRAINER.get(), EntityMrCrainer.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.MRWOOFLESS.get(), EntityMrWoofless.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.PETEZAHHUTT.get(), EntityPeteZahHutt.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.PINKSHEEP.get(), EntityPinkSheep.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.PRESTONPLAYZ.get(), EntityPrestonPlayz.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.SHARKY.get(), EntitySharky.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.TINYTURTLE.get(), EntityTinyTurtle.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.VIKKSTAR123.get(), EntityVikkstar123.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.SSUNDEE.get(), EntitySSundee.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.STAMPYLONGHEAD.get(), EntityStampylonghead.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.TEWITY.get(), EntityTewity.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.THNXCYA.get(), EntityThnxCya.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.LOGDOTZIP.get(), EntityLogDotZip.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.POPULARMMOS.get(), EntityPopularMMO.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModRegistry.SERIALPLAYER.get(), EntitySerialPlayer.getAttributes().create());


        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.SCUBA_STEVE.get(), EntityScubaSteveRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.ALEXIRCRAFT.get(), EntityAlexircraftRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.ANTVENNOM.get(), EntityAntVenomRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.APHMAU.get(), EntityAphmauRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.BABY_ANGEL.get(), EntityBabyAngelRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.BABY_DUCK.get(), EntityBabyDuckRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.BABY_LEAH.get(), EntityBabyLeahRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.BABY_MAX.get(), EntityBabyMaxRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.BABJANCANADIAN.get(), EntityBajanCanadianRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.CAPTAIN_SPARKLEZ.get(), EntityCaptainSparklezRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.CASSIE_THE_CAT.get(), EntityCassieTheCatRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.DONUT_THE_DOG.get(), EntityDonutTheDogRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.DANTDM.get(), EntityDanTDMRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.EVIL_LITTLE_KELLY.get(), EntityEvilLittleKellyRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.EXPLODING_TNT.get(), EntityExplodingTNTRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.FRIZZLEANDPOP.get(), EntityFrizzleandPopRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.IHASCUPQUAKE.get(), EntityIhascupquakeRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.ISQUID.get(), EntityISquidRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.JEROMEASF.get(), EntityJeromeASFRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.LACHLAN.get(), EntityLachlanRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.LDSHADOWLADY.get(), EntityLDShadowLadyRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.LITTLEALLY.get(), EntityLittleAllyRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.LITTLECARLYMC.get(), EntityLittleCarlyRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.LITTLEDONNY.get(), EntityLittleDonnyRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.LITTLEKELLYMC.get(), EntityLittleKellyMCRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.LITTLELIZARDGAMING.get(), EntityLittleLizardGamingRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.LITTLEROPO.get(), EntityLittleRopoRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.MAXTHEMONKEY.get(), EntityMaxTheMonkeyRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.MRCRAINER.get(), EntityMRCrainerRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.MRWOOFLESS.get(), EntityMRWooflessRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.PETEZAHHUTT.get(), EntityPetaRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.PINKSHEEP.get(), EntityPinkSheepRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.PRESTONPLAYZ.get(), EntityPrestonRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.SHARKY.get(), EntitySharkyRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.TINYTURTLE.get(), EntityTinyTurtleRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.VIKKSTAR123.get(), EntityVikkstar123Render::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.TEWITY.get(), EntityTewityRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.THNXCYA.get(), EntityThnxcyaRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.SSUNDEE.get(), EntitySsundeeRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.STAMPYLONGHEAD.get(), EntityStampylongheadRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.LOGDOTZIP.get(), EntityLogDotZipRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.POPULARMMOS.get(), PopularmmosRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.SERIALPLAYER.get(), EntitySerialPlayerRender::new);

        registerEntities();
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }


    private void registerEntities() {
        registerModEntityWithEgg(EntityGhost.class, "ghost", 0x4d0000, 0x000000);
        registerModEntityWithEgg(EntitySuperGirlyGamer.class, "supergirlygamer", 0xff33cc, 0xe6005c);
        registerModEntityWithEgg(EntitySkyDoesMinecraft.class, "skydoesminecraft", 0xffff33, 0x000000);
        registerModEntityWithEgg(EntityTruemu.class, "truemu", 0x0066ff, 0xff9933);
        registerModEntityWithEgg(EntityLuckyMob.class, "luckymob", 0x0, 0x0);

        BlockRenderRegister.registerBlockRenderer();
        ItemRenderRegistry.registerItemRender();
    }
}
