package com.rinal.covid19.education

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.rinal.covid19.databinding.FragmentEducationBinding


class EducationFragment : Fragment() {

    private val viewModel: EducationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentEducationBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.educationViewModel = viewModel

        binding.rvEducation.adapter = EducationAdapter(EducationAdapter.OnCLickListener{
            viewModel.displayEducationDetail(it)
        })

        binding.topAppBar.setOnClickListener {
            findNavController().navigate(EducationFragmentDirections.actionEducationFragmentToHomeFragment2())
        }

        viewModel.navigateToDetailEdu.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController()
                    .navigate(EducationFragmentDirections.actionEducationFragmentToDetailEducationFragment(it))
                viewModel.displayEducationDetailComplete()
            }
        })

        return binding.root
    }
}
