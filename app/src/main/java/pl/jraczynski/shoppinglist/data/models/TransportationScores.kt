package pl.jraczynski.shoppinglist.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TransportationScores(
    @Json(name = "ad")
    val ad: Int?,
    @Json(name = "al")
    val al: Int?,
    @Json(name = "at")
    val at: Int?,
    @Json(name = "ax")
    val ax: Int?,
    @Json(name = "ba")
    val ba: Int?,
    @Json(name = "be")
    val be: Int?,
    @Json(name = "bg")
    val bg: Int?,
    @Json(name = "ch")
    val ch: Int?,
    @Json(name = "cy")
    val cy: Int?,
    @Json(name = "cz")
    val cz: Int?,
    @Json(name = "de")
    val de: Int?,
    @Json(name = "dk")
    val dk: Int?,
    @Json(name = "dz")
    val dz: Int?,
    @Json(name = "ee")
    val ee: Int?,
    @Json(name = "eg")
    val eg: Int?,
    @Json(name = "es")
    val es: Int?,
    @Json(name = "fi")
    val fi: Int?,
    @Json(name = "fo")
    val fo: Int?,
    @Json(name = "fr")
    val fr: Int?,
    @Json(name = "gg")
    val gg: Int?,
    @Json(name = "gi")
    val gi: Int?,
    @Json(name = "gr")
    val gr: Int?,
    @Json(name = "hr")
    val hr: Int?,
    @Json(name = "hu")
    val hu: Int?,
    @Json(name = "ie")
    val ie: Int?,
    @Json(name = "il")
    val il: Int?,
    @Json(name = "im")
    val im: Int?,
    @Json(name = "is")
    val isX: Int?,
    @Json(name = "it")
    val `it`: Int?,
    @Json(name = "je")
    val je: Int?,
    @Json(name = "lb")
    val lb: Int?,
    @Json(name = "li")
    val li: Int?,
    @Json(name = "lt")
    val lt: Int?,
    @Json(name = "lu")
    val lu: Int?,
    @Json(name = "lv")
    val lv: Int?,
    @Json(name = "ly")
    val ly: Int?,
    @Json(name = "ma")
    val ma: Int?,
    @Json(name = "mc")
    val mc: Int?,
    @Json(name = "md")
    val md: Int?,
    @Json(name = "me")
    val me: Int?,
    @Json(name = "mk")
    val mk: Int?,
    @Json(name = "mt")
    val mt: Int?,
    @Json(name = "nl")
    val nl: Int?,
    @Json(name = "no")
    val no: Int?,
    @Json(name = "pl")
    val pl: Int?,
    @Json(name = "ps")
    val ps: Int?,
    @Json(name = "pt")
    val pt: Int?,
    @Json(name = "ro")
    val ro: Int?,
    @Json(name = "rs")
    val rs: Int?,
    @Json(name = "se")
    val se: Int?,
    @Json(name = "si")
    val si: Int?,
    @Json(name = "sj")
    val sj: Int?,
    @Json(name = "sk")
    val sk: Int?,
    @Json(name = "sm")
    val sm: Int?,
    @Json(name = "sy")
    val sy: Int?,
    @Json(name = "tn")
    val tn: Int?,
    @Json(name = "tr")
    val tr: Int?,
    @Json(name = "ua")
    val ua: Int?,
    @Json(name = "uk")
    val uk: Int?,
    @Json(name = "us")
    val us: Int?,
    @Json(name = "va")
    val va: Int?,
    @Json(name = "world")
    val world: Int?,
    @Json(name = "xk")
    val xk: Int?
)