package com.soarmorrow.bms.view.intro_screen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.soarmorrow.bms.R
import com.soarmorrow.bms.base.BaseFragment

class ThankYouFragment : BaseFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thank_you, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataManager.setLoginStatus(true)

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ThankYouFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
