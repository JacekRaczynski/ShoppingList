package pl.jraczynski.shoppinglist.data

data class Team(
    val name: String? = null,
    val admin: String? = null,
    val uid: String? = null,
    val members: List<String>? = null,
    val listofProducts: Object? = null
)
