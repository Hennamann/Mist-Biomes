package com.henrikstabell.mistbiomes.biomes;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.SurfaceRuleData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.SurfaceRules;
import terrablender.api.BiomeProvider;
import terrablender.worldgen.TBClimate;

import java.util.Optional;
import java.util.function.Consumer;

public class MistBiomesProvider extends BiomeProvider {

    public MistBiomesProvider(ResourceLocation name, int weight) {
        super(name, weight);
    }

    @Override
    public void addOverworldBiomes(Registry<Biome> registry, Consumer<Pair<TBClimate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
            builder.replaceBiome(Biomes.FOREST, MistBiomesInitializer.MIST_FOREST);
            builder.replaceBiome(Biomes.BIRCH_FOREST, MistBiomesInitializer.MIST_BIRCH_FOREST);
            builder.replaceBiome(Biomes.DESERT, MistBiomesInitializer.MIST_DESERT);
            builder.replaceBiome(Biomes.PLAINS, MistBiomesInitializer.MIST_PLAINS);
            builder.replaceBiome(Biomes.SNOWY_PLAINS, MistBiomesInitializer.SNOWY_MIST_PLAINS);
            builder.replaceBiome(Biomes.SWAMP, MistBiomesInitializer.MIST_SWAMP);
            builder.replaceBiome(Biomes.TAIGA, MistBiomesInitializer.MIST_TAIGA);
            builder.replaceBiome(Biomes.SNOWY_TAIGA, MistBiomesInitializer.SNOWY_MIST_TAIGA);
        });
    }

    @Override
    public Optional<SurfaceRules.RuleSource> getOverworldSurfaceRules() {
        return Optional.of(SurfaceRuleData.overworld());
    }
}
