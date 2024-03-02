package com.tecana.infiniteblocks

class IType(
        private val name: String,
        private val displayName: String,
        private val lore: List<String>,
        private val itemMaterial: String,
        private val placedMaterial: String,
        private val cost: Double,
        private val message: String,
        private val insufficentfundsmessage: String,
        private val enchanted: Boolean


        ) {
    fun getName(): String = name

    fun getDisplayName(): String = displayName
    fun getLore(): List<String> = lore

    fun getItemMaterial(): String = itemMaterial
    fun getPlacedMaterial(): String = placedMaterial
    fun getCost(): Double = cost
    fun getMessage(): String = message
    fun getInsufficentFunds(): String = insufficentfundsmessage
    fun isEnchanted(): Boolean = enchanted

}