package pl.jraczynski.shoppinglist.data

import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentReference
import pl.jraczynski.shoppinglist.data.models.Product
import java.util.*

data class ProductDB(
    val uid: String? = null,
    val name: String? = null,
    val image: String? = null,
    val productData: String? = null,
    val date: Timestamp? = null,
    val categories: ArrayList<DocumentReference>? = null,
    val author: String? = null,
    val amount: Int? = null
)
