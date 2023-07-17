package com.analeticiacesar.listadecompras.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.analeticiacesar.listadecompras.databinding.ActivityProductDetailsBinding
import com.analeticiacesar.listadecompras.extensions.formatForBrazilianCurrency
import com.analeticiacesar.listadecompras.extensions.loadImage
import com.analeticiacesar.listadecompras.model.Product

class ProductDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityProductDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadProduct()
    }

    private fun loadProduct() {
        intent.getParcelableExtra<Product>(CHAVE_PRODUTO)?.let { product ->
            fillFields(product)
        } ?: finish()
    }

    private fun fillFields(product: Product) {
        with(binding){
            imageProduct.loadImage(product.image)
            textViewProductName.text = product.name
            textViewProductDescription.text = product.description
            textViewProductValue.text = product.value.formatForBrazilianCurrency()
        }
    }
}