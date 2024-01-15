package abe.owtt

import abe.owtt.dimension.Dimensions
import abe.owtt.item.DevWandItem
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import net.minecraft.world.dimension.DimensionType
import org.slf4j.LoggerFactory

const val MOD_ID = "owtt"

object OtherWorldsThanThese : ModInitializer {
    private val logger = LoggerFactory.getLogger("owtt")

	// Register items
	private val DEV_WAND =  Registry.register(Registries.ITEM, Identifier(MOD_ID, "dev_wand"), DevWandItem())

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		logger.info("Hello Fabric world!")

		Dimensions.init()
	}

	fun id(path: String) = Identifier(MOD_ID, path)
}