package com.dev.freetoplay.presentation.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LeadingIconButton(
    textButton: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconSize: Dp = 24.dp,
    enabled: Boolean = true,
    @DrawableRes iconResId: Int,
    border: BorderStroke? = null,
    contentDescription: String = "",
    buttonColors : ButtonColors = ButtonDefaults.textButtonColors(
        contentColor = MaterialTheme.colors.onPrimary,
        backgroundColor = MaterialTheme.colors.primary
    )
){
    Button(
        modifier = modifier,
        enabled = enabled,
        border = border,
        colors = buttonColors,
        onClick = onClick
    ){
        Row(verticalAlignment = Alignment.CenterVertically){
            Icon(
                modifier = Modifier
                    .padding(end = 5.dp)
                    .requiredSize(iconSize),
                painter = painterResource(id = iconResId),
                contentDescription = contentDescription
            )
            Text(
                text = textButton,
                color = buttonColors.contentColor(enabled = enabled).value,
                modifier = Modifier.wrapContentHeight(align = Alignment.CenterVertically)
            )

        }
    }

}