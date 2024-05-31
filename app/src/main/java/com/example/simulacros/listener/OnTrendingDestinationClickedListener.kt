package com.example.simulacros.listener

import com.example.simulacros.domain.model.TrendingDestination

interface OnTrendingDestinationClickedListener {
    fun onTrendingDestinationItemDetail(trendingDestination: TrendingDestination)
}