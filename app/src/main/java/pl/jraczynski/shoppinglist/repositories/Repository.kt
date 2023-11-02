package pl.jraczynski.shoppinglist.repositories

import android.content.Context
import pl.jraczynski.shoppinglist.data.models.FoodProduct
import pl.jraczynski.shoppinglist.data.remote.RemoteSource
import retrofit2.Response

class Repository(context: Context) {
    private val api = RemoteSource.api

    suspend fun loadFoodProduct(id: Long) : Response<FoodProduct>{
        return api.getFoodProduct(id)
    }
}