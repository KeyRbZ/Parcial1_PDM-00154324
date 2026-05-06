package com.example.orderupapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.orderupapp.model.Producto

@Composable
fun PedidoItem(
    producto: Producto,
    cantidad: Int,
    onEliminar: () -> Unit
) {
    val subtotal = producto.precio * cantidad

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = producto.nombre)
                Text(text = "Cantidad: $cantidad x $${producto.precio}")
                Text(text = "Subtotal: $${subtotal}")
            }

            androidx.compose.material3.Button(
                onClick = onEliminar
            ) {
                Text("Eliminar")
            }
        }
    }
}