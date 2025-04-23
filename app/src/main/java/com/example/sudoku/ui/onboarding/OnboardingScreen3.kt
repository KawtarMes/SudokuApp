package com.example.sudoku.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sudoku.R
import com.example.sudoku.navigation.Screen
import com.example.sudoku.ui.composables.RedButton
import com.example.sudoku.ui.composables.WhiteButton
import com.example.sudoku.ui.theme.SudokuFontFamily

@Composable
fun OnboardingScreen3(navController: NavController, viewmodel: OnboardingVM) {

    OnBoardingContent3(
        onNext = { viewmodel.navigateToWelcomeScreen() },
        onBack = { navController.popBackStack() }
    )

    LaunchedEffect(Unit) {
        viewmodel.navigateToNextScreen.collect { nextScreen ->
            navController.navigate(nextScreen) {
                popUpTo(Screen.Onboarding2.route) { inclusive = false }
            }
        }
    }

}

//@Preview
@Composable
fun OnBoardingContent3(
    onNext: () -> Unit,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),

    ) {

        Column(
            modifier = Modifier.weight(2f),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = stringResource(R.string.onboarding3_title),
                textAlign = TextAlign.Center,
                fontSize = 26.sp,
                fontFamily = SudokuFontFamily,
                modifier = Modifier
                    .padding(50.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Image(
                painter = painterResource(id = R.drawable.onboarding3_image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = stringResource(R.string.onboarding3_text),
                textAlign = TextAlign.Center,
                fontFamily = SudokuFontFamily,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Image(
                painter = painterResource(id = R.drawable.pagination_3),
                contentDescription = null,
                Modifier.align(Alignment.CenterHorizontally)
            )
        }
        Box() {
            Image(
                painter = painterResource(id = R.drawable.onboarding_vector),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop,
                alignment = Alignment.BottomCenter
            )

            RedButton(
                onClick = onNext,
                text = stringResource(R.string.next_button_text),
                modifier = Modifier.align(Alignment.Center)
            )
            WhiteButton(
                onClick = onBack,
                text = stringResource(R.string.back_button_text),
                modifier = Modifier.align(Alignment.BottomCenter)
            )

        }

    }

}