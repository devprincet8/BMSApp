package com.soarmorrow.bms.view.offer.listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.soarmorrow.bms.R
import com.soarmorrow.bms.base.BaseFragment
import com.soarmorrow.bms.constants.FragmentConstants
import com.soarmorrow.bms.repository.AgentRepository
import com.soarmorrow.bms.repository.OfferRepository
import com.soarmorrow.bms.view.common_listing.CommonListClickListener
import com.soarmorrow.bms.view.common_listing.CommonListAdapter
import kotlinx.android.synthetic.main.fragment_agent_listing.*
import kotlinx.android.synthetic.main.fragment_offer_listing.*

class OfferListingFragment : BaseFragment(),
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
        return inflater.inflate(R.layout.fragment_offer_listing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadOfferList()
        add_offer.setOnClickListener { mCallback.onFragmentSelected(null,FragmentConstants.FRAG_OFFER_ADD) }
    }
    companion object {
        @JvmStatic
        fun newInstance() =
            OfferListingFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    private fun loadOfferList() {
        rv_offer.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val menuAdapter = CommonListAdapter(
            CommonListAdapter.TYPE_OFFER,
            context!!,
            this
        )
        rv_offer.adapter = menuAdapter
        menuAdapter.setItemList(OfferRepository.generateOfferData())
    }

    override fun onItemSelected(item: Any?) {
     mCallback.onFragmentSelected(item,FragmentConstants.FRAG_OFFER_DETAILS)
    }

}
