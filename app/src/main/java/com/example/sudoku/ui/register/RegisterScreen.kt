package com.example.sudoku.ui.register

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sudoku.R
import com.example.sudoku.ui.composables.RedButton
import com.example.sudoku.ui.theme.red
import com.example.sudoku.ui.theme.yellow


@Composable
fun RegisterScreen(navController: NavController, viewModel: RegisterVM){

    var username  by remember { mutableStateOf("") }
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

     RegisteContent(
         email =email,
         password= password,
         username= username,
         onUsernameChange = {username = it},
         onEmailChange =  {email = it},
         onPasswordChange = {password= it},
         onClick = {
             viewModel.signUpWithEmail(
                 email,
                 password,
                 username
             )
         }
     )
}

//@Preview
@Composable
fun RegisteContent(
                   email : String,
                   password: String,
                   username: String,
                   onEmailChange: (String) -> Unit,
                   onUsernameChange: (String) -> Unit,
                   onPasswordChange: (String) -> Unit,
                   onClick: () -> Unit
) {

    Box(
        Modifier.fillMaxSize()
    ) {
        RegisterBackground()

        Column(
            Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Spacer(Modifier)
            Image(
                painter = painterResource(id = R.drawable.text_logo),
                contentDescription = null,
            )

            Image(
                painter = painterResource(id = R.drawable.owl_logo),
                contentDescription = null,
                modifier = Modifier.size(70.dp)
            )
            Text(
                text = stringResource(R.string.register_name)
            )

            TextField(
                value = username,
                onValueChange = onUsernameChange,
                label = { Text(text = stringResource(R.string.username)) },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = red,
                    unfocusedContainerColor = yellow
                )
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

            RedButton(
                onClick,
                text = stringResource(R.string.next_button_text),
                buttonAlignementModifier = Modifier
            )
        }
    }

}

@Preview
@Composable
fun RegisterBackground(){
    Box(Modifier.fillMaxSize()) {
        Image(
            painter = rememberVectorPainter(image = ImageVector.vectorResource(R.drawable.vector_register)),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
    }
}

