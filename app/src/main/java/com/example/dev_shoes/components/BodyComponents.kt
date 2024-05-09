package com.example.dev_shoes.components


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleView(name: String){
    Text(text = name , fontSize = 40.sp, fontWeight = FontWeight.Bold)
}

@Composable
fun Spacito(){
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun MainButton(name: String, backColor: Color, color: Color, onClick:()->Unit){

    ExtendedFloatingActionButton(
            onClick = onClick,
            modifier = Modifier.width(165.dp),
            contentColor = color,
            containerColor = backColor,

            shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp),





    ) {
        Text(text= name)
    }
}