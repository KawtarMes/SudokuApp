package com.example.sudoku.ui.level

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sudoku.R
import com.example.sudoku.ui.composables.RedButton
import com.example.sudoku.ui.theme.ShOrange
import com.example.sudoku.ui.theme.SudokuFontFamily
import com.example.sudoku.utils.Level


@Composable
fun LevelScreen(navController: NavController, viewModel: LevelVM) {

    LevelContent()

}

//@Preview
@Composable
fun LevelContent(
    // isLevelSelected: Boolean
) {

    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(R.drawable.vector_levels),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )

        Column(
            Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, start = 15.dp, end = 15.dp, bottom = 10.dp)
        ) {

            Text(
                text = stringResource(R.string.title_level),
                fontSize = 30.sp,
                fontFamily = SudokuFontFamily,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(10.dp)
            )

            LevelRadioGroup()

        }
        RedButton(

            onClick = {},
            text = stringResource(R.string.lets_play_button_text),
            modifier = Modifier.align(Alignment.BottomCenter)
        )

    }


}

@Composable
fun LevelRadioGroup(
    //isLevelSelected: Boolean
    //selectedLevel
    //onSelectedLevel
) {


    val isLevelSelected by remember { mutableStateOf(true) }
    val levelsList = listOf(
        Triple(R.drawable.eggshell, R.string.eggshell_lvl, Level.Beginner),
        Triple(R.drawable.cracked, R.string.cracked_lvl, Level.Easy),
        Triple(R.drawable.chick, R.string.chick_lvl, Level.Intermediate),
        Triple(R.drawable.fledgeling, R.string.fledgeling_lvl, Level.Advanced),
        Triple(R.drawable.wise_owl, R.string.wise_owl_lvl, Level.Expert),


        )


    Column()
    {
        levelsList.forEach { (img, title, level) ->

            RowLevel(img, title, level, isLevelSelected = isLevelSelected)

        }
    }
}

//@Preview
@Composable
fun RowLevel(
    imageRes: Int,
    levelTitle: Int,
    levelTitle2: Level,
    isLevelSelected: Boolean,
//selectedLevel
//onSelectedLevel

) {
    Row(
        Modifier
            .padding(horizontal = 10.dp, vertical = 12.dp)
            .fillMaxWidth()
            .clickable {
                isLevelSelected != isLevelSelected
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .size(60.dp)
        )
        Column(
            Modifier
                .weight(1f)
                .padding(start = 15.dp)
        ) {
            Text(
                text = stringResource(levelTitle),
                fontSize = 32.sp,
                fontFamily = SudokuFontFamily,
                modifier = Modifier.align(Alignment.Start)
            )
            Text(
                text = "($levelTitle2)",
                modifier = Modifier.align(Alignment.Start)
            )


        }

        if (isLevelSelected) {
            CustomRBtnSelected()
        } else {
            CustomRBtnUnselected()
        }



    }
}


@Preview
@Composable
fun CustomRBtnSelected() {
    Column(
        Modifier
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(Color.White)
        ) {
            Box(
                modifier = Modifier
                    .size(33.dp)
                    .clip(CircleShape)
                    .background(ShOrange)
                    .align(Alignment.Center)
            )
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .align(Alignment.Center)
            )
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape)
                    .background(ShOrange)
                    .align(Alignment.Center)
            )
        }
    }
}

@Preview
@Composable
fun CustomRBtnUnselected() {
    Column(
        Modifier
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(Color.White)
                .shadow(
                    shape = CircleShape,
                    elevation = 1.dp,
                    ambientColor = Color.LightGray
                )
        )
    }
}