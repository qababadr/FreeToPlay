package com.dev.freetoplay.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dev.freetoplay.R

@Composable
fun TopBar(
    onOpenDrawer: () -> Unit,
    onSearchButtonClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = onOpenDrawer) {
            Icon(
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = "",
                tint = MaterialTheme.colors.onBackground
            )
        }
        IconButton(onClick = onSearchButtonClick) {
            Icon(
                painter = painterResource(id = R.drawable.ic_magnifying_glass_solid),
                contentDescription = "",
                tint = MaterialTheme.colors.onBackground
            )
        }
    }
}