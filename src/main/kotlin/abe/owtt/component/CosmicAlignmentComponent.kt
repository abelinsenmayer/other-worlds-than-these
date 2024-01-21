package abe.owtt.component

import abe.owtt.makeLogger
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent

const val MAX_ALIGNMENT = 1000
const val MIN_ALIGNMENT = 0

data class CosmicAlignmentComponent(
    override var value: Int = 0,
    val changeRate: Int = 1
) : IntComponent, ServerTickingComponent {
    private val logger = makeLogger(this)

    init {
        if (this.value < MIN_ALIGNMENT || this.value > MAX_ALIGNMENT) {
            logger.warn("Cosmic alignment is out of bounds, resetting to $MIN_ALIGNMENT")
            this.value = MIN_ALIGNMENT
        }
    }

    override fun serverTick() {
        if (this.value < MAX_ALIGNMENT) {
            this.value += changeRate
        } else if(this.value > MIN_ALIGNMENT) {
            this.value -= changeRate
        } else {
            throw IllegalStateException("Cosmic alignment is out of bounds")
        }
    }
}