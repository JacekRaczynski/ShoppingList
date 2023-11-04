package pl.jraczynski.shoppinglist.data.remote

import okhttp3.OkHttpClient
import pl.jraczynski.shoppinglist.data.models.FoodProduct
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit


interface FoodProductAPI {
    //https://world.openfoodfacts.net/api/v2/product/3017624010701
    @GET("product/{id}")
    suspend fun getFoodProduct(@Path("id")id: Long): Response<FoodProduct>
}

object RemoteSource{
    var okHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(120, TimeUnit.SECONDS)
        .readTimeout(120, TimeUnit.SECONDS)
        .writeTimeout(120, TimeUnit.SECONDS)
        .build()
    //https://world.openfoodfacts.org/api/v2/product
    //https://world.openfoodfacts.net/api/v2/
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://world.openfoodfacts.org/api/v2/")
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val api = retrofit.create(FoodProductAPI::class.java)
}