package com.henrikstabell.mistbiomes.content.biomes;

import com.henrikstabell.mistbiomes.client.config.MistBiomesConfig;
import com.henrikstabell.mistcore.api.IBiomeMist;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeMistPlains extends Biome implements IBiomeMist {

    public BiomeMistPlains() {
        super(new BiomeProperties("Mist Plains").setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(0.8F).setRainfall(0.4F));
        this.decorator.treesPerChunk = 0;
        this.decorator.extraTreeChance = 0.05F;
        this.decorator.flowersPerChunk = 0;
        this.decorator.grassPerChunk = 10;
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityHorse.class, 5, 2, 6));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDonkey.class, 1, 1, 3));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityZombie.class, 20, 8, 16));
    }

    public WorldGenAbstractTree getRandomTreeFeature(Random rand)
    {
        return (WorldGenAbstractTree)(rand.nextInt(3) == 0 ? BIG_TREE_FEATURE : TREE_FEATURE);
    }

    @Override
    public float getMistDensity(int i, int i1, int i2) {
        return MistBiomesConfig.mistDensity;
    }

    @Override
    public int getMistColour(int i, int i1, int i2) {
        return 16777215;
    }
}