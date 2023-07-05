package com.analeticiacesar.listadecompras.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.analeticiacesar.listadecompras.dao.ProductDAO
import com.analeticiacesar.listadecompras.databinding.ActivityProductListBinding
import com.analeticiacesar.listadecompras.ui.recyclerview.adapter.ItemProductAdapter

class ProductListActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityProductListBinding.inflate(layoutInflater)
    }

    override fun onResume() {
        super.onResume()
        setContentView(binding.root)
        val dao = ProductDAO()
        binding.recyclerView.adapter = ItemProductAdapter(
            context = this,
            items = dao.searchAll()
        )
        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, ProductFormActivity::class.java)
            startActivity(intent)
        }
    }
}