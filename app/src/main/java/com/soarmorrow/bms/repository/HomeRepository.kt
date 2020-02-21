package com.soarmorrow.bms.repository

import com.soarmorrow.bms.R
import com.soarmorrow.bms.view.home.HomeMenuAdapter
import com.soarmorrow.bms.view.home.MenuItem

class HomeRepository
{
    companion object
    {
        fun generateMenuData(type: Int): List<MenuItem> {
            val listOfMovie = mutableListOf<MenuItem>()
            when (type) {
                HomeMenuAdapter.TYPE_GRID -> {
                    var menuModel = MenuItem(R.drawable.property, "Property\nManagement", type)
                    listOfMovie.add(menuModel)

                    menuModel = MenuItem(R.drawable.profile, "Profile\n" + "Management", type)
                    listOfMovie.add(menuModel)

                    menuModel = MenuItem(R.drawable.agent, "Agent\n" + "Management", type)
                    listOfMovie.add(menuModel)

                    menuModel = MenuItem(R.drawable.booking_small, "Booking\n" + "Management", type)
                    listOfMovie.add(menuModel)

                    menuModel = MenuItem(R.drawable.offer, "Offer\n" + "Management", type)
                    listOfMovie.add(menuModel)

                    menuModel = MenuItem(R.drawable.account, "Account\n" + "Management", type)
                    listOfMovie.add(menuModel)

                }
                HomeMenuAdapter.TYPE_HORIZONTAL -> {
                    var menuModel = MenuItem(R.drawable.property_small, "Property\nManagement", type)
                    listOfMovie.add(menuModel)

                    menuModel = MenuItem(R.drawable.profile_small, "Profile\n" + "Management", type)
                    listOfMovie.add(menuModel)

                    menuModel = MenuItem(R.drawable.agent_small, "Agent\n" + "Management", type)
                    listOfMovie.add(menuModel)

                    menuModel = MenuItem(R.drawable.booking_small, "Booking\n" + "Management", type)
                    listOfMovie.add(menuModel)

                    menuModel = MenuItem(R.drawable.offer_small, "Offer\n" + "Management", type)
                    listOfMovie.add(menuModel)

                    menuModel = MenuItem(R.drawable.account_small, "Account\n" + "Management", type)
                    listOfMovie.add(menuModel)

                }
            }


            return listOfMovie
        }

    }
}