package com.rinal.covid19.indonesia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController

import com.rinal.covid19.R
import com.rinal.covid19.databinding.FragmentDetailIndonesiaBinding

class DetailIndonesiaFragment : Fragment() {

    private val viewModel: DetailIndonesiaViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailIndonesiaBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.indonesiaViewModel = viewModel

        binding.topAppBar.setNavigationOnClickListener {
            findNavController().navigate(DetailIndonesiaFragmentDirections.actionDetailIndonesiaFragmentToHomeFragment())
        }

        return binding.root
    }

}
