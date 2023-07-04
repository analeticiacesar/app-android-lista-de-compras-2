package com.analeticiacesar.listadecompras.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.analeticiacesar.listadecompras.databinding.ItemProductBinding
import com.analeticiacesar.listadecompras.model.Product

class ItemProductAdapter (
    private val context: Context,
    private val items: List<Product>
        ) : RecyclerView.Adapter<ItemProductAdapter.ViewHolder>() {

    class ViewHolder(binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        private val name = binding.textName
        private val description = binding.textDescription
        private val price = binding.textPrice

        fun bind(item: Product) {
            name.text = item.name
            description.text = item.description
            price.text = item.value.toPlainString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount() = items.size

}
