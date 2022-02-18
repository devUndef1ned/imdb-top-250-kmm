package com.devundefined.imdbtop250.networking

import com.devundefined.imdbtop250.domain.Movie
import com.devundefined.imdbtop250.networking.dto.MovieDto

internal object Mapper {
    operator fun invoke(dto: MovieDto): Movie = with(dto) {
        Movie(
            id = id,
            rank = rank.toInt(),
            title = title,
            fullTitle = fullTitle,
            year = year,
            image = image,
            crew = crew,
            imDbRating = imDbRating.toFloat(),
            imDbRatingCount = imDbRatingCount,
        )
    }
}