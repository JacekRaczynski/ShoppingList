package pl.jraczynski.shoppinglist.data

import java.util.Date

data class Item(
    val id: String,
    val title: String,
    val amount: Int,
    val image: String,
    val category: String,
    val authorId: String,
    val date: Date
)
