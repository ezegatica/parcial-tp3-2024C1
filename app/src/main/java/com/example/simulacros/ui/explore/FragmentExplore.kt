package com.example.simulacros.ui.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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

class FragmentExplore : Fragment(), OnOfferItemClickedListener {
    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ExploreViewModel by viewModels()

    lateinit var recyclerOffers: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var offerAdapter: OfferAdapter
    private var isLiked = false
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

        recyclerOffers = binding.recyclerOffers
        recyclerOffers.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recyclerOffers.layoutManager = linearLayoutManager

        viewModel.offers.observe(viewLifecycleOwner, Observer { offers ->
            offerAdapter = OfferAdapter(offers, this)
            recyclerOffers.adapter = offerAdapter
        })

        val btnLike: ImageButton = binding.likeButton
        btnLike.setOnClickListener(){
            isLiked = !isLiked
            if(isLiked){
                btnLike.setImageResource(R.drawable.liked_logo)
            }else{
                btnLike.setImageResource(R.drawable.like_logo)
            }
        }

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

}