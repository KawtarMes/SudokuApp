package com.example.sudoku.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sudoku.ui.theme.ShOrange

@Preview
@Composable
fun CustomRBtnSelected() {
    Column(
        Modifier
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(Color.White)
        ) {
            Box(
                modifier = Modifier
                    .size(33.dp)
                    .clip(CircleShape)
                    .background(ShOrange)
                    .align(Alignment.Center)
            )
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .align(Alignment.Center)
            )
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape)
                    .background(ShOrange)
                    .align(Alignment.Center)
            )
        }
    }
}

@Preview
@Composable
fun CustomRBtnUnselected() {
    Column(
        Modifier
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(Color.White)
                .shadow(
                    shape = CircleShape,
                    elevation = 1.dp,
                    ambientColor = Color.LightGray,
                )
        )
    }
}

@Composable
fun CustomRBtn(
    selected: Boolean,
    onClick: (() -> Unit)?
) {
    Box(
        Modifier.clickable {
            if (onClick != null) {
                onClick()
            }
        }
    ) {

        if (selected) {
            CustomRBtnSelected()
        } else {
            CustomRBtnUnselected()
        }
    }
}