package com.dev.freetoplay.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.dev.freetoplay.R

@Composable
fun SearchBar(
    query: String,
    focusManager: FocusManager,
    onSearch: (String) -> Unit,
    search: () -> Unit,
    onClearQuery: () -> Unit
){
    Surface(
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .requiredHeight(75.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .padding(top = 3.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
             TextField(
                 label = {
                     Text(
                         text = stringResource(id = R.string.lbl_search),
                         color = MaterialTheme.colors.onBackground
                     )
                 },
                 modifier = Modifier.fillMaxWidth(fraction = 0.89f),
                 value = query,
                 textStyle = MaterialTheme.typography.subtitle2,
                 onValueChange = onSearch,
                 keyboardOptions = KeyboardOptions(
                     keyboardType = KeyboardType.Text,
                     imeAction = ImeAction.Search
                 ),
                 keyboardActions = KeyboardActions(onSearch = {
                       focusManager.clearFocus()
                       search()
                 }),
                 shape = MaterialTheme.shapes.small
             )
            IconButton(onClick = onClearQuery) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_xmark_solid),
                    contentDescription = "",
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier.requiredSize(size = dimensionResource(id = com.intuit.sdp.R.dimen._24sdp))
                )
            }
        }

    }

}