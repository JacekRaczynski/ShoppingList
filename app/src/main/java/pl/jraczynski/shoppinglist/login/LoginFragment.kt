package pl.jraczynski.shoppinglist.login

import android.R
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

import pl.jraczynski.shoppinglist.activities.MainActivity
import pl.jraczynski.shoppinglist.databinding.FragmentSignInBinding


class LoginFragment : Fragment() {
    private val fbAuth = FirebaseAuth.getInstance()
    private val TAG = "LoginFragment"
    private lateinit var binding: FragmentSignInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupLoginButton()
        setupRegistrationButton()
    }

    private fun setupLoginButton() {
        binding.signInButton.setOnClickListener {
            val email = binding.emailLoginInput.text.trim().toString()
            val password = binding.passwordLoginInput.text.trim().toString()
            if (!email.isNullOrEmpty() && !password.isNullOrEmpty())
                fbAuth.signInWithEmailAndPassword(email, password)
                    .addOnSuccessListener { authResult ->
                        if (authResult.user != null) {
                            val intent = Intent(requireContext(), MainActivity::class.java).apply {
                                flags =
                                    (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            }
                            startActivity(intent)
                        }
                    }
                    .addOnFailureListener { e ->
                        Snackbar.make(requireView(), "Login failed", Snackbar.LENGTH_SHORT).show()
                        Log.d(TAG, e.message.toString())
                    }
        }
    }

    private fun setupRegistrationButton() {
        binding.signUpButton.setOnClickListener {
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToRegistrationFragment().actionId
            )
        }

    }


}