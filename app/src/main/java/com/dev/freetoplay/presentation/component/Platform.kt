package com.dev.freetoplay.presentation.component

import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.dev.freetoplay.R

@Composable
fun Platform(text: String) {

    val resource = if (text.contains("windows", ignoreCase = true)) {
        R.drawable.ic_windows_brands
    } else {
        R.drawable.ic_window_maximize_solid
    }

    Icon(
        painter = painterResource(id = resource),
        contentDescription = "",
        tint = MaterialTheme.colors.primaryVariant
    )
}