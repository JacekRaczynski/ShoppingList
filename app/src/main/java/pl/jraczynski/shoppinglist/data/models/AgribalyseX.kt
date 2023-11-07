package pl.jraczynski.shoppinglist.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AgribalyseX(
    @Json(name = "agribalyse_food_code")
    val agribalyseFoodCode: String?,
    @Json(name = "agribalyse_proxy_food_code")
    val agribalyseProxyFoodCode: String?,
    @Json(name = "co2_agriculture")
    val co2Agriculture: Double?,
    @Json(name = "co2_consumption")
    val co2Consumption: Int?,
    @Json(name = "co2_distribution")
    val co2Distribution: Double?,
    @Json(name = "co2_packaging")
    val co2Packaging: Double?,
    @Json(name = "co2_processing")
    val co2Processing: Double?,
    @Json(name = "co2_total")
    val co2Total: Double?,
    @Json(name = "co2_transportation")
    val co2Transportation: Double?,
    @Json(name = "code")
    val code: String?,
    @Json(name = "dqr")
    val dqr: String?,
    @Json(name = "ef_agriculture")
    val efAgriculture: Double?,

    @Json(name = "ef_distribution")
    val efDistribution: Double?,
    @Json(name = "ef_packaging")
    val efPackaging: Double?,
    @Json(name = "ef_processing")
    val efProcessing: Double?,
    @Json(name = "ef_total")
    val efTotal: Double?,
    @Json(name = "ef_transportation")
    val efTransportation: Double?,
    @Json(name = "is_beverage")
    val isBeverage: Int?,
    @Json(name = "name_en")
    val nameEn: String?,
    @Json(name = "name_fr")
    val nameFr: String?,
    @Json(name = "score")
    val score: Int?
)