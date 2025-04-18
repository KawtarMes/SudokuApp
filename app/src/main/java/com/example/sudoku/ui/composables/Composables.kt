package com.example.sudoku.ui.composables

import androidx.compose.foundation.background
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.sudoku.ui.theme.red

//@Preview
@Composable
fun RedButton(onClick : ()-> Unit, modifier: Modifier, text: String){
    ElevatedButton(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = red),

        ) {
        Text(text = text)
    }
}


@Composable
fun WhiteButton(onClick : ()-> Unit, modifier: Modifier, text: String){
    ElevatedButton(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),

    ) {
        Text(text = text,
            color = Color.Black,
        )
    }
}