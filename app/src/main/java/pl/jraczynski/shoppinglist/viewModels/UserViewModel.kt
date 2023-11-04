package pl.jraczynski.shoppinglist.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import pl.jraczynski.shoppinglist.repositories.FirebaseRepository

class UserViewModel(private val application: Application): AndroidViewModel(application) {
    private val repository = FirebaseRepository()
    val user = repository.getUserData()

}