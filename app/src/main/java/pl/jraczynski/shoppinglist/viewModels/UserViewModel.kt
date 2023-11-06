package pl.jraczynski.shoppinglist.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import pl.jraczynski.shoppinglist.repositories.FirebaseRepository

class UserViewModel(private val application: Application): AndroidViewModel(application) {
    private val repository = FirebaseRepository()
    val user = repository.getUserData()
    fun getMembers(membersId: List<String>): LiveData<MutableList<Pair<String, String>>>{
       return repository.getMembers(membersId)
    }

}