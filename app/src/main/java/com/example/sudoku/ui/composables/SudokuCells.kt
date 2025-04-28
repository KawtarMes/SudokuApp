package com.example.sudoku.ui.composables

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.sudoku.ui.theme.ShOrange
import com.example.sudoku.ui.theme.SudokuGridFontFamily

//@Preview
@Composable
fun SudokuCell(
    number: Int,
    isSelected: Boolean,
    onClick: () -> Unit,
    // index : Int?,
    //indice1: Int?

) {

    Box(
        Modifier
            .background(
                if (isSelected) {
                    ShOrange
                } else {
                    Color.White
                }
            )
            .aspectRatio(1f)
            .border(
                border = BorderStroke(0.3.dp, Color.Black)
            )
            .size(10.dp)
            .clickable {

                onClick()

                Log.i("BoxCell", "is clicked ? : $isSelected ")
            }
    ) {
        // case vide
        // case vide et selectionné , avec index
        //case pleine avec index qui est reselctionné apres pour effacer et changer par ex
        // case pleine , donc valeurs initiales sans index

        if (number != 0) {
            Text(
                text = number.toString(),
                textAlign = TextAlign.Center,
                fontFamily = SudokuGridFontFamily,
                modifier = Modifier.align(Alignment.Center)
            )
        }


    }
}


// cellules initiales preremplies
@Composable
fun SudokuCellInitial(
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
        Text(
            text = number.toString(),
            textAlign = TextAlign.Center,
            fontFamily = SudokuGridFontFamily,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
