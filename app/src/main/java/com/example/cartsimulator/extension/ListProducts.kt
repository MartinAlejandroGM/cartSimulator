package com.example.cartsimulator.extension

import com.example.cartsimulator.models.Product

fun initProducts(): ArrayList<Product> {
    val productList = ArrayList<Product>()
    return productList.apply {
        add(Product("Xbox", 5000))
        add(Product("PS5", 5000))
        add(Product("Switch", 5000))
        add(Product("PC", 5000))
    }

}
