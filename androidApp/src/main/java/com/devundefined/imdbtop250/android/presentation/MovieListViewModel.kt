package com.devundefined.imdbtop250.android.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devundefined.imdbtop250.domain.Movie250TopRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(private val repository: Movie250TopRepository) :
    ViewModel() {

    private val _state: MutableStateFlow<State> = MutableStateFlow(State.Initial)

    val state: StateFlow<State> = _state

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.get250Top()
                    .onLeft { left -> _state.value = State.Error(left) }
                    .onRight { right -> _state.value = State.Success(right) }
            }
        }
    }
}
