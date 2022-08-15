package com.dev.freetoplay.presentation.activity

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.freetoplay.data.repository.GameRepositoryImpl
import com.dev.freetoplay.domain.model.Game
import com.dev.freetoplay.util.CURRENT_ROUTE_KEY
import com.dev.freetoplay.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: GameRepositoryImpl,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _splashScreenVisible = mutableStateOf(value = false)
    val splashScreenVisible: State<Boolean>
        get() = _splashScreenVisible

    private val _games: MutableStateFlow<Resource<List<Game>>> =
        MutableStateFlow(value = Resource.Loading())
    val games: StateFlow<Resource<List<Game>>>
        get() = _games


    private val _currentRoute: MutableStateFlow<String> =
        MutableStateFlow(value = savedStateHandle.get(key = CURRENT_ROUTE_KEY) ?: "")
    val currentRoute: StateFlow<String>
        get() = _currentRoute

    init {
        viewModelScope.launch {
            _splashScreenVisible.value = true
            _games.value = repository.getAllGames()
            _splashScreenVisible.value = false
        }
    }

    fun setRoute(route: String){
        _currentRoute.value = route
    }
}