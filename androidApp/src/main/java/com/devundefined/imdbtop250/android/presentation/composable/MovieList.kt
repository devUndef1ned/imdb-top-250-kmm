package com.devundefined.imdbtop250.android.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.devundefined.imdbtop250.android.presentation.MovieListViewModel
import com.devundefined.imdbtop250.android.presentation.State

@Composable
fun MovieList(viewModel: MovieListViewModel) {
    val state by viewModel.state.collectAsState()

    Box(
        modifier = Modifier.background(color = MaterialTheme.colors.surface).fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val currentState = state
        when (currentState) {
            is State.Error -> Text(text = "Error occurred!\n${currentState.error.message}")
            State.Initial -> Text("We are going to load data")
            State.Loading -> CircularProgressIndicator()
            is State.Success -> Text(text = "Received data with count ${currentState.data.size}")
        }
    }
}