package com.dev.freetoplay.di

import android.content.Context
import com.dev.freetoplay.application.FreeToPlayApplication
import com.dev.freetoplay.data.remote.api.Api
import com.dev.freetoplay.data.remote.api.ApiBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesFreeToPlayApplication(
        @ApplicationContext app: Context
    ): FreeToPlayApplication{
           return app as FreeToPlayApplication
    }


    @Singleton
    @Provides
    fun providesApi(apiBuilder: ApiBuilder): Api {
        return apiBuilder.builder(Api::class.java)
    }

}