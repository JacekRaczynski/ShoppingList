package pl.jraczynski.shoppinglist.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CategoriesProperties(
    @Json(name = "agribalyse_food_code:en")
    val agribalyseFoodCodeEn: String?,
    @Json(name = "agribalyse_proxy_food_code:en")
    val agribalyseProxyFoodCodeEn: String?,
    @Json(name = "ciqual_food_code:en")
    val ciqualFoodCodeEn: String?
)