package com.analeticiacesar.listadecompras.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.analeticiacesar.listadecompras.databinding.ActivityProductDetailsBinding

class ProductDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityProductDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}