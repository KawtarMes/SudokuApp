package com.example.sudoku.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sudoku.R
import com.example.sudoku.ui.theme.SudokuFontFamily


//@Preview
@Composable
fun RedButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .clickable {
                onClick()
            }
            .padding(vertical = 10.dp, horizontal = 5.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.red_button),
            contentDescription = stringResource(R.string.register_button_continue_desc),
            modifier = Modifier
                .fillMaxWidth()
        )
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontFamily = SudokuFontFamily,
            fontSize = 32.sp,
            modifier = Modifier.align(Alignment.Center),
            color = Color.White

        )
    }
}

//@Preview
@Composable
fun WhiteButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier // que pour aligner la box
) {
    Box(
        modifier = modifier
            .clickable {
                onClick()
            }
            .padding(vertical = 5.dp, horizontal = 5.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.white_button),
            contentDescription = stringResource(R.string.register_button_continue_desc),
            modifier = Modifier
                .fillMaxWidth()
        )
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontFamily = SudokuFontFamily,
            fontSize = 32.sp,
            modifier = Modifier.align(Alignment.Center),
        )
    }
}

//@Preview
@Composable
fun YellowButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .clickable {
                onClick()
            }
            .padding(vertical = 5.dp, horizontal = 5.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.button_yellow),
            contentDescription = stringResource(R.string.register_button_continue_desc),
            modifier = Modifier
                .fillMaxWidth()
        )
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontFamily = SudokuFontFamily,
            fontSize = 32.sp,
            modifier = Modifier.align(Alignment.Center),
        )
    }
}


@Composable
fun CloseButton(
    onClick: () -> Unit,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .clickable {
                onClick()
            }
            .padding(5.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.close_button),
            contentDescription = stringResource(R.string.close_button_desc),
        )
    }
}


@Composable
fun MenuButton(
    onClick: () -> Unit,
    modifier: Modifier

) {
    Box(
        modifier = modifier
            .clickable {
                onClick()
            }
            .padding(5.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.menu_button),
            contentDescription = stringResource(R.string.menu_button_desc),
        )
    }
}


@Composable
fun HintButton(
    onClick: () -> Unit,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .clickable {
                onClick()
            }
            .padding(5.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.hint_button),
            contentDescription = stringResource(R.string.hint_button_desc),
        )
    }
}








