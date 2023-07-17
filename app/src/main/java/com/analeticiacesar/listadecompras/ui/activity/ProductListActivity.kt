package com.analeticiacesar.listadecompras.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.analeticiacesar.listadecompras.dao.ProductDAO
import com.analeticiacesar.listadecompras.databinding.ActivityProductListBinding
import com.analeticiacesar.listadecompras.ui.recyclerview.adapter.ItemProductAdapter

class ProductListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductListBinding
    private val dao = ProductDAO()
    private val adapter = ItemProductAdapter(context = this, items = dao.searchAll())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.searchAll())
        setupFloatingActionButton()
    }

    private fun setupFloatingActionButton() {
        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, ProductFormActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = adapter
        adapter.whenClicksOnItem = {
            val intent = Intent(this, ProductDetailsActivity::class.java).apply {
                putExtra(CHAVE_PRODUTO, it)
            }
            startActivity(intent)
        }
    }
}