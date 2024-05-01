package com.example.dev_shoes.views


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.dev_shoes.components.BotonIcono
import com.example.dev_shoes.components.BotonNormal
import com.example.dev_shoes.components.BotonNormal2
import com.example.dev_shoes.components.BotonOutline
import com.example.dev_shoes.components.BotonTexto
import com.example.dev_shoes.components.Space


@Composable
fun HomeView() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        BotonNormal()
        Space()
        BotonNormal2()
        Space()
        BotonTexto()
        Space()
        BotonOutline()
        Space()
        BotonIcono()
    }


}

@Composable
fun ContentHomeView() {

}

