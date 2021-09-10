package com.minuk.lolapp.ui.champion

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.minuk.lolapp.network.model.Champion
import com.minuk.lolapp.ui.text.OutLinedText
import com.minuk.lolapp.ui.theme.LoLAppTheme

@Composable
fun ChampionList(
    modifier: Modifier,
    champions: List<Champion>
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        val chunkedItems = champions.chunked(2)

        items(items = chunkedItems) { rowItem ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                for (champion in rowItem) {
                    ChampionItem(champion)
                }
            }
        }
    }
}

@Composable
fun ChampionItem(championModel: Champion) {
    Card {
        ConstraintLayout(
            modifier = Modifier
                .width(150.dp)
                .aspectRatio(1.0f)
                .background(
                    shape = RoundedCornerShape(18.dp),
                    color = Color.White
                )
        ) {
            val (image, text) = createRefs()

            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    },
                painter = rememberImagePainter(
                    data = championModel.summaryIconUrl,
                    builder = {
                        scale(Scale.FILL)
                        crossfade(true)
                    }
                ),
                contentScale = ContentScale.Crop,
                contentDescription = null,
            )

            OutLinedText(
                modifier = Modifier.constrainAs(text) {
                    bottom.linkTo(parent.bottom, 8.dp)
                    start.linkTo(parent.start)
                    end.linkTo(image.end)
                },
                text = championModel.name,
                textSize = 14.sp
            )

        }
    }
}

@Preview
@Composable
fun ChampionPreview() {
    ChampionItem(championModel = Champion(
        version = "",
        id = "Ari",
        name = "아리",
        blurb = "아리 설명",
    ).apply {
        summaryIconUrl = "http://ddragon.leagueoflegends.com/cdn/11.17.1/img/champion/Aatrox.png"
    }
    )
}

@Preview
@Composable
fun ChampionListPreview() {
    LoLAppTheme {
        ChampionList(
            modifier = Modifier.fillMaxSize(),
            champions = listOf(
                Champion(
                    version = "",
                    id = "Ari",
                    name = "아리",
                    blurb = "아리 설명",
                ).apply {
                    summaryIconUrl = "http://ddragon.leagueoflegends.com/cdn/11.17.1/img/champion/Aatrox.png"
                },
                Champion(
                    version = "",
                    id = "Ari",
                    name = "아리",
                    blurb = "아리 설명",
                ).apply {
                    summaryIconUrl = "http://ddragon.leagueoflegends.com/cdn/11.17.1/img/champion/Aatrox.png"
                },
                Champion(
                    version = "",
                    id = "Ari",
                    name = "아리",
                    blurb = "아리 설명",
                ).apply {
                    summaryIconUrl = "http://ddragon.leagueoflegends.com/cdn/11.17.1/img/champion/Aatrox.png"
                }
            )
        )
    }
}