package com.devundefined.imdbtop250.domain

import com.devundefined.imdbtop250.Error
import com.devundefined.imdbtop250.monad.Either

interface Movie250TopRepository {
    suspend fun get250Top(): Either<Error, Collection<Movie>>
}