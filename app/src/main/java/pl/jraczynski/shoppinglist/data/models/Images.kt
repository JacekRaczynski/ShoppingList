package pl.jraczynski.shoppinglist.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Images(
    @Json(name = "front_en")
    val frontEn: FrontEn?,
    @Json(name = "ingredients_en")
    val ingredientsEn: IngredientsEn?,
    @Json(name = "nutrition_en")
    val nutritionEn: NutritionEn?,
    @Json(name = "packaging_en")
    val packagingEn: PackagingEn?,
)