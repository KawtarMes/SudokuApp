package com.example.sudoku.ui.main

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun MainScreen(navController:NavController, viewModel: MainVM) {


    MainContent()
}

@Composable
fun MainContent() {
    Text(text = "MainContent")
}