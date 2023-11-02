package pl.jraczynski.shoppinglist.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EcoscoreData(
    @Json(name = "adjustments")
    val adjustments: Adjustments?,
    @Json(name = "agribalyse")
    val agribalyse: Agribalyse?,
    @Json(name = "grade")
    val grade: String?,
    @Json(name = "grades")
    val grades: Grades?,
    @Json(name = "missing")
    val missing: Missing?,
    @Json(name = "missing_data_warning")
    val missingDataWarning: Int?,
    @Json(name = "previous_data")
    val previousData: PreviousData?,
    @Json(name = "score")
    val score: Int?,
    @Json(name = "scores")
    val scores: Scores?,
    @Json(name = "status")
    val status: String?
)