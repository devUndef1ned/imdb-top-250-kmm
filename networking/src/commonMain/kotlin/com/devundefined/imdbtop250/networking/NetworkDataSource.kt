package com.devundefined.imdbtop250.networking

import com.devundefined.imdbtop250.core.Error
import com.devundefined.imdbtop250.domain.Movie
import com.devundefined.imdbtop250.monad.Either
import com.devundefined.imdbtop250.monad.map
import com.devundefined.imdbtop250.networking.dto.MovieDto

class NetworkDataSource(private val apiClient: ApiClient) {

    private suspend fun load(): Either<Error, List<MovieDto>> {
        return runCatching { apiClient.getTop250() }.map { response ->
            if (response.errorMessage.isEmpty()) {
                Either.right<Error, List<MovieDto>>(response.items)
            } else {
                Either.left(Error(response.errorMessage))
            }
        }.getOrElse { Either.left(Error(it.message.orEmpty())) }

    }

    suspend fun getTop250(): Either<Error, List<Movie>> {
        return load().map { list -> list.map(Mapper::invoke) }
    }
}
