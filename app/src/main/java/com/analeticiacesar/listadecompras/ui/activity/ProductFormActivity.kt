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
        setupSaveButton()
    }

    private fun setupSaveButton() {
        binding.buttonSave.setOnClickListener {
            val dao = ProductDAO()
            dao.add(createProduct())
            finish()
        }
    }

    private fun createProduct() = Product(
        binding.editTextName.text.toString(),
        binding.editTextDescription.text.toString(),
        binding.editTextValue.text.toString().toBigDecimal()
    )
}