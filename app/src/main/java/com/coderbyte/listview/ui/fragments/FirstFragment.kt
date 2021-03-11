package com.coderbyte.listview.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.coderbyte.listview.R
import com.coderbyte.listview.databinding.FragmentFirstBinding
import com.coderbyte.listview.networking.UserHandler
import com.coderbyte.listview.pojo.User
import com.coderbyte.listview.ui.adapters.UserAdapter
import com.coderbyte.listview.ui.presenters.FirstFragmentPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(),FirstFragmentPresenter.UserPresenter {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        UserHandler.getUserList(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful && context!=null) {
                    binding.listView.adapter = UserAdapter(response.body()!!,context!!)
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onSuccess(userList: List<User>) {
        if (context!=null) {
            binding.listView.adapter = UserAdapter(userList, requireContext())
        }
    }

    override fun onFailure(msg: String?) {
        if (context!=null) {
        }
    }

    override fun onFailure(code: Int) {
        if (context!=null) {
        }
    }
}