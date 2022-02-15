package com.bobafett.instantmenu.core.menu.datasource.storage

import com.bobafett.instantmenu.core.menu.datasource.transactionWithContext
import com.bobafett.instantmenu.db.InstantMenuDB
import com.bobafett.instantmenu.db.MenuItem
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class DatabaseHelper(
    sqlDriver: SqlDriver,
    private val backgroundDispatcher: CoroutineDispatcher
) {
    private val dbRef: InstantMenuDB = InstantMenuDB(sqlDriver)

    fun getMenuItems(): Flow<List<MenuItem>> =
        dbRef.tableQueries
            .selectAll()
            .asFlow()
            .mapToList()
            .flowOn(backgroundDispatcher)

    suspend fun insertMenuItems(menuItems: List<MenuItem>) {
        dbRef.transactionWithContext(backgroundDispatcher) {
            menuItems.forEach { menuItem ->
                dbRef.tableQueries.insertMenuItem(
                    id = null,
                    name = menuItem.name,
                    description = menuItem.description,
                    imageUrl = menuItem.imageUrl,
                    price = menuItem.price
                )
            }
        }
    }

    suspend fun deleteAll() {
        dbRef.transactionWithContext(backgroundDispatcher) {
            dbRef.tableQueries.deleteAll()
        }
    }

    fun selectById(id: Long): Flow<List<MenuItem>> =
        dbRef.tableQueries
            .selectById(id)
            .asFlow()
            .mapToList()
            .flowOn(backgroundDispatcher)

    fun selectById(name: String): Flow<List<MenuItem>> =
        dbRef.tableQueries
            .selectByName(name)
            .asFlow()
            .mapToList()
            .flowOn(backgroundDispatcher)

}
