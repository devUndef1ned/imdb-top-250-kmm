package com.devundefined.networking.imdbtop250

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.serialization.kotlinx.json.*

class ApiClient {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }

    private companion object {
        private const val BASE_URL = "https://imdb-api.com/"
    }
}