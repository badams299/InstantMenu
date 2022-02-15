package com.bobafett.instantmenu.core.menu.datasource.network

import com.bobafett.instantmenu.ItemHighlight
import kotlinx.serialization.Serializable

@Serializable
data class MenuItem(
    val id: Int,
    val name: String,
    val description: String,
    val price : String,
    val imageUrl: String,
    val tags: List<ItemHighlight>,
    val category: String
)