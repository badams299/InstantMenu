package com.bobafett.instantmenu.android

import android.app.Application
import android.content.Context
import com.bobafett.instantmenu.initKoin
import io.reactivex.schedulers.Schedulers.single
import org.koin.dsl.module

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(
            module {
                single<Context> { this@MainApp }
            }
        )
    }
}