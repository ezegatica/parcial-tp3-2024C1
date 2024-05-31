package com.example.simulacros.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simulacros.domain.model.TrendingDestination
import com.example.simulacros.holders.TrendingDestinationHolder
import com.example.simulacros.listener.OnOfferItemClickedListener

class TrendingDestinationAdapter(
    private val offerList: List<TrendingDestination>,
    private val onItemClick: OnOfferItemClickedListener
)  : RecyclerView.Adapter<TrendingDestinationHolder>() {

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingDestinationHolder {
        TODO("Not yet implemented")
    }


    override fun onBindViewHolder(holder: TrendingDestinationHolder, position: Int) {
        TODO("Not yet implemented")
    }
}