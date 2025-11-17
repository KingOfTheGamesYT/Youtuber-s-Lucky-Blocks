package thvardhan.ytluckyblocks.misc;

import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "ytluckyblocks", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModSpawns {

    @SubscribeEvent
    public static void addSpawns(BiomeLoadingEvent event) {

        // restrict to desert biome category
        if (event.getCategory() == Biome.Category.DESERT) {

            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(
                    new MobSpawnInfo.Spawners(
                            RegistrationHandler.LUCKY_MOB.get(),
                            6,      // weight
                            15,     // min
                            50      // max
                    )
            );
        }
    }
}