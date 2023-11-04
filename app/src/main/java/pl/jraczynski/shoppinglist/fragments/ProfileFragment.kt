package pl.jraczynski.shoppinglist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import pl.jraczynski.shoppinglist.R
import pl.jraczynski.shoppinglist.databinding.FragmentMainBinding
import pl.jraczynski.shoppinglist.databinding.FragmentProfileBinding
import pl.jraczynski.shoppinglist.viewModels.UserViewModel

class ProfileFragment : BaseFragment() {
    private lateinit var binding: FragmentProfileBinding
    private val userViewModel by viewModels<UserViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userViewModel.user.observe(viewLifecycleOwner) { user ->
            binding.nameProfile.text =  user.name
            binding.emailProfile.text = user.email
            binding.emailProfile.text = user.email

        }
    }
}