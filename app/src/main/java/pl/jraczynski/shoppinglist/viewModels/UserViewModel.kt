package pl.jraczynski.shoppinglist.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import pl.jraczynski.shoppinglist.data.Item
import pl.jraczynski.shoppinglist.repositories.FirebaseRepository

class UserViewModel(private val application: Application): AndroidViewModel(application) {
    val currentItem = MutableLiveData<Item>()
    var item :Item? = null
    fun getCurrentItem(): LiveData<Item>{
        return currentItem
    }
    private val repository = FirebaseRepository()
    val user = repository.getUserData()
    fun getMembers(membersId: List<String>): LiveData<MutableList<Pair<String, String>>>{
       return repository.getMembers(membersId)
    }
}