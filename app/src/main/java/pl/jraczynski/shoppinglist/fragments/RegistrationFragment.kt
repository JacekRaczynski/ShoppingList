package pl.jraczynski.shoppinglist.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import pl.jraczynski.shoppinglist.activities.MainActivity
import pl.jraczynski.shoppinglist.databinding.FragmentSignUpBinding

class RegistrationFragment : Fragment() {
    private val fbAuth = FirebaseAuth.getInstance()
    private val TAG = "RegistrationFragment"
    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSignUpClick()
    }

    private fun setupSignUpClick() {
        binding.signUpButton.setOnClickListener {
            val email = binding.editTextTextEmailAddress.text?.trim().toString()
            val password = binding.password.text?.trim().toString()
            val repeatedpassword = binding.repeatPassword.text?.trim().toString()
            if(password == repeatedpassword && !email.isNullOrEmpty() &&!password.isNullOrEmpty()){
                fbAuth.createUserWithEmailAndPassword(email,password)
                    .addOnSuccessListener { authResult ->
                    if(authResult.user != null){
                        val intent = Intent(requireContext(), MainActivity::class.java).apply {
                            flags =
                                (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        }
                        startActivity(intent)
                    }
                    }
                    .addOnFailureListener {e ->
                        Snackbar.make(requireView(), "Registration failed", Snackbar.LENGTH_SHORT).show()
                        Log.d(TAG, e.message.toString())
                    }
            }
        }
    }

}