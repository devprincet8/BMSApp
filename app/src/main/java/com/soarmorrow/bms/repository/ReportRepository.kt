package com.soarmorrow.bms.repository

import android.content.Context
import com.soarmorrow.bms.R
import com.soarmorrow.bms.view.account.model.ItemAgentCommission
import com.soarmorrow.bms.view.account.model.ItemAgentWiseTotalSales
import com.soarmorrow.bms.view.account.model.ItemTotalSales
import com.soarmorrow.bms.view.common_listing.CommonListAdapter


class ReportRepository(private var context: Context) {
    companion object {
        fun getData(type: Int): List<Any> {
            var list = listOf<Any>()
            when (type) {
                CommonListAdapter.TYPE_REPORT_TOTAL -> {
                    list = generateTotalSalesReportData()
                }
                CommonListAdapter.TYPE_REPORT_AGENT_WISE -> {
                    list = generateAgentWiseSalesReportData()
                }
                CommonListAdapter.TYPE_REPORT_AGENT_COMMISSION -> {
                    list = generateAgentCommissionReportData()
                }
            }
            return list
        }

        private fun generateTotalSalesReportData(): List<ItemTotalSales> {
            val listOfMovie = mutableListOf<ItemTotalSales>()
            var menuModel = ItemTotalSales(
                "Angel Queen Houseboats",
                "Dec 03, 2019", DefaultAddress,
                "4 Adults x 16,000",
                "64,000"
            )
            listOfMovie.add(menuModel)
            menuModel = ItemTotalSales(
                "Rose Houseboats",
                "Dec 03, 2019", DefaultAddress,
                "4 Adults x  16,000",
                " 64,000"
            )
            listOfMovie.add(menuModel)
            menuModel = ItemTotalSales(
                "Kumarakom Queen Houseboats",
                "Dec 03, 2019", DefaultAddress,
                "4 Adults x  16,000",
                " 64,000"
            )
            listOfMovie.add(menuModel)
            menuModel = ItemTotalSales(
                "Kerala State Houseboats",
                "Dec 03, 2019", DefaultAddress,
                "4 Adults x  16,000",
                " 64,000"
            )
            listOfMovie.add(menuModel)
            menuModel = ItemTotalSales(
                "Star Houseboats",
                "Dec 03, 2019", DefaultAddress,
                "4 Adults x  16,000",
                " 64,000"
            )
            listOfMovie.add(menuModel)

            return listOfMovie
        }


        private fun generateAgentWiseSalesReportData(): List<ItemAgentWiseTotalSales> {
            val listOfMovie = mutableListOf<ItemAgentWiseTotalSales>()
            var menuModel = ItemAgentWiseTotalSales(
                "Angel Queen Houseboats",
                "Dec 03, 2019", DefaultAddress,
                "4 Adults x  16,000",
                "Offered 25%", " 64,000"
            )
            listOfMovie.add(menuModel)
            menuModel = ItemAgentWiseTotalSales(
                "Star Queen Houseboats",
                "Dec 03, 2019", DefaultAddress,
                "4 Adults x  16,000",
                "Offered 25%", " 64,000"
            )
            listOfMovie.add(menuModel)

            menuModel = ItemAgentWiseTotalSales(
                "Ocean Houseboats",
                "Dec 03, 2019", DefaultAddress,
                "4 Adults x  16,000",
                "Offered 25%", " 64,000"
            )
            listOfMovie.add(menuModel)

            menuModel = ItemAgentWiseTotalSales(
                "Angel Queen Houseboats",
                "Dec 03, 2019", DefaultAddress,
                "4 Adults x  16,000",
                "Offered 25%", " 64,000"
            )
            listOfMovie.add(menuModel)

            menuModel = ItemAgentWiseTotalSales(
                "Angel Queen Houseboats",
                "Dec 03, 2019", DefaultAddress,
                "4 Adults x  16,000",
                "Offered 25%", " 64,000"
            )
            listOfMovie.add(menuModel)

            return listOfMovie
        }

        private fun generateAgentCommissionReportData(): List<ItemAgentCommission> {
            val listOfMovie = mutableListOf<ItemAgentCommission>()
            var menuModel = ItemAgentCommission(
                "Angel Queen Houseboats",
                "Dec 03, 2019",
                "25%",
                " 16,000"
            )
            listOfMovie.add(menuModel)
            menuModel = ItemAgentCommission(
                "Queen Houseboats",
                "Dec 03, 2019",
                "25%",
                " 16,000"
            )
            listOfMovie.add(menuModel)
            menuModel = ItemAgentCommission(
                "Ocean Houseboats",
                "Dec 03, 2019",
                "25%",
                " 16,000"
            )
            listOfMovie.add(menuModel)
            menuModel = ItemAgentCommission(
                "Star Houseboats",
                "Dec 03, 2019",
                "25%",
                " 16,000"
            )
            listOfMovie.add(menuModel)
            menuModel = ItemAgentCommission(
                "Angel Queen Houseboats",
                "Dec 03, 2019",
                "25%",
                " 16,000"
            )
            listOfMovie.add(menuModel)

            return listOfMovie
        }

        private var DefaultAddress =
            "Shop no 03,Old Bridge Junction,Near Beach Road\nAlappuzha,Kerala 672673"
    }
}