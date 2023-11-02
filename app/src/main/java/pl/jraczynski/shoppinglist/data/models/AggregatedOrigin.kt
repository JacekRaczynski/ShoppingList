package pl.jraczynski.shoppinglist.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AggregatedOrigin(
    @Json(name = "epi_score")
    val epiScore: String?,
    @Json(name = "origin")
    val origin: String?,
    @Json(name = "percent")
    val percent: Int?,
    @Json(name = "transportation_score")
    val transportationScore: Any?
)