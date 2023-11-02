package pl.jraczynski.shoppinglist.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Missing(
    @Json(name = "labels")
    val labels: Int?,
    @Json(name = "origins")
    val origins: Int?,
    @Json(name = "packagings")
    val packagings: Int?
)