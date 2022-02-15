package com.bobafett.instantmenu

import com.bobafett.instantmenu.core.menu.datasource.storage.DatabaseHelper
import com.bobafett.instantmenu.db.MenuItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test


class DatabaseTests : KoinTest {
    private val dbHelper: DatabaseHelper by inject()

    private suspend fun DatabaseHelper.insertItem(name: String) {
        insertMenuItems(
            listOf(
                MenuItem(
                    id = 1,
                    name = name,
                    description = "Description",
                    imageUrl = "www.google.com",
                    price = "$1.00"
                )
            )
        )
    }

    @BeforeTest
    suspend fun setUp() = runBlocking {
        startKoin {
            modules(
                coreModule
            )
        }
        dbHelper.deleteAll()
        dbHelper.insertItem("CheeseBurger")
    }

    @AfterTest
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun selectAllItemsSuccess() = runBlocking {
        val items = dbHelper.getMenuItems().first()
        //assertEquals(items.find { it.name == "CheeseBurger" })
    }


}