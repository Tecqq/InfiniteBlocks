package com.tecana.infiniteblocks

import org.bukkit.configuration.ConfigurationSection

class ITypeManager {
    private val iTypeMap: HashMap<String, IType> = java.util.HashMap<String, IType>()

    init {
        loadITypes()
    }

    private fun loadITypes() {
        val iTypesSection: ConfigurationSection = InfiniteBlocks.instance.config.getConfigurationSection("infiniteblocks")
        for (key in iTypesSection.getKeys(false)) {
            val specificTypeSection = iTypesSection.getConfigurationSection(key)
            if (specificTypeSection != null) {
                val displayname = specificTypeSection.getString("displayname")
                val lore = specificTypeSection.getStringList("lore")
                val itemmaterial = specificTypeSection.getString("itemmaterial")
                val placedmaterial = specificTypeSection.getString("placedmaterial")
                val cost = specificTypeSection.getDouble("cost")
                val message = specificTypeSection.getString("message")
                val insufficentfundsmessage = specificTypeSection.getString("insufficentfundsmessage")
                val enchanted = specificTypeSection.getBoolean("enchanted")

                val iType = IType(key, displayname, lore, itemmaterial, placedmaterial, cost, message, insufficentfundsmessage, enchanted)
                iTypeMap[key] = iType
            }
        }
    }

    fun getITypeByName(name: String): IType {
        return iTypeMap[name]!!
    }
}
