package pl.jraczynski.shoppinglist.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PreviousData(
    @Json(name = "agribalyse")
    val agribalyse: AgribalyseX?,
    @Json(name = "grade")
    val grade: String?,
    @Json(name = "score")
    val score: Int?
)