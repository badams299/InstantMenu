package com.bobafett.instantmenu.core.menu.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuItem(
    @SerialName("name") val name: String,
    @SerialName("price") val link: String?,
    @SerialName("description") val desc: String?,
    @SerialName("imageUrl") val imageUrl: String?,
    @SerialName("date") val date: Long
)