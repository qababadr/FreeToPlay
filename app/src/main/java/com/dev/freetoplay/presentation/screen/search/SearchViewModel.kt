package com.dev.freetoplay.presentation.screen.search

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.freetoplay.data.repository.GameRepositoryImpl
import com.dev.freetoplay.domain.model.Game
import com.dev.freetoplay.util.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: GameRepositoryImpl,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {


    private val _isLoading = Channel<Boolean>()
    val isLoading: Flow<Boolean>
        get() = _isLoading.receiveAsFlow()

    private val _games: MutableStateFlow<List<Game>> = MutableStateFlow(value = emptyList())
    val games: StateFlow<List<Game>>
        get() = _games

    private val _query: MutableStateFlow<String> = MutableStateFlow(value = "")
    val query: StateFlow<String>
        get() = _query

    private val _screenMode: MutableStateFlow<String> = MutableStateFlow(value = "")
    val screenMode: StateFlow<String>
        get() = _screenMode

    private val _searchDetailVisible: MutableStateFlow<Boolean> = MutableStateFlow(value = false)
    val searchDetailVisible: StateFlow<Boolean>
        get() = _searchDetailVisible


    init {

        savedStateHandle.get<String>(key = SEARCH_SCREEN_MODE_KEY)?.let { mode ->
            _screenMode.value = mode
        }

        savedStateHandle.get<String>(key = SEARCH_SCREEN_FILTER_KEY)?.let { filter ->
            when(filter){
                PC_GAMES -> getGamesByPlatform(filter = PC_GAMES)
                BROWSER_GAMES -> getGamesByPlatform(filter = BROWSER_GAMES)
                LATEST_GAMES -> getLatestGames()
            }
        }
    }

    fun onSearch(games: List<Game>) {
        viewModelScope.launch {
            _isLoading.send(true)
            delay(500)
            _games.value =
                games.filter { game -> game.title.contains(_query.value, ignoreCase = true) }
            _isLoading.send(false)
        }
    }

    fun clearSearchQuery(){
        _query.value = ""
    }

    fun onQuery(query: String){
        _query.value = query
    }

    fun showSearchDetail(){
        _searchDetailVisible.value = true
    }

    fun setRoute(route: String){
        savedStateHandle.set(
            key = CURRENT_ROUTE_KEY,
            value = route
        )
    }

    private fun getGamesByPlatform(filter: String) {
        viewModelScope.launch {
            _isLoading.send(true)
            _games.value = when (val response = repository.getGamesByPlatform(platform = filter)) {
                is Resource.Success -> {
                    response.data ?: emptyList()
                }
                else -> emptyList()
            }
            _isLoading.send(false)
        }
    }

    private fun getLatestGames() {
        viewModelScope.launch {
            _isLoading.send(true)
            _games.value = when (val response = repository.sortGames(criteria = LATEST_GAMES)) {
                is Resource.Success -> response.data ?: emptyList()
                else -> emptyList()
            }
            _isLoading.send(false)
        }
    }
}