package com.dev.freetoplay.presentation.screen.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.NavHostController
import com.dev.freetoplay.domain.model.Game
import com.dev.freetoplay.util.ALL_GAMES_KEY
import com.dev.freetoplay.util.SEARCH_MODE_KEY
import kotlinx.coroutines.launch

@Composable
fun SearchScreen(
    viewModel: SearchViewModel,
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    games: List<Game>
) {

    val screenMode by viewModel.screenMode
        .collectAsState()

    val isLoading by viewModel.isLoading
        .collectAsState(initial = false)

    val searchDetailVisible by viewModel.searchDetailVisible
        .collectAsState()

    val availableGames by viewModel.games
        .collectAsState()

    val searchQuery by viewModel.query
        .collectAsState()

    val scope = rememberCoroutineScope()

    val focusManager = LocalFocusManager.current

    Column(modifier = Modifier.fillMaxSize()) {
        if(screenMode == SEARCH_MODE_KEY){
            SearchMode(
                isLoading = isLoading,
                focusManager = focusManager,
                searchDetailVisible = searchDetailVisible,
                searchSuggestions = availableGames,
                navController = navController,
                query = searchQuery,
                onClearQuery = {
                    viewModel.clearSearchQuery()
                    navController.popBackStack()
                },
                onSearch = { query ->
                    viewModel.onQuery(query = query)
                    if(query.isNotEmpty()){
                        viewModel.onSearch(games = games)
                    }
                },
                search = {
                    if(searchQuery.isNotEmpty()){
                        viewModel.showSearchDetail()
                    }
                }
            )
        } else{
            FilterMode(
                isLoading = isLoading,
                games = availableGames,
                onGameClick = { id ->
                    navController.navigate(route = "gameDetail/$id")
                },
                onOpenDrawer = {
                     scope.launch {
                         scaffoldState.drawerState.open()
                     }
                },
                onSearchClick = {
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        key = ALL_GAMES_KEY,
                        value = availableGames
                    )
                    navController.navigate(route = "search?mode=$SEARCH_MODE_KEY")
                }
            )
        }
    }
}