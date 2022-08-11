package com.dev.freetoplay.presentation.screen.base

sealed class Screen(
    val route: String
){
    object HomeScreen: Screen(route = "home")
    object GameDetailScreen: Screen(route = "gameDetail/{id}")
}
