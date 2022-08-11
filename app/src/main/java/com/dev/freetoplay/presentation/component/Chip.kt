package com.dev.freetoplay.presentation.component

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun Chip(
    modifier: Modifier = Modifier,
    borderWidth: Dp = 3.dp,
    borderColor: Color = MaterialTheme.colors.primary,
    shape: Shape = RoundedCornerShape(25.dp),
    elevation: Dp = 8.dp,
    backgroundColor: Color = MaterialTheme.colors.primary,
    content: @Composable () -> Unit
){
    Surface(
        modifier = modifier.border(
            width = borderWidth,
            color = borderColor,
            shape = shape
        ),
        elevation = elevation,
        shape = shape,
        color = backgroundColor
    ) {
        content()
    }
    
}