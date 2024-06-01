package com.example.simulacros.ui.search_result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simulacros.adapters.FlightListAdapter
import com.example.simulacros.databinding.FragmentSearchResultBinding
import com.example.simulacros.domain.model.Flight
import com.example.simulacros.listener.OnFlightItemClickedListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchResultFragment : Fragment(), OnFlightItemClickedListener {

    private var _binding: FragmentSearchResultBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(this).get(SearchResultViewModel::class.java)

        _binding = FragmentSearchResultBinding.inflate(inflater, container, false)

        val root: View = binding.root
        val recFlight = binding.recFlights
        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            binding.loading.isVisible = it
        })
        viewModel.listFlight.observe(viewLifecycleOwner, Observer {
            recFlight.adapter = FlightListAdapter((it ?: listOf()),this)

        })
        var flightListAdapter = FlightListAdapter(listOf(), this)
        recFlight.setHasFixedSize(true)
        recFlight.layoutManager = LinearLayoutManager(context)
        recFlight.adapter = flightListAdapter
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onFlightItemDetail(flight: Flight) {
        TODO("Not yet implemented")
    }

}