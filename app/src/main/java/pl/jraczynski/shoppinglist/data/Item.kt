package pl.jraczynski.shoppinglist.data

import com.google.firebase.Timestamp
import java.util.Date

data class Item(
    val uid: String? = null,
    val name: String? = null,
    val productData: String? = null,
    val amount: Int? = null,
    val image: String? = null,
    val categories: List<Categories>? = null,
    val authorId: String? = null,
    val date: Timestamp?= null,
) :java.io.Serializable
