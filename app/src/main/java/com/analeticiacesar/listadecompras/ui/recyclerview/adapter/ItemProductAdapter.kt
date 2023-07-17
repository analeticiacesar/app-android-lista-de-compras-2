package com.analeticiacesar.listadecompras.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.analeticiacesar.listadecompras.databinding.ItemProductBinding
import com.analeticiacesar.listadecompras.extensions.formatForBrazilianCurrency
import com.analeticiacesar.listadecompras.extensions.loadImage
import com.analeticiacesar.listadecompras.model.Product
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

class ItemProductAdapter(
    private val context: Context,
    items: List<Product>,
    var whenClicksOnItem: (produto: Product) -> Unit = { }
) : RecyclerView.Adapter<ItemProductAdapter.ViewHolder>() {

    private val products = items.toMutableList()

    inner class ViewHolder(binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        private lateinit var product: Product

        init {
            itemView.setOnClickListener {
                if(::product.isInitialized) {
                    whenClicksOnItem(product)
                }
            }
        }

        private val name = binding.textName
        private val description = binding.textDescription
        private val price = binding.textPrice
        private val image = binding.imageItem

        fun bind(item: Product) {
            product = item
            name.text = item.name
            description.text = item.description
            price.text = item.value.formatForBrazilianCurrency()
            if (item.image == null) {
                image.visibility = View.GONE
            } else {
                image.loadImage(item.image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = products[position]
        holder.bind(item)
    }

    override fun getItemCount() = products.size

    fun update(products: List<Product>) {
        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }

}
