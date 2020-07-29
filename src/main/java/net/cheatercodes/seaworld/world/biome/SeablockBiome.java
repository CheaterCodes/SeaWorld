package net.cheatercodes.seaworld.world.biome;

import com.sun.tools.javac.util.List;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.carver.Carver;
import net.minecraft.world.gen.decorator.CarvingMaskDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.decorator.TopSolidHeightmapNoiseBiasedDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class SeablockBiome extends Biome {
    public SeablockBiome() {
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
    }
}
