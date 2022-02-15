package com.bobafett.instantmenu

import com.bobafett.instantmenu.core.menu.datasource.network.MenuItemsApi
import com.bobafett.instantmenu.core.menu.datasource.storage.DatabaseHelper
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import kotlinx.coroutines.Dispatchers
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

fun initKoin(appModule: Module): KoinApplication {
    val koinApplication = startKoin {
        modules(
            appModule,
            platformModule,
            coreModule
        )
    }

    // Dummy initialization logic, making use of appModule declarations for demonstration purposes.
    val koin = koinApplication.koin
    // doOnStartup is a lambda which is implemented in Swift on iOS side
    val doOnStartup = koin.get<() -> Unit>()
    doOnStartup.invoke()

//    val kermit = koin.get<Logger> { parametersOf(null) }
    // AppInfo is a Kotlin interface with separate Android and iOS implementations
//    val appInfo = koin.get<AppInfo>()
//    kermit.v { "App Id ${appInfo.appId}" }

    return koinApplication
}

val coreModule = module {
    single {
        DatabaseHelper(
            get(),
            Dispatchers.Default
        )

    }
    single {
        HttpClient(get()) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(
                    kotlinx.serialization.json.Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
    }
    factory { MenuItemsApi(get()) }


    // platformLogWriter() is a relatively simple config option, useful for local debugging. For production
    // uses you *may* want to have a more robust configuration from the native platform. In KaMP Kit,
    // that would likely go into platformModule expect/actual.
    // See https://github.com/touchlab/Kermit
    //val baseLogger = Logger(config = StaticConfig(logWriterList = listOf(platformLogWriter())), "KampKit")
    //factory { (tag: String?) -> if (tag != null) baseLogger.withTag(tag) else baseLogger }
}

expect val platformModule: Module
