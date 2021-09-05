package com.minuk.lolapp.ui.champion

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberImagePainter
import com.minuk.lolapp.ui.text.OutLinedText

@Composable
fun ChampionList(champions: List<ChampionModel>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        val chunkedItems = champions.chunked(2)

        items(items = chunkedItems) { rowItem ->
            Row(
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
fun ChampionItem(championModel: ChampionModel) {
    ConstraintLayout(
        modifier = Modifier
            .height(56.dp)
            .background(
                shape = RoundedCornerShape(18.dp),
                color = Color.White
            )
    ) {
        val (image, text) = createRefs()

        Image(
            modifier = Modifier.constrainAs(image) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            },
            painter = rememberImagePainter(
                data = championModel.summaryImage,
                builder = {
                    crossfade(true)
                }
            ),
            contentDescription = null,
        )

        OutLinedText(
            modifier = Modifier.constrainAs(text) {
                bottom.linkTo(parent.bottom, 8.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            text = championModel.name,
            textSize = 14.sp
        )

    }
}

@Preview
@Composable
fun ChampionPreview() {
    ChampionItem(championModel = ChampionModel(
        version = "",
        id = "Ari",
        name = "아리",
        title = "아리 타이틀",
        blurb = "아리 설명",
        summaryImage = "http://ddragon.leagueoflegends.com/cdn/11.17.1/img/champion/Aatrox.png",
        loadingImage = "http://ddragon.leagueoflegends.com/cdn/img/champion/loading/Aatrox_0.jpg"
    ))
}