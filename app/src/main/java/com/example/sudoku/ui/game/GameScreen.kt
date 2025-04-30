package com.example.sudoku.ui.game

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
import com.example.sudoku.ui.composables.SudokuCell
import com.example.sudoku.ui.theme.ShGray
import com.example.sudoku.ui.theme.SudokuFontFamily


@Composable
fun GameScreen(navController: NavController, viewModel: GameVM, gridLevel: String) {


    LaunchedEffect(gridLevel) {
        viewModel.getGridByLevel(gridLevel)
    }

    val toastMessage by viewModel.messageStateFlow.collectAsState()
    val gridInitial: Array<IntArray> = viewModel.getGridIntialArray()
    var numberSelected by remember { mutableStateOf(0) }
    var grid by remember { mutableStateOf(gridInitial) }
    var cellSelected: Pair<Int, Int>? by remember { mutableStateOf(null) }

    GameContent(
        grid = grid,
        numberSelected = numberSelected,
        cellSelected = cellSelected,
        onCellClicked = { cellSelected = it },
        onNumberSelected = { selectedNumber ->
            numberSelected = selectedNumber
            cellSelected?.let { (row, col) -> //si il ya une case selected
                if (grid[row][col] == 0 || grid[row][col] != selectedNumber) {  // case vide ou case diff du chiffre actuel , on peut change
                    val newGrid =
                        grid.map { it.copyOf() }.toTypedArray() // copy de la grille quia a changeé
                    newGrid[row][col] = if (selectedNumber == 10) 0 else selectedNumber
                    grid = newGrid
                }
            }
        },
        onSolve = {
            viewModel.solveGrid(grid)
        }

    )

    LaunchedEffect(Unit) {
        viewModel.navigateToNextScreen.collect { route ->
            navController.navigate(route)
        }
    }


    val context = LocalContext.current
    LaunchedEffect(toastMessage) {
        if (toastMessage != "")
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
    }

}

@Preview
@Composable
fun GameContentPreview() {
    /*GameContent(
        numberSelected = 0,
        onNumberSelected = {},
        isSelected = false,
        grid = arrayOf(
            intArrayOf(5, 3, 0, 0, 7, 0, 0, 0, 0),
            intArrayOf(6, 0, 0, 1, 9, 5, 0, 0, 0),
            intArrayOf(0, 9, 8, 0, 0, 0, 0, 6, 0),
            intArrayOf(8, 0, 0, 0, 6, 0, 0, 0, 3),
            intArrayOf(4, 0, 0, 8, 0, 3, 0, 0, 1),
            intArrayOf(7, 0, 0, 0, 2, 0, 0, 0, 6),
            intArrayOf(0, 6, 0, 0, 0, 0, 2, 8, 0),
            intArrayOf(0, 0, 0, 4, 1, 9, 0, 0, 5),
            intArrayOf(0, 0, 0, 0, 8, 0, 0, 7, 9)
        ),
        onCellClicked = {()-> }
     //  index = null // au debut
    )*/
}



@Composable
fun GameContent(
    numberSelected: Int,
    onNumberSelected: (Int) -> Unit,
    cellSelected: Pair<Int, Int>?,
    onCellClicked: (Pair<Int, Int>?) -> Unit,
    grid: Array<IntArray>,
    onSolve: () -> Unit

) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .background(ShGray),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {


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
            grid.forEachIndexed { rowIndex, row ->

                itemsIndexed(row.toTypedArray()) { colIndex, item ->

                    // case vide, et Selectionner on recupere les 2 index
                    // et on remplie avec les numberselected sur les chiffre enbas
                    SudokuCell(
                        number = item,
                        isSelected = cellSelected == Pair(
                            rowIndex,
                            colIndex
                        ), // vrai que à la position selectionné
                        onClick = {
                            onCellClicked(
                                Pair(
                                    rowIndex,
                                    colIndex
                                )
                            )
                        }// changement de la position
                    )

                }
            }
        }


        NumberKeyBoard(
            numberSelected = numberSelected,
            onNumberSelected = onNumberSelected,

            )

        RedButton(
            onClick = onSolve,
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