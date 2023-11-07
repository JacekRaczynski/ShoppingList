package pl.jraczynski.shoppinglist.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import pl.jraczynski.shoppinglist.R
import pl.jraczynski.shoppinglist.activities.MainActivity
import pl.jraczynski.shoppinglist.databinding.FragmentAddItemBinding


class AddItemFragment : BaseFragment() {
    private lateinit var binding: FragmentAddItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddItemBinding.inflate(layoutInflater)
        val view = binding.root

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).userViewModel.getCurrentItem().observe(viewLifecycleOwner) { item ->
             if(item!=null) {
                 binding.itemInformationTitle.text = getString(R.string.itemExists)
                 binding.amount.text = item!!.amount?.toString()

            binding.decreaseAmount.setOnClickListener { it ->
                if (Integer.parseInt( binding.amount.text.toString()) > 0) {
                    binding.amount.text = (Integer.parseInt( binding.amount.text.toString()) - 1).toString()
                }
            }
            binding.increaseAmount.setOnClickListener { it ->
                    binding.amount.text = (Integer.parseInt( binding.amount.text.toString()) + 1).toString()
            }
            binding.nameItem.text = item.name
            binding.dateItem.text = item.date.toString()
                 var categories :String = ""
                 item.categories?.forEach {category ->  categories = categories + " " + category.name }
            binding.categoriesItem.text = categories
                 binding.detailJSON.text = item.productData
                 binding.updateButton.setOnClickListener {
                     (activity as MainActivity).foodViewModel.updateItemAmount(item,Integer.parseInt( binding.amount.text.toString()))
                    findNavController().popBackStack()
                 }
         }
        }

    }

}