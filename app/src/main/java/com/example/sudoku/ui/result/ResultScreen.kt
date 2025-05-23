package com.example.sudoku.ui.result

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sudoku.R
import com.example.sudoku.ui.composables.YellowButton
import com.example.sudoku.ui.theme.ShRed
import com.example.sudoku.ui.theme.SudokuFontFamily

@Composable
fun ResultScreen(navController: NavController) {

}

@Preview
@Composable
fun ResultContent() {

    Column(
        Modifier
            .fillMaxSize()
            .background(ShRed),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box() {
            Image(
                painter = painterResource(R.drawable.congrat_box),
                contentDescription = null,
                modifier = Modifier.align(Alignment.Center)

            )

            Text(
                text = "COMPLETED",
                fontSize = 36.sp,
                color = Color.White,
                fontFamily = SudokuFontFamily,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 150.dp)
                    .align(Alignment.TopCenter)
            )
            Text(
                text = "Well Done",
                fontSize = 36.sp,
                fontFamily = SudokuFontFamily,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 90.dp)
                    .align(Alignment.Center)
            )

            YellowButton(
                {},
                text = stringResource(R.string.continue_button_text),
                Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 10.dp)
            )

        }
    }
}
