package com.example.sudoku.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sudoku.R


@Composable
fun Splash1Column(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxSize()
    ){
        Spacer(Modifier)
        Image(
            painter = painterResource(id = R.drawable.shlogo_1),
            contentDescription = null ,
            Modifier.size(250.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.text_logo),
            contentDescription = null ,
        )
        Spacer(Modifier)
        EggsIconsRow()
    }
}



@Composable
fun EggsIconsRow(){
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.loading_eggs),
            contentDescription = null,
            Modifier.padding(40.dp)
        )
    }
}

@Composable
fun BackGround(){
    Image(
        painter = painterResource(R.drawable.vector_splash1),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}