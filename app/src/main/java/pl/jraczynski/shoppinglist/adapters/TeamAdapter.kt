package pl.jraczynski.shoppinglist.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.jraczynski.shoppinglist.databinding.MemberRowBinding
import pl.jraczynski.shoppinglist.viewHolders.MemberViewHolder


class TeamAdapter(private val user: List<Pair<String,String>>) :
    RecyclerView.Adapter<MemberViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val memberViewHolder = MemberRowBinding.inflate(inflater, parent, false)
        return MemberViewHolder(memberViewHolder,parent)
    }

    override fun getItemCount(): Int {
        return user.size
    }

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        holder.userName.text = user[position].second

    }
}

