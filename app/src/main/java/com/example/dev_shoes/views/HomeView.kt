package com.example.dev_shoes.views


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dev_shoes.R
import com.example.dev_shoes.components.MainButton
import com.example.dev_shoes.components.Spacito



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController) {

    Scaffold {

        ContentHomeView(navController)


    }


}

@Composable
fun ContentHomeView(navController: NavController) {
    val id = 123
    var opcional by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

       
        Image(
            painter = painterResource(id = R.drawable.portadc),
            contentDescription = "Descripción de la imagen",


            )
        Spacito()
        Spacito()

       /* TextField(
            value = opcional,
            onValueChange = { opcional = it },
            label = { Text(text = "opcional") }
        )*/


        Row {
            MainButton(name = "REGISTER", backColor = Color.White , Color(0xFF131000)) {
                //navController.navigate("Detail/${id}/?${opcional}")
            }
            Spacer(modifier = Modifier.width(25.dp))

            MainButton(name = "LOG IN", backColor = Color(0xFF131000), color = Color.White) {
                navController.navigate("Login")
            }
        }

    }


}

