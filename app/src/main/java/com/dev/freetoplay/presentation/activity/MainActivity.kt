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
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.dev.freetoplay.presentation.screen.base.Index
import com.dev.freetoplay.presentation.theme.FreeToPlayTheme
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

                    },
                    onGameClick = { gameId ->
                        navController.navigate(route = "gameDetail/$gameId")
                    }
                )
            }
        }
    }
}


