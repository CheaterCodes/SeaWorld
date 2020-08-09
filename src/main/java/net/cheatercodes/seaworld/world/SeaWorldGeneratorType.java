package net.cheatercodes.seaworld.world;

import com.mojang.serialization.Lifecycle;
import net.cheatercodes.seaworld.mixin.DimensionTypeAccessor;
import net.cheatercodes.seaworld.world.biome.SeaSourcesBiomes;
import net.minecraft.client.world.GeneratorType;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.FixedBiomeSource;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.gen.GeneratorOptions;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;

public class SeaWorldGeneratorType extends GeneratorType {
    public static final GeneratorType TYPE = new SeaWorldGeneratorType();

    private SeaWorldGeneratorType() {
        super("seaworld");
    }

    public static void register() {
        VALUES.add(TYPE);
    }

    @Override
    protected ChunkGenerator getChunkGenerator(Registry<Biome> biomes, Registry<ChunkGeneratorSettings> chunkGeneratorSettings, long seed) {
        return new NoiseChunkGenerator(new FixedBiomeSource(SeaSourcesBiomes.SEAWORLD_BIOME), seed, () -> chunkGeneratorSettings.get(ChunkGeneratorSettings.OVERWORLD));
    }

    private ChunkGenerator getNetherChunkGenerator(Registry<Biome> biomes, Registry<ChunkGeneratorSettings> chunkGeneratorSettings, long seed) {
        return new NoiseChunkGenerator(new FixedBiomeSource(SeaSourcesBiomes.SEAWORLD_BIOME), seed, () -> chunkGeneratorSettings.get(ChunkGeneratorSettings.OVERWORLD));
    }

    private ChunkGenerator getEndChunkGenerator(Registry<Biome> biomes, Registry<ChunkGeneratorSettings> chunkGeneratorSettings, long seed) {
        return new NoiseChunkGenerator(new FixedBiomeSource(SeaSourcesBiomes.SEAWORLD_BIOME), seed, () -> chunkGeneratorSettings.get(ChunkGeneratorSettings.OVERWORLD));
    }

    @Override
    public GeneratorOptions method_29077(DynamicRegistryManager.Impl registryManager, long l, boolean bl, boolean bl2) {
        Registry<Biome> biomes = registryManager.get(Registry.BIOME_KEY);
        Registry<ChunkGeneratorSettings> chunkGeneratorSettings = registryManager.get(Registry.NOISE_SETTINGS_WORLDGEN);
        SimpleRegistry<DimensionOptions> registry = new SimpleRegistry<>(Registry.DIMENSION_OPTIONS, Lifecycle.experimental());

        registry.add(DimensionOptions.OVERWORLD, new DimensionOptions(DimensionTypeAccessor::getOverworld, getChunkGenerator(biomes, chunkGeneratorSettings, l)), Lifecycle.stable());
        registry.add(DimensionOptions.NETHER, new DimensionOptions(DimensionTypeAccessor::getTheNether, getNetherChunkGenerator(biomes, chunkGeneratorSettings, l)), Lifecycle.stable());
        registry.add(DimensionOptions.END, new DimensionOptions(DimensionTypeAccessor::getTheEnd, getEndChunkGenerator(biomes, chunkGeneratorSettings, l)), Lifecycle.stable());
        //registry.markLoaded(DimensionOptions.OVERWORLD);
        //registry.markLoaded(DimensionOptions.NETHER);
        //registry.markLoaded(DimensionOptions.END);
        return new GeneratorOptions(l, bl, bl2, registry);
    }
}
