package pl.jraczynski.shoppinglist.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Adjustments(
    @Json(name = "origins_of_ingredients")
    val originsOfIngredients: OriginsOfIngredients?,
    @Json(name = "packaging")
    val packaging: Packaging?,
    @Json(name = "production_system")
    val productionSystem: ProductionSystem?,
    @Json(name = "threatened_species")
    val threatenedSpecies: ThreatenedSpecies?
)