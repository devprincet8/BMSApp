package com.soarmorrow.bms.view.intro_screen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.soarmorrow.bms.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_reg_property.*


class PropertyRegisterFragment : BaseFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.soarmorrow.bms.R.layout.fragment_reg_property, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // access the spinner
        var languages = arrayListOf<String>("india","pak","ban","nz","aus","eng","wi")
        var adapter = ArrayAdapter<String>(
            activity!!,
            android.R.layout.simple_spinner_dropdown_item, languages
        )
        sp.adapter = adapter
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            PropertyRegisterFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
