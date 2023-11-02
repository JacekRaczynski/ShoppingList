package pl.jraczynski.shoppinglist.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.firebase.auth.*
import pl.jraczynski.shoppinglist.R


class RegistrationActivity : AppCompatActivity() {
    private val fbAuth = FirebaseAuth.getInstance()
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_registration)
      //  RegistrationActivityBinding
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_register) as NavHostFragment
        navController = navHostFragment.findNavController()
        setupActionBarWithNavController(navController)
    }

    override fun onStart() {
        super.onStart()
        isCurrentUser()
    }
    private fun isCurrentUser(){
        fbAuth.signOut()
        fbAuth.currentUser?.let{
        val intent = Intent(applicationContext, MainActivity::class.java).apply{
                flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            }
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}