package com.example.simulacros.holders

import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.simulacros.R

class OfferHolder (v: View) : RecyclerView.ViewHolder(v) {

    private var view: View

    init {
        this.view = v
    }

    fun setTitle(title: String){
        val text: TextView = view.findViewById(R.id.title_text)
        text.text = title
    }

    fun setDescription(description: String){
        val text: TextView = view.findViewById(R.id.description_text)
        text.text = description
    }

    fun getCardLayout (): CardView {
        return view.findViewById(R.id.item_offer_card)
    }

    fun getImage(): ImageView {
        return view.findViewById(R.id.offer_img)
    }

}