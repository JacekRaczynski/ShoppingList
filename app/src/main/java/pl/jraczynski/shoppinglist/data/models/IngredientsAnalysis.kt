package pl.jraczynski.shoppinglist.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IngredientsAnalysis(
    @Json(name = "en:non-vegan")
    val enNonVegan: List<String?>?,
    @Json(name = "en:palm-oil")
    val enPalmOil: List<String?>?,
    @Json(name = "en:vegan-status-unknown")
    val enVeganStatusUnknown: List<String?>?,
    @Json(name = "en:vegetarian-status-unknown")
    val enVegetarianStatusUnknown: List<String?>?
)