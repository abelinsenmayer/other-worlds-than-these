package abe.owtt

import abe.owtt.OtherWorldsThanThese.id
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.server.world.ServerWorld
import net.minecraft.world.World

private val DIM1_TYPE_KEY: RegistryKey<World> = RegistryKey.of(RegistryKeys.WORLD, id("dim1"))

object Dimensions {
    lateinit var DIM1_DIMENSION : ServerWorld
    lateinit var OVERWORLD_DIMENSION : ServerWorld

    fun init() {
        ServerLifecycleEvents.SERVER_STARTED.register { server ->
            DIM1_DIMENSION = server.getWorld(DIM1_TYPE_KEY)!!
            OVERWORLD_DIMENSION = server.getWorld(World.OVERWORLD)!!
        }
    }
}