package com.example.sudoku.ui.level

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.sudoku.navigation.Screen
import com.example.sudoku.ui.composables.LevelRadioGroup
import com.example.sudoku.ui.composables.RedButton
import com.example.sudoku.ui.theme.SudokuFontFamily
import com.example.sudoku.utils.Level


@Composable
fun LevelScreen(navController: NavController, viewModel: LevelVM) {

    var selectedOption by remember { mutableStateOf(Level.Beginner) }

    LevelContent(
        selectedOption = selectedOption,
        onOptionSelected = { selectedOption = it },
        onClick = {
            val gridLevel = selectedOption
            navController.navigate("${Screen.Game.route}/" + "$gridLevel") {

            }
            Log.i("LevelChosen", "Level chosen = $gridLevel")
        } // navtoGame envoyer level
    )

}

@Preview
@Composable
fun LevelContentPreview() {
    LevelContent(
        selectedOption = Level.Beginner,
        onOptionSelected = { Level.Expert },
        onClick = {}
    )
}


//@Preview
@Composable
fun LevelContent(
    selectedOption: Level,
    onOptionSelected: (Level) -> Unit,
    onClick: () -> Unit
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
                .padding(top = 70.dp, start = 15.dp, end = 15.dp, bottom = 10.dp)
        ) {

            Text(
                text = stringResource(R.string.title_level),
                fontSize = 36.sp,
                fontFamily = SudokuFontFamily,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 40.dp)
            )

            LevelRadioGroup(
                Modifier,
                selectedOption = selectedOption,
                onOptionSelected = onOptionSelected
            )

        }
        RedButton(
            onClick = onClick,
            text = stringResource(R.string.lets_play_button_text),
            modifier = Modifier.align(Alignment.BottomCenter)
        )

    }
}
