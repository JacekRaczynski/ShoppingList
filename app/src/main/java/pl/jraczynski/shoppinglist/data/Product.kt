package pl.jraczynski.shoppinglist.data

import pl.jraczynski.shoppinglist.data.models.Product
import java.util.*

data class Product(
    val uid: String? = null,
    val name: String? = null,
    val image: String? = null,
    val date: Date? = null,
    val categories: Categories? = null,
    val author: User? = null,
    val amount: Int? = null
)
