package com.analeticiacesar.listadecompras.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.analeticiacesar.listadecompras.dao.ProductDAO
import com.analeticiacesar.listadecompras.databinding.ActivityProductFormBinding
import com.analeticiacesar.listadecompras.model.Product

class ProductFormActivity : AppCompatActivity() {
    lateinit var binding: ActivityProductFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductFormBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonSave.setOnClickListener {
            binding.run {
                val newProduct = Product(
                    textName.text.toString(),
                    textDescription.text.toString(),
                    textPrice.text.toString().toBigDecimal()
                )
                val dao = ProductDAO()
                dao.add(newProduct)
            }
        }
    }
}