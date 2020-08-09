package net.cheatercodes.seaworld.mixin;

import net.cheatercodes.seaworld.world.SeaWorldGeneratorType;
import net.minecraft.client.gui.screen.world.MoreOptionsDialog;
import net.minecraft.client.world.GeneratorType;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.world.gen.GeneratorOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(MoreOptionsDialog.class)
public class MoreOptionsDialogMixin {
    @Shadow
    private Optional<GeneratorType> field_25049;

    @Shadow private GeneratorOptions generatorOptions;

    @Shadow private DynamicRegistryManager.Impl field_25483;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void changeDefaultGeneratorType(CallbackInfo callbackInfo) {
        //this.generatorOptions = SeaWorldGeneratorType.TYPE.method_29077(this.field_25483, this.generatorOptions.getSeed(), this.generatorOptions.shouldGenerateStructures(), this.generatorOptions.hasBonusChest());
        //this.field_25049 = Optional.of(SeaWorldGeneratorType.TYPE);
    }
}
