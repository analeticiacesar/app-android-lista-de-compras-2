package com.analeticiacesar.listadecompras.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.analeticiacesar.listadecompras.databinding.ImageFormBinding
import com.analeticiacesar.listadecompras.extensions.loadImage

class ImageFormDialog(private val context: Context) {
    fun showDialog() {
        val bindingImageForm = ImageFormBinding.inflate(LayoutInflater.from(context))
        bindingImageForm.buttonLoad.setOnClickListener {
            val url = bindingImageForm.editTextUrl.text.toString()
            bindingImageForm.imageItem.loadImage(url)
        }
        AlertDialog.Builder(context)
            .setView(bindingImageForm.root)
            .setPositiveButton("Confirmar") { _, _ ->
//                binding.imageItem.loadImage(url)

            }
            .setNegativeButton("Cancelar") { _, _ ->

            }
            .show()
    }
}