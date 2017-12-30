package com.henrikstabell.mistbiomes.client.config;

import com.henrikstabell.mistbiomes.MistBiomes;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


// TODO: Get this properly ordered and categorized (Blame it on Forge...)
@Config(modid = MistBiomes.MODID, name = "MistBiomes")
@Config.LangKey("mistbiomes.config.title")
public class MistBiomesConfig {

    @Config.Name("Mist Forest")
    @Config.Comment("Should the Mist Forest biome be enabled or disabled?")
    @Config.RequiresMcRestart
    public static boolean mistForestEnabled = true;

    @Config.Name("Mist Plains")
    @Config.Comment("Should the Mist Plains biome be enabled or disabled?")
    @Config.RequiresMcRestart
    public static boolean mistPlainsEnabled = true;

    @Config.Name("Mist Desert")
    @Config.Comment("Should the Mist Desert biome be enabled or disabled?")
    @Config.RequiresMcRestart
    public static boolean mistDesertEnabled = true;

    @Config.Name("Mist Taiga")
    @Config.Comment("Should the Mist Taiga biome be enabled or disabled?")
    @Config.RequiresMcRestart
    public static boolean mistTaigaEnabled = true;

    @Config.Name("Cold Mist Taiga")
    @Config.Comment("Should the Cold Mist Taiga biome be enabled or disabled?")
    @Config.RequiresMcRestart
    public static boolean coldMistTaigaEnabled = true;

    @Config.Name("Misty Swamplands")
    @Config.Comment("Should the Misty Swamplands biome be enabled or disabled?")
    @Config.RequiresMcRestart
    public static boolean mistySwamplandsEnabled = true;

    @Config.Name("Mist Density")
    @Config.Comment("How much mist should the mist biomes have?")
    public static float mistDensity = 0.1F;

    @Mod.EventBusSubscriber(modid = MistBiomes.MODID)
    private static class EventHandler {
        @SubscribeEvent
        public static void onConfigChangedEvent(final ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(MistBiomes.MODID)) {
                ConfigManager.sync(MistBiomes.MODID, Config.Type.INSTANCE);
            }
        }
    }
}