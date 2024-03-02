package com.tecana.infiniteblocks

import com.tecana.infiniteblocks.commands.CommandInfiniteBlocks
import com.tecana.infiniteblocks.events.EventBlockPlace
import net.milkbowl.vault.economy.Economy
import org.bukkit.Bukkit
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin


class InfiniteBlocks : JavaPlugin() {

    companion object { lateinit var instance: InfiniteBlocks private set }


    private lateinit var iTypeManager: ITypeManager
    lateinit var commandManager: CommandManager
    private var econ: Economy? = null
    override fun onEnable() {
        saveDefaultConfig()
        instance = this
        iTypeManager = ITypeManager()
        commandManager = CommandManager()
        getCommand("infiniteblocks").executor = CommandInfiniteBlocks()
        Bukkit.getServer().pluginManager.registerEvents(EventBlockPlace(), this)
        if (!setupEconomy()) {
            System.out.printf("[%s] - Disabled due to no Vault dependency found!%n", *arrayOf<Any>(description.name))
            server.pluginManager.disablePlugin(this as Plugin)
            return
        }
    }

    fun getITypeManager(): ITypeManager {
        return iTypeManager
    }

    private fun setupEconomy(): Boolean {
        if (server.pluginManager.getPlugin("Vault") == null) {
            return false
        }
        val rsp = server.servicesManager.getRegistration(Economy::class.java) ?: return false
        econ = rsp.provider
        return econ != null
    }
    fun getEconomy(): Economy? {
        return econ
    }
}