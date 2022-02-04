package com.devundefined.imdbtop250.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class MovieCollectionDto(val items: List<MovieDto>, val errorMessage: String)
