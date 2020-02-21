package com.soarmorrow.bms.view.booking


import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.soarmorrow.bms.base.BaseFragment
import com.soarmorrow.bms.repository.AgentRepository
import com.soarmorrow.bms.repository.BookingRepository
import com.soarmorrow.bms.repository.PropertyRepository
import com.soarmorrow.bms.view.common_listing.CommonListAdapter
import com.soarmorrow.bms.view.common_listing.CommonListClickListener
import kotlinx.android.synthetic.main.fragment_agent_details.*
import kotlinx.android.synthetic.main.fragment_booking.*


class BookingFragment : BaseFragment(), CommonListClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.soarmorrow.bms.R.layout.fragment_booking, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        loadBookingList()
        setSpinnerData()
    }

    private fun setListeners() {
        btn_cancel.setOnClickListener { activity?.finish() }
        btn_book.setOnClickListener { activity?.finish() }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            BookingFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    private fun loadBookingList() {
        rv_booking_summary.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val menuAdapter = CommonListAdapter(
            CommonListAdapter.TYPE_BOOKING,
            context!!,
            this
        )
        rv_booking_summary.adapter = menuAdapter
        menuAdapter.setItemList(BookingRepository.generateBookingData())
    }

    override fun onItemSelected(item: Any?) {

    }

    private fun setSpinnerData() {
        val countryAdapter = ArrayAdapter<String>(
            activity!!,
            R.layout.simple_spinner_dropdown_item, BookingRepository.getBookingType()
        )
        sp_booking_type.adapter = countryAdapter

        val cityAdapter = ArrayAdapter<String>(
            activity!!,
            R.layout.simple_spinner_dropdown_item,
            AgentRepository.getAgentName()
        )
        sp_booking_agent.adapter = cityAdapter

    }
}
