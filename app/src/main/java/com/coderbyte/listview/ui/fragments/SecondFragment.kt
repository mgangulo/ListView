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
import com.coderbyte.listview.databinding.FragmentSecondBinding
import com.coderbyte.listview.pojo.User

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val user:User = requireArguments().getParcelable<User>("userData")!!
        binding.idText.setText(getString(R.string.idLabel,user.id))
        binding.nameText.setText(getString(R.string.name,user.name))
        binding.usernameText.setText(getString(R.string.username,user.username))
        binding.emailText.setText(getString(R.string.email,user.email))
        binding.phoneText.setText(getString(R.string.phone,user.phone))
        binding.websiteText.setText(getString(R.string.website,user.website))
        binding.companyNameText.setText(getString(R.string.name,user.company.name))
        binding.catchphraseText.setText(getString(R.string.catchphrase,user.company.catchPhrase))
        binding.bsText.setText(getString(R.string.bs,user.company.bs))
        binding.streetText.setText(getString(R.string.street,user.address.street))
        binding.cityText.setText(getString(R.string.city,user.address.city))
        binding.zipcodeText.setText(getString(R.string.zipcode,user.address.zipcode))
        binding.suiteText.setText(getString(R.string.suite,user.address.suite))
        binding.coordinatesText.setText(getString(R.string.coordinates,user.address.geo.lat,user.address.geo.lng))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}