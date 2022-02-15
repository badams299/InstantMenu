package com.bobafett.instantmenu

import com.bobafett.instantmenu.db.InstantMenuDB
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import org.koin.dsl.module

actual val platformModule = module {
    single<SqlDriver> { NativeSqliteDriver(InstantMenuDB.Schema, "InstantMenuDB") }
}