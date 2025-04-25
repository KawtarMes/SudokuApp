package com.example.sudoku.ui.game

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sudoku.R
import com.example.sudoku.ui.composables.CloseButton
import com.example.sudoku.ui.composables.HintButton
import com.example.sudoku.ui.composables.MenuButton
import com.example.sudoku.ui.composables.NumberKeyBoard
import com.example.sudoku.ui.composables.RedButton
import com.example.sudoku.ui.theme.ShGray
import com.example.sudoku.ui.theme.SudokuFontFamily
import com.example.sudoku.ui.theme.SudokuGridFontFamily

@Composable
fun GameScreen(navController: NavController, viewModel: GameVM, gridLevel: String) {

    var numberSelected by remember { mutableStateOf(0) }
    var isCellSelected by remember { mutableStateOf(false) }

    //viewModel.getAllGrid()

    GameContent(
        numberSelected = numberSelected,
        onNumberSelected = { numberSelected = it },
        isCellSelected = isCellSelected

    )
    Log.i("Number", "number selected : $numberSelected ")

}

@Preview
@Composable
fun GameContentPreview() {
    GameContent(
        numberSelected = 3,
        onNumberSelected = {},
        isCellSelected = false
    )
}


//@Preview
@Composable
fun SudokuCell(
    number: Int,
    isSelected: Boolean
) {
    Box(
        Modifier
            .background(Color.White)
            .aspectRatio(1f)
            .border(
                border = BorderStroke(0.3.dp, Color.Black)
            )
            .size(10.dp)
            .clickable {
                isSelected != isSelected

            }
    ) {
        if (number != 0) {
            Text(
                text = number.toString(),
                textAlign = TextAlign.Center,
                fontFamily = SudokuGridFontFamily,
                modifier = Modifier.align(Alignment.Center)
            )
        } else if (number == 0 && isSelected == true) {
            //mettre le chiffre clické en bas

        }
    }
}

@Composable
fun GameContent(
    numberSelected: Int,
    onNumberSelected: (Int) -> Unit,
    isCellSelected: Boolean
) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .background(ShGray),
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
            text = stringResource(R.string.game_screen_title),
            textAlign = TextAlign.Center,
            fontFamily = SudokuFontFamily,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)

        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(9),
            modifier =
                Modifier.padding(20.dp)

        ) {
            grid.forEach { gridLine ->
                itemsIndexed(gridLine.toTypedArray()) { index, item ->

                    SudokuCell(item, isCellSelected)

                    if (item == 0 && numberSelected != 0 && numberSelected != 10) {
                        SudokuCell(numberSelected, isCellSelected)

                    } else if (numberSelected == 10) {
                        SudokuCell(0, isCellSelected)
                    } else {
                        SudokuCell(item, isCellSelected)
                    }

                }

            }

        }

        NumberKeyBoard(
            numberSelected = numberSelected,
            onNumberSelected = onNumberSelected
        )

        RedButton(
            onClick = {},
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = stringResource(R.string.solve_button_text)
        )
    }
}


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

