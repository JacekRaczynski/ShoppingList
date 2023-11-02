package pl.jraczynski.shoppinglist.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NutriscoreData(
    @Json(name = "energy")
    val energy: Int?,
    @Json(name = "energy_points")
    val energyPoints: Int?,
    @Json(name = "energy_value")
    val energyValue: Int?,
    @Json(name = "fiber")
    val fiber: Int?,
    @Json(name = "fiber_points")
    val fiberPoints: Int?,
    @Json(name = "fiber_value")
    val fiberValue: Int?,
    @Json(name = "fruits_vegetables_nuts_colza_walnut_olive_oils")
    val fruitsVegetablesNutsColzaWalnutOliveOils: Int?,
    @Json(name = "fruits_vegetables_nuts_colza_walnut_olive_oils_points")
    val fruitsVegetablesNutsColzaWalnutOliveOilsPoints: Int?,
    @Json(name = "fruits_vegetables_nuts_colza_walnut_olive_oils_value")
    val fruitsVegetablesNutsColzaWalnutOliveOilsValue: Int?,
    @Json(name = "grade")
    val grade: String?,
    @Json(name = "is_beverage")
    val isBeverage: Int?,
    @Json(name = "is_cheese")
    val isCheese: Int?,
    @Json(name = "is_fat")
    val isFat: Int?,
    @Json(name = "is_water")
    val isWater: Int?,
    @Json(name = "negative_points")
    val negativePoints: Int?,
    @Json(name = "positive_points")
    val positivePoints: Int?,
    @Json(name = "proteins")
    val proteins: Double?,
    @Json(name = "proteins_points")
    val proteinsPoints: Int?,
    @Json(name = "proteins_value")
    val proteinsValue: Double?,
    @Json(name = "saturated_fat")
    val saturatedFat: Double?,
    @Json(name = "saturated_fat_points")
    val saturatedFatPoints: Int?,
    @Json(name = "saturated_fat_ratio")
    val saturatedFatRatio: Double?,
    @Json(name = "saturated_fat_ratio_points")
    val saturatedFatRatioPoints: Int?,
    @Json(name = "saturated_fat_ratio_value")
    val saturatedFatRatioValue: Double?,
    @Json(name = "saturated_fat_value")
    val saturatedFatValue: Double?,
    @Json(name = "score")
    val score: Int?,
    @Json(name = "sodium")
    val sodium: Int?,
    @Json(name = "sodium_points")
    val sodiumPoints: Int?,
    @Json(name = "sodium_value")
    val sodiumValue: Int?,
    @Json(name = "sugars")
    val sugars: Double?,
    @Json(name = "sugars_points")
    val sugarsPoints: Int?,
    @Json(name = "sugars_value")
    val sugarsValue: Double?
)