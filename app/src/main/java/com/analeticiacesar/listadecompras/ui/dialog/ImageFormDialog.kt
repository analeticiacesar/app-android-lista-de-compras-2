package com.analeticiacesar.listadecompras.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.analeticiacesar.listadecompras.databinding.ImageFormBinding
import com.analeticiacesar.listadecompras.extensions.loadImage

class ImageFormDialog(private val context: Context) {
    fun showDialog(urlPadrao: String? = null, whenLoadImage: (image: String) -> Unit) {
        val binding = ImageFormBinding.inflate(LayoutInflater.from(context))
        urlPadrao?.let {
            binding.imageItem.loadImage(it)
            binding.editTextUrl.setText(it)
        }
        binding.buttonLoad.setOnClickListener {
            val url = binding.editTextUrl.text.toString()
            binding.imageItem.loadImage(url)
        }
        AlertDialog.Builder(context)
            .setView(binding.root)
            .setPositiveButton("Confirmar") { _, _ ->
                val url = binding.editTextUrl.text.toString()
                whenLoadImage(url)
            }
            .setNegativeButton("Cancelar") { _, _ ->

            }
            .show()
    }
}