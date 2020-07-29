package net.cheatercodes.seaworld.mixin;

import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(DimensionType.class)
public interface DimensionTypeAccessor {
    @Accessor(value = "OVERWORLD")
    static DimensionType getOverworld() {
        throw new AbstractMethodError();
    }

    @Accessor(value = "THE_NETHER")
    static DimensionType getTheNether() {
        throw new AbstractMethodError();
    }

    @Accessor(value = "THE_END")
    static DimensionType getTheEnd() {
        throw new AbstractMethodError();
    }
}
