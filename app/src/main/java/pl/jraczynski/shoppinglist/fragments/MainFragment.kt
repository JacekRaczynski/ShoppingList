package pl.jraczynski.shoppinglist.fragments

import android.Manifest
import android.app.AlertDialog
import android.hardware.usb.UsbRequest
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions
import pl.jraczynski.shoppinglist.CaptureAct
import pl.jraczynski.shoppinglist.R
import pl.jraczynski.shoppinglist.activities.MainActivity
import pl.jraczynski.shoppinglist.adapters.ProductAdapter
import pl.jraczynski.shoppinglist.databinding.FragmentMainBinding
import pl.jraczynski.shoppinglist.viewModels.ProductViewModel
import pl.jraczynski.shoppinglist.viewModels.UserViewModel
import java.util.*


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
        val adapter = ProductAdapter((activity as MainActivity).temporaryListOfProducts(),binding.shoppingModeSwitch)
        binding.productListRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.productListRecyclerView.adapter = adapter
        setupAddProduct()
        userViewModel.user.observe(viewLifecycleOwner) { user ->
       }
    }

    fun setupAddProduct(){
        binding.scanProductButton.setOnClickListener {
            cameraPermissionRequest()
        }

    }


}