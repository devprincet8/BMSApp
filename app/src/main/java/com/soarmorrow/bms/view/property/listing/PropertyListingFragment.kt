package com.soarmorrow.bms.view.property.listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.soarmorrow.bms.R
import com.soarmorrow.bms.base.BaseFragment
import com.soarmorrow.bms.constants.FragmentConstants
import com.soarmorrow.bms.repository.PropertyRepository.Companion.generatePropertyListData
import com.soarmorrow.bms.view.common_listing.CommonListAdapter
import com.soarmorrow.bms.view.common_listing.CommonListClickListener
import kotlinx.android.synthetic.main.fragment_property_listing.*

class PropertyListingFragment : BaseFragment(),
    CommonListClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_property_listing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadPropertyList()
        create_property.setOnClickListener {
            mCallback.onFragmentSelected(null,FragmentConstants.FRAG_PROPERTY_ADD)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            PropertyListingFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    private fun loadPropertyList() {
        rv_property.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val menuAdapter = CommonListAdapter(
            CommonListAdapter.TYPE_PROPERTY,
            context!!,
            this
        )
        rv_property.adapter = menuAdapter
        menuAdapter.setItemList(generatePropertyListData())

    }

    override fun onItemSelected(item: Any?) {
        mCallback.onFragmentSelected(item,FragmentConstants.FRAG_PROPERTY_DETAILS)
    }

}
