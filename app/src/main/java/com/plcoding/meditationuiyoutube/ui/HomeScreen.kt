package com.plcoding.meditationuiyoutube

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.meditationuiyoutube.ui.theme.*

@Composable
fun HomeScreen(){
    Box (modifier = Modifier
        .fillMaxSize()
        .background(DeepBlue)
    ){
        Column {
            GreetingSection()
            ChipSection(listOf("Sweet Sleep", "Insomnia", "Depression"))
            CurrentMeditation()
            FeaturedSection(
                features = listOf(
                    Feature(
                        title = "Sleep Meditation",
                        R.drawable.ic_headphone,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Night Island",
                        R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Calming Sounds",
                        R.drawable.ic_headphone,
                        Beige1,
                        Beige2,
                        Beige3
                    )
                )
            )

        }
    }

}

@Composable
fun GreetingSection(
    name:String = "John"
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ){
        Column(
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Good Morning $name",
                style = MaterialTheme.typography.h2
            )

            Text(
                text = "We wish you have a good day.",
                style = MaterialTheme.typography.body1
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }

}

@Composable
fun ChipSection(
    chips: List<String>
){
    var selectedChipIndex by remember{
        mutableStateOf(0)
    }
    LazyRow {
        items(chips.size){
            Box(
                modifier = Modifier
                    .padding(start = 15.dp , top = 15.dp, bottom = 15.dp)
                    .clickable {
                    selectedChipIndex = it
                }
                    .clip(RoundedCornerShape(1.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
            ){
                Text(
                    text = chips[it],
                    color = TextWhite,
                    fontSize = 15.sp,
                )
            }
        }
    }
}

@Composable
fun CurrentMeditation(
    colors: Color = LightRed
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(colors)
            .padding(horizontal = 15.dp, vertical = 20.dp)
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(end = 120.dp)
        ){
        Text(
            text = "Daily Thought",
            style = MaterialTheme.typography.h2
        )
        Text(
            text = "Meditation = 3-10 min",
            style = MaterialTheme.typography.body1,
            color = TextWhite
        )}
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp)
        ){
            Icon(
                painter = painterResource(R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeaturedSection(
    features: List<Feature>
){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Featured",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(15.dp)
        )

        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ){
            items(features.size){
                FeatureItem(feature = features[it])
            }
        }
    }
}

@Composable
fun FeatureItem(
    feature: Feature
){
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        //Medium Colored Path
        val mediumColoredPoint1 = Offset(0f,height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f,height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f,height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f,height * 0.7f)
        val mediumColoredPoint5 = Offset(width* 1.4f,-height.toFloat())

        //Path Drawing
        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x,mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1,mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2,mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3,mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4,mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()

        }

        //Light Colored Path
        //Medium Colored Path
        val lightColoredPoint1 = Offset(0f,height * 0.35f)
        val lightColoredPoint2 = Offset(width * 0.1f,height * 0.4f)
        val lightColoredPoint3 = Offset(width * 0.3f,height * 0.35f)
        val lightColoredPoint4 = Offset(width * 0.65f,height.toFloat())
        val lightColoredPoint5 = Offset(width* 1.4f,-height.toFloat())

        //Path Drawing
        val lightColoredPath = Path().apply {
            moveTo(lightColoredPoint1.x,lightColoredPoint1.y)
            standardQuadFromTo(lightColoredPoint1,lightColoredPoint2)
            standardQuadFromTo(lightColoredPoint2,lightColoredPoint3)
            standardQuadFromTo(lightColoredPoint3,lightColoredPoint4)
            standardQuadFromTo(lightColoredPoint4,lightColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()

        }
        Canvas(modifier = Modifier
            .fillMaxSize()){
                drawPath(
                    path = mediumColoredPath,
                    color = feature.mediumColor
                )
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ){
            Text(
                text = feature.title,
                style = MaterialTheme.typography.h2,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier .align(Alignment.BottomStart)
            )
            Text(
                text = "Start",
                fontSize = 10.sp,
                fontWeight = Bold,
                modifier = Modifier
                    .clickable {
                    /*ToDo*/
                }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 5.dp, horizontal = 15.dp)
            )
        }
    }

}

