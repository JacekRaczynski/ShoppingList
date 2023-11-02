package pl.jraczynski.shoppinglist.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductionSystem(
    @Json(name = "labels")
    val labels: List<Any?>?,
    @Json(name = "value")
    val value: Int?,
    @Json(name = "warning")
    val warning: String?
)