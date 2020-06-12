package com.rinal.covid19.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.rinal.covid19.databinding.FragmentDetailEducationBinding

class DetailEducationFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailEducationBinding.inflate(inflater)

        binding.lifecycleOwner = this
        val educationProperties = DetailEducationFragmentArgs.fromBundle(requireArguments()).propertyEducation
        val viewModel = DetailViewModelFactory(educationProperties)
        binding.detailViewModel = ViewModelProvider(this, viewModel).get(DetailEducationViewModel::class.java)

        binding.topAppBar.setOnClickListener {
            findNavController().navigate(DetailEducationFragmentDirections.actionDetailEducationFragmentToEducationFragment())
        }

        return binding.root
    }
}
