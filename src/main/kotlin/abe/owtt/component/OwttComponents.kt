package abe.owtt.component

import abe.owtt.OtherWorldsThanThese
import abe.owtt.OtherWorldsThanThese.LOGGER
import abe.owtt.dimension.getInitialAlignment
import dev.onyxstudios.cca.api.v3.component.ComponentKey
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3
import dev.onyxstudios.cca.api.v3.world.WorldComponentFactoryRegistry
import dev.onyxstudios.cca.api.v3.world.WorldComponentInitializer

val COSMIC_ALIGNMENT: ComponentKey<CosmicAlignmentComponent> = ComponentRegistryV3.INSTANCE.getOrCreate(OtherWorldsThanThese.id("cosmic_alignment"), CosmicAlignmentComponent::class.java)

class OwttComponents : WorldComponentInitializer {

    override fun registerWorldComponentFactories(registry: WorldComponentFactoryRegistry) {
        registry.register(COSMIC_ALIGNMENT) { world -> CosmicAlignmentComponent(getInitialAlignment(world)) }
        LOGGER.info("Initializing cosmic alignment component")
    }
}