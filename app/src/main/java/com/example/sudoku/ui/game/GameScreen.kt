package com.example.sudoku.ui.game

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sudoku.ui.composables.CloseButton
import com.example.sudoku.ui.composables.HintButton
import com.example.sudoku.ui.composables.MenuButton
import com.example.sudoku.ui.theme.SudokuFontFamily
import com.example.sudoku.ui.theme.SudokuGridFontFamily

@Composable
fun GameScreen(navController: NavController, viewModel: GameVM, gridLevel: String) {

    viewModel.getAllGrid()

    GameContent()
}

@Preview
@Composable
fun GameConntentPreview() {
    GameContent()
}


//@Preview
@Composable
fun SudokuCell(
    number: Int
) {
    Box(
        Modifier
            .background(Color.White)
            .aspectRatio(1f)
            .border(
                border = BorderStroke(0.3.dp, Color.Black)
            )
            .size(10.dp)
    ) {
        if (number != 0) {
            Text(
                text = number.toString(),
                textAlign = TextAlign.Center,
                fontFamily = SudokuGridFontFamily,
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            //mettre le chiffre clické en bas

        }
    }
}

@Composable
fun GameContent() {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {

        val grid: Array<IntArray> = arrayOf(
            intArrayOf(5, 3, 0, 0, 7, 0, 0, 0, 0),
            intArrayOf(6, 0, 0, 1, 9, 5, 0, 0, 0),
            intArrayOf(0, 9, 8, 0, 0, 0, 0, 6, 0),
            intArrayOf(8, 0, 0, 0, 6, 0, 0, 0, 3),
            intArrayOf(4, 0, 0, 8, 0, 3, 0, 0, 1),
            intArrayOf(7, 0, 0, 0, 2, 0, 0, 0, 6),
            intArrayOf(0, 6, 0, 0, 0, 0, 2, 8, 0),
            intArrayOf(0, 0, 0, 4, 1, 9, 0, 0, 5),
            intArrayOf(0, 0, 0, 0, 8, 0, 0, 7, 9)
        )

        TopRow()

        Text(
            text = "Tap a box and select a number from below\n" +
                    "to fill the Sudoku board.",
            fontFamily = SudokuFontFamily,
            fontSize = 24.sp,
            modifier = Modifier.padding(vertical = 20.dp)

        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(9),
            modifier =
                Modifier

        ) {
            grid.forEach { gridLine ->
                itemsIndexed(gridLine.toTypedArray()) { index, item ->
                    SudokuCell(item)
                }
            }

        }


    }
}

@Preview
@Composable
fun TopRow() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CloseButton({}, Modifier)
            Text(
                text = "EggShell level",
                fontFamily = SudokuFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp

            )
        }

        Row {
            HintButton({}, Modifier)
            MenuButton({}, Modifier)

        }

    }
}

