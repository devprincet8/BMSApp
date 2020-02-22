package com.soarmorrow.bms.view.intro_screen

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.soarmorrow.bms.R
import com.soarmorrow.bms.api.response.login.LoginResponse
import com.soarmorrow.bms.base.BaseFragment
import com.soarmorrow.bms.util.Utils
import com.soarmorrow.bms.util.Validator
import com.soarmorrow.bms.view.home.HomeActivity
import com.soarmorrow.bms.view.register.RegisterActivity
import com.soarmorrow.bms.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment() {

    private val loginModel: LoginViewModel by viewModel()
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

        tv_register.setOnClickListener { moveToActivity(RegisterActivity.newIntent(context)) }
        login.setOnClickListener {
            if(Validator.validLoginInput(email.text.toString(),password.text.toString()))
            {
                showProgress()
                loginModel.doLogin(email.text.toString(),password.text.toString())
            }
            else
            {
                Utils.showMessage("Field cannot be empty",it)
            }

        }


        loginModel.loginResponse.observe(this, Observer(function = fun(resp: LoginResponse) {
            hideProgress()
            resp.let {
               if (resp.code ==200)
               {
                   Utils.showMessage(resp.message?.text!!, getView()!!)
                   Handler().postDelayed({
                        dataManager.setLoginStatus(true)
                       moveToActivity(HomeActivity.newIntent(context))
                       activity?.finish()
                   }, 1000)


               }
                else
               {
                   Utils.showMessage(resp.message?.text!!, getView()!!)
               }
            }
        }))
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
