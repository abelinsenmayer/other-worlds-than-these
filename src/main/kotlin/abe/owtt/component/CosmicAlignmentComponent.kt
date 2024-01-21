package abe.owtt.component

import abe.owtt.makeLogger
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent
import net.minecraft.nbt.NbtCompound

const val MAX_ALIGNMENT = 1000
const val MIN_ALIGNMENT = 0
const val TICK_FREQUENCY = 200

data class CosmicAlignmentComponent(
    override var value: Int = 0,
    var changeRate: Int = 1
) : IntComponent, ServerTickingComponent {
    private val logger = makeLogger(this)
    private var tickCount = 0

    override fun writeToNbt(tag: NbtCompound) {
        super.writeToNbt(tag)
        tag.putInt("changeRate", this.changeRate)
        tag.putInt("tickCount", this.tickCount)
    }

    override fun readFromNbt(tag: NbtCompound) {
        super.readFromNbt(tag)
        this.changeRate = tag.getInt("changeRate")
        this.tickCount = tag.getInt("tickCount")
    }

    init {
        if (this.value < MIN_ALIGNMENT || this.value > MAX_ALIGNMENT) {
            logger.warn("Cosmic alignment is out of bounds, resetting to $MIN_ALIGNMENT")
            this.value = MIN_ALIGNMENT
        }
    }

    /**
     * The server ticks 20 times per second, but we don't want to change the alignment that often. Alignment changes every [TICK_FREQUENCY] ticks.
     */
    override fun serverTick() {
        if (this.tickCount == TICK_FREQUENCY) {
            logger.info("TICK! Alignment is now ${this.value}")
            if (this.value < MAX_ALIGNMENT) {
                this.value += changeRate
            } else if(this.value > MIN_ALIGNMENT) {
                this.value -= changeRate
            } else {
                throw IllegalStateException("Cosmic alignment is out of bounds")
            }
            this.tickCount = 0
        } else {
            this.tickCount += 1
        }
    }
}