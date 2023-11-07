package pl.jraczynski.shoppinglist.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import pl.jraczynski.shoppinglist.databinding.MemberRowBinding

class MemberViewHolder(binding: MemberRowBinding, private val view: View) : ViewHolder(binding.root) {
    val userName = binding.userName
}