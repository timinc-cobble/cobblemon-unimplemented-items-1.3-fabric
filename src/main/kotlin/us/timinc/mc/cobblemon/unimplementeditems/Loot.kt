package us.timinc.mc.cobblemon.unimplementeditems

import net.fabricmc.fabric.api.loot.v2.LootTableSource
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.storage.loot.LootPool
import net.minecraft.world.level.storage.loot.LootTable
import net.minecraft.world.level.storage.loot.entries.LootTableReference

object Loot {
    fun register(source: LootTableSource, id: ResourceLocation, tableBuilder: LootTable.Builder) {
        if (source.isBuiltin && UnimplementedItems.config.lootPoolOverrides.contains(id)) {
            val pool = LootPool.Builder()
                .with(LootTableReference.lootTableReference(ResourceLocation(UnimplementedItems.MOD_ID, "overrides/${id.path}")).build())
            tableBuilder.withPool(pool)
        }
    }
}