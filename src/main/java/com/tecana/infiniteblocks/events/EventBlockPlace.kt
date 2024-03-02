package com.tecana.infiniteblocks.events

import com.tecana.infiniteblocks.InfiniteBlocks
import de.tr7zw.nbtapi.NBTItem
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.inventory.ItemStack

class EventBlockPlace : Listener {

    private fun isInfiniteBlock(stack: ItemStack?): Boolean {
        return NBTItem(stack).getBoolean("infiniteblock")
    }

    private fun getType(stack: ItemStack?): String {
        return NBTItem(stack).getString("infiniteblocktype")
    }

    @EventHandler
    fun onPlace(event: BlockPlaceEvent) {
        if (isInfiniteBlock(event.itemInHand)) {
            event.isCancelled = true
            val type = InfiniteBlocks.instance.getITypeManager().getITypeByName(getType(event.itemInHand))

            if (InfiniteBlocks.instance.getEconomy()?.getBalance(event.player)!! >= type.getCost()) {
                event.blockReplacedState.type = Material.getMaterial(type.getPlacedMaterial())
                InfiniteBlocks.instance.getEconomy()?.withdrawPlayer(event.player, type.getCost())
                event.player.sendMessage(ChatColor.translateAlternateColorCodes('&', type.getMessage()))
            } else {
                event.player.sendMessage(ChatColor.translateAlternateColorCodes('&', type.getInsufficentFunds()))
            }
        }
    }
}