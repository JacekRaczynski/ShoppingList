package pl.jraczynski.shoppinglist.fragments

import android.Manifest
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.viewModels
import androidx.core.content.PermissionChecker
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions
import pl.jraczynski.shoppinglist.CaptureAct
import pl.jraczynski.shoppinglist.R
import pl.jraczynski.shoppinglist.activities.MainActivity
import pl.jraczynski.shoppinglist.adapters.ProductAdapter
import pl.jraczynski.shoppinglist.data.Categories
import pl.jraczynski.shoppinglist.data.Item
import pl.jraczynski.shoppinglist.databinding.ActivityMainBinding
import pl.jraczynski.shoppinglist.databinding.FragmentMainBinding
import pl.jraczynski.shoppinglist.viewModels.FoodViewModel
import java.util.*
import kotlin.collections.ArrayList


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    val CAMERA_PERMISSION_REQUEST_CODE :Int = 3;
    private val foodViewModel by viewModels<FoodViewModel>()
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
    }

    fun setupAddProduct(){
        binding.scanProductButton.setOnClickListener {
            cameraPermissionRequest()
        }

    }
    fun cameraPermissionRequest() {
        if(!checkCameraPermission()){
            requestPermissions(arrayOf(Manifest.permission.CAMERA),
                CAMERA_PERMISSION_REQUEST_CODE);
        } else {
            scanCode()
        }
    }
    private fun checkCameraPermission(): Boolean{
        return context?.let {
            PermissionChecker.checkSelfPermission(
                it,
                Manifest.permission.CAMERA)
        } == PermissionChecker.PERMISSION_GRANTED
    }
    private fun scanCode(){
        val options: ScanOptions = ScanOptions()
        options.setPrompt("Volume up to flash on")
        options.setBeepEnabled(true)
        options.setBeepEnabled(true)
        options.setOrientationLocked(true)
        options.setCaptureActivity(CaptureAct::class.java)
        barLaucher.launch(options)
    }

    var barLaucher: ActivityResultLauncher<ScanOptions> = registerForActivityResult(
        ScanContract(),
        ActivityResultCallback {
                result -> if(result.contents != null){
            var builder: AlertDialog.Builder = AlertDialog.Builder(activity)
            builder.setTitle("result");
            builder.setMessage(result.contents)
            builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.dismiss()
            }).show()
        }

        })


}