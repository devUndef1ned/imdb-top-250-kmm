package com.devundefined.imdbtop250.networking

import com.devundefined.imdbtop250.networking.dto.MovieCollectionDto
import com.devundefined.imdbtop250.networking.dto.MovieDto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*

class ApiClient(engine: HttpClientEngine) {
    private val client = HttpClient(engine) {
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun getTop250(): MovieCollectionDto {
        return client.get(makeUrl("Top250Movies")).body()
    }

    private fun makeUrl(path: String): String = "$BASE_URL$path/$API_KEY"

    private companion object {
        private const val BASE_URL = "https://imdb-api.com/en/API/"
        private const val API_KEY = "k_mi1mapn7"
    }
}