package com.example.sudoku.ui.register

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sudoku.R
import com.example.sudoku.navigation.Screen
import com.example.sudoku.ui.theme.red
import com.example.sudoku.ui.theme.yellow
import io.github.jan.supabase.realtime.Column


@Composable
fun RegisterScreen(navController: NavController, viewModel: RegisterVM){

    viewModel.signUpWithEmail(
        "mesfaouyi.kawtar@outlook.fr",
        "12345678"
    )
    Log.i("Register","ugoiugkg")


    LaunchedEffect( Unit){
        //toast
    }

    LaunchedEffect( Unit){
    //navigation
    }

     RegisteContent(
         onClick = {

     }
     )
}

//@Preview
@Composable
fun RegisteContent(onClick: () -> Unit) {
    Column (
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Image(
            painter = painterResource(id = R.drawable.text_logo),
            contentDescription = null ,
        )
        Text(
            text = stringResource(R.string.register_name)
        )

        TextField(
            value = "value",
            onValueChange = {  },
            label = { Text(text = stringResource(R.string.username)) },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = red,
                unfocusedContainerColor = yellow
            )
        )

        TextField(
            value = "password",
            onValueChange = {  },
            label = { Text(text = stringResource(R.string.password)) },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = red,
                unfocusedContainerColor = yellow
            )
        )
        ContinueButton(onClick)
    }
}

@Preview
@Composable
fun RegisterBackground(){

}

//@Preview
@Composable
fun ContinueButton(onClick: ()-> Unit){
    Box(
        Modifier.clickable {
            onClick
    }
    ) {
        Image(
            painter = painterResource(R.drawable.button_continue),
            contentDescription = stringResource(R.string.register_button_continue_desc)
        )
    }
}
