package abe.owtt

import abe.owtt.OtherWorldsThanThese.id
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.server.world.ServerWorld
import net.minecraft.world.World

private val DIM1_TYPE_KEY: RegistryKey<World> = RegistryKey.of(RegistryKeys.WORLD, id("dim1"))

object Dimensions {
    lateinit var DIM1 : ServerWorld
    lateinit var OVERWORLD : ServerWorld

    fun init() {
        ServerLifecycleEvents.SERVER_STARTED.register { server ->
            DIM1 = server.getWorld(DIM1_TYPE_KEY)!!
            OVERWORLD = server.getWorld(World.OVERWORLD)!!
        }
    }
}