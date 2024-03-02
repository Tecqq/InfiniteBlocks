package com.tecana.infiniteblocks.commands

import com.tecana.infiniteblocks.ICommand
import com.tecana.infiniteblocks.InfiniteBlocks
import de.tr7zw.nbtapi.NBTItem
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.command.CommandSender
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

class CommandGive : ICommand() {
    init {
        addAlias("give")
    }

    override fun execute(sender: CommandSender, args: Array<String>): Boolean {
        val senderPlayer: Player = sender as Player
        if (args.isEmpty()) {
            sendHelpMessage(senderPlayer)
            return false
        }
        val player: Player? = Bukkit.getPlayer(args[0])
        if (player == null) {
            sender.sendMessage(color(InfiniteBlocks.instance.config.getString("playernotfound")))
            return true
        }
        if (sender.hasPermission("infiniteblocks.admin")) {
            val nbtItem = NBTItem(ItemStack(Material.getMaterial(InfiniteBlocks.instance.getITypeManager().getITypeByName(args[1]).getItemMaterial()), 1))
            nbtItem.setBoolean("infiniteblock", true)
            nbtItem.setString("infiniteblocktype", args[1])
            val itemStack = nbtItem.item
            val meta: ItemMeta? = itemStack.itemMeta
            meta?.displayName = ChatColor.translateAlternateColorCodes('&', InfiniteBlocks.instance.getITypeManager().getITypeByName(args[1])!!.getDisplayName())
            val lore: ArrayList<String> = ArrayList()
            for (lores in InfiniteBlocks.instance.getITypeManager().getITypeByName(args[1]).getLore()) {
                lore.add(ChatColor.translateAlternateColorCodes('&', lores))
            }
            meta?.lore = lore
            if (InfiniteBlocks.instance.getITypeManager().getITypeByName(args[1]).isEnchanted()) {
                meta?.addEnchant(Enchantment.DURABILITY, 1, true)
                meta?.addItemFlags(ItemFlag.HIDE_ENCHANTS)
            }
            itemStack.itemMeta = meta
            player.inventory.addItem(itemStack)
            return true
        }
        senderPlayer.sendMessage(color(InfiniteBlocks.instance.config.getString("nopermission")))
        return true
    }

    private fun color(string: String): String {
        return ChatColor.translateAlternateColorCodes('&', string)
    }

    private fun sendHelpMessage(player: Player) {
        for (lore in InfiniteBlocks.instance.config.getStringList("helpmessage")) {
            player.sendMessage(color(lore))
        }
    }
}