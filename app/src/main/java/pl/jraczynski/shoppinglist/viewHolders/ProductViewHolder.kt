package pl.jraczynski.shoppinglist.viewHolders

import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.core.content.ContentProviderCompat
import androidx.core.content.ContextCompat
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.chip.Chip
import pl.jraczynski.shoppinglist.R
import pl.jraczynski.shoppinglist.data.Categories
import pl.jraczynski.shoppinglist.databinding.ProductRowBinding

class ProductViewHolder(binding: ProductRowBinding, private val view: View) : ViewHolder(binding.root) {
    val titleProduct = binding.title
    val amountProduct = binding.amount
    val imageProduct = binding.image
    val categoryChip = binding.chip
    val remove = binding.remove


    fun setChipForCategory(category: Categories?) {
        when (category) {
            Categories.sporting_goods -> {
                categoryChip.chipIcon = ContextCompat.getDrawable(
                    view.context,
                    R.drawable.sport_icon
                )
                categoryChip.setChipBackgroundColorResource(R.color.blue)
            }
            Categories.health_beauty -> {
                categoryChip.chipIcon = ContextCompat.getDrawable(
                    view.context,
                    R.drawable.health_beauty_icon
                )
                categoryChip.setChipBackgroundColorResource(R.color.pink)

            }
            Categories.home_garden -> {
                categoryChip.chipIcon = ContextCompat.getDrawable(
                    view.context,
                    R.drawable.home_garden_icon
                )
                categoryChip.setChipBackgroundColorResource(R.color.green)

            }
            else -> {
                categoryChip.chipIcon = ContextCompat.getDrawable(
                    view.context,
                    R.drawable.food_icon
                )
                categoryChip.setChipBackgroundColorResource(R.color.beige)
            }

        }
    }
}
