package abe.owtt

import abe.owtt.component.IntComponent
import abe.owtt.dimension.Dimensions
import abe.owtt.item.DevWandItem
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry
import net.fabricmc.api.ModInitializer
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory

const val MOD_ID = "owtt"

object OtherWorldsThanThese : ModInitializer {
    private val logger = LoggerFactory.getLogger("owtt")

	// Register items
	val DEV_WAND =  Registry.register(Registries.ITEM, Identifier(MOD_ID, "dev_wand"), DevWandItem())

	val COSMIC_ALIGNMENT = ComponentRegistry.getOrCreate(OtherWorldsThanThese.id("cosmic_alignment"), IntComponent::class.java)

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		logger.info("Initializing Other Worlds Than These (owtt)")

		Dimensions.init()
	}

	fun id(path: String) = Identifier(MOD_ID, path)
}