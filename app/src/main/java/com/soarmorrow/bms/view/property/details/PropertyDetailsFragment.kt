package com.soarmorrow.bms.view.property.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager

import com.soarmorrow.bms.R
import com.soarmorrow.bms.base.BaseFragment
import com.soarmorrow.bms.repository.PropertyRepository
import com.soarmorrow.bms.repository.PropertyRepository.Companion.generateCheckBoxData
import com.soarmorrow.bms.repository.PropertyRepository.Companion.generateImageData
import kotlinx.android.synthetic.main.fragment_home.rv_menu
import kotlinx.android.synthetic.main.fragment_property_details.*
import kotlinx.android.synthetic.main.fragment_reg_property.*

class PropertyDetailsFragment : BaseFragment(),
    AddPropertyClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_property_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadCheckBoxList()
        setSpinnerData()
        loadImageList()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            PropertyDetailsFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    private fun loadCheckBoxList() {
        rv_menu.layoutManager = GridLayoutManager(context, 2)
        rv_menu.isNestedScrollingEnabled = false
        val menuAdapter = PropertyCheckBoxAdapter()
        rv_menu.adapter = menuAdapter
        menuAdapter.setMenuList(generateCheckBoxData())
        btn_save_property.setOnClickListener { activity!!.finish() }
    }

    private fun loadImageList() {
        rv_images.layoutManager = GridLayoutManager(context, 2)
        rv_images.isNestedScrollingEnabled = false
        val menuAdapter =
            PropertyImageAdapter(context!!, this)
        rv_images.adapter = menuAdapter
        menuAdapter.setMenuList(generateImageData())
    }

    override fun onImageRemoved(pos: Int) {
        //  Toast.makeText(context, "Remove $pos", Toast.LENGTH_SHORT).show()
    }

    override fun onPickerSelected() {
        //  Toast.makeText(context, "onPickerSelected", Toast.LENGTH_SHORT).show()
    }

    private fun setSpinnerData() {
        val propertyTypeAdapter = ArrayAdapter<String>(
            activity!!,
            android.R.layout.simple_spinner_dropdown_item, PropertyRepository.getPropertyType()
        )
        sp_property_type.adapter = propertyTypeAdapter

        val propertyOfferAdapter = ArrayAdapter<String>(
            activity!!,
            android.R.layout.simple_spinner_dropdown_item,
            PropertyRepository.getPropertyCommission()
        )
        sp_commission.adapter = propertyOfferAdapter
    }

}
