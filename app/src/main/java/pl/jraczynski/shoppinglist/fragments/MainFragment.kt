package pl.jraczynski.shoppinglist.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager

import pl.jraczynski.shoppinglist.R
import pl.jraczynski.shoppinglist.adapters.ProductAdapter
import pl.jraczynski.shoppinglist.data.Item
import pl.jraczynski.shoppinglist.databinding.FragmentMainBinding
import pl.jraczynski.shoppinglist.viewModels.ProductViewModel
import pl.jraczynski.shoppinglist.viewModels.UserViewModel


class MainFragment : BaseFragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    private val productViewModel by viewModels<ProductViewModel>()
    private val userViewModel by viewModels<UserViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var userItemList : List<Item> = listOf()
        var teamItemList : List<Item> = listOf()
        userViewModel.user.observe(viewLifecycleOwner) { user ->
            user.listofProducts?.list?.let {
                userItemList = it
                val adapter = ProductAdapter(it, binding.shoppingModeSwitch)
                binding.privateProductListRecyclerView.layoutManager = LinearLayoutManager(context)
                binding.privateProductListRecyclerView.adapter = adapter
                setupShoppingMode(userItemList,teamItemList)
            }
            user.team?.listofProducts?.list?.let {
                teamItemList = it
                val adapter = ProductAdapter(it, binding.shoppingModeSwitch)
                binding.teamProductListRecyclerView.layoutManager = LinearLayoutManager(context)
                binding.teamProductListRecyclerView.adapter = adapter
                setupShoppingMode(userItemList,teamItemList)

            }
        }

        setupShoppingMode(userItemList,teamItemList)
        setupAddProduct()

        userViewModel.user.observe(viewLifecycleOwner) { user ->
            Log.d("DDDDDDDDDDDDDDDDDDDDDD11111DDDDDD", user.toString())
       }
    }

    fun setupAddProduct(){
        binding.scanProductButton.setOnClickListener {
            cameraPermissionRequest()
        }


    }
    fun setupShoppingMode(privateItemList: List<Item>,teamItemList: List<Item>) {
        binding.shoppingModeSwitch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            privateItemList?.forEach {
                val position = privateItemList.indexOf(it)
                val viewHolder = binding.privateProductListRecyclerView.findViewHolderForAdapterPosition(position)
                val itemLayout = viewHolder?.itemView?.findViewById<LinearLayout>(R.id.remove)
                if (isChecked) {
                    itemLayout?.visibility = View.VISIBLE

                } else {
                    itemLayout?.visibility = View.GONE
                }
            }
            teamItemList?.forEach {
                val position = teamItemList.indexOf(it)
                val viewHolder = binding.teamProductListRecyclerView.findViewHolderForAdapterPosition(position)
                val itemLayout = viewHolder?.itemView?.findViewById<LinearLayout>(R.id.remove)
                if (isChecked) {
                    itemLayout?.visibility = View.VISIBLE

                } else {
                    itemLayout?.visibility = View.GONE
                }
            }
        })
    }

}