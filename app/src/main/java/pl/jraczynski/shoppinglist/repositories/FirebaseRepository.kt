package pl.jraczynski.shoppinglist.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.*
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import pl.jraczynski.shoppinglist.data.*

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
                if(it.data != null) {
                    scope.launch {
                        val shoppingList: ShoppingListDB? = getDocumentReference(it,"listofProducts",ShoppingListDB::class.java)
                        val team: TeamDB? = getDocumentReference(it,"team",TeamDB::class.java)
                        val teamShoppingList = team?.listofProducts?.get()?.await()?.toObject(ShoppingListDB::class.java)
                        val user = User(
                            name = it.getField("name"),
                            email = it.getField("email"),
                            team =  Team(
                                uid = team?.uid,
                                name = team?.name,
                                admin = team?.admin,
                                members = team?.members,
                                listofProducts =ShoppingList(
                                    uid = teamShoppingList?.uid,
                                    list = teamShoppingList?.let { it1 -> getItemList(it1) }
                            )),
                            listofProducts = ShoppingList(
                                uid = shoppingList?.uid,
                                list = shoppingList?.let { it1 -> getItemList(it1) }
                        ))
                        cloudResult.postValue(user!!)
                    }
                }
            }
            .addOnFailureListener {
                Log.d(TAG, it.message.toString())
            }
        return cloudResult
    }
    fun  getMembers(membersId: List<String>): LiveData<MutableList<Pair<String,String>>> {
        val cloudResult = MutableLiveData<MutableList<Pair<String, String>>>()
        val list: MutableList<Pair<String, String>> = mutableListOf()

        val scope =
            CoroutineScope(Dispatchers.Main + Job())
        membersId.forEach { id ->
            cloud.collection("users")
                .document(id!!)
                .get()
                .addOnSuccessListener { it ->
                    if (it.data != null) {
                            val pair: Pair<String, String> = Pair(id!!, it.getField("name")!!)
                            list.add(pair)
                        cloudResult.postValue(list)
                    }
                }
                .addOnFailureListener {
                    Log.d(TAG, it.message.toString())
                }
        }
        return cloudResult
    }

    suspend  fun  <T> getDocumentReference(document: DocumentSnapshot, objectName: String, classType: Class<T>): T? {
        if(document == null) return  null
        return document.getDocumentReference(objectName)?.get()?.await()?.toObject(classType)!!
    }
suspend  fun getItemList(shoppingList: ShoppingListDB): MutableList<Item> {
    val itemList: MutableList<Item> = mutableListOf()
    if(shoppingList != null) {
        (shoppingList?.products as ArrayList<DocumentReference>).forEach { docuReference ->
            val data: ProductDB? = docuReference.get().await().toObject(ProductDB::class.java)
            val categories: MutableList<Categories> = mutableListOf()
            (data?.categories as ArrayList<DocumentReference>).forEach{cat ->
                val category: CategoriesDB? = cat.get().await().toObject(CategoriesDB::class.java)
                if (category?.name != null) {
                    categories.add(Categories.valueOf(category.name!!))
                }
            }
            itemList.add(
                Item(
                    uid = data?.uid,
                    name = data?.name,
                    image = data?.image,
                    productData = data?.productData,
                    date = data?.date.toString(),
                    categories = categories,
                    amount = data.amount,
                    authorId = data.author
                )
            )
        }
    }
    return itemList
}
}