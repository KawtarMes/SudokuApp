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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.sudoku.R
import com.example.sudoku.navigation.Screen
import com.example.sudoku.ui.composables.RedButton
import com.example.sudoku.ui.theme.SudokuFontFamily


@Composable
fun OnBoardingScreen(navController: NavController, viewModel: OnboardingVM) {

    //  OnBoardingPage1(onClick= {viewModel.navigateToOnBoarding2()})
    LaunchedEffect(Unit) {
        viewModel.navigateToNextScreen.collect { nextScreen ->
            navController.navigate(nextScreen) {
                popUpTo(Screen.Onboarding.route) { inclusive = true }
            }
        }
    }
}



@Composable
@Preview
fun OnBoardingPage1(
    //onClick: ()->Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Column(
            modifier = Modifier.weight(3f),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = stringResource(R.string.onboarding1_title),
                textAlign = TextAlign.Center,
                fontFamily = SudokuFontFamily,
                fontSize = 26.sp,
                modifier = Modifier.padding(10.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.onboarding1_image),
                contentDescription = null,
            )
            Text(
                text = stringResource(R.string.onboarding1_text),
                textAlign = TextAlign.Center,
                fontFamily = SudokuFontFamily,
                fontSize = 18.sp,
                modifier = Modifier.padding(10.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.pagination_1),
                contentDescription = null,
                Modifier.align(Alignment.CenterHorizontally)
            )
        }
        Box(

            Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(id = R.drawable.onboarding_vector),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .zIndex(0f),
            )


            RedButton(
                { },
                text = stringResource(R.string.next_button_text),
                modifier = Modifier.align(Alignment.BottomCenter)
            )


        }
    }
}
