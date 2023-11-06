package pl.jraczynski.shoppinglist.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import pl.jraczynski.shoppinglist.R
import pl.jraczynski.shoppinglist.activities.MainActivity
import pl.jraczynski.shoppinglist.adapters.ProductAdapter
import pl.jraczynski.shoppinglist.adapters.TeamAdapter
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
            if(user.team != null ){
                binding.teamCard.visibility = View.VISIBLE
                binding.noTeamInformation.visibility = View.GONE
                binding.teamName.text = user.team.name
                if(user.team.members?.isNotEmpty() == true) {
                    userViewModel.getMembers(user.team.members!!).observe(viewLifecycleOwner){
                        it.forEach {
                            Log.d("XXXXXXXX", it.first + " " + it.second)
                        }
                        val adapter = TeamAdapter(it)
                        binding.membersListRecyclerView.layoutManager = LinearLayoutManager(context)
                        binding.membersListRecyclerView.adapter = adapter
                    }
                }
            }else {
                binding.teamCard.visibility = View.GONE
                binding.noTeamInformation.visibility = View.VISIBLE
            }
        }


    }
}