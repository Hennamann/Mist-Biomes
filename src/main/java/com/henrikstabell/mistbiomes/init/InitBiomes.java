package com.henrikstabell.mistbiomes.init;

import com.henrikstabell.mistbiomes.client.config.MistBiomesConfig;
import com.henrikstabell.mistbiomes.content.biomes.*;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class InitBiomes {

    public static final Biome MISTFOREST = new BiomeMistForest();
    public static final Biome MISTPLAINS = new BiomeMistPlains();
    public static final Biome MISTDESERT = new BiomeMistDesert();
    public static final Biome COLDMISTTAIGA = new BiomeColdMistTaiga();
    public static final Biome MISTTAIGA = new BiomeMistTaiga();
    public static final Biome MISTSWAMPLAND = new BiomeMistSwamp();
    public static final Biome MISTMUSHROOMISLAND = new BiomeMistMushroomIsland();

    public static void registerBiomes() {
            initBiome(MISTFOREST, "MistForest", BiomeType.WARM, Type.FOREST);
            initBiome(MISTPLAINS, "MistPlains", BiomeType.WARM, Type.PLAINS);
            initBiome(MISTTAIGA, "MistTaiga", BiomeType.COOL, Type.COLD, Type.CONIFEROUS, Type.FOREST);
            initBiome(MISTDESERT, "MistDesert", BiomeType.DESERT, Type.HOT, Type.DRY, Type.SANDY);
            initBiome(COLDMISTTAIGA, "ColdMistTaiga", BiomeType.ICY, Type.CONIFEROUS, Type.FOREST, Type.SNOWY);
            initBiome(MISTSWAMPLAND, "MistSwamp", BiomeType.WARM, Type.WET, Type.SWAMP);
            initBiome(MISTMUSHROOMISLAND, "MistyMushroomIsland", BiomeType.COOL, Type.MUSHROOM, Type.RARE);
    }

    public static void addBiomes() {
        if (MistBiomesConfig.mistForestEnabled) {
            addBiome(MISTFOREST);
        }
        if (MistBiomesConfig.mistPlainsEnabled) {
            addBiome(MISTPLAINS);
        }
        if (MistBiomesConfig.mistTaigaEnabled) {
            addBiome(MISTTAIGA);
        }
        if (MistBiomesConfig.mistDesertEnabled) {
            addBiome(MISTDESERT);
        }
        if (MistBiomesConfig.coldMistTaigaEnabled) {
            addBiome(COLDMISTTAIGA);
        }
        if (MistBiomesConfig.mistySwamplandsEnabled) {
            addBiome(MISTSWAMPLAND);
        }
        if (MistBiomesConfig.mistyMushroomIslandsEnabled) {
            addBiome(MISTMUSHROOMISLAND);
        }
    }

    private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... types) {
        biome.setRegistryName(name);
        ForgeRegistries.BIOMES.register(biome);
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));
        return biome;
    }

    private static Biome addBiome(Biome biome) {
        BiomeManager.addSpawnBiome(biome);
        return biome;
    }
}