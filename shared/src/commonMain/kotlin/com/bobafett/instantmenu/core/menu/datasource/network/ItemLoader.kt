package com.bobafett.instantmenu.core.menu.datasource.network

import com.bobafett.instantmenu.core.menu.entity.MenuItem
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.statement.*

class ItemLoader(
    private val httpClient: HttpClient,
    private val transformer: ItemResponseTransformer
) {
//    suspend fun getFeed(url: String, isDefault: Boolean): List<MenuItem> {
//        val xml = httpClient.get<HttpResponse>(url).readText()
//        return transformer.parse(url, xml, isDefault)
//    }
}