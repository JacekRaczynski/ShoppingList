package pl.jraczynski.shoppinglist.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NovaGroupsMarkers(
    @Json(name = "3")
    val x3: List<List<String?>?>?,
    @Json(name = "4")
    val x4: List<List<String?>?>?
)