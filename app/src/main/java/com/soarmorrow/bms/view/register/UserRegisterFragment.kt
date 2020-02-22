package com.soarmorrow.bms.view.intro_screen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.soarmorrow.bms.R
import com.soarmorrow.bms.base.BaseFragment
import com.soarmorrow.bms.util.Utils
import com.soarmorrow.bms.util.Validator
import com.soarmorrow.bms.view.register.RegisterActivity
import com.soarmorrow.bms.viewmodel.RegisterViewModel
import kotlinx.android.synthetic.main.fragment_reg_company.*
import kotlinx.android.synthetic.main.fragment_reg_user.*
import org.koin.android.viewmodel.ext.android.viewModel

class UserRegisterFragment : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reg_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
            UserRegisterFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
    fun setRegisterDataToViewModel():Boolean {
        var allFieldValidated=false
        if (Validator.validRegisterUserInput(
                et_username.text.toString(),
                et_email.text.toString(),
                et_password.text.toString(),
                et_confirm_password.text.toString()
            )
        ) {
            if (Validator.isPasswordMatch(et_password.text.toString(),
                    et_confirm_password.text.toString()))
            {
                val viewModel= (activity as RegisterActivity).registerModel
                viewModel.registerRequest.name = et_username.text.toString()
                viewModel.registerRequest.email = et_email.text.toString()
                viewModel.registerRequest.password = et_password.text.toString()

                if(cb_terms.isChecked)
                {
                    allFieldValidated=true
                }
                else
                {
                    showMessage(getString(R.string.accept_terms))
                }


            }
            else {
               showMessage(getString(R.string.password_mismatch))
            }

        } else {
            showMessage(getString(R.string.empty_filed))
        }
        return allFieldValidated

    }
}
