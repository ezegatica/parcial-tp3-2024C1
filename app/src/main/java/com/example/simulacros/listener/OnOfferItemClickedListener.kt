package com.example.simulacros.listener

import com.example.simulacros.domain.model.Offer

interface OnOfferItemClickedListener {
    fun onOfferItemDetail(offer: Offer)
}