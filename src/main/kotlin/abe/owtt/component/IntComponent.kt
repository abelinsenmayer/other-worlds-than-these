package abe.owtt.component

import dev.onyxstudios.cca.api.v3.component.ComponentV3
import net.minecraft.nbt.NbtCompound

interface IntComponent : ComponentV3 {
    var value: Int

    override fun readFromNbt(tag: NbtCompound) {
        this.value = tag.getInt("value")
    }

    override fun writeToNbt(tag: NbtCompound) {
        tag.putInt("value", this.value)
    }
}