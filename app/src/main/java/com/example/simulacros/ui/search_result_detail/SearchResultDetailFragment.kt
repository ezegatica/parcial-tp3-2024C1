package com.example.simulacros.ui.search_result_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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


        return root
    }
}