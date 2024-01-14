package abe.owtt

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory

const val MOD_ID = "owtt"

object OtherWorldsThanThese : ModInitializer {
    private val logger = LoggerFactory.getLogger("owtt")

	private val DEV_WAND = Item(FabricItemSettings().maxCount(1))

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		logger.info("Hello Fabric world!")

		Registry.register(Registries.ITEM, Identifier(MOD_ID, "dev_wand"), DEV_WAND)
	}
}