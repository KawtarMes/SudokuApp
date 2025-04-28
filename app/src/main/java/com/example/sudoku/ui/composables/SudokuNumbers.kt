package com.example.sudoku.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sudoku.R
import com.example.sudoku.ui.theme.SudokuGridFontFamily

@Composable
fun NumberButton(
    number: Int,
    numberSelected: Int,
    onNumberSelected: (Int) -> Unit,
) {
    Column(

    ) {
        Box(
            modifier = Modifier
                .padding(3.dp)
                .size(50.dp)
                .clip(CircleShape)
                .background(Color.White)
                .selectable(
                    selected = numberSelected == number,
                    onClick = { onNumberSelected(number) },
                    role = Role.Button,
                )

        ) {
            if (number == 10) {
                Image(
                    painter = painterResource(R.drawable.cancel_icon),
                    contentDescription = stringResource(R.string.cancel_icon_desc),
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                Text(
                    text = number.toString(),
                    fontFamily = SudokuGridFontFamily,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

        }
    }
}


//@Preview
@Composable
fun NumberKeyBoard(
    numberSelected: Int,
    onNumberSelected: (Int) -> Unit,
) {

    Row(

    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(5),
            modifier =
                Modifier
                    .padding(20.dp)
                    .selectableGroup(),
        ) {
            items(10) { number ->
                NumberButton(
                    number = number + 1,
                    numberSelected = numberSelected + 1,
                    onNumberSelected = { onNumberSelected(number + 1) },

                )
            }
        }
    }

}