package com.dev.freetoplay.data.repository

import com.dev.freetoplay.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseRepository {
    suspend fun <T> invokeApi(
        apiCall: suspend () -> T
    ): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                Resource.Error(error = throwable)
            }
        }
    }

}