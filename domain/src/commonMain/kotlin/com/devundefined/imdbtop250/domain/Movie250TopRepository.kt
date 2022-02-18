package com.devundefined.imdbtop250.domain

interface Movie250TopRepository {
    suspend fun get250Top(): Collection<Movie>
}