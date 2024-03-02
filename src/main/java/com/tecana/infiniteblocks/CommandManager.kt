package com.tecana.infiniteblocks

import com.tecana.infiniteblocks.commands.CommandGive
import org.bukkit.command.CommandSender
import java.util.HashMap

class CommandManager {
    private val commands: MutableMap<String, ICommand> = HashMap<String, ICommand>()


    init {
        addCommand(CommandGive())
    }

    private fun addCommand(command: ICommand) {
        for (alias in command.getAliases()) {
            commands[alias] = command
        }
    }

    fun executeCommand(sender: CommandSender, alias: String, args: Array<String>): Boolean {
        val command: ICommand? = commands[alias]
        return command?.execute(sender, args) ?: false
    }
}