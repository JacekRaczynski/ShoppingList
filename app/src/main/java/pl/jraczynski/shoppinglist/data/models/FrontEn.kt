package pl.jraczynski.shoppinglist.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FrontEn(
    @Json(name = "angle")
    val angle: Int?,
    @Json(name = "coordinates_image_size")
    val coordinatesImageSize: String?,
    @Json(name = "geometry")
    val geometry: String?,
    @Json(name = "imgid")
    val imgid: String?,
    @Json(name = "normalize")
    val normalize: Any?,
    @Json(name = "rev")
    val rev: String?,
    @Json(name = "white_magic")
    val whiteMagic: Any?,
    @Json(name = "x1")
    val x1: String?,
    @Json(name = "x2")
    val x2: String?,
    @Json(name = "y1")
    val y1: String?,
    @Json(name = "y2")
    val y2: String?
)