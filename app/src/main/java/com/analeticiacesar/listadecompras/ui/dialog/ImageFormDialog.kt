package com.analeticiacesar.listadecompras.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import coil.load
import com.analeticiacesar.listadecompras.databinding.ImageFormBinding

class ImageFormDialog(private val context: Context) {
    fun showDialog() {
        val bindingImageForm = ImageFormBinding.inflate(LayoutInflater.from(context))
        bindingImageForm.buttonLoad.setOnClickListener {
            val url = bindingImageForm.editTextUrl.text.toString()
            bindingImageForm.imageItem.load(url)
        }
        AlertDialog.Builder(context)
            .setView(bindingImageForm.root)
            .setPositiveButton("Confirmar") { _, _ ->
//                binding.imageItem.load(url)

            }
            .setNegativeButton("Cancelar") { _, _ ->

            }
            .show()
    }
}