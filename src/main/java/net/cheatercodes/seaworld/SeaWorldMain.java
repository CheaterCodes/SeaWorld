package net.cheatercodes.seaworld;

import net.cheatercodes.seaworld.world.SeaWorldGeneratorType;
import net.fabricmc.api.ModInitializer;

public class SeaWorldMain implements ModInitializer {
	@Override
	public void onInitialize() {
		SeaWorldGeneratorType.register();
	}
}
