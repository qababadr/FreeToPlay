package com.dev.freetoplay.presentation.component

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dev.freetoplay.R

@Composable
fun NavBar(
    title: String,
    onBackPress: () -> Unit
){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onBackPress() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "",
                tint = MaterialTheme.colors.onBackground
            )
        }
        Text(text = title)
        Spacer(modifier = Modifier.requiredWidth(26.dp))
    }

}