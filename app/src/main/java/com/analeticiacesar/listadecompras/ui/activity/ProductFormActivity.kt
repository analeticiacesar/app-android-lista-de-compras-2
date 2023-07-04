package com.analeticiacesar.listadecompras.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.analeticiacesar.listadecompras.databinding.ActivityProductFormBinding

class ProductFormActivity : AppCompatActivity() {
    lateinit var binding: ActivityProductFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}