package thvardhan.ytluckyblocks;

import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
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
        //MinecraftForge.EVENT_BUS.register(new YTEventHandler());
        ModEntites.init();
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("Creating mod tabs");
       //ModTabs.createTabs();
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntites.SCUBA_STEVE.get(), EntityScubaSteve.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.ALEXIRCRAFT.get(), EntityAlexirCraft.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.ANTVENNOM.get(), EntityAntVenom.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.APHMAU.get(), EntityAphmau.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.BABY_ANGEL.get(), EntityBabyAngel.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.BABY_DUCK.get(), EntityBabyDuck.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.BABY_LEAH.get(), EntityBabyLeah.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.BABY_MAX.get(), EntityBabyMax.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.BABJANCANADIAN.get(), EntityBajanCanadian.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.CAPTAIN_SPARKLEZ.get(), EntityCaptainSparklez.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.CASSIE_THE_CAT.get(), EntityCassieTheCat.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.DONUT_THE_DOG.get(), EntityDonutTheDog.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.DANTDM.get(), EntityDanTDM.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.EVIL_LITTLE_KELLY.get(), EntityEvilLittleKelly.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.EXPLODING_TNT.get(), EntityExplodingTNT.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.FRIZZLEANDPOP.get(), EntityFrizzleandpop.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.IHASCUPQUAKE.get(), EntityIhasCupquake.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.ISQUID.get(), EntityISquid.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.JEROMEASF.get(), EntityJeromeASF.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.LACHLAN.get(), EntityLachlan.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.LDSHADOWLADY.get(), EntityLDShadowLady.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.LITTLEALLY.get(), EntityLittleAlly.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.LITTLECARLYMC.get(), EntityLittleCarlyMC.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.LITTLEDONNY.get(), EntityLittleDonny.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.LITTLEKELLYMC.get(), EntityLittleKellyMC.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.LITTLELIZARDGAMING.get(), EntityLittleLizardGaming.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.LITTLEROPO.get(), EntityLittleRopo.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.MAXTHEMONKEY.get(), EntityMaxTheMonkey.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.MRCRAINER.get(), EntityMrCrainer.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.MRWOOFLESS.get(), EntityMrWoofless.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.PETEZAHHUTT.get(), EntityPeteZahHutt.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.PINKSHEEP.get(), EntityPinkSheep.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.PRESTONPLAYZ.get(), EntityPrestonPlayz.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.SHARKY.get(), EntitySharky.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.TINYTURTLE.get(), EntityTinyTurtle.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.VIKKSTAR123.get(), EntityVikkstar123.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.SSUNDEE.get(), EntitySSundee.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.STAMPYLONGHEAD.get(), EntityStampylonghead.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.TEWITY.get(), EntityTewity.getAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntites.THNXCYA.get(), EntityThnxCya.getAttributes().create());

        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.SCUBA_STEVE.get(), EntityScubaSteveRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.ALEXIRCRAFT.get(), EntityAlexircraftRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.ANTVENNOM.get(), EntityAntVenomRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.APHMAU.get(), EntityAphmauRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.BABY_ANGEL.get(), EntityBabyAngelRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.BABY_DUCK.get(), EntityBabyDuckRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.BABY_LEAH.get(), EntityBabyLeahRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.BABY_MAX.get(), EntityBabyMaxRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.BABJANCANADIAN.get(), EntityBajanCanadianRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.CAPTAIN_SPARKLEZ.get(), EntityCaptainSparklezRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.CASSIE_THE_CAT.get(), EntityCassieTheCatRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.DONUT_THE_DOG.get(), EntityDonutTheDogRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.DANTDM.get(), EntityDanTDMRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.EVIL_LITTLE_KELLY.get(), EntityEvilLittleKellyRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.EXPLODING_TNT.get(), EntityExplodingTNTRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.FRIZZLEANDPOP.get(), EntityFrizzleandPopRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.IHASCUPQUAKE.get(), EntityIhascupquakeRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.ISQUID.get(), EntityISquidRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.JEROMEASF.get(), EntityJeromeASFRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.LACHLAN.get(), EntityLachlanRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.LDSHADOWLADY.get(), EntityLDShadowLadyRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.LITTLEALLY.get(), EntityLittleAllyRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.LITTLECARLYMC.get(), EntityLittleCarlyRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.LITTLEDONNY.get(), EntityLittleDonnyRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.LITTLEKELLYMC.get(), EntityLittleKellyMCRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.LITTLELIZARDGAMING.get(), EntityLittleLizardGamingRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.LITTLEROPO.get(), EntityLittleRopoRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.MAXTHEMONKEY.get(), EntityMaxTheMonkeyRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.MRCRAINER.get(), EntityMRCrainerRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.MRWOOFLESS.get(), EntityMRWooflessRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.PETEZAHHUTT.get(), EntityPetaRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.PINKSHEEP.get(), EntityPinkSheepRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.PRESTONPLAYZ.get(), EntityPrestonRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.SHARKY.get(), EntitySharkyRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.TINYTURTLE.get(), EntityTinyTurtleRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.VIKKSTAR123.get(), EntityVikkstar123Render::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.TEWITY.get(), EntityTewityRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.THNXCYA.get(), EntityThnxcyaRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.SSUNDEE.get(), EntitySsundeeRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntites.STAMPYLONGHEAD.get(), EntityStampylongheadRender::new);

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
        registerModEntityWithEgg(EntityLogDotZip.class, "logdotzip", 0xff3333, 0xffaa00);
        registerModEntityWithEgg(EntityPopularMMO.class, "popularmmo", 0x262626, 0x005580);
        registerModEntityWithEgg(EntityGhost.class, "ghost", 0x4d0000, 0x000000);
        registerModEntityWithEgg(EntitySerialPlayer.class, "thvardhan", 0xcc9900, 0xffff66);
        registerModEntityWithEgg(EntitySuperGirlyGamer.class, "supergirlygamer", 0xff33cc, 0xe6005c);
        registerModEntityWithEgg(EntitySkyDoesMinecraft.class, "skydoesminecraft", 0xffff33, 0x000000);
        registerModEntityWithEgg(EntityTruemu.class, "truemu", 0x0066ff, 0xff9933);
        registerModEntityWithEgg(EntityLuckyMob.class, "luckymob", 0x0, 0x0);

        BlockRenderRegister.registerBlockRenderer();
        ItemRenderRegistry.registerItemRender();
    }
}
