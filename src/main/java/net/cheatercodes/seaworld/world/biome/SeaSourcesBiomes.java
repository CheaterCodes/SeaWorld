package net.cheatercodes.seaworld.world.biome;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilders;

public class SeaSourcesBiomes {
    public static Biome SEAWORLD_BIOME = BuiltinRegistries.add(BuiltinRegistries.BIOME, new Identifier("seaworld"), createSeaworldBiome());

    private static Biome createSeaworldBiome() {
        SpawnSettings.Builder spawnSettingsBuilder = new SpawnSettings.Builder();
        spawnSettingsBuilder.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(EntityType.SQUID, 1, 1, 4));
        spawnSettingsBuilder.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(EntityType.DOLPHIN, 1, 1, 4));
        spawnSettingsBuilder.spawn(SpawnGroup.WATER_AMBIENT, new SpawnSettings.SpawnEntry(EntityType.COD, 1, 1, 4));

        GenerationSettings.Builder generationSettingsBuilder = new GenerationSettings.Builder();
        generationSettingsBuilder.surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);

        generationSettingsBuilder.carver(GenerationStep.Carver.LIQUID, ConfiguredCarvers.UNDERWATER_CANYON);
        generationSettingsBuilder.carver(GenerationStep.Carver.LIQUID, ConfiguredCarvers.UNDERWATER_CAVE);

        generationSettingsBuilder.structureFeature(ConfiguredStructureFeatures.SHIPWRECK);
        generationSettingsBuilder.structureFeature(ConfiguredStructureFeatures.OCEAN_RUIN_COLD);
        generationSettingsBuilder.structureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_OCEAN);

        generationSettingsBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SEAGRASS_DEEP_COLD);
        generationSettingsBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.KELP_COLD);

        BiomeEffects.Builder biomeEffectsBuilder = new BiomeEffects.Builder();
        biomeEffectsBuilder.waterColor(0x88CAE2);
        biomeEffectsBuilder.waterFogColor(0x588391);
        biomeEffectsBuilder.fogColor(0xC0D8FF);
        biomeEffectsBuilder.skyColor(0x7BA4FF);

        Biome.Builder biomeBuilder = new Biome.Builder();
        biomeBuilder.precipitation(Biome.Precipitation.RAIN);
        biomeBuilder.category(Biome.Category.OCEAN);
        biomeBuilder.depth(-1.8f);
        biomeBuilder.scale(0.1f);
        biomeBuilder.temperature(0.5f);
        biomeBuilder.downfall(0.5f);
        biomeBuilder.effects(biomeEffectsBuilder.build());
        biomeBuilder.spawnSettings(spawnSettingsBuilder.build());
        biomeBuilder.generationSettings(generationSettingsBuilder.build());

        return biomeBuilder.build();
    }

	/*
	*     public SeablockBiome() {
        super(new Biome.Settings()
            .configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG)
            .precipitation(Precipitation.RAIN).category(Category.OCEAN).depth(-1.8f).scale(0.1f)
            .temperature(0.5f).downfall(0.5f).parent(null).effects(
                new BiomeEffects.Builder().waterColor(0x88CAE2).waterFogColor(0x588391).fogColor(0xC0D8FF).build()));

        this.addCarver(GenerationStep.Carver.LIQUID, Biome.configureCarver(Carver.UNDERWATER_CANYON, new ProbabilityConfig(0.02F)));
        this.addCarver(GenerationStep.Carver.LIQUID, Biome.configureCarver(Carver.UNDERWATER_CAVE, new ProbabilityConfig(0.06666667F)));

        this.addStructureFeature(StructureFeature.SHIPWRECK.configure(new ShipwreckFeatureConfig(false)));
        this.addStructureFeature(StructureFeature.OCEAN_RUIN.configure(new OceanRuinFeatureConfig(OceanRuinFeature.BiomeType.COLD, 0.3F, 0.9F)));

        this.addStructureFeature(DefaultBiomeFeatures.SUNKEN_SHIPWRECK);
        this.addStructureFeature(DefaultBiomeFeatures.COLD_OCEAN_RUIN);
        this.addStructureFeature(DefaultBiomeFeatures.OCEAN_RUINED_PORTAL);

        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.SEAGRASS.configure(new SeagrassFeatureConfig(48, 0.8D)).createDecoratedFeature(Decorator.TOP_SOLID_HEIGHTMAP.configure(DecoratorConfig.DEFAULT)));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.SIMPLE_BLOCK.configure(new SimpleBlockFeatureConfig(Blocks.SEAGRASS.getDefaultState(), List.of(Blocks.STONE.getDefaultState()), List.of(Blocks.WATER.getDefaultState()), List.of(Blocks.WATER.getDefaultState()))).createDecoratedFeature(Decorator.CARVING_MASK.configure(new CarvingMaskDecoratorConfig(GenerationStep.Carver.LIQUID, 0.1F))));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.KELP.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.TOP_SOLID_HEIGHTMAP_NOISE_BIASED.configure(new TopSolidHeightmapNoiseBiasedDecoratorConfig(120, 80.0D, 0.0D, Heightmap.Type.OCEAN_FLOOR_WG))));
        //this.addFeature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, SeaSourcesFeatures.STARTING_RAFT_FEATURE.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.NOPE.configure(DecoratorConfig.DEFAULT)));
        //this.addFeature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, SeaSourcesFeatures.DRIFTING_ITEMS_FEATURE.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.NOPE.configure(DecoratorConfig.DEFAULT)));

        this.addSpawn(SpawnGroup.WATER_CREATURE, new Biome.SpawnEntry(EntityType.SQUID, 1, 1, 4));
        this.addSpawn(SpawnGroup.WATER_CREATURE, new Biome.SpawnEntry(EntityType.DOLPHIN, 1, 1, 2));
        this.addSpawn(SpawnGroup.WATER_AMBIENT, new Biome.SpawnEntry(EntityType.COD, 10, 3, 6));
    }*/
}
