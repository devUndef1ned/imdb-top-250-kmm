package com.devundefined.imdbtop250.domain

import com.devundefined.imdbtop250.core.Error
import com.devundefined.imdbtop250.monad.Either

interface Movie250TopRepository {
    suspend fun get250Top(): Either<Error, List<Movie>>
}