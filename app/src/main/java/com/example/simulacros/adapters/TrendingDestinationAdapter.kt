package com.example.simulacros.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simulacros.R
import com.example.simulacros.domain.model.TrendingDestination
import com.example.simulacros.holders.TrendingDestinationHolder
import com.example.simulacros.listener.OnTrendingDestinationClickedListener

class TrendingDestinationAdapter(
    private val trendingDestinationList: List<TrendingDestination>,
    private val onItemClick: OnTrendingDestinationClickedListener
)  : RecyclerView.Adapter<TrendingDestinationHolder>() {

    override fun getItemCount() = trendingDestinationList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingDestinationHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_trending_destination,parent,false)
        return (TrendingDestinationHolder(view))
    }


    override fun onBindViewHolder(holder: TrendingDestinationHolder, position: Int) {
        val trendingDestination = trendingDestinationList[position]

        holder.setDestino(trendingDestination.destino)
        holder.setPais(trendingDestination.pais)
        holder.setCodigo(trendingDestination.codigo)

        Glide.with(holder.itemView.context)
            .load(trendingDestination.image)
            .centerCrop()
            .placeholder(R.drawable.progress_animation)
            .into(holder.getImage());

        holder.getCardLayout().setOnClickListener{
            onItemClick.onTrendingDestinationItemDetail(trendingDestination)
        }
    }
}