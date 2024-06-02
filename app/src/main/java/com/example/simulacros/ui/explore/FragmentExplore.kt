package com.example.simulacros.ui.explore


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simulacros.adapters.OfferAdapter
import com.example.simulacros.databinding.FragmentExploreBinding
import com.example.simulacros.domain.model.Offer
import com.example.simulacros.listener.OnOfferItemClickedListener
import androidx.lifecycle.Observer
import com.example.simulacros.R
import com.example.simulacros.adapters.TrendingDestinationAdapter
import com.example.simulacros.domain.model.TrendingDestination
import com.example.simulacros.listener.OnTrendingDestinationClickedListener

class FragmentExplore : Fragment(), OnOfferItemClickedListener, OnTrendingDestinationClickedListener {
    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ExploreViewModel by viewModels()

    private var isLiked = false

    private lateinit var linearLayoutManagerOffer: LinearLayoutManager
    lateinit var recyclerOffers: RecyclerView
    private lateinit var offerAdapter: OfferAdapter

    private lateinit var linearLayoutManagerTrendingDestination: LinearLayoutManager
    lateinit var recyclerTrendingDestination: RecyclerView
    private lateinit var trendingDestinationAdapter: TrendingDestinationAdapter

    companion object {
        fun newInstance() = FragmentExplore()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val exploreViewModel = ViewModelProvider(this).get(ExploreViewModel::class.java)
        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        linearLayoutManagerOffer = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        linearLayoutManagerTrendingDestination = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)


        //Recycler Offer
        recyclerOffers = binding.recyclerOffers
        recyclerOffers.setHasFixedSize(true)
        recyclerOffers.layoutManager = linearLayoutManagerOffer

        viewModel.offers.observe(viewLifecycleOwner, Observer { offers ->
            offerAdapter = OfferAdapter(offers, this)
            recyclerOffers.adapter = offerAdapter
        })

        //Recycler Trending Destination
        recyclerTrendingDestination = binding.recyclerTrendingDestinations
        recyclerTrendingDestination.setHasFixedSize(true)
        recyclerTrendingDestination.layoutManager = linearLayoutManagerTrendingDestination

        viewModel.trendingDestinations.observe(viewLifecycleOwner, Observer { trendingDestination ->
            trendingDestinationAdapter = TrendingDestinationAdapter(trendingDestination,this)
            recyclerTrendingDestination.adapter = trendingDestinationAdapter
        })

        //Logica de Like Button
        val btnLike: ImageButton = binding.likeButton
        btnLike.setOnClickListener(){
            updateLikeButton(btnLike,!isLiked)
        }

        //Logica de Flight Button
        val btnFlight: ImageButton = binding.exploreFlightButton
        btnFlight.setOnClickListener() {
            view.findNavController().navigate(FragmentExploreDirections.actionFragmentExploreToFragmentSearch())
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onOfferItemDetail(offer: Offer) {
        //NO HACE NADA
    }

    override fun onTrendingDestinationItemDetail(trendingDestination: TrendingDestination) {
        //NO HACE NADA
    }

    private fun updateLikeButton(button: ImageButton, isLiked: Boolean) {
        if (isLiked) {
            button.setImageResource(R.drawable.liked_logo)
        } else {
            button.setImageResource(R.drawable.like_logo)
        }
    }

}