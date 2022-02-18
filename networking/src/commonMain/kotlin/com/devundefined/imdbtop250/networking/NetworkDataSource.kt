package com.devundefined.imdbtop250.networking

import com.devundefined.imdbtop250.Error
import com.devundefined.imdbtop250.domain.Movie
import com.devundefined.imdbtop250.monad.Either
import com.devundefined.imdbtop250.monad.map
import com.devundefined.imdbtop250.networking.dto.MovieDto

class NetworkDataSource(private val apiClient: ApiClient) {

    private suspend fun load(): Either<Error, List<MovieDto>> {
        val response = apiClient.getTop250()
        return if (response.errorMessage.isEmpty()) {
            Either.right(response.items)
        } else  {
            Either.left(Error(response.errorMessage))
        }
    }
    suspend fun getTop250(): Either<Error, Collection<Movie>> {
        return load().map { list -> list.map(Mapper::invoke) }
    }
}