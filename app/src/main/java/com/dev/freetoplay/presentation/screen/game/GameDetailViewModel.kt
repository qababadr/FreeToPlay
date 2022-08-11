package com.dev.freetoplay.presentation.screen.game

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.dev.freetoplay.data.repository.GameRepositoryImpl
import com.dev.freetoplay.util.GAME_ID_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameDetailViewModel @Inject constructor(
    private val repository: GameRepositoryImpl,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {


    lateinit var gameID: String

    init {
        savedStateHandle.get<String>(key = GAME_ID_KEY)?.let{ id ->
            gameID = id
        }
    }

}