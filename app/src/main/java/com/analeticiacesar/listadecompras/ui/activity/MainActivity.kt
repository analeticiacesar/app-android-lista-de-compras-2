package com.analeticiacesar.listadecompras.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.analeticiacesar.listadecompras.dao.ProductDAO
import com.analeticiacesar.listadecompras.databinding.ActivityMainBinding
import com.analeticiacesar.listadecompras.model.Product
import com.analeticiacesar.listadecompras.ui.recyclerview.adapter.ItemProductAdapter

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dao = ProductDAO()
        binding.recyclerView.adapter = ItemProductAdapter(
            this,
            dao.searchAll()
        )
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, ProductFormActivity::class.java)
            startActivity(intent)
        }
    }
}