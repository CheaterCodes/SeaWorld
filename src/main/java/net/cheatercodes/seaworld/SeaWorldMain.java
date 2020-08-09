package net.cheatercodes.seaworld;

import net.cheatercodes.seaworld.world.SeaWorldGeneratorType;
import net.fabricmc.api.ClientModInitializer;

public class SeaWorldMain implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		SeaWorldGeneratorType.register();
	}
}
