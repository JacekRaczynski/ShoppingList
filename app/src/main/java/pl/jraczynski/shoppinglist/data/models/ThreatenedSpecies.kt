package pl.jraczynski.shoppinglist.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ThreatenedSpecies(
    @Json(name = "ingredient")
    val ingredient: String?,
    @Json(name = "value")
    val value: Int?
)