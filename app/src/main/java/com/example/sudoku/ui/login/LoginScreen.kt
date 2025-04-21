package com.example.sudoku.ui.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.sudoku.R
import com.example.sudoku.ui.register.ContinueButton
import com.example.sudoku.ui.theme.red
import com.example.sudoku.ui.theme.yellow

@Composable
fun LoginScreen(navController: NavController, viewModel: LoginVM) {

    var email  by remember { mutableStateOf("") }
    var password  by remember { mutableStateOf("") }

    val toastMessage by viewModel.messageStateFlow.collectAsState()

    val context = LocalContext.current
    LaunchedEffect( toastMessage){
        Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
    }

    LaunchedEffect(Unit){
        viewModel.navigateToNextScreen.collect{ route->
            navController.navigate(route)
        }
    }

    LoginContent(
        email =email,
        password= password,
        onEmailChange =  {email = it},
        onPasswordChange = {password= it},
        onClick = {
            viewModel.signInWithEmail(
                email,
                password,
            )
        },
        onNavToRegister = { viewModel.navigateToRegisterScreen() },
    )
}

//@Preview
@Composable
fun LoginContent(
    email : String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onClick: () -> Unit,
    onNavToRegister: ()-> Unit,
) {

    Column (
        Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ){
        Image(
            painter = painterResource(id = R.drawable.text_logo),
            contentDescription = null ,
        )
        TextField(
            value = email,
            onValueChange = onEmailChange,
            label = { Text(text = stringResource(R.string.email)) },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = red,
                unfocusedContainerColor = yellow
            )
        )

        TextField(
            value = password,
            onValueChange = onPasswordChange,
            label = { Text(text = stringResource(R.string.password)) },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = red,
                unfocusedContainerColor = yellow
            )
        )

        Spacer(Modifier)
        ContinueButton(onClick)
        Text(
            text = stringResource(R.string.create_account),
            modifier = Modifier.clickable { onNavToRegister() }
        )
    }
}