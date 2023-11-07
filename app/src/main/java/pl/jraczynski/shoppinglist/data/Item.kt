package pl.jraczynski.shoppinglist.data

import pl.jraczynski.shoppinglist.data.models.Product
import java.util.Date

data class Item(
    val uid: String? = null,
    val name: String? = null,
    val productData: String? = null,
    val amount: Int? = null,
    val image: String? = null,
    val categories: List<Categories>? = null,
    val authorId: String? = null,
    val date: String?
) :java.io.Serializable
