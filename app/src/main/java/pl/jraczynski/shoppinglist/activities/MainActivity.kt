package pl.jraczynski.shoppinglist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.content.PermissionChecker
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.stateIn
import android.Manifest
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationBarView
import pl.jraczynski.shoppinglist.R
import pl.jraczynski.shoppinglist.adapters.ProductAdapter
import pl.jraczynski.shoppinglist.data.Categories
import pl.jraczynski.shoppinglist.data.Item
import pl.jraczynski.shoppinglist.databinding.ActivityMainBinding
import pl.jraczynski.shoppinglist.fragments.*
import pl.jraczynski.shoppinglist.viewModels.FoodViewModel
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    private val foodViewModel by viewModels<FoodViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navController = navHostFragment.findNavController()
        setupActionBarWithNavController(navController)
        setUpBottomNav()

        foodViewModel.performFetchSingleFoodProduct(id = 3017624010701)
        foodViewModel.getFoodProduct().observe(this) { it ->
            Log.d("PROCESS_D", it.toString())
        }


    }
    fun setUpBottomNav() {
        binding.bottomNavigation.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.mainFragment -> {
                    if (navController.currentDestination?.id != R.id.mainFragment) {
                        navController.navigate(R.id.mainFragment)
                    }
                    return@OnItemSelectedListener true
                }
                R.id.profileFragment -> {
                    if (navController.currentDestination?.id != R.id.profileFragment) {
                        navController.navigate(R.id.profileFragment)
                    }
                    return@OnItemSelectedListener true
                }
                R.id.iconScanFragment -> {
                    navHostFragment?.let { navFragment ->
                        navFragment.childFragmentManager.primaryNavigationFragment?.let { fragment ->
                            (fragment as BaseFragment).cameraPermissionRequest()
                        }
                    }
                    return@OnItemSelectedListener true
                }

                else -> {
                    return@OnItemSelectedListener true
                }
            }
        }
        )
    }

}