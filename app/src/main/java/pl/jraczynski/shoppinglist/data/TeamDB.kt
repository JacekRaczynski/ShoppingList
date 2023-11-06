package pl.jraczynski.shoppinglist.data

import com.google.firebase.firestore.DocumentReference

data class TeamDB(
    val name: String? = null,
    val admin: String? = null,
    val uid: String? = null,
    val members: List<String>? = null,
    val listofProducts: DocumentReference? = null
)
