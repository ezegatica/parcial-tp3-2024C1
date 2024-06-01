package com.example.simulacros.ui.search_result_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.simulacros.R
import com.example.simulacros.databinding.FragmentSearchResultDetailBinding

class SearchResultDetailFragment : Fragment() {

    private var _binding: FragmentSearchResultDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel = ViewModelProvider(this).get(SearchResultDetailViewModel::class.java)

        _binding = FragmentSearchResultDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root;

        SearchResultDetailFragmentArgs.fromBundle(requireArguments()).flight.let {
            Glide.with(requireContext())
                .load(it.airlineLogo)
                .centerCrop()
                .placeholder(R.drawable.progress_animation)
                .into(binding.ivDogDetail);

        }

        return root
    }
}