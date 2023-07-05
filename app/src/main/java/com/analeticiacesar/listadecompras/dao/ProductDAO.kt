package com.analeticiacesar.listadecompras.dao

import com.analeticiacesar.listadecompras.model.Product

class ProductDAO {
    companion object {
        private val products = mutableListOf<Product>()
    }

    fun add(product: Product){
        products.add(product)
    }

    fun searchAll() : List<Product> {
        return products.toList()
    }

}