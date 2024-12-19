package com.example.base.ktorclient

import com.example.base.utils.BaseUrl
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import com.example.data.localStorage.LocalStorage

private const val Header = "Authorization"
private const val Bearer = "Bearer"

internal fun createHttpClient(json: Json, localStorage: LocalStorage) = HttpClient(CIO) {
    expectSuccess = true
    install(ContentNegotiation) {
        json(json)
    }
    install(DefaultRequest) {
        header(Header, "$Bearer ${localStorage.accessToken}")
        url(BaseUrl)
        contentType(ContentType.Application.Json)
    }
    logging()
}

internal fun HttpClientConfig<*>.logging() = install(Logging) {
    level = LogLevel.ALL
    logger = object : Logger {
        override fun log(message: String) {
            println("HTTP Client message: $message)")
        }
    }
}