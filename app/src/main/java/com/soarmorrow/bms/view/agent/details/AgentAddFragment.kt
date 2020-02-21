package com.soarmorrow.bms.view.agent.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager

import com.soarmorrow.bms.R
import com.soarmorrow.bms.base.BaseFragment
import com.soarmorrow.bms.repository.AgentRepository
import com.soarmorrow.bms.repository.PropertyRepository
import com.soarmorrow.bms.view.agent.listing.model.AgentItem
import com.soarmorrow.bms.view.common_listing.CommonListClickListener
import com.soarmorrow.bms.view.common_listing.CommonListAdapter
import kotlinx.android.synthetic.main.fragment_add_agent.*
import kotlinx.android.synthetic.main.fragment_agent_details.*
import kotlinx.android.synthetic.main.fragment_agent_details.sp_city
import kotlinx.android.synthetic.main.fragment_agent_details.sp_country
import kotlinx.android.synthetic.main.fragment_agent_details.view.*
import kotlinx.android.synthetic.main.fragment_agent_listing.*
import kotlinx.android.synthetic.main.fragment_property_details.*

class AgentAddFragment : BaseFragment() {
    lateinit var agentItem: AgentItem
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
        return inflater.inflate(R.layout.fragment_add_agent, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setSpinnerData()
    }

    private fun setListeners() {
        btn_create_agent.setOnClickListener { activity?.finish() }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AgentAddFragment().apply {
                arguments = Bundle().apply {
                }
            }

        private const val KEY_AGENT = "AgentData"
    }

    private fun setSpinnerData() {
        val propertyTypeAdapter = ArrayAdapter<String>(
            activity!!,
            android.R.layout.simple_spinner_dropdown_item, AgentRepository.getCountry()
        )
        sp_country.adapter = propertyTypeAdapter

        val propertyOfferAdapter = ArrayAdapter<String>(
            activity!!,
            android.R.layout.simple_spinner_dropdown_item,
            AgentRepository.getCity()
        )
        sp_city.adapter = propertyOfferAdapter
    }
}
