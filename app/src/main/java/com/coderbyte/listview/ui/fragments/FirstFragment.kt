package com.coderbyte.listview.ui.fragments

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
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
    private val presenter:FirstFragmentPresenter = FirstFragmentPresenter();

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
        presenter.getUserList(this)
        binding.listView.setOnItemClickListener(){adapterView, view, position, id ->
            val userData = adapterView.getItemAtPosition(position)
            if (userData is User){
                val navigateAction = FirstFragmentDirections.actionFirstFragmentToSecondFragment(userData)
                findNavController().navigate(navigateAction)
            }
        }
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
            showAlertDialog(when (msg==null){
                true -> getString(R.string.unknown_error)
                else -> msg
            })
        }
    }

    override fun onFailure(code: Int) {
        if (context!=null) {
            showAlertDialog(getString(R.string.error_code,code))
        }
    }

    fun showAlertDialog(msg:String){
        val builder = AlertDialog.Builder(requireContext())

        builder.setMessage(msg)
            .setTitle(R.string.error)
            .setPositiveButton(R.string.ok,object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    dialog?.dismiss();
                }
            })

        builder.create().show()
    }
}