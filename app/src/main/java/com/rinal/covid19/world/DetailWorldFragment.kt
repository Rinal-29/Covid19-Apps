package com.rinal.covid19.world

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.rinal.covid19.databinding.FragmentDetailWorldBinding

class DetailWorldFragment : Fragment() {

    private val viewModel : DetailWorldViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailWorldBinding.inflate(inflater)

        binding.worldViewModel = viewModel
        binding.lifecycleOwner = this

        binding.topAppBar.setNavigationOnClickListener {
            findNavController().navigate(DetailWorldFragmentDirections.actionDetailWorldFragmentToHomeFragment())
        }

        return binding.root
    }
}
