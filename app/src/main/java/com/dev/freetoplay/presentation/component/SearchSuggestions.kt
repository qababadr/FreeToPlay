package com.dev.freetoplay.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.freetoplay.R
import com.dev.freetoplay.domain.model.Game

@Composable
fun SearchSuggestions(
    query: String,
    searchResult: List<Game>,
    onClick: (Int) -> Unit
){
    if(searchResult.isEmpty()){
       if(query.isNotEmpty()){
           WarningMessage(
               textId = R.string.txt_empty_result,
               extraText = " $query"
           )
       }
    }
    else{
        LazyColumn(
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(space = 10.dp)
        ){
            items(items = searchResult){ game ->
                SearchSuggestionsItem(
                    gameTitle = game.title,
                    gameId = game.id,
                    onClick = { onClick(game.id) }
                )
            }

        }
    }

}