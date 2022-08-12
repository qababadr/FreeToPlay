package com.dev.freetoplay.domain.model

import com.dev.freetoplay.data.remote.dto.MinimumSystemRequirementsDto
import com.dev.freetoplay.data.remote.dto.ScreenshotDto

data class GameDetail(
    val description: String,
    val developer: String,
    val freeToGameProfileUrl: String,
    val gameUrl: String,
    val genre: String,
    val id: Int,
    val minimumSystemRequirements: MinimumSystemRequirementsDto?,
    val platform: String,
    val publisher: String,
    val releaseDate: String,
    val screenShots: List<ScreenshotDto>,
    val shortDescription: String,
    val status: String,
    val thumbnail: String,
    val title: String
)
