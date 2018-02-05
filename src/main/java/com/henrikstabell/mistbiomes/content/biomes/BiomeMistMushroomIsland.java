package com.henrikstabell.mistbiomes.content.biomes;

import com.henrikstabell.mistbiomes.client.config.MistBiomesConfig;
import com.henrikstabell.mistcore.api.IBiomeMist;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeMistMushroomIsland extends Biome implements IBiomeMist{

    public BiomeMistMushroomIsland() {
        super(new BiomeProperties(("Misty Mushroom Island")).setBaseHeight(0.2F).setHeightVariation(0.3F).setTemperature(0.9F).setRainfall(1.0F));
        this.decorator.treesPerChunk = -100;
        this.decorator.flowersPerChunk = -100;
        this.decorator.grassPerChunk = -100;
        this.decorator.mushroomsPerChunk = 1;
        this.decorator.bigMushroomsPerChunk = 1;
        this.topBlock = Blocks.MYCELIUM.getDefaultState();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityMooshroom.class, 8, 4, 8));
    }

    @Override
    public float getMistDensity(int i, int i1, int i2) {
        return MistBiomesConfig.mistDensity;
    }

    @Override
    public int getMistColour(int i, int i1, int i2) {
        return 16777215;
    }

    @Override
    public int getMistMultiplier(int i) {
        return 10;
    }
}
