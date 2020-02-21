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
import kotlinx.android.synthetic.main.fragment_agent_details.*
import kotlinx.android.synthetic.main.fragment_agent_details.view.*
import kotlinx.android.synthetic.main.fragment_agent_listing.*
import kotlinx.android.synthetic.main.fragment_property_details.*

class AgentDetailsFragment : BaseFragment() {
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
        return inflater.inflate(R.layout.fragment_agent_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAgentDetails(arguments?.getParcelable(KEY_AGENT))
        addListeners()
        setSpinnerData()
    }

    companion object {
        @JvmStatic
        fun newInstance(item: AgentItem) =
            AgentDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_AGENT, item)
                }
            }

        private const val KEY_AGENT = "AgentData"
    }

    private fun setAgentDetails(item: AgentItem?) {
        if (item != null) {
            this.agentItem = item
            title.text = item.title
            address.text = item.address
            tel.text = item.tele
            mob.text = item.mob
            email.text = item.email
            contact_person.text = item.contact_person
            tv_commision.text = "${item.commission}%"
        }

    }

    private fun addListeners() {
        btn_save_agent_details.setOnClickListener { activity?.finish() }
        minus.setOnClickListener {
            agentItem.commission--
            setAgentDetails(agentItem)
        }
        plus.setOnClickListener {
            agentItem.commission++
            setAgentDetails(agentItem)
        }
    }

    private fun setSpinnerData() {
        val countryAdapter = ArrayAdapter<String>(
            activity!!,
            android.R.layout.simple_spinner_dropdown_item, AgentRepository.getCountry()
        )
        sp_country.adapter = countryAdapter

        val cityAdapter = ArrayAdapter<String>(
            activity!!,
            android.R.layout.simple_spinner_dropdown_item,
            AgentRepository.getCity()
        )
        sp_city.adapter = cityAdapter

        val propertyAdapter = ArrayAdapter<String>(
            activity!!,
            android.R.layout.simple_spinner_dropdown_item,
            PropertyRepository.getPropertyList()
        )
        sp_property.adapter = propertyAdapter
    }
}
