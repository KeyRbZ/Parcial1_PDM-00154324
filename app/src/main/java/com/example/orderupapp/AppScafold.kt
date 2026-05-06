package com.example.orderupapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.orderupapp.ui.theme.OrderUpAppTheme

@Composable
fun AppScaffold() {
    OrderUpAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            MainNavigation()
        }
    }
}