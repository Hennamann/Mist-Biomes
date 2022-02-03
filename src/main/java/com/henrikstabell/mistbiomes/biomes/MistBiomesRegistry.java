package com.henrikstabell.mistbiomes.biomes;

import com.henrikstabell.mistcore.api.MistBiome;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MistBiomesRegistry {

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        IForgeRegistry<Biome> registry = event.getRegistry();
        registry.register(MistBiomesOverworldBiomes.mistForest(false).setRegistryName(MistBiomesInitializer.MIST_FOREST.location()));
        registry.register(MistBiomesOverworldBiomes.mistForest(true).setRegistryName(MistBiomesInitializer.MIST_BIRCH_FOREST.location()));
        registry.register(MistBiomesOverworldBiomes.mistDesert().setRegistryName(MistBiomesInitializer.MIST_DESERT.location()));
        registry.register(MistBiomesOverworldBiomes.mistPlains( false).setRegistryName(MistBiomesInitializer.MIST_PLAINS.location()));
        registry.register(MistBiomesOverworldBiomes.mistPlains(true).setRegistryName(MistBiomesInitializer.SNOWY_MIST_PLAINS.location()));
        registry.register(MistBiomesOverworldBiomes.mistSwamp().setRegistryName(MistBiomesInitializer.MIST_SWAMP.location()));
        registry.register(MistBiomesOverworldBiomes.mistTaiga(false).setRegistryName(MistBiomesInitializer.MIST_TAIGA.location()));
        registry.register(MistBiomesOverworldBiomes.mistTaiga(true).setRegistryName(MistBiomesInitializer.SNOWY_MIST_TAIGA.location()));
    }

    @SubscribeEvent
    public static void registerMistBiomes(RegistryEvent.Register<MistBiome> event) {
        IForgeRegistry<MistBiome> registry = event.getRegistry();
        registry.register(new MistBiome(12, 40).setRegistryName(MistBiomesInitializer.MIST_FOREST.location()));
        registry.register(new MistBiome(12, 40).setRegistryName(MistBiomesInitializer.MIST_BIRCH_FOREST.location()));
        registry.register(new MistBiome(12, 120).setRegistryName(MistBiomesInitializer.MIST_DESERT.location()));
        registry.register(new MistBiome(12, 110).setRegistryName(MistBiomesInitializer.MIST_PLAINS.location()));
        registry.register(new MistBiome(12, 110).setRegistryName(MistBiomesInitializer.SNOWY_MIST_PLAINS.location()));
        registry.register(new MistBiome(12, 80).setRegistryName(MistBiomesInitializer.MIST_SWAMP.location()));
        registry.register(new MistBiome(12, 20).setRegistryName(MistBiomesInitializer.MIST_TAIGA.location()));
        registry.register(new MistBiome(12, 20).setRegistryName(MistBiomesInitializer.SNOWY_MIST_TAIGA.location()));
    }
}
