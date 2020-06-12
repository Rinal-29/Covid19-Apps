package com.rinal.covid19.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.rinal.covid19.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.introduction_layout.view.*

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val binding = FragmentHomeBinding.inflate(inflater)

        drawerLayout = binding.drawerLayout

        val navController = this.findNavController()

        NavigationUI.setupWithNavController(binding.topAppBar, navController, binding.drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)

        binding.lifecycleOwner = this
        binding.viewModelHome = viewModel

        binding.topAppBar.setOnMenuItemClickListener {
            return@setOnMenuItemClickListener NavigationUI.onNavDestinationSelected(it, requireView().findNavController())
        }

        binding.btnWorld.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailWorldFragment())
        }

        binding.btnIndonesia.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailIndonesiaFragment())
        }

        binding.education.btn_more_info.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToEducationFragment())
        }

        return binding.root
    }
}
