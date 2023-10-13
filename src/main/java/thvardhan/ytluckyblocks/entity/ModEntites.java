package thvardhan.ytluckyblocks.entity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import thvardhan.ytluckyblocks.Main;

public class ModEntites {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Main.MODID);

    public static void init() {
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
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

}
