package com.example.dev_shoes.assets

import com.example.dev_shoes.model.dto.MaterialItem
import com.example.dev_shoes.model.dto.RegistroDeComprasDTO
import com.example.dev_shoes.model.dto.listaDeComprasDTO

fun generateMaterialItems(): List<MaterialItem> {
    return listOf(
        MaterialItem(1, "CUERO", "Descripción del CUERO,  PRECIO: 4.0 la unidad , 2mm"),
        MaterialItem(2, "BADANA", "Descripción del BADANA PRECIO: 8.0 el pie 1.6 mm"),
        MaterialItem(3, "FELPA", "Descripción del FELPA PRECIO: 4.0 color negro ")
    )
}

fun generateRegistroItems(): List<RegistroDeComprasDTO> {
    return listOf(
        RegistroDeComprasDTO(3333, "08 de marzo", "Caqueta compra para modelo botin"),
        RegistroDeComprasDTO(2222, "05 de marzo", "Caqueta compra para modelo botin"),
        RegistroDeComprasDTO(1111, "08 de enero", "Caqueta compra para modelo botin ")
    )
}

fun generateListaDeCompraItems(): List<listaDeComprasDTO> {
    return listOf(
        listaDeComprasDTO(1, "CUERO", true),
        listaDeComprasDTO(3, "BADANA", false),

    )
}