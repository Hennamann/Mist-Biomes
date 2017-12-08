package com.henrikstabell.mistbiomes.content.biomes;

import com.henrikstabell.mistcore.api.IBiomeMist;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.biome.Biome;

public class BiomeMistForest extends Biome implements IBiomeMist {

    public BiomeMistForest() {
        super(new BiomeProperties("MistForest").setTemperature(0.7F).setRainfall(0.8F));
        this.decorator.treesPerChunk = 10;
        this.decorator.grassPerChunk = 2;
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWolf.class, 5, 4, 4));
    }

    @Override
    public float getMistDensity(int var1, int var2, int var3) {
        return 0.1F;
    }

    @Override
    public int getMistColour(int var1, int var2, int var3) {
        return 16777215;
    }
}
