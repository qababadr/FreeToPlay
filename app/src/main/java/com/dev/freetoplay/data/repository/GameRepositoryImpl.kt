package com.dev.freetoplay.data.repository

import com.dev.freetoplay.data.remote.api.Api
import com.dev.freetoplay.domain.model.Game
import com.dev.freetoplay.domain.repository.GameRepository
import com.dev.freetoplay.util.Resource
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    val api: Api
): BaseRepository(), GameRepository {


    override suspend fun getAllGames(): Resource<List<Game>> {
        val response = invokeApi {
            api.getAllGames()
        }
        return when(response){
            is Resource.Error -> Resource.Error(error = response.error)
            is Resource.Loading -> Resource.Loading()
            is Resource.Success -> Resource.Success(
                data = response.data?.map { it.toGame() }?: emptyList()
            )
        }
    }

}