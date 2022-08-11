package com.dev.freetoplay.presentation.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.dev.freetoplay.R

@Composable
fun EmptyResult(
    @StringRes textId: Int,
    extraText: String = ""
){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_circle_info_solid),
            tint = MaterialTheme.colors.onSurface,
            contentDescription = ""
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        Text(
           text = buildAnnotatedString {
               append(text = stringResource(id = textId))
               withStyle(
                   SpanStyle(fontWeight = FontWeight.Bold)
               ){
                   append(extraText)
               }
           },
           color = MaterialTheme.colors.onSurface,
           style = MaterialTheme.typography.subtitle2
        )
    }

}