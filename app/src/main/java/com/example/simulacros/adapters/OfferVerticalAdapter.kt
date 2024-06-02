package com.example.simulacros.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.simulacros.R
import com.example.simulacros.domain.model.Offer
import com.example.simulacros.holders.OfferHolder
import com.example.simulacros.listener.OnOfferItemClickedListener

class OfferVerticalAdapter (
    private val offerList: List<Offer>,
    private val onItemClick: OnOfferItemClickedListener
)  : OfferAdapter(offerList, onItemClick)  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_offer,parent,false)
        return (OfferHolder(view))
    }


}