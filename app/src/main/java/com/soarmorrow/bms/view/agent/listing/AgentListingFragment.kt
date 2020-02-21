package com.soarmorrow.bms.view.agent.listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.soarmorrow.bms.R
import com.soarmorrow.bms.base.BaseFragment
import com.soarmorrow.bms.constants.FragmentConstants
import com.soarmorrow.bms.repository.AgentRepository
import com.soarmorrow.bms.view.common_listing.CommonListClickListener
import com.soarmorrow.bms.view.common_listing.CommonListAdapter
import kotlinx.android.synthetic.main.fragment_agent_listing.*

class AgentListingFragment : BaseFragment(),
    CommonListClickListener {

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
        return inflater.inflate(R.layout.fragment_agent_listing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadAgentList()
        add_agent.setOnClickListener { mCallback.onFragmentSelected(null,FragmentConstants.FRAG_AGENT_ADD) }
    }
    companion object {
        @JvmStatic
        fun newInstance() =
            AgentListingFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    private fun loadAgentList() {
        rv_agent.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val menuAdapter = CommonListAdapter(
            CommonListAdapter.TYPE_AGENT,
            context!!,
            this
        )
        rv_agent.adapter = menuAdapter
        menuAdapter.setItemList(AgentRepository.generateAgentData())
    }

    override fun onItemSelected(item: Any?) {
     mCallback.onFragmentSelected(item,FragmentConstants.FRAG_AGENT_DETAILS)
    }

}
