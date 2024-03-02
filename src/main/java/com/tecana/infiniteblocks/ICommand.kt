package com.tecana.infiniteblocks

import org.bukkit.command.CommandSender

abstract class ICommand {
    private val aliases: MutableList<String> = mutableListOf()

    abstract fun execute(sender: CommandSender, args: Array<String>): Boolean

    fun getAliases(): List<String> = aliases

    protected fun addAlias(alias: String) {
        aliases.add(alias)
    }
}