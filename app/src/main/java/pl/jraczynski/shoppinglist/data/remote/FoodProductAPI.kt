package pl.jraczynski.shoppinglist.data.remote

import pl.jraczynski.shoppinglist.data.models.FoodProduct
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface FoodProductAPI {
    //https://world.openfoodfacts.net/api/v2/product/3017624010701
    @GET("product/{id}")
    suspend fun getFoodProduct(@Path("id")id: Long): Response<FoodProduct>
}

object RemoteSource{
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://world.openfoodfacts.net/api/v2/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val api = retrofit.create(FoodProductAPI::class.java)
}