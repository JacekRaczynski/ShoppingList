package pl.jraczynski.shoppinglist.data.models


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
@Entity(tableName = "foodProduct_table")
@JsonClass(generateAdapter = true)
data class FoodProduct(
    @PrimaryKey(autoGenerate = false)
    val code: String?,
    @Json(name = "product")
    val product: Product?,
    @Json(name = "status")
    val status: Int?,
    @Json(name = "status_verbose")
    val statusVerbose: String?
)