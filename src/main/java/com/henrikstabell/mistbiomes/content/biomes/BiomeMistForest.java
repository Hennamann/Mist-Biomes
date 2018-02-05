package com.henrikstabell.mistbiomes.content.biomes;

import com.henrikstabell.mistbiomes.client.config.MistBiomesConfig;
import com.henrikstabell.mistcore.api.IBiomeMist;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.biome.Biome;

public class BiomeMistForest extends Biome implements IBiomeMist {

    public BiomeMistForest() {
        super(new BiomeProperties("Mist Forest").setTemperature(0.7F).setRainfall(0.8F));
        this.decorator.treesPerChunk = 10;
        this.decorator.grassPerChunk = 2;
        this.decorator.flowersPerChunk = 0;
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWolf.class, 5, 4, 4));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityZombie.class, 20, 8, 16));
    }

    public int getModdedBiomeGrassColor(int original) {
        return 1604134;
    }

    public int getModdedBiomeFoliageColor(int original) {
        return 877336;
    }

    @Override
    public float getMistDensity(int var1, int var2, int var3) {
        return MistBiomesConfig.mistDensity;
    }

    @Override
    public int getMistColour(int var1, int var2, int var3) {
        return 16777215;
    }
}