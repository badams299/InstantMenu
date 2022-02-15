package com.bobafett.instantmenu

import kotlinx.coroutines.CoroutineScope

interface BaseTest {
    fun <T> runTest(block: suspend CoroutineScope.() -> T)
}