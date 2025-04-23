package com.example.sudoku.ui.level

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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


}

@Preview
@Composable
fun LevelContent() {

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
    //selectedLevel
    //onSelectedLevel
) {
    val levelsList = listOf(
        Triple(R.drawable.eggshell, R.string.eggshell_lvl, Level.BEGINNER),
        Triple(R.drawable.cracked, R.string.cracked_lvl, Level.EASY),
        Triple(R.drawable.chick, R.string.chick_lvl, Level.INTERMIDIATE),
        Triple(R.drawable.fledgeling, R.string.fledgeling_lvl, Level.ADVANCED),
        Triple(R.drawable.wise_owl, R.string.wise_owl_lvl, Level.EXPERT),


        )

    Column()
    {
        levelsList.forEach { (img, title, level) ->

            RowLevel(img, title, level)

        }
    }
}

//@Preview
@Composable
fun RowLevel(
    imageRes: Int,
    levelTitle: Int,
    levelTitle2: Level,
//selectedLevel
//onSelectedLevel

) {
    Row(
        Modifier
            .fillMaxWidth()
            .selectable(
                selected = false /*levelTitle == selectedLevel*/,
                onClick = {/*onSelecetedLeved*/ }
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(

        ) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(60.dp)
            )
            Text(
                text = stringResource(levelTitle),
                fontSize = 32.sp,
                fontFamily = SudokuFontFamily,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = "(${levelTitle2.toString().lowercase()})",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )


        }
        RadioButton(
            selected = false, //id == selectedLevel,
            onClick = {},
            modifier = Modifier,
            enabled = true,
            colors = RadioButtonColors(
                selectedColor = ShOrange,
                unselectedColor = Color.White,
                disabledSelectedColor = Color.LightGray,
                disabledUnselectedColor = Color.LightGray
            )
        )

    }
}


