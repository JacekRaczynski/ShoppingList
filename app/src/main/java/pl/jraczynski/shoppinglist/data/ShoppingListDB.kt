package pl.jraczynski.shoppinglist.data

import com.google.firebase.firestore.DocumentReference


data class ShoppingListDB(
    val uid: String? = null,
    val products: ArrayList<DocumentReference>? = null,
)
