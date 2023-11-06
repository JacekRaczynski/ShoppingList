package pl.jraczynski.shoppinglist.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Switch
import androidx.recyclerview.widget.RecyclerView
import pl.jraczynski.shoppinglist.data.Categories
import pl.jraczynski.shoppinglist.data.Item
import pl.jraczynski.shoppinglist.databinding.ProductRowBinding

import pl.jraczynski.shoppinglist.viewHolders.ProductViewHolder

class ProductAdapter(private val products: List<Item>, private val view: Switch) :
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
        holder.titleProduct.text = products[position].name
        holder.amountProduct.text = products[position].amount.toString()
        products[position].categories?.let{ it ->
            holder.setChipForCategory(Categories.byCategoryNameOrNull(it.get(0).name))} //TODO
      //  holder.itemView = products[position].category
    }
}

