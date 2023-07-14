package com.analeticiacesar.listadecompras.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.analeticiacesar.listadecompras.dao.ProductDAO
import com.analeticiacesar.listadecompras.databinding.ActivityProductFormBinding
import com.analeticiacesar.listadecompras.extensions.loadImage
import com.analeticiacesar.listadecompras.model.Product
import com.analeticiacesar.listadecompras.ui.dialog.ImageFormDialog

class ProductFormActivity : AppCompatActivity() {
    lateinit var binding: ActivityProductFormBinding
    private var url: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupClickImage()
        setupSaveButton()
    }

    private fun setupClickImage() {
        binding.imageItem.setOnClickListener {
            ImageFormDialog(this).showDialog (url) { imageUrl ->
                url = imageUrl
                binding.imageItem.loadImage(url)
            }
        }
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
        binding.editTextValue.text.toString().toBigDecimal(),
        url
    )
}