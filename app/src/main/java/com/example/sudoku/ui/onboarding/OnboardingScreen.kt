package com.example.sudoku.ui.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.sudoku.ui.composables.RedButton


@Composable
fun OnBoardingScreen(navController: NavController, viewModel: ViewModel){

    //carroussel
}


@Composable
@Preview
fun OnBoardingPage1(){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceAround
    ){
        Text("Titre")
        Box {  }

        RedButton({},Modifier, "Back")
    }
}


fun OnBoardingPage2(){

}

fun OnBoardingPage3(){

}
