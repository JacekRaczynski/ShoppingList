package pl.jraczynski.shoppinglist.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.getField
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import pl.jraczynski.shoppinglist.data.Team
import pl.jraczynski.shoppinglist.data.User

class FirebaseRepository {
    private val TAG = "FIREBASE_REPO"
    private val storage = FirebaseStorage.getInstance()
    private val auth = FirebaseAuth.getInstance()
    private val cloud = FirebaseFirestore.getInstance()
    private val scope = CoroutineScope(Dispatchers.Main + Job())

    fun  getUserData(): LiveData<User>{
        val cloudResult = MutableLiveData<User>()
        val uid = auth.currentUser?.uid
        val scope =
            CoroutineScope(Dispatchers.Main + Job())
        cloud.collection("users")
            .document(uid!!)
            .get()
            .addOnSuccessListener {it->
                scope.launch {
                    val user = User(
                        name = it.getField("name"),
                        email = it.getField("email"),
                        team =  getDocumentReference(it,"team",Team::class.java)

                        //team =
                        /*  Team( FirebaseFirestore.getInstance().document()

                        it.getDocumentReference("team").get()
                )*/
                    )
                    cloudResult.postValue(user!!)
                    Log.d("DDDDDDDDDDDDDDDDDDD", user.toString())
                }
                //     Log.d("DDDDDDDDDDDDDDDDDDD", it.toString())

//                val res: Team? = getDocumentReference(it,"team",Team::class.java)
//                scope.launch {
//                    Log.d("DDDDDDDDDDDDDDDDDDD",
//                        it.getDocumentReference("team")?.get()?.await()?.toObject(Team::class.java)?.members?.get(0).toString() )
//                    it.getDocumentReference("team")?.get()?.await()?.toObject(Team::class.java)
//                }
//                scope.launch {
//            val res =      getDocumentReference(it,"team",Team::class.java)
//                }

                // it.toObject(User::class.java)
                //= it.toObject(User::class.java)

            }
            .addOnFailureListener {
                Log.d(TAG, it.message.toString())
            }
        return cloudResult
    }

    suspend  fun  <T> getDocumentReference(document: DocumentSnapshot, objectName: String, classType: Class<T>): T{
        return document.getDocumentReference(objectName)?.get()?.await()?.toObject(classType)!!
    }

}