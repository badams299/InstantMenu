package com.bobafett.instantmenu

import com.bobafett.instantmenu.db.InstantMenuDB
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import io.ktor.client.engine.*
import io.ktor.client.engine.okhttp.*
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single<SqlDriver> {
        AndroidSqliteDriver(
            InstantMenuDB.Schema,
            get(),
            "InstantMenuDB"
        )
    }
}