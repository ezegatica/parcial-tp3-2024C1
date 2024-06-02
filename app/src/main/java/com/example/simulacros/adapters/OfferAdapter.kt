package com.example.simulacros.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simulacros.R
import com.example.simulacros.domain.model.Offer
import com.example.simulacros.holders.OfferHolder
import com.example.simulacros.listener.OnOfferItemClickedListener

abstract class OfferAdapter  (
    private val offerList: List<Offer>,
    private val onItemClick: OnOfferItemClickedListener
)  : RecyclerView.Adapter<OfferHolder>() {

        override fun getItemCount() = offerList.size

        abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferHolder

        override fun onBindViewHolder(holder: OfferHolder, position: Int) {
            val offer = offerList[position]
            holder.setTitle(offer.title)
            holder.setDescription(offer.description)

            Glide.with(holder.itemView.context)
                .load(offer.image)
                .centerCrop()
                .placeholder(R.drawable.progress_animation)
                .into(holder.getImage());

            holder.getCardLayout().setOnClickListener{
                onItemClick.onOfferItemDetail(offer)
            }
        }

}