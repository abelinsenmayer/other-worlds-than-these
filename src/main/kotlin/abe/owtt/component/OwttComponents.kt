package abe.owtt.component

import abe.owtt.OtherWorldsThanThese
import abe.owtt.OtherWorldsThanThese.COSMIC_ALIGNMENT
import abe.owtt.dimension.getInitialAlignment
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry
import dev.onyxstudios.cca.api.v3.world.WorldComponentFactoryRegistry
import dev.onyxstudios.cca.api.v3.world.WorldComponentInitializer

class OwttComponents : WorldComponentInitializer {
    override fun registerWorldComponentFactories(registry: WorldComponentFactoryRegistry) {
        registry.register(COSMIC_ALIGNMENT) { world -> CosmicAlignmentComponent(getInitialAlignment(world)) }
    }
}