package com.devundefined.imdbtop250.android.presentation

import com.devundefined.imdbtop250.domain.Movie
import com.devundefined.imdbtop250.core.Error as CoreError

sealed class State {
    object Initial : State()
    object Loading : State()
    data class Error(val error: CoreError) : State()
    data class Success(val data: List<Movie>) : State()
}
