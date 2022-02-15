package com.bobafett.instantmenu.core.menu.datasource.network

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*

class MenuItemsApi(private val httpClient: HttpClient) {

    suspend fun fetchMenuItems(
        id: String
    ): List<MenuItem>? {
        return try {
            val wrapper: ResponseWrapperSchema = httpClient
                .get("https://myserver.com/menus?q=$id")
            return wrapper.items
        } catch (e: ServerResponseException) {
            null
        }
    }
}