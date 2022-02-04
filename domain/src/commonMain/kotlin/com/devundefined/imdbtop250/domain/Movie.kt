package com.devundefined.imdbtop250.domain

data class Movie(
    val id: String,
    val rank: Int,
    val title: String,
    val fullTitle: String,
    val year: String,
    val image: String,
    val crew: String,
    val imDbRating: Float,
    val imDbRatingCount: Long,
)
