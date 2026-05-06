package com.example.orderupapp

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes {
    @Serializable
    data object Menu : Routes()

    @Serializable
    data object Orden : Routes()
}