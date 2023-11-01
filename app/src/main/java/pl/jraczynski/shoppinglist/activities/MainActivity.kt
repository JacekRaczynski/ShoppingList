package pl.jraczynski.shoppinglist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.recyclerview.widget.LinearLayoutManager
import pl.jraczynski.shoppinglist.R
import pl.jraczynski.shoppinglist.adapters.ProductAdapter
import pl.jraczynski.shoppinglist.data.Categories
import pl.jraczynski.shoppinglist.data.Product
import pl.jraczynski.shoppinglist.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = ProductAdapter(temporaryListOfProducts(),binding.shoppingModeSwitch)
        binding.productListRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.productListRecyclerView.adapter = adapter


    }
    fun temporaryListOfProducts() : List<Product>{
        val products = ArrayList<Product>()
        products.add(Product(
            id = "12312",
            title = "Ser",
            amount = 2,
            image = "PL.jpg",
            category = Categories.home_garden.toString(),
            authorId = "1231",
            date = Date()

        ))
                products.add(Product(
            id = "1233",
            title = "Szynka",
            amount = 3,
            image = "PL.jpg",
            category = Categories.health_beauty.toString(),
            authorId = "1231",
            date = Date()

        )

        )
        products.add(Product(
            id = "12312",
            title = "Ser",
            amount = 2,
            image = "PL.jpg",
            category = Categories.food.toString(),
            authorId = "1231",
            date = Date()

        ))
        products.add(Product(
            id = "1233",
            title = "Szynka",
            amount = 3,
            image = "PL.jpg",
            category = Categories.sporting_goods.toString(),
            authorId = "1231",
            date = Date()

        )

        )
        products.add(Product(
            id = "12312",
            title = "Ser",
            amount = 2,
            image = "PL.jpg",
            category = Categories.food.toString(),
            authorId = "1231",
            date = Date()

        ))
        products.add(Product(
            id = "1233",
            title = "Szynka",
            amount = 3,
            image = "PL.jpg",
            category = "Spożywcze",
            authorId = "1231",
            date = Date()

        )

        )

        products.add(Product(
            id = "1233",
            title = "Szynka",
            amount = 3,
            image = "PL.jpg",
            category = "Spożywcze",
            authorId = "1231",
            date = Date()

        )

        )
        products.add(Product(
            id = "1233",
            title = "Szynka",
            amount = 3,
            image = "PL.jpg",
            category = "Spożywcze",
            authorId = "1231",
            date = Date()

        )

        )
        products.add(Product(
            id = "1233",
            title = "Szynka",
            amount = 3,
            image = "PL.jpg",
            category = "Spożywcze",
            authorId = "1231",
            date = Date()

        )

        )
        products.add(Product(
            id = "12312",
            title = "Ser",
            amount = 2,
            image = "PL.jpg",
            category = "Spożywcze",
            authorId = "1231",
            date = Date()

        ))
        products.add(Product(
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