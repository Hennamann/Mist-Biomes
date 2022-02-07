package com.henrikstabell.mistbiomes;

import com.henrikstabell.mistbiomes.biomes.MistBiomesInitializer;
import com.henrikstabell.mistbiomes.biomes.MistBiomesProvider;
import com.henrikstabell.mistbiomes.config.Configuration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import terrablender.api.BiomeProviders;

@Mod(MistBiomes.MODID)
public class MistBiomes {

    public static final String MODID = "mistbiomes";

    public MistBiomes() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Configuration.commonSpec);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() ->
                BiomeProviders.register(new MistBiomesProvider(new ResourceLocation(MODID, "biome_provider"), 6)));
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        if (ModList.get().isLoaded("fogtweaker")) {
            InterModComms.sendTo("fogtweaker", "biome_override", MistBiomesInitializer.MIST_FOREST::location);
            InterModComms.sendTo("fogtweaker", "biome_override", MistBiomesInitializer.MIST_BIRCH_FOREST::location);
            InterModComms.sendTo("fogtweaker", "biome_override", MistBiomesInitializer.MIST_PLAINS::location);
            InterModComms.sendTo("fogtweaker", "biome_override", MistBiomesInitializer.SNOWY_MIST_PLAINS::location);
            InterModComms.sendTo("fogtweaker", "biome_override", MistBiomesInitializer.MIST_DESERT::location);
            InterModComms.sendTo("fogtweaker", "biome_override", MistBiomesInitializer.MIST_SWAMP::location);
            InterModComms.sendTo("fogtweaker", "biome_override", MistBiomesInitializer.MIST_TAIGA::location);
            InterModComms.sendTo("fogtweaker", "biome_override", MistBiomesInitializer.SNOWY_MIST_TAIGA::location);
            InterModComms.sendTo("fogtweaker", "biome_override", MistBiomesInitializer.MIST_BADLANDS::location);
            InterModComms.sendTo("fogtweaker", "biome_override", MistBiomesInitializer.WOODED_MIST_BADLANDS::location);
        }
    }
}