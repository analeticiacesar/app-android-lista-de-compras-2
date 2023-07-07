package com.analeticiacesar.listadecompras.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.analeticiacesar.listadecompras.R
import com.analeticiacesar.listadecompras.dao.ProductDAO
import com.analeticiacesar.listadecompras.databinding.ActivityProductFormBinding
import com.analeticiacesar.listadecompras.databinding.ImageFormBinding
import com.analeticiacesar.listadecompras.model.Product

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
            val bindingImageForm = ImageFormBinding.inflate(layoutInflater)
            bindingImageForm.buttonLoad.setOnClickListener {
                url = bindingImageForm.editTextUrl.text.toString()
                bindingImageForm.imageItem.load(url)
            }
            AlertDialog.Builder(this)
                .setView(bindingImageForm.root)
                .setPositiveButton("Confirmar") { _, _ ->
                    binding.imageItem.load(url)

                }
                .setNegativeButton("Cancelar") { _, _ ->
                    url = null
                }
                .show()
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