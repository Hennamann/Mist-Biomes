package com.henrikstabell.mistbiomes.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class Configuration {

    public static final ForgeConfigSpec commonSpec;
    public static final Common COMMON;

    static {
        final Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
        commonSpec = commonSpecPair.getRight();
        COMMON = commonSpecPair.getLeft();
    }

    public static class Common {

        public final ForgeConfigSpec.BooleanValue mistForestEnabled;
        public final ForgeConfigSpec.BooleanValue mistBirchForestEnabled;
        public final ForgeConfigSpec.BooleanValue mistDesertEnabled;
        public final ForgeConfigSpec.BooleanValue mistDarkForestEnabled;
        public final ForgeConfigSpec.BooleanValue mistPlainsEnabled;
        public final ForgeConfigSpec.BooleanValue mistSnowyPlainsEnabled;
        public final ForgeConfigSpec.BooleanValue mistSwampEnabled;
        public final ForgeConfigSpec.BooleanValue mistTaigaEnabled;
        public final ForgeConfigSpec.BooleanValue mistSnowyTaigaEnabled;
        public final ForgeConfigSpec.BooleanValue mistBadlandsEnabled;
        public final ForgeConfigSpec.BooleanValue mistWoodedBadlandsEnabled;

        public Common(ForgeConfigSpec.Builder builder) {
            mistForestEnabled = builder
                    .comment("Should the Misty Forest biome be enabled?")
                    .translation("config.common.mistbiomes.mistforestenabled")
                    .define("mistForestEnabled", true);
            mistBirchForestEnabled = builder
                    .comment("Should the Misty Birch Forest biome be enabled?")
                    .translation("config.common.mistbiomes.mistbirchforestenabled")
                    .define("mistBirchForestEnabled", true);
            mistDesertEnabled = builder
                    .comment("Should the Misty Desert biome be enabled?")
                    .translation("config.common.mistbiomes.mistdesertenabled")
                    .define("mistDesertEnabled", true);
            mistDarkForestEnabled = builder
                    .comment("Should the Misty Dark Forest biome be enabled?")
                    .translation("config.common.mistbiomes.mistdarkforestenabled")
                    .define("mistDarkForestEnabled", true);
            mistPlainsEnabled = builder
                    .comment("Should the Misty Plains biome be enabled?")
                    .translation("config.common.mistbiomes.mistplainsenabled")
                    .define("mistPlainsEnabled", true);
            mistSnowyPlainsEnabled = builder
                    .comment("Should the Snowy Mist Plains biome be enabled?")
                    .translation("config.common.mistbiomes.mistsnowyplainsenabled")
                    .define("mistSnowyPlainsEnabled", true);
            mistSwampEnabled = builder
                    .comment("Should the Misty Swamp biome be enabled?")
                    .translation("config.common.mistbiomes.mistswampenabled")
                    .define("mistSwampEnabled", true);
            mistTaigaEnabled = builder
                    .comment("Should the Misty Taiga biome be enabled?")
                    .translation("config.common.mistbiomes.misttaigaenabled")
                    .define("mistTaigaEnabled", true);
            mistSnowyTaigaEnabled = builder
                    .comment("Should the Snowy Mist Taiga biome be enabled?")
                    .translation("config.common.mistbiomes.mistsnowytaigaenabled")
                    .define("mistSnowyTaigaEnabled", true);
            mistBadlandsEnabled = builder
                    .comment("Should the Misty Badlands biome be enabled?")
                    .translation("config.common.mistbiomes.mistbadlandsenabled")
                    .define("mistBadlandsEnabled", true);
            mistWoodedBadlandsEnabled = builder
                    .comment("Should the Wooded Misty Badlands biome be enabled?")
                    .translation("config.common.mistbiomes.mistwoodedbadlandsenabled")
                    .define("mistWoodedBadlandsEnabled", true);
        }
    }

    public static boolean getMistForestEnabled() {
        return COMMON.mistForestEnabled.get();
    }

    public static boolean getMistBirchForestEnabled() {
        return COMMON.mistBirchForestEnabled.get();
    }

    public static boolean getMistDesertEnabled() {
        return COMMON.mistDesertEnabled.get();
    }

    public static boolean getMistDarkForestEnabled() {
        return COMMON.mistDarkForestEnabled.get();
    }

    public static boolean getMistPlainsEnabled() {
        return COMMON.mistPlainsEnabled.get();
    }

    public static boolean getMistSnowyPlainsEnabled() {
        return COMMON.mistSnowyPlainsEnabled.get();
    }

    public static boolean getMistSwampEnabled() {
        return COMMON.mistSwampEnabled.get();
    }

    public static boolean getMistTaigaEnabled() {
        return COMMON.mistTaigaEnabled.get();
    }

    public static boolean getMistSnowyTaigaEnabled() {
        return COMMON.mistSnowyTaigaEnabled.get();
    }

    public static boolean getMistBadlandsEnabled() {
        return COMMON.mistBadlandsEnabled.get();
    }

    public static boolean getMistWoodedBadlandsEnabled() {
        return COMMON.mistWoodedBadlandsEnabled.get();
    }
}
