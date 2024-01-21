package abe.owtt.dimension

import abe.owtt.component.COSMIC_ALIGNMENT
import net.minecraft.world.World
import abe.owtt.OtherWorldsThanThese.LOGGER
import kotlin.random.Random

fun getInitialAlignment(world : World): Int {
    LOGGER.debug("Setting initial alignment for world {}", world.dimensionKey.value)
    return Random.nextInt(1000)
}

fun getAlignmentChangeRate(world : World): Int {
    LOGGER.debug("Setting alignment change rate for world {}", world.dimensionKey.value)
    when (world.dimensionKey.value.path) {
        "minecraft:overworld" -> return 1
        "minecraft:the_nether" -> return 2
        "minecraft:the_end" -> return 3
    }
    LOGGER.warn("Unknown dimension {}, setting alignment change rate to 0", world.dimensionKey.value)
    return 0
}

fun World.alignment(): Int {
    return COSMIC_ALIGNMENT.get(this).value
}