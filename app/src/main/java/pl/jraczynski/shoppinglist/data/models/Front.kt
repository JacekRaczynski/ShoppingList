package pl.jraczynski.shoppinglist.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Front(
    @Json(name = "display")
    val display: Display?,
    @Json(name = "small")
    val small: Small?,
    @Json(name = "thumb")
    val thumb: Thumb?
)