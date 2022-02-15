package com.bobafett.instantmenu

import com.bobafett.instantmenu.core.menu.datasource.network.GitHubApiMock
import com.bobafett.instantmenu.core.menu.datasource.network.MenuItemsApi
import com.bobafett.instantmenu.core.menu.datasource.network.mockEngineModule
import kotlinx.coroutines.runBlocking
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.*


class GitHubApiExploratoryTest : KoinTest {

    private val menuItemsApi: MenuItemsApi by inject()
    private val gitHubApiMock: GitHubApiMock by inject()

    @BeforeTest
    fun setUp() {
        startKoin{
            modules(
                mockEngineModule,
                coreModule
            )
        }
    }

    @AfterTest
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun thisShit() = runBlocking {

        gitHubApiMock.givenSuccess()
        val results = menuItemsApi.fetchMenuItems(GitHubApiMock.SOCIALIST)

        assertEquals("react-tetris", results?.first()?.name)
    }

    @Test
    fun thisShitFailure() = runBlocking {

        gitHubApiMock.givenFailure()
        val results = menuItemsApi.fetchMenuItems(GitHubApiMock.SOCIALIST)
        assertNull(results)
    }
}