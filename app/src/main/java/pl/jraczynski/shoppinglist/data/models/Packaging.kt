package pl.jraczynski.shoppinglist.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Packaging(
    @Json(name = "non_recyclable_and_non_biodegradable_materials")
    val nonRecyclableAndNonBiodegradableMaterials: Int?,
    @Json(name = "packagings")
    val packagings: List<PackagingX>?,
    @Json(name = "score")
    val score: Int?,
    @Json(name = "value")
    val value: Int?,
    @Json(name = "warning")
    val warning: String?
)