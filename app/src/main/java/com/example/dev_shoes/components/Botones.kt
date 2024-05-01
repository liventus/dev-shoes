package com.example.dev_shoes.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BotonNormal() {
    Button(onClick = { /*TODO*/ }, enabled = false) {
        Text(text = "Mi Boton", fontSize = 30.sp)
    }
}

@Composable
fun BotonNormal2() {
    Button(
        onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red
        )
    ) {
        Text(text = "Mi Boton", fontSize = 30.sp)
    }
}

@Composable
fun BotonTexto() {
    TextButton(onClick = { /*TODO*/ }) {
        Text(text = "Mi Boton", fontSize = 30.sp)
    }
}

@Composable
fun BotonOutline() {
    OutlinedButton(
        onClick = { /*TODO*/ }, border = BorderStroke(
            3.dp, Color.Blue
        )
    ) {
        Text(text = "Mi Boton", fontSize = 30.sp)
    }
}

@Composable
fun BotonIcono() {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            Icons.Filled.Home,
            contentDescription = "Icono",
            tint = Color.Red,
            modifier = Modifier.size(50.dp)
        )

    }

}


@Composable
fun Space() {
    Spacer(modifier = Modifier.height(10.dp))
}