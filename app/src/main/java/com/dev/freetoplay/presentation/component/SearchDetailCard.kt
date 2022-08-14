package com.dev.freetoplay.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.dev.freetoplay.R
import com.dev.freetoplay.domain.model.Game
import com.dev.freetoplay.presentation.theme.RedErrorLight

@Composable
fun SearchDetailCard(
    game: Game,
    onClick: (Int) -> Unit
) {

    Card(
        backgroundColor = MaterialTheme.colors.surface,
        shape = MaterialTheme.shapes.medium,
        elevation = 8.dp,
        modifier = Modifier
            .requiredHeight(height = 150.dp)
            .fillMaxWidth()
            .clickable { onClick(game.id) }
    ){
        Row(modifier = Modifier.fillMaxSize()){
            NetworkImage(
                url = game.thumbnail,
                contentScale = ContentScale.Crop,
                crossFade = 1000,
                modifier = Modifier.fillMaxWidth(fraction = 0.3f),
                onLoading = {
                    ConstraintLayout(modifier = Modifier.fillMaxSize(fraction = 0.5f)) {
                        val indicatorRef = createRef()
                        CircularProgressIndicator(
                            modifier = Modifier.constrainAs(indicatorRef) {
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                        )
                    }
                },
                onError = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_warning),
                        contentDescription = "",
                        tint = RedErrorLight
                    )
                }
            )
            Column {
                Text(
                    text = game.title,
                    modifier = Modifier
                        .padding(5.dp)
                        .align(alignment = Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.body1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colors.onPrimary
                )
                Spacer(modifier = Modifier.padding(3.dp))
                Text(
                    text = game.shortDescription,
                    modifier = Modifier.padding(all = 5.dp)
                        .fillMaxWidth(fraction = 0.85f),
                    style = MaterialTheme.typography.caption,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colors.onSurface,
                    maxLines = 2
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Row(
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 5.dp)
                ){
                    Chip(
                        backgroundColor = MaterialTheme.colors.primaryVariant,
                        borderWidth = 1.dp,
                    ) {
                        Text(
                            modifier = Modifier.padding(all = 5.dp),
                            text = game.genre,
                            style = MaterialTheme.typography.caption,
                            color = Color.Black
                        )
                    }
                    Spacer(modifier = Modifier.padding(end = 3.dp))
                    Platform(text = game.platform)
                }
            }
        }
    }

}