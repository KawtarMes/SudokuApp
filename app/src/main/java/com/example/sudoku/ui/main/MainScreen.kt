package com.example.sudoku.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.sudoku.R
import com.example.sudoku.ui.composables.RedButton
import com.example.sudoku.ui.theme.SudokuFontFamily

@Composable
fun MainScreen(navController:NavController, viewModel: MainVM) {

    WelcomeContent()
}

@Preview
@Composable
fun WelcomeContent() {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(R.drawable.welcome_vector),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .zIndex(0f)
                .background(Color.White)
                .align(Alignment.BottomCenter)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Spacer(Modifier.size(80.dp))
            Text(
                text = stringResource(R.string.welcome_title),
                textAlign = TextAlign.Center,
                fontFamily = SudokuFontFamily,
                fontSize = 20.sp,
                modifier = Modifier.padding(40.dp)
            )

            Image(
                painter = painterResource(R.drawable.text_logo),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Spacer(Modifier.size(80.dp))
            Image(
                painter = painterResource(R.drawable.logo_owl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
            )
            Spacer(Modifier.size(40.dp))

            Text(
                text = stringResource(R.string.welcome_text),
                textAlign = TextAlign.Center,
                fontFamily = SudokuFontFamily,
                fontSize = 18.sp,
                modifier = Modifier.padding(10.dp)
            )

        }

        RedButton(
            {},
            text = stringResource(R.string.lets_start_button_text),
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}
