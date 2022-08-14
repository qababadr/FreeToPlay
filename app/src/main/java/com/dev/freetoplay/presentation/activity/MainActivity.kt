package com.dev.freetoplay.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalUriHandler
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.dev.freetoplay.presentation.screen.base.Index
import com.dev.freetoplay.presentation.screen.base.Screen
import com.dev.freetoplay.presentation.theme.FreeToPlayTheme
import com.dev.freetoplay.util.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                mainViewModel.splashScreenVisible.value
            }
        }
        setContent {
            val scaffoldState = rememberScaffoldState()
            val navController = rememberNavController()
            val availableGames by mainViewModel.games.collectAsState()
            val scope = rememberCoroutineScope()
            val uriHandler = LocalUriHandler.current

            FreeToPlayTheme(
                darkTheme = isSystemInDarkTheme()
            ) {
                Index(
                    scaffoldState = scaffoldState,
                    navController = navController,
                    availableGames = availableGames,
                    onOpenDrawer = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    },
                    onSearchButtonClick = {
                        scope.launch {
                            val path = "search?mode=$SEARCH_MODE_KEY"
                            navController.currentBackStackEntry?.savedStateHandle?.set(
                                key = ALL_GAMES_KEY,
                                value = availableGames.data?: emptyList()
                            )
                            navController.navigate(route = path)
                        }
                    },
                    onGameClick = { gameId ->
                        navController.navigate(route = "gameDetail/$gameId")
                    },
                    onPlayTheGameClicked = { gameUrl ->
                        uriHandler.openUri(uri = gameUrl)
                    },
                    onHomeMenuClick = {
                        scope.launch {
                            scaffoldState.drawerState.close()
                            navController.navigate(route = Screen.HomeScreen.route)
                        }
                    },
                    onPCGamesClick = {
                        scope.launch {
                            val path = "search?mode=$FILTER_MODE_KEY&filter=$PC_GAMES"
                            scaffoldState.drawerState.close()
                            navController.navigate(route = path)
                        }
                    },
                    onWebGamesClick = {
                        scope.launch {
                            val path = "search?mode=$FILTER_MODE_KEY&filter=$BROWSER_GAMES"
                            scaffoldState.drawerState.close()
                            navController.navigate(route = path)
                        }
                    },
                    onLatestGamesClick = {
                        scope.launch {
                            val path = "search?mode=$FILTER_MODE_KEY&filter=$LATEST_GAMES"
                            scaffoldState.drawerState.close()
                            navController.navigate(route = path)
                        }
                    }
                )
            }
        }
    }
}


