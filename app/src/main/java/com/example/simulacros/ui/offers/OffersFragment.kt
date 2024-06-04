package com.example.simulacros.ui.offers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simulacros.adapters.OfferVerticalAdapter
import com.example.simulacros.databinding.FragmentOffersBinding
import com.example.simulacros.domain.model.Offer
import com.example.simulacros.listener.OnOfferItemClickedListener

class OffersFragment : Fragment(), OnOfferItemClickedListener {

    private var _binding: FragmentOffersBinding? = null
    private val binding get() = _binding!!

    private  val viewModel: OffersViewModel by viewModels()

    private lateinit var linearLayoutManagerOffer: LinearLayoutManager
    lateinit var recyclerOffersBig: RecyclerView
    private lateinit var offerVerticalAdapter: OfferVerticalAdapter

    companion object {
        fun newInstance() = OffersFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val offersViewModel = ViewModelProvider(this).get(OffersViewModel::class.java)
        _binding = FragmentOffersBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        linearLayoutManagerOffer = LinearLayoutManager(context)

        recyclerOffersBig = binding.recyclerOffersBig
        recyclerOffersBig.setHasFixedSize(true)
        recyclerOffersBig.layoutManager = linearLayoutManagerOffer

        viewModel.offers.observe(viewLifecycleOwner, Observer { offers ->
            offerVerticalAdapter = OfferVerticalAdapter(offers, this)
            recyclerOffersBig.adapter = offerVerticalAdapter

        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onOfferItemDetail(offer: Offer) {
    }
}