package pl.jraczynski.shoppinglist.fragments

import android.os.Bundle
import android.util.Log
import android.view.*

import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import pl.jraczynski.shoppinglist.R
import pl.jraczynski.shoppinglist.activities.MainActivity

import pl.jraczynski.shoppinglist.adapters.TeamAdapter
import pl.jraczynski.shoppinglist.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment() {
    private lateinit var binding: FragmentProfileBinding
    private val fbAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.logout_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logout_action -> {
                fbAuth.signOut()
                requireActivity().finish()
            }
        }
        return super.onOptionsItemSelected(item)
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
        (activity as MainActivity).userViewModel.user.observe(viewLifecycleOwner) { user ->
            binding.nameProfile.text =  user.name
            binding.emailProfile.text = user.email
            if(user.team != null ){
                binding.teamCard.visibility = View.VISIBLE
                binding.noTeamInformation.visibility = View.GONE
                binding.teamName.text = user.team.name
                if(user.team.members?.isNotEmpty() == true) {
                    (activity as MainActivity).userViewModel.getMembers(user.team.members!!).observe(viewLifecycleOwner){
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