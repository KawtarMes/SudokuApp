package com.example.sudoku.ui.composables

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.sudoku.ui.theme.ShOrange
import com.example.sudoku.ui.theme.ShYellow
import com.example.sudoku.ui.theme.SudokuFontFamily

//@Preview
@Composable
fun YellowTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPasswordField: Boolean
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = placeholder,
                fontFamily = SudokuFontFamily,
            )
        },

        keyboardOptions = if (isPasswordField) {
            KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        } else {
            KeyboardOptions(
                keyboardType = KeyboardType.Unspecified
            )
        },
        visualTransformation = if (isPasswordField) PasswordVisualTransformation()
        else VisualTransformation.None,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedTextColor = ShOrange,
            disabledContainerColor = ShYellow,
            focusedLabelColor = ShYellow,
            unfocusedLabelColor = Color.Black,
            focusedBorderColor = ShYellow,
            unfocusedBorderColor = ShYellow

        )
    )

}