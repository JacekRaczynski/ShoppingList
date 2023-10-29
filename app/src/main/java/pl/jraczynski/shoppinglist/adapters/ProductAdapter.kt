package pl.jraczynski.shoppinglist.adapters

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import pl.jraczynski.shoppinglist.R
import pl.jraczynski.shoppinglist.data.Categories
import pl.jraczynski.shoppinglist.data.Product
import pl.jraczynski.shoppinglist.databinding.ProductRowBinding

import pl.jraczynski.shoppinglist.viewHolders.ProductViewHolder

class ProductAdapter(private val products: List<Product>) :
    RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val productRowBinding = ProductRowBinding.inflate(inflater, parent, false)
        return ProductViewHolder(productRowBinding,parent)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.titleProduct.text = products[position].title
        holder.amountProduct.text = products[position].amount.toString()
        products[position].category?.let{ it ->
            holder.setChipForCategory(Categories.byCategoryNameOrNull(it))}
      //  holder.itemView = products[position].category
    }
}

