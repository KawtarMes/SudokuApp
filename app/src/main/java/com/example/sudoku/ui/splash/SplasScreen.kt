package com.example.sudoku.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.sudoku.R
import com.example.sudoku.navigation.Screen
import com.example.sudoku.ui.theme.ShYellow

@Composable
fun SplashScreen(navController: NavController, viewModel:SplashVM){

    val navigateToSecondSplash by viewModel.navigateToSecondSplash.collectAsState()

    LaunchedEffect(navigateToSecondSplash) {
        if (navigateToSecondSplash) {
            navController.navigate(Screen.Splash1.route) {
                popUpTo(Screen.Splash.route) { inclusive = true }
            }
        }
    }

    SplashContent()

}


@Preview
@Composable
fun SplashContent(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ShYellow),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(){
            Image(
                painter = painterResource(R.drawable.loading_eggs),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}










