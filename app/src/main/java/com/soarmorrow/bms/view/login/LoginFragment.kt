package com.soarmorrow.bms.view.intro_screen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.soarmorrow.bms.R
import com.soarmorrow.bms.base.BaseFragment
import com.soarmorrow.bms.view.home.HomeActivity
import com.soarmorrow.bms.view.register.RegisterActivity
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataManager.setLoginStatus(true)
        tv_register.setOnClickListener { moveToActivity(RegisterActivity.newIntent(context)) }
        login.setOnClickListener { moveToActivity(HomeActivity.newIntent(context)) }
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
            LoginFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
