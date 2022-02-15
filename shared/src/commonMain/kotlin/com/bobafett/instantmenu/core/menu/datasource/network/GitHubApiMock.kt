package com.bobafett.instantmenu.core.menu.datasource.network

import io.ktor.client.engine.*
import io.ktor.client.engine.mock.*
import io.ktor.client.request.*
import io.ktor.http.*
import org.koin.dsl.module

val mockEngineModule = module {
    single { GitHubApiMock() }
    single<HttpClientEngine> {
        val gitHubApiMock: GitHubApiMock = get()
        gitHubApiMock.engine
    }
}


class GitHubApiMock {

    companion object {
        const val SOCIALIST = "tetris"
        const val TET_KEYWORD = "tet"
    }

    private var isSuccess: Boolean? = null
        get() = field ?: throw IllegalStateException("Mock has not beet initialized")

    fun givenSuccess() {
        isSuccess = true
    }

    fun givenFailure() {
        isSuccess = false
    }

    val engine = MockEngine { request ->
        handleSearchRequest(request) ?: errorResponse()
    }

    private fun MockRequestHandleScope.handleSearchRequest(
        request: HttpRequestData
    ): HttpResponseData? {
        // 1
        if (request.url.encodedPath.contains("menus").not()) {
            return null
        }

        // 2
        val searchKeyword = request.url.parameters["q"] ?: ""
        val responseContent = when (searchKeyword.lowercase()) {
            SOCIALIST -> MockedApiResponse.FOR_TETRIS
            "tet" -> MockedApiResponse.FOR_TET
            else -> MockedApiResponse.FOR_INVALID
        }

        val statusCode = if (isSuccess == true) {
            HttpStatusCode.OK
        } else {
            HttpStatusCode.InternalServerError
        }

        return respond(
            content = responseContent,
            status = statusCode,
            headers = headersOf(HttpHeaders.ContentType, "application/json")
        )
    }

    private fun MockRequestHandleScope.errorResponse(): HttpResponseData {
        return respond(
            content = "",
            status = HttpStatusCode.BadRequest,
            headers = headersOf(HttpHeaders.ContentType, "application/json")
        )
    }
}