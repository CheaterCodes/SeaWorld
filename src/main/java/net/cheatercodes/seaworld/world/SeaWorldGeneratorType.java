package net.cheatercodes.seaworld.world;

import com.mojang.serialization.Lifecycle;
import net.cheatercodes.seaworld.mixin.DimensionTypeAccessor;
import net.cheatercodes.seaworld.world.biome.SeaSourcesBiomes;
import net.minecraft.client.world.GeneratorType;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryTracker;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.world.biome.source.FixedBiomeSource;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.gen.GeneratorOptions;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorType;
import net.minecraft.world.gen.chunk.SurfaceChunkGenerator;

public class SeaWorldGeneratorType extends GeneratorType {
    public static final GeneratorType TYPE = new SeaWorldGeneratorType();

    private SeaWorldGeneratorType() {
        super("seaworld");
    }

    public static void register() {
        VALUES.add(TYPE);
    }

    @Override
    protected ChunkGenerator method_29076(long seed) {
        return new SurfaceChunkGenerator(new FixedBiomeSource(SeaSourcesBiomes.SEABLOCK_BIOME), seed, ChunkGeneratorType.Preset.OVERWORLD.getChunkGeneratorType());
    }

    private ChunkGenerator getNetherChunkGenerator(long seed) {
        return new SurfaceChunkGenerator(new FixedBiomeSource(SeaSourcesBiomes.SEABLOCK_BIOME), seed, ChunkGeneratorType.Preset.OVERWORLD.getChunkGeneratorType());
    }

    private ChunkGenerator getEndChunkGenerator(long seed) {
        return new SurfaceChunkGenerator(new FixedBiomeSource(SeaSourcesBiomes.SEABLOCK_BIOME), seed, ChunkGeneratorType.Preset.OVERWORLD.getChunkGeneratorType());
    }

    @Override
    public GeneratorOptions method_29077(RegistryTracker.Modifiable modifiable, long l, boolean bl, boolean bl2) {
        SimpleRegistry<DimensionOptions> registry = new SimpleRegistry<>(Registry.DIMENSION_OPTIONS, Lifecycle.experimental());
        registry.add(DimensionOptions.OVERWORLD, new DimensionOptions(DimensionTypeAccessor::getOverworld, method_29076(l)));
        registry.add(DimensionOptions.NETHER, new DimensionOptions(DimensionTypeAccessor::getTheNether, getNetherChunkGenerator(l)));
        registry.add(DimensionOptions.END, new DimensionOptions(DimensionTypeAccessor::getTheEnd, getEndChunkGenerator(l)));
        registry.markLoaded(DimensionOptions.OVERWORLD);
        registry.markLoaded(DimensionOptions.NETHER);
        registry.markLoaded(DimensionOptions.END);
        return new GeneratorOptions(l, bl, bl2, registry);
    }
}
