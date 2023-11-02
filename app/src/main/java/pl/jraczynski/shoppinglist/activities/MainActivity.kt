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
import pl.jraczynski.shoppinglist.R
import pl.jraczynski.shoppinglist.adapters.ProductAdapter
import pl.jraczynski.shoppinglist.data.Categories
import pl.jraczynski.shoppinglist.data.Item
import pl.jraczynski.shoppinglist.databinding.ActivityMainBinding
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
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_main) as NavHostFragment
        navController = navHostFragment.findNavController()
        setupActionBarWithNavController(navController)

        foodViewModel.performFetchSingleFoodProduct(id = 3017624010701)
        foodViewModel.getFoodProduct().observe(this) { it ->
            Log.d("PROCESS_D", it.toString())
        }


    }
    fun temporaryListOfProducts() : List<Item>{
        val products = ArrayList<Item>()
        products.add(Item(
            id = "12312",
            title = "Ser",
            amount = 2,
            image = "PL.jpg",
            category = Categories.home_garden.toString(),
            authorId = "1231",
            date = Date()

        ))
                products.add(Item(
            id = "1233",
            title = "Szynka",
            amount = 3,
            image = "PL.jpg",
            category = Categories.health_beauty.toString(),
            authorId = "1231",
            date = Date()

        )

        )
        products.add(Item(
            id = "12312",
            title = "Ser",
            amount = 2,
            image = "PL.jpg",
            category = Categories.food.toString(),
            authorId = "1231",
            date = Date()

        ))
        products.add(Item(
            id = "1233",
            title = "Szynka",
            amount = 3,
            image = "PL.jpg",
            category = Categories.sporting_goods.toString(),
            authorId = "1231",
            date = Date()

        )

        )
        products.add(Item(
            id = "12312",
            title = "Ser",
            amount = 2,
            image = "PL.jpg",
            category = Categories.food.toString(),
            authorId = "1231",
            date = Date()

        ))
        products.add(Item(
            id = "1233",
            title = "Szynka",
            amount = 3,
            image = "PL.jpg",
            category = "Spożywcze",
            authorId = "1231",
            date = Date()

        )

        )

        products.add(Item(
            id = "1233",
            title = "Szynka",
            amount = 3,
            image = "PL.jpg",
            category = "Spożywcze",
            authorId = "1231",
            date = Date()

        )

        )
        products.add(Item(
            id = "1233",
            title = "Szynka",
            amount = 3,
            image = "PL.jpg",
            category = "Spożywcze",
            authorId = "1231",
            date = Date()

        )

        )
        products.add(Item(
            id = "1233",
            title = "Szynka",
            amount = 3,
            image = "PL.jpg",
            category = "Spożywcze",
            authorId = "1231",
            date = Date()

        )

        )
        products.add(Item(
            id = "12312",
            title = "Ser",
            amount = 2,
            image = "PL.jpg",
            category = "Spożywcze",
            authorId = "1231",
            date = Date()

        ))
        products.add(Item(
            id = "1233",
            title = "Szynka",
            amount = 3,
            image = "PL.jpg",
            category = "Spożywcze",
            authorId = "1231",
            date = Date()

        )

        )
        return products

    }

}