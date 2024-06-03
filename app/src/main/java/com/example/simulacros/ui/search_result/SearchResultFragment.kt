package com.example.simulacros.ui.search_result

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavArgs
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simulacros.adapters.FlightListAdapter
import com.example.simulacros.databinding.FragmentSearchResultBinding
import com.example.simulacros.domain.model.Flight
import com.example.simulacros.listener.OnFlightItemClickedListener
import com.example.simulacros.ui.search.FragmentSearch
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchResultFragment : Fragment(), OnFlightItemClickedListener {

    private var _binding: FragmentSearchResultBinding? = null
    private val args : SearchResultFragmentArgs by navArgs()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(this).get(SearchResultViewModel::class.java)

        _binding = FragmentSearchResultBinding.inflate(inflater, container, false)

        //Recibimos los argumentos, en principio no se utilizan
        val flightFrom = args.from
        val flightTo = args.to
        val flightDate = args.date
        val flightClass = args.classes
        val flightPassengers = args.passengers

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
        Log.i("FLIGHT clicked", flight.toString())
        val action = SearchResultFragmentDirections.actionNavigationSearchResultToNavigationSearchResultDetail(flight);
        view?.findNavController()?.navigate(action);
    }

}