package com.example.orderupapp.model

const val pupusaImg = "https://comedera.com/wp-content/uploads/sites/9/2023/05/Pupusas-de-queso-shutterstock_1803502444.jpg"
const val cafeImg = "https://i.blogs.es/139e0f/cafe-americano2/840_560.jpeg"
const val chocoImg = "https://cocinaconcoqui.com/wp-content/uploads/2025/12/chocolate-caliente-casero-500x500.jpg"
const val cocaImg = "https://d23esi1h40dfmi.cloudfront.net/wp-content/uploads/2025/08/01124509/00732.jpg"

data class Producto(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val imagenUrl: String,
    val tipo: TipoProducto
)

val menuProductos = listOf(
    Producto(1, "Pupusa de queso", 0.75, pupusaImg, TipoProducto.PUPUSA),
    Producto(2, "Pupusa de frijol con queso", 0.75, pupusaImg, TipoProducto.PUPUSA),
    Producto(3, "Pupusa revuelta", 1.00, pupusaImg, TipoProducto.PUPUSA),
    Producto(4, "Pupusa de chicharrón", 1.00, pupusaImg, TipoProducto.PUPUSA),
    Producto(5, "Pupusa de loroco con queso", 1.00, pupusaImg, TipoProducto.PUPUSA),
    Producto(6, "Pupusa de ayote", 0.75, pupusaImg, TipoProducto.PUPUSA),
    Producto(7, "Pupusa de espinaca", 0.85, pupusaImg, TipoProducto.PUPUSA),
    Producto(8, "Pupusa de jalapeño con queso", 1.00, pupusaImg, TipoProducto.PUPUSA),
    Producto(9, "Café", 1.00, cafeImg, TipoProducto.BEBIDA),
    Producto(10, "Chocolate caliente", 1.50, chocoImg, TipoProducto.BEBIDA),
    Producto(11, "Coca-Cola", 1.25, cocaImg, TipoProducto.BEBIDA)
)