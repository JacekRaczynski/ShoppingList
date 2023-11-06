package pl.jraczynski.shoppinglist.data


data class User(
    val email: String? = null,
    val name: String? = null,
    val team: Team? =null,
    val uid: String? = null,
    val listofProducts: ShoppingList? = null
)
