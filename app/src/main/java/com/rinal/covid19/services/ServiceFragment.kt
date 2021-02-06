package com.rinal.covid19.services

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.rinal.covid19.R
import com.rinal.covid19.databinding.FragmentServiceBinding

class ServiceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentServiceBinding.inflate(inflater)

        binding.topAppBar.setNavigationOnClickListener {
            findNavController().navigate(ServiceFragmentDirections.actionServiceFragmentToHomeFragment())
        }

        binding.register.setOnClickListener {
            val url = "https://covid19.sulselprov.go.id/rapidgratis"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        return binding.root
    }
}
