package com.dev.freetoplay.domain.repository

import com.dev.freetoplay.domain.model.Game
import com.dev.freetoplay.domain.model.GameDetail
import com.dev.freetoplay.util.Resource

interface GameRepository {

    suspend fun getAllGames(): Resource<List<Game>>

    suspend fun getGame(id: Int): Resource<GameDetail?>

    suspend fun getGamesByPlatform(platform :String): Resource<List<Game>>

    suspend fun sortGames(criteria: String): Resource<List<Game>>
}