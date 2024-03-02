package com.tecana.infiniteblocks.commands

import com.tecana.infiniteblocks.InfiniteBlocks
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.util.*

class CommandInfiniteBlocks : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, string: String, args: Array<String>): Boolean {
        if (args.isNotEmpty()) {
            return InfiniteBlocks.instance.commandManager.executeCommand(sender, args[0], args.copyOfRange(1, args.size))
        }
        sendHelpMessage(sender)

        return false
    }
    private fun sendHelpMessage(sender: CommandSender) {
        for (lore in InfiniteBlocks.instance.config.getStringList("helpmessage")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', lore))
        }
    }
}