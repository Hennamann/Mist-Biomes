package com.henrikstabell.mistbiomes;

import com.henrikstabell.mistbiomes.init.InitBiomes;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MistBiomes.MODID, version = MistBiomes.VERSION, dependencies = "required-after:mistcore")
public class MistBiomes
{
    public static final String MODID = "mistbiomes";
    public static final String VERSION = "1.0.1";

    @EventHandler
    public void preInit(FMLPreInitializationEvent preEvent) {}

    @EventHandler
    public void init(FMLInitializationEvent event) {
        InitBiomes.registerBiomes();
        InitBiomes.addBiomes();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent postEvent) {}
}