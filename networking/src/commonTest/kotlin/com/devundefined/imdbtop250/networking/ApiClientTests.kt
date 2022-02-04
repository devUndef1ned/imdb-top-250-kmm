package com.devundefined.imdbtop250.networking

import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlin.test.Test
import kotlin.test.asserter


class ApiClientTests {

    @Test
    fun shouldReturnMovieCollection() = runTest {
        val apiClient = getMockClient()

        val response = apiClient.getTop250()

        asserter.assertTrue("Content was empty!", response.items.isNotEmpty())
    }

    private fun getMockClient(): ApiClient {
        val engine = MockEngine { request ->
            respond(
                content = mockedResponse,
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        return ApiClient(engine)
    }


    private val mockedResponse =
        "{\"items\":[{\"id\":\"tt0111161\",\"rank\":\"1\",\"title\":\"The Shawshank Redemption\",\"fullTitle\":\"The Shawshank Redemption (1994)\",\"year\":\"1994\",\"image\":\"https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX128_CR0,3,128,176_AL_.jpg\",\"crew\":\"Frank Darabont (dir.), Tim Robbins, Morgan Freeman\",\"imDbRating\":\"9.2\",\"imDbRatingCount\":\"2538931\"},{\"id\":\"tt0068646\",\"rank\":\"2\",\"title\":\"The Godfather\",\"fullTitle\":\"The Godfather (1972)\",\"year\":\"1972\",\"image\":\"https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UX128_CR0,1,128,176_AL_.jpg\",\"crew\":\"Francis Ford Coppola (dir.), Marlon Brando, Al Pacino\",\"imDbRating\":\"9.1\",\"imDbRatingCount\":\"1747116\"}],\"errorMessage\":\"\"}"
}