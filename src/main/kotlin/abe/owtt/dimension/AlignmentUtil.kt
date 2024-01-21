package abe.owtt.dimension

import abe.owtt.component.COSMIC_ALIGNMENT
import net.minecraft.world.World
import abe.owtt.OtherWorldsThanThese.LOGGER

fun getInitialAlignment(world : World): Int {
    LOGGER.debug("Setting initial alignment for world {}", world.dimensionKey.value)
    return 0
}

fun World.alignment(): Int {
    LOGGER.debug("Getting alignment for world {}", this)
    return COSMIC_ALIGNMENT.get(this).value
}