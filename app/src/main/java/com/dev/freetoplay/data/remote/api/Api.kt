package com.dev.freetoplay.data.remote.api

import com.dev.freetoplay.data.remote.dto.GameDto
import retrofit2.http.GET

interface Api {

    @GET("games")
    suspend fun getAllGames(): List<GameDto>
}