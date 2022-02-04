package com.devundefined.imdbtop250.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class MovieDto(
    val id: String,
    val rank: String,
    val title: String,
    val fullTitle: String,
    val year: String,
    val image: String,
    val crew: String,
    val imDbRating: String,
    val imDbRatingCount: Long,
)
