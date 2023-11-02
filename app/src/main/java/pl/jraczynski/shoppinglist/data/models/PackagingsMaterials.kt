package pl.jraczynski.shoppinglist.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PackagingsMaterials(
    @Json(name = "all")
    val all: All?,
    @Json(name = "en:glass")
    val enGlass: EnGlass?
)