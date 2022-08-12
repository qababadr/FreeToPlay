package com.dev.freetoplay.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ExtraInformationRow(
    firstTitle: String,
    secondTitle: String,
    textColor: Color,
    icon: @Composable (() -> Unit)? = null
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){

        Text(
            text = firstTitle,
            style = MaterialTheme.typography.caption,
            color = textColor
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            icon?.invoke()
            Text(
                text = secondTitle,
                style = MaterialTheme.typography.caption,
                color = textColor
            )
        }

    }

}