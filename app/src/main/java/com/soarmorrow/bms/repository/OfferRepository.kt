package com.soarmorrow.bms.repository

import com.soarmorrow.bms.view.offer.model.OfferItem

class OfferRepository {
    companion object {
        fun generateOfferData(): List<OfferItem> {
            val listOfMovie = mutableListOf<OfferItem>()
            var menuModel = OfferItem("Summer Offer", "10/03/2020", "20/03/2020", "25")
            listOfMovie.add(menuModel)
            listOfMovie.add(menuModel)
            listOfMovie.add(menuModel)
            listOfMovie.add(menuModel)
            listOfMovie.add(menuModel)
            listOfMovie.add(menuModel)
            listOfMovie.add(menuModel)
            return listOfMovie
        }


    }
}