package com.dev.freetoplay.data.remote.dto

import com.dev.freetoplay.domain.model.Screenshot

data class ScreenshotDto(
    val id: Int,
    val image: String
){
    fun toScreenshot(): Screenshot {
        return Screenshot(
            id,
            image
        )
    }
}