package com.bobafett.instantmenu

import kotlinx.serialization.Serializable

@Serializable
sealed class ItemHighlight {
    object Spicy : ItemHighlight()
    object Vegan : ItemHighlight()
    object GlutenFree : ItemHighlight()
}