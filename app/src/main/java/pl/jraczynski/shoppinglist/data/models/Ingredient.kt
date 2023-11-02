package pl.jraczynski.shoppinglist.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Ingredient(
    @Json(name = "from_palm_oil")
    val fromPalmOil: String?,
    @Json(name = "id")
    val id: String?,
    @Json(name = "percent_estimate")
    val percentEstimate: Double?,
    @Json(name = "percent_max")
    val percentMax: Double?,
    @Json(name = "percent_min")
    val percentMin: Double?,
    @Json(name = "text")
    val text: String?,
    @Json(name = "vegan")
    val vegan: String?,
    @Json(name = "vegetarian")
    val vegetarian: String?
)