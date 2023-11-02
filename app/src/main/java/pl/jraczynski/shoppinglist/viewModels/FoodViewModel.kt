package pl.jraczynski.shoppinglist.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pl.jraczynski.shoppinglist.data.models.FoodProduct
import pl.jraczynski.shoppinglist.repositories.Repository

class FoodViewModel(private val application: Application):AndroidViewModel(application) {
    private val repository = Repository(application)
    private val _foodProduct = MutableStateFlow<FoodProduct?>(null)
    val foodProduct = _foodProduct.asStateFlow()
    private val food = MutableLiveData<FoodProduct?>()

    fun performFetchSingleFoodProduct(id: Long) = viewModelScope.launch {
        val remoteFoodProduct = repository.loadFoodProduct(id)
        Log.d("PROCESS_D","Remote source")
        if(remoteFoodProduct.isSuccessful){
            val data = remoteFoodProduct.body()
            if(data != null){
                _foodProduct.update { data }
                food.value = data

                }


            }
        }

     fun getFoodProduct(): LiveData<FoodProduct?>{
        return food
    }

    }

