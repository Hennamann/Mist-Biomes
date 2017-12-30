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

    public static void registerBiomes() {
        if (MistBiomesConfig.mistForestEnabled) {
            initBiome(MISTFOREST, "MistForest", BiomeType.WARM, Type.FOREST);
        }
        if (MistBiomesConfig.mistPlainsEnabled) {
            initBiome(MISTPLAINS, "MistPlains", BiomeType.WARM, Type.PLAINS);
        }
        if (MistBiomesConfig.mistTaigaEnabled) {
            initBiome(MISTTAIGA, "MistTaiga", BiomeType.WARM, Type.FOREST);
        }
        if (MistBiomesConfig.mistDesertEnabled) {
            initBiome(MISTDESERT, "MistDesert", BiomeType.DESERT, Type.DEAD, Type.DRY, Type.SANDY);
        }
        if (MistBiomesConfig.coldMistTaigaEnabled) {
            initBiome(COLDMISTTAIGA, "ColdMistTaiga", BiomeType.ICY, Type.COLD, Type.FOREST, Type.SNOWY);
        }
        if (MistBiomesConfig.mistySwamplandsEnabled) {
            initBiome(MISTSWAMPLAND, "MistSwamp", BiomeType.WARM, Type.DEAD, Type.CONIFEROUS, Type.LUSH, Type.SWAMP, Type.SPOOKY);
        }
    }

    private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... types) {
        biome.setRegistryName(name);
        ForgeRegistries.BIOMES.register(biome);
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));
        BiomeManager.addSpawnBiome(biome);
        return biome;
    }
}