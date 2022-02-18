package com.devundefined.imdbtop250.domain

import com.devundefined.imdbtop250.Error
import com.devundefined.imdbtop250.monad.Either
import com.devundefined.imdbtop250.networking.ApiClient
import com.devundefined.imdbtop250.networking.NetworkDataSource

class Movie250TopRepositoryImpl(private val networkDataSource: NetworkDataSource) : Movie250TopRepository {
    override suspend fun get250Top(): Either<Error, Collection<Movie>> {
        return networkDataSource.getTop250()
    }
}