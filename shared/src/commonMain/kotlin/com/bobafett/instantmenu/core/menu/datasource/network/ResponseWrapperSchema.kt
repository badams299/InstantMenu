package com.bobafett.instantmenu.core.menu.datasource.network

import kotlinx.serialization.Serializable


@Serializable
data class ResponseWrapperSchema(
    val items: List<MenuItem>
)