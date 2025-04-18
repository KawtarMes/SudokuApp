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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
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
            painter = painterResource(id = R.drawable.loading),
            contentDescription = null,
            Modifier.padding(40.dp)
        )
    }
}

@Composable
fun BackGround(){
    val vector = ImageVector.vectorResource(R.drawable.vector__yellow)
    Image(
        painter = rememberVectorPainter(image = vector),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize().rotate(180f).zIndex(0f)
    )
}