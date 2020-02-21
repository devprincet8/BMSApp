package com.soarmorrow.bms.repository

import com.soarmorrow.bms.view.agent.listing.model.AgentItem

class AgentRepository {
    companion object {
        fun generateAgentData(): List<AgentItem> {
            val listOfMovie = mutableListOf<AgentItem>()
            var menuModel = AgentItem(
                "Radwa Travel & Tourism",
                "S11, Deira Tower, Dubai",
                "Tel: +97 9734123456",
                "Mob: +97 9867123123",
                "Email: email@email.com",
                "Contact Person: Fasil K", defaultCommission
            )
            listOfMovie.add(menuModel)
            menuModel = AgentItem(
                "Akbar Travel & Tourism",
                "S11, Deira Tower, Dubai",
                "Tel: +97 9734123456",
                "Mob: +97 9867123123",
                "Email: email@email.com",
                "Contact Person: Fasil K", defaultCommission
            )
            listOfMovie.add(menuModel)
            menuModel = AgentItem(
                "Safar Travel & Tourism",
                "S11, Deira Tower, Dubai",
                "Tel: +97 9734123456",
                "Mob: +97 9867123123",
                "Email: email@email.com",
                "Contact Person: Fasil K", defaultCommission
            )
            listOfMovie.add(menuModel)
            menuModel = AgentItem(
                "Mayura Agency",
                "S11, Deira Tower, Dubai",
                "Tel: +97 9734123456",
                "Mob: +97 9867123123",
                "Email: email@email.com",
                "Contact Person: Fasil K", defaultCommission
            )
            listOfMovie.add(menuModel)
            menuModel = AgentItem(
                "Kerala Travel & Tourism",
                "S11, Deira Tower, Dubai",
                "Tel: +97 9734123456",
                "Mob: +97 9867123123",
                "Email: email@email.com",
                "Contact Person: Fasil K", defaultCommission
            )
            listOfMovie.add(menuModel)


            return listOfMovie
        }

        fun getCountry(): List<String> {
            return listOf(
                "United Arab Emirates",
                "India",
                "Australia",
                "New Zealand",
                "Argentina",
                "Denmark",
                "Poland",
                "Brazil"
            )
        }

        fun getCity(): List<String> {
            return listOf(
                "Kerala",
                "Tamilnadu",
                "Mumbai"

            )
        }

        fun getAgentName(): List<String> {
            return listOf(
                "Radwa Travel & Tourism",
                "Safar Tours and Travels",
                "Akbar Tours and Travels",
                "Mayura Agency"
            )
        }

        private const val defaultCommission = 15

    }
}