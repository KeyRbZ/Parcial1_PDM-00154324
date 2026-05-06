package com.example.orderupapp.screen

import com.example.orderupapp.model.Producto

data class OrderItem(
    val producto: Producto,
    val cantidad: Int
)