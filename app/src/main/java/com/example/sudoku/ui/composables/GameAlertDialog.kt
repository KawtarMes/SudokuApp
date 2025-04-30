package com.example.sudoku.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.sudoku.R


@Preview
@Composable
fun dialogPreview() {
    DialogWithImage({}, {}, "OUPSIE , grid incorrect . Try again ?")
}

@Composable
fun DialogWithImage(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    textMessage: String
) {
    Dialog(
        onDismissRequest = { onDismissRequest() }
    ) {
        // Draw a rectangle shape with rounded corners inside the dialog
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(375.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(R.drawable.logo_owl),
                    contentDescription = "imageDescription",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(160.dp)
                )
                Text(
                    text = textMessage,
                    modifier = Modifier.padding(16.dp),
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    TextButton(
                        onClick = { onDismissRequest() },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("CLOSE")
                    }
                    TextButton(
                        onClick = { onConfirmation() },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("OK")
                    }
                }
            }
        }
    }
}
/*----------------------------------------KMM quiz dialog------------------------------------------------------*/

// 3 types pour quiz
/*
* Bonne reponse : vert
* image , titre, point + trophy icone , text info ulterieures , button question suivante
*
* Mauvaise reponse: rouge
* image, titre , carde avec info sur la bonne reponse, mm txt info ulterieures, button question suivante
*
* Quitter la partie: orange
* image, titre, text , 2 buttons ( "annuler" et "oui, je quitte")
*
* Pour compo
*
* Confiramation compo: orange
* image, text , 2 buttons ( "annuler" et "oui, je quitte")
*
* */
@Preview
@Composable
fun QuizDialogPreview() {

    /* MyCustomDialog(
         onDismissRequest = {},
         content = { QuizDialogWithImage({}, {}, "") }
     )*/
    QuizDialogWithImage({}, {}, "Bravo, bonne réponse!")


}

@Composable
fun QuizDialogWithImage(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    //image : painter
    textMessage: String
) {
    Dialog(
        onDismissRequest = { onDismissRequest() },


        ) {
        // Draw a rectangle shape with rounded corners inside the dialog
        Card(
            modifier = Modifier
                .fillMaxWidth()

                .padding(20.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Green,
                                Color.Black
                            ),

                            )
                    ),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(R.drawable.green_icon),
                    contentDescription = "imageDescription",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .padding(10.dp)
                        .height(60.dp)
                )
                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = textMessage.uppercase(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                    )

                    Text(
                        text = "+10",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        modifier = Modifier.padding(16.dp),
                    )

                    Text(
                        text = "En 1907, le Stade Toulousain voit officiellement le jour, né d’une fusion entre deux clubs estudiantins (le SOET et le Véto-Sport). ",
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        modifier = Modifier.padding(16.dp),
                    )
                }




                Button(
                    onClick = {},
                    shape = RoundedCornerShape(6.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .height(40.dp),
                    colors = ButtonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                        disabledContainerColor = Color.White,
                        disabledContentColor = Color.White
                    )

                ) {
                    Text(
                        text = "Question suivante"
                    )
                }

            }
        }
    }
}




