package com.rinal.covid19.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.rinal.covid19.R
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

        binding.education.buttonServices.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToServiceFragment())
        }

        binding.education.btn_more_info.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToEducationFragment())
        }

        binding.education.contact1.setOnClickListener {
            val numberContact = resources.getString(R.string.number1)
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$numberContact"))
            startActivity(intent)
        }

        binding.education.contact2.setOnClickListener {
            val numberContact = resources.getString(R.string.number2)
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$numberContact"))
            startActivity(intent)
        }

        binding.education.contact3.setOnClickListener {
            val numberContact = resources.getString(R.string.number3)
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$numberContact"))
            startActivity(intent)
        }

        binding.education.contact4.setOnClickListener {
            val numberContact = resources.getString(R.string.number4)
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$numberContact"))
            startActivity(intent)
        }

        return binding.root
    }
}
