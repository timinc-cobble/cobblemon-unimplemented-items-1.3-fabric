@file:Suppress("MemberVisibilityCanBePrivate")

package us.timinc.mc.cobblemon.unimplementeditems.items

import com.cobblemon.mod.common.api.pokemon.stats.Stats
import com.cobblemon.mod.common.item.CobblemonItemGroups
import dev.architectury.registry.fuel.FuelRegistry
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.loot.v2.LootTableEvents
import net.fabricmc.fabric.api.loot.v2.LootTableSource
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry
import net.minecraft.core.Registry
import net.minecraft.resources.ResourceLocation
import net.minecraft.server.packs.resources.ResourceManager
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.storage.loot.BuiltInLootTables
import net.minecraft.world.level.storage.loot.LootPool
import net.minecraft.world.level.storage.loot.LootTable
import net.minecraft.world.level.storage.loot.LootTables
import net.minecraft.world.level.storage.loot.entries.LootItem
import us.timinc.mc.cobblemon.unimplementeditems.Loot
import us.timinc.mc.cobblemon.unimplementeditems.UnimplementedItems

object UnimplementedItemsItems {
    val ABILITY_CAPSULE = AbilityCapsule()
    val BOTTLE_CAP_ATK = BottleCap(Stats.ATTACK)
    val BOTTLE_CAP_DEF = BottleCap(Stats.DEFENCE)
    val BOTTLE_CAP_SA = BottleCap(Stats.SPECIAL_ATTACK)
    val BOTTLE_CAP_SD = BottleCap(Stats.SPECIAL_DEFENCE)
    val BOTTLE_CAP_SPD = BottleCap(Stats.SPEED)
    val BOTTLE_CAP_HP = BottleCap(Stats.HP)
    val BOTTLE_CAP = Item(
        FabricItemSettings().group(CobblemonItemGroups.MEDICINE_ITEM_GROUP).maxCount(16)
    )
    val BOTTLE_CAP_GOLD = BottleCap(null)
    val POTION = Potion(60)
    val POTION_HYPER = Potion(150)
    val POTION_MAX = Potion(null)
    val ELIXIR = Elixir(null)
    val ETHER = Elixir(10)
    val ABILITY_PATCH = AbilityPatch()
    val DRY_ROOT = DryRoot()
    val POWER_WEIGHT = PowerEvBooster(Stats.HP, 8)
    val POWER_BRACER = PowerEvBooster(Stats.ATTACK, 8)
    val POWER_BELT = PowerEvBooster(Stats.DEFENCE, 8)
    val POWER_LENS = PowerEvBooster(Stats.SPECIAL_ATTACK, 8)
    val POWER_BAND = PowerEvBooster(Stats.SPECIAL_DEFENCE, 8)
    val POWER_ANKLET = PowerEvBooster(Stats.SPEED, 8)

    fun register() {
        LootTableEvents.MODIFY.register(LootTableEvents.Modify { _: ResourceManager, _: LootTables, id: ResourceLocation, tableBuilder: LootTable.Builder, source: LootTableSource ->
            Loot.register(source, id, tableBuilder)
        })

        Registry.register(
            Registry.ITEM, UnimplementedItems.myResourceLocation("ability_capsule"), ABILITY_CAPSULE
        )
        Registry.register(
            Registry.ITEM, UnimplementedItems.myResourceLocation("bottle_cap_atk"), BOTTLE_CAP_ATK
        )
        Registry.register(
            Registry.ITEM, UnimplementedItems.myResourceLocation("bottle_cap_def"), BOTTLE_CAP_DEF
        )
        Registry.register(
            Registry.ITEM, UnimplementedItems.myResourceLocation("bottle_cap_sa"), BOTTLE_CAP_SA
        )
        Registry.register(
            Registry.ITEM, UnimplementedItems.myResourceLocation("bottle_cap_sd"), BOTTLE_CAP_SD
        )
        Registry.register(
            Registry.ITEM, UnimplementedItems.myResourceLocation("bottle_cap_spd"), BOTTLE_CAP_SPD
        )
        Registry.register(
            Registry.ITEM, UnimplementedItems.myResourceLocation("bottle_cap_hp"), BOTTLE_CAP_HP
        )
        Registry.register(
            Registry.ITEM, UnimplementedItems.myResourceLocation("bottle_cap"), BOTTLE_CAP
        )
        Registry.register(
            Registry.ITEM, UnimplementedItems.myResourceLocation("bottle_cap_gold"), BOTTLE_CAP_GOLD
        )
        Registry.register(
            Registry.ITEM, UnimplementedItems.myResourceLocation("potion"), POTION
        )
        Registry.register(
            Registry.ITEM, UnimplementedItems.myResourceLocation("potion_hyper"), POTION_HYPER
        )
        Registry.register(
            Registry.ITEM, UnimplementedItems.myResourceLocation("potion_max"), POTION_MAX
        )
        Registry.register(Registry.ITEM, UnimplementedItems.myResourceLocation("ether"), ETHER)
        Registry.register(
            Registry.ITEM, UnimplementedItems.myResourceLocation("elixir"), ELIXIR
        )
        Registry.register(
            Registry.ITEM, UnimplementedItems.myResourceLocation("ability_patch"), ABILITY_PATCH
        )
        Registry.register(
            Registry.ITEM, UnimplementedItems.myResourceLocation("dry_root"), DRY_ROOT
        )
        Registry.register(Registry.ITEM, UnimplementedItems.myResourceLocation("power_weight"), POWER_WEIGHT)
        Registry.register(Registry.ITEM, UnimplementedItems.myResourceLocation("power_bracer"), POWER_BRACER)
        Registry.register(Registry.ITEM, UnimplementedItems.myResourceLocation("power_belt"), POWER_BELT)
        Registry.register(Registry.ITEM, UnimplementedItems.myResourceLocation("power_lens"), POWER_LENS)
        Registry.register(Registry.ITEM, UnimplementedItems.myResourceLocation("power_band"), POWER_BAND)
        Registry.register(Registry.ITEM, UnimplementedItems.myResourceLocation("power_anklet"), POWER_ANKLET)

        FuelRegistry.register(100, DRY_ROOT)
        CompostingChanceRegistry.INSTANCE.add(DRY_ROOT, 0.3F)
    }
}