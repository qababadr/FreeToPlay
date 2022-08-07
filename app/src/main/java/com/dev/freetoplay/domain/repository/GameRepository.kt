package com.dev.freetoplay.domain.repository

import com.dev.freetoplay.domain.model.Game
import com.dev.freetoplay.util.Resource

interface GameRepository {

    suspend fun getAllGames(): Resource<List<Game>>

}