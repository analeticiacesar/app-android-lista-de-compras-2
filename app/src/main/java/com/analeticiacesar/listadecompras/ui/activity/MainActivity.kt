package com.analeticiacesar.listadecompras.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.analeticiacesar.listadecompras.databinding.ActivityMainBinding
import com.analeticiacesar.listadecompras.model.Product
import com.analeticiacesar.listadecompras.ui.recyclerview.adapter.ItemProductAdapter

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.recyclerView.adapter = ItemProductAdapter(
            this,
            listOf(Product("Cesta de Fruta", "Laranja, maçã, uva", "100.00".toBigDecimal()))
        )
        setContentView(binding.root)
    }
}