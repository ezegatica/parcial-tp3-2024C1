package com.example.simulacros.ui.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.simulacros.R
import com.example.simulacros.databinding.FragmentExploreBinding
import com.example.simulacros.databinding.FragmentIntroBinding
import com.example.simulacros.ui.intro.IntroFragment
import com.example.simulacros.ui.intro.IntroFragmentDirections
import com.example.simulacros.ui.explore.ExploreViewModel

class FragmentExplore : Fragment() {
    private var _binding: FragmentExploreBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = FragmentExplore()
    }

    private val viewModel: ExploreViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val exploreViewModel = ViewModelProvider(this).get(ExploreViewModel::class.java)

        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val btnFlight: Button = binding.exploreFlightButton
        btnFlight.setOnClickListener() {
                view?.findNavController()?.navigate(FragmentExploreDirections.actionFragmentExploreToFragmentSearch())
            }

        return root
    }

}