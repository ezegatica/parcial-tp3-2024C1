package com.example.simulacros.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.simulacros.R

class TrendingDestinationHolder (v: View) : RecyclerView.ViewHolder(v){

    private var view: View


    //var destino: String, var pais: String, var codigo: String, var image: Int
    init {
        this.view = v
    }

    fun setDestino(destino: String){
        val text: TextView = view.findViewById(R.id.trend_destination)
        text.text = destino
    }
    fun setPais(pais: String){
        val text: TextView = view.findViewById(R.id.trend_dest_pais)
        text.text = pais
    }

    fun setCodigo(codigo: String){
        val text: TextView = view.findViewById(R.id.trend_dest_code)
        text.text = codigo
    }

    fun getCardLayout(): CardView{
        return view.findViewById(R.id.trending_destination_card)
    }

    fun getImage(): ImageView{
        return view.findViewById(R.id.trend_dest_img)
    }


}