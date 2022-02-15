package com.bobafett.instantmenu.core.menu

import com.bobafett.instantmenu.core.menu.datasource.network.ItemLoader
import com.bobafett.instantmenu.core.menu.datasource.storage.DatabaseHelper
import com.bobafett.instantmenu.core.menu.entity.MenuItem

class MenuRepo(
    private val itemLoader : ItemLoader,
    private val itemStorage : DatabaseHelper
) {

//    @Throws(Exception::class)
//    suspend fun getAllFeeds(
//        forceUpdate: Boolean = false
//    ): List<MenuItem> {
//
//
//        var feeds = itemStorage.getMenuItems()
////
////        if (feeds.isEmpty()) {
////            val feedsUrls = if (feeds.isEmpty()) settings.defaultFeedUrls else feeds.map { it.sourceUrl }
////            feeds = feedsUrls.mapAsync { url ->
////                val new = feedLoader.getFeed(url, settings.isDefault(url))
////                feedStorage.saveFeed(new)
////                new
////            }
////        }
////
//        return feeds
//    }


}