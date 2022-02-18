package com.devundefined.imdbtop250.domain

import com.devundefined.imdbtop250.networking.ApiClient

class Movie250TopRepositoryImpl(private val apiClient: ApiClient) : Movie250TopRepository {
    override suspend fun get250Top(): Collection<Movie> {
        return apiClient.getTop250().items
    }
}