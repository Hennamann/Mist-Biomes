package com.henrikstabell.mistbiomes.biomes;

import com.henrikstabell.mistcore.api.MistBiome;
import com.henrikstabell.mistcore.api.MistBiomeCategories;
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
        registry.register(MistBiomesOverworldBiomes.mistDarkForest().setRegistryName(MistBiomesInitializer.MIST_DARK_FOREST.location()));
        registry.register(MistBiomesOverworldBiomes.mistDesert().setRegistryName(MistBiomesInitializer.MIST_DESERT.location()));
        registry.register(MistBiomesOverworldBiomes.mistPlains(false).setRegistryName(MistBiomesInitializer.MIST_PLAINS.location()));
        registry.register(MistBiomesOverworldBiomes.mistPlains(true).setRegistryName(MistBiomesInitializer.SNOWY_MIST_PLAINS.location()));
        registry.register(MistBiomesOverworldBiomes.mistSwamp().setRegistryName(MistBiomesInitializer.MIST_SWAMP.location()));
        registry.register(MistBiomesOverworldBiomes.mistTaiga(false).setRegistryName(MistBiomesInitializer.MIST_TAIGA.location()));
        registry.register(MistBiomesOverworldBiomes.mistTaiga(true).setRegistryName(MistBiomesInitializer.SNOWY_MIST_TAIGA.location()));
        registry.register(MistBiomesOverworldBiomes.mistBadlands(false).setRegistryName(MistBiomesInitializer.MIST_BADLANDS.location()));
        registry.register(MistBiomesOverworldBiomes.mistBadlands(true).setRegistryName(MistBiomesInitializer.WOODED_MIST_BADLANDS.location()));
    }

    @SubscribeEvent
    public static void registerMistBiomes(RegistryEvent.Register<MistBiome> event) {
        IForgeRegistry<MistBiome> registry = event.getRegistry();
        registry.register(new MistBiome(12, 40, MistBiomeCategories.MIST_FOREST, false).setRegistryName(MistBiomesInitializer.MIST_FOREST.location()));
        registry.register(new MistBiome(12, 40, MistBiomeCategories.MIST_FOREST, false).setRegistryName(MistBiomesInitializer.MIST_BIRCH_FOREST.location()));
        registry.register(new MistBiome(12, 20, MistBiomeCategories.MIST_DEEP_FOREST, false).setRegistryName(MistBiomesInitializer.MIST_DARK_FOREST.location()));
        registry.register(new MistBiome(12, 120, MistBiomeCategories.MIST_DESERT, false).setRegistryName(MistBiomesInitializer.MIST_DESERT.location()));
        registry.register(new MistBiome(12, 110, MistBiomeCategories.MIST_PLAIN, false).setRegistryName(MistBiomesInitializer.MIST_PLAINS.location()));
        registry.register(new MistBiome(12, 110, MistBiomeCategories.MIST_PLAIN, true).setRegistryName(MistBiomesInitializer.SNOWY_MIST_PLAINS.location()));
        registry.register(new MistBiome(12, 80, MistBiomeCategories.MIST_SWAMP, false).setRegistryName(MistBiomesInitializer.MIST_SWAMP.location()));
        registry.register(new MistBiome(12, 20, MistBiomeCategories.MIST_DEEP_FOREST, false).setRegistryName(MistBiomesInitializer.MIST_TAIGA.location()));
        registry.register(new MistBiome(12, 20, MistBiomeCategories.MIST_DEEP_FOREST, true).setRegistryName(MistBiomesInitializer.SNOWY_MIST_TAIGA.location()));
        registry.register(new MistBiome(12, 100, MistBiomeCategories.MIST_WASTELAND, false).setRegistryName(MistBiomesInitializer.MIST_BADLANDS.location()));
        registry.register(new MistBiome(12, 80, MistBiomeCategories.MIST_WASTELAND, false).setRegistryName(MistBiomesInitializer.WOODED_MIST_BADLANDS.location()));
    }
}
