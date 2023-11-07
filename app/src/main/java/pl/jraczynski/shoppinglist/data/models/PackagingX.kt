package pl.jraczynski.shoppinglist.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PackagingX(
    @Json(name = "ecoscore_material_score")
    val ecoscoreMaterialScore: Int?,
    @Json(name = "ecoscore_shape_ratio")
    val ecoscoreShapeRatio: Double?,
    @Json(name = "material")
    val material: String?,
    @Json(name = "shape")
    val shape: String?
)