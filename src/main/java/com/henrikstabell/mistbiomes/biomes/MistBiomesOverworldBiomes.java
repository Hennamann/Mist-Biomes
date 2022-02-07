package com.henrikstabell.mistbiomes.biomes;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.data.worldgen.placement.*;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

import javax.annotation.Nullable;

import static net.minecraft.data.worldgen.BiomeDefaultFeatures.caveSpawns;
import static net.minecraft.data.worldgen.BiomeDefaultFeatures.monsters;

public class MistBiomesOverworldBiomes {

    @Nullable
    private static final Music NORMAL_MUSIC = null;

    protected static int calculateSkyColor(float color) {
        float $$1 = color / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }

    private static Biome biome(Biome.Precipitation precipitation, Biome.BiomeCategory category, float temperature, float downfall, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music) {
        return biome(precipitation, category, temperature, downfall, 4159204, 329011, spawnBuilder, biomeBuilder, music);
    }

    private static Biome biome(Biome.Precipitation precipitation, Biome.BiomeCategory category, float temperature, float downfall, int waterColor, int waterFogColor, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music) {
        return (new Biome.BiomeBuilder()).precipitation(precipitation).biomeCategory(category).temperature(temperature).downfall(downfall).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(waterColor).waterFogColor(waterFogColor).fogColor(12638463).skyColor(calculateSkyColor(temperature)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(music).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    private static void desertSpawns(MobSpawnSettings.Builder builder) {
        caveSpawns(builder);
        monsters(builder, 100, 25, 100, false);
        builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.HUSK, 80, 4, 4));
    }

    private static void globalOverworldGeneration(BiomeGenerationSettings.Builder p_194870_) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(p_194870_);
        BiomeDefaultFeatures.addDefaultCrystalFormations(p_194870_);
        BiomeDefaultFeatures.addDefaultMonsterRoom(p_194870_);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(p_194870_);
        BiomeDefaultFeatures.addDefaultSprings(p_194870_);
        BiomeDefaultFeatures.addSurfaceFreezing(p_194870_);
    }

    public static Biome mistPlains(boolean snowy) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = new BiomeGenerationSettings.Builder();
        globalOverworldGeneration(biomegenerationsettings$builder);
        if (snowy) {
            mobspawnsettings$builder.creatureGenerationProbability(0.07F);
            BiomeDefaultFeatures.snowySpawns(mobspawnsettings$builder);
        }
        monsters(mobspawnsettings$builder, 100, 25, 100, false);
        BiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        if (snowy) {
            BiomeDefaultFeatures.addSnowyTrees(biomegenerationsettings$builder);
        }
        BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);

        float f = snowy ? 0.0F : 0.8F;
        return biome(snowy ? Biome.Precipitation.SNOW : Biome.Precipitation.RAIN, snowy ? Biome.BiomeCategory.ICY : Biome.BiomeCategory.PLAINS, f, snowy ? 0.5F : 0.4F, mobspawnsettings$builder, biomegenerationsettings$builder, NORMAL_MUSIC);
    }

    public static Biome mistForest(boolean birchForest) {
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = new BiomeGenerationSettings.Builder();
        globalOverworldGeneration(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        if (birchForest) {
            BiomeDefaultFeatures.addBirchTrees(biomegenerationsettings$builder);
            BiomeDefaultFeatures.addOtherBirchTrees(biomegenerationsettings$builder);
        }
        BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        monsters(mobspawnsettings$builder, 100, 25, 100, false);

        float f = birchForest ? 0.6F : 0.7F;
        return biome(Biome.Precipitation.RAIN, Biome.BiomeCategory.FOREST, f, birchForest ? 0.6F : 0.8F, mobspawnsettings$builder, biomegenerationsettings$builder, NORMAL_MUSIC);
    }

    public static Biome mistDesert() {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        desertSpawns(mobspawnsettings$builder);
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addFossilDecoration(biomegenerationsettings$builder);
        globalOverworldGeneration(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDesertExtraDecoration(biomegenerationsettings$builder);
        return biome(Biome.Precipitation.NONE, Biome.BiomeCategory.DESERT, 2.0F, 0.0F, mobspawnsettings$builder, biomegenerationsettings$builder, NORMAL_MUSIC);
    }

    public static Biome mistSwamp() {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.monsters(mobspawnsettings$builder, 100, 25, 100, false);
        mobspawnsettings$builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 1, 1, 1));
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addFossilDecoration(biomegenerationsettings$builder);
        globalOverworldGeneration(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addSwampClayDisk(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addSwampVegetation(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addSwampExtraVegetation(biomegenerationsettings$builder);
        biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);
        return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.SWAMP).temperature(0.8F).downfall(0.9F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(6388580).waterFogColor(2302743).fogColor(12638463).skyColor(calculateSkyColor(0.8F)).foliageColorOverride(6975545).grassColorModifier(BiomeSpecialEffects.GrassColorModifier.SWAMP).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawnsettings$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
    }

    public static Biome mistTaiga(boolean snowy) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        float f = snowy ? -0.5F : 0.25F;
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.monsters(mobspawnsettings$builder, 100, 25, 100, false);
        globalOverworldGeneration(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addTaigaTrees(biomegenerationsettings$builder);

        return biome(snowy ? Biome.Precipitation.SNOW : Biome.Precipitation.RAIN, Biome.BiomeCategory.TAIGA, f, snowy ? 0.4F : 0.8F, snowy ? 4020182 : 4159204, 329011, mobspawnsettings$builder, biomegenerationsettings$builder, NORMAL_MUSIC);
    }

    public static Biome mistDarkForest() {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.monsters(mobspawnsettings$builder, 100, 25, 100, false);
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = new BiomeGenerationSettings.Builder();
        globalOverworldGeneration(biomegenerationsettings$builder);
        biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.DARK_FOREST_VEGETATION);
        BiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
        return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).temperature(0.7F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(0.7F)).grassColorModifier(BiomeSpecialEffects.GrassColorModifier.DARK_FOREST).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawnsettings$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
    }

    public static Biome mistBadlands(boolean wooded) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.monsters(mobspawnsettings$builder, 100, 25, 100, false);
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = new BiomeGenerationSettings.Builder();
        globalOverworldGeneration(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addExtraGold(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        if (wooded) {
            BiomeDefaultFeatures.addBadlandsTrees(biomegenerationsettings$builder);
        }

        BiomeDefaultFeatures.addBadlandGrass(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addBadlandExtraVegetation(biomegenerationsettings$builder);
        return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.MESA).temperature(2.0F).downfall(0.0F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(2.0F)).foliageColorOverride(10387789).grassColorOverride(9470285).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawnsettings$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
    }
}
