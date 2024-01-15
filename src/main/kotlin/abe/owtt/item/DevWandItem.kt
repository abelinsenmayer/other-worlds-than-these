package abe.owtt.item

import abe.owtt.Dimensions
import net.fabricmc.fabric.api.dimension.v1.FabricDimensions
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.TeleportTarget
import net.minecraft.world.World
import org.apache.logging.log4j.LogManager

class DevWandItem : Item(FabricItemSettings().maxCount(1)) {
    private val logger = LogManager.getLogger(DevWandItem::class.java)

    override fun use(world: World?, user: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
        if (!world!!.isClient) {
            val teleportTarget = TeleportTarget(user!!.pos, user.velocity, user.yaw, user.pitch)
            val targetWorld : ServerWorld = if (world == Dimensions.DIM1) {
                Dimensions.OVERWORLD
            } else {
                Dimensions.DIM1
            }
            FabricDimensions.teleport(user, targetWorld, teleportTarget)
        }
        return TypedActionResult.success(user!!.getStackInHand(hand))
    }
}