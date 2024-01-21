package abe.owtt.component

import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent
import org.apache.logging.log4j.LogManager

data class CosmicAlignmentComponent(override var value: Int) : IntComponent, ServerTickingComponent {
    private val logger = LogManager.getLogger(CosmicAlignmentComponent::class.java)

    override fun serverTick() {
        this.value += 1
        logger.info("Cosmic alignment is now $value")
    }
}