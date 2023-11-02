package pl.jraczynski.shoppinglist.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OriginsOfIngredients(
    @Json(name = "aggregated_origins")
    val aggregatedOrigins: List<AggregatedOrigin?>?,
    @Json(name = "epi_score")
    val epiScore: Int?,
    @Json(name = "epi_value")
    val epiValue: Int?,
    @Json(name = "origins_from_origins_field")
    val originsFromOriginsField: List<String?>?,
    @Json(name = "transportation_score")
    val transportationScore: Int?,
    @Json(name = "transportation_scores")
    val transportationScores: TransportationScores?,
    @Json(name = "transportation_value")
    val transportationValue: Int?,
    @Json(name = "transportation_values")
    val transportationValues: TransportationValues?,
    @Json(name = "value")
    val value: Int?,
    @Json(name = "values")
    val values: Values?,
    @Json(name = "warning")
    val warning: String?
)