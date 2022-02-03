package com.henrikstabell.mistbiomes.biomes;

import com.henrikstabell.mistbiomes.MistBiomes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class MistBiomesInitializer {

    public static final ResourceKey<Biome> MIST_FOREST = register("mist_forest");
    public static final ResourceKey<Biome> MIST_BIRCH_FOREST = register("mist_birch_forest");
    public static final ResourceKey<Biome> MIST_DESERT = register("mist_desert");
    public static final ResourceKey<Biome> MIST_PLAINS = register("mist_plains");
    public static final ResourceKey<Biome> SNOWY_MIST_PLAINS = register("snowy_mist_plains");
    public static final ResourceKey<Biome> MIST_SWAMP = register("mist_swamp");
    public static final ResourceKey<Biome> MIST_TAIGA = register("mist_taiga");
    public static final ResourceKey<Biome> SNOWY_MIST_TAIGA = register("snowy_mist_taiga");

    private static ResourceKey<Biome> register(String name)
    {
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(MistBiomes.MODID, name));
    }
}
