package abe.owtt.dimension

import abe.owtt.component.COSMIC_ALIGNMENT
import net.minecraft.world.World
import abe.owtt.OtherWorldsThanThese.LOGGER
import kotlin.random.Random

const val OVERWORLD_CHANGE_RATE = 2
const val NETHER_CHANGE_RATE = 3
const val END_CHANGE_RATE = 1
const val OTHER_DIMENSIONS_CHANGE_RATE = 1

fun getInitialAlignment(world : World): Int {
    LOGGER.debug("Setting initial alignment for world {}", world.dimensionKey.value)
    return Random.nextInt(1000)
}

fun getAlignmentChangeRate(world : World): Int {
    LOGGER.debug("Setting alignment change rate for world {}", world.dimensionKey.value)
    when (world.dimensionKey.value.path) {
        "minecraft:overworld" -> return OVERWORLD_CHANGE_RATE
        "minecraft:the_nether" -> return NETHER_CHANGE_RATE
        "minecraft:the_end" -> return END_CHANGE_RATE
    }
    LOGGER.info("Unknown dimension {}, setting alignment change rate to {}", OTHER_DIMENSIONS_CHANGE_RATE, world.dimensionKey.value)
    return OTHER_DIMENSIONS_CHANGE_RATE
}

fun World.alignment(): Int {
    return COSMIC_ALIGNMENT.get(this).value
}