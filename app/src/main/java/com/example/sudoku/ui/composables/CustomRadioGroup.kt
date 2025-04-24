package com.example.sudoku.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sudoku.R
import com.example.sudoku.ui.theme.SudokuFontFamily
import com.example.sudoku.utils.Level


//@Preview
@Composable
fun LevelRadioGroup(
    modifier: Modifier = Modifier,
    selectedOption: Level,
    onOptionSelected: (Level) -> Unit
) {

    val levelsList = listOf(
        Triple(R.drawable.eggshell, R.string.eggshell_lvl, Level.Beginner),
        Triple(R.drawable.cracked, R.string.cracked_lvl, Level.Easy),
        Triple(R.drawable.chick, R.string.chick_lvl, Level.Intermediate),
        Triple(R.drawable.fledgeling, R.string.fledgeling_lvl, Level.Advanced),
        Triple(R.drawable.wise_owl, R.string.wise_owl_lvl, Level.Expert),
    )

    Column(modifier.selectableGroup()) {
        levelsList.forEach { (imageRes, levelTitle, level) ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 12.dp)
                    .selectable(
                        selected = (level == selectedOption),
                        onClick = { onOptionSelected(level) },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(imageRes),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(60.dp)
                )

                Column(
                    Modifier
                        .weight(1f)
                        .padding(start = 15.dp)
                ) {
                    Text(
                        text = stringResource(levelTitle),
                        fontSize = 32.sp,
                        fontFamily = SudokuFontFamily,
                        modifier = Modifier.align(Alignment.Start)
                    )
                    Text(
                        text = "(${level})",
                        modifier = Modifier.align(Alignment.Start)
                    )

                }

                CustomRBtn(
                    selected = (level == selectedOption),
                    onClick = null
                )
            }
        }
    }
}