package pl.jraczynski.shoppinglist.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NutrientLevels(
    @Json(name = "fat")
    val fat: String?,
    @Json(name = "salt")
    val salt: String?,
    @Json(name = "saturated-fat")
    val saturatedFat: String?,
    @Json(name = "sugars")
    val sugars: String?
)