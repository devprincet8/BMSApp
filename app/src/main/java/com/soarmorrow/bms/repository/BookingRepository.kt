package com.soarmorrow.bms.repository

import com.soarmorrow.bms.view.booking.model.BookingItem

class BookingRepository {
    companion object {
        fun generateBookingData(): List<BookingItem> {
            val listOfMovie = mutableListOf<BookingItem>()
            var menuModel = BookingItem(
                "Radwa Travel & Tourism",
                "Dec 17, 2019"
            )
            listOfMovie.add(menuModel)
            menuModel = BookingItem(
                "Grand Houseboats",
                "Jan 19, 20120"
            )
            listOfMovie.add(menuModel)
            menuModel = BookingItem(
                "Prabhu Resort",
                "Jan 23, 20120"
            )
            listOfMovie.add(menuModel)

            return listOfMovie
        }

        fun getBookingType(): List<String> {
            return listOf("Self Booking", "Agent Booking")
        }
    }
}