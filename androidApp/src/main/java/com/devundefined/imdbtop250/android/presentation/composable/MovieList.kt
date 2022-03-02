package com.devundefined.imdbtop250.android.presentation.composable

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.devundefined.imdbtop250.domain.Movie

@Composable
fun MovieList(list: List<Movie>) {
    LazyColumn {
            items(list) { movie ->
                MovieRow(movie)
            }
    }
}